$(document).ready(function () {
    loadDVDs();
});

function loadDVDs() {
    $.ajax({
        type: 'GET',
        url: "/DVDLibrary/dvds"
    }).success(function (data, status) {
        fillDVDTable(data, status);
    });
}

function fillDVDTable(data, status) {
    clearTable();
    var dvdTable = $('#content-rows');

    $.each(data, function (index, dvd) {
        dvdTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-dvd-id': dvd.id,
                                    'data-toggle': 'modal',
                                    'data-target': '#details-modal'
                                })
                                .text(dvd.title)
                                ) // ends the <a> tag
                        ) // ends the <td> tag
                .append($('<td>').text(dvd.year))
                .append($('<td>').text(dvd.mpaa))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-dvd-id': dvd.id,
                                    'data-toggle': 'modal',
                                    'data-target': '#edit-modal'
                                })
                                .text('Edit')
                                ) // ends the <a> tag
                        ) // ends the <td> tag for Edit
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteDVD(' + dvd.id + ')'
                                })
                                .text('Delete')
                                ) // ends the <a> tag
                        ) // ends the <td> tag for Delete
                ); // ends the <tr> 
    }); // ends the 'each' function
}

$('#add-button').click(function (event) {
    event.preventDefault();
    $('.validationErrors').empty();

    $.ajax({
        type: 'POST',
        url: '/DVDLibrary/dvd',
        data: JSON.stringify({
            title: $('#add-title').val(),
            year: $('#add-year').val(),
            mpaa: $('#add-mpaa').val(),
            director: $('#add-director').val(),
            studio: $('#add-studio').val(),
            note: $('#add-note').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
        $('#add-title').val('');
        $('#add-year').val('');
        $('#add-mpaa').val('');
        $('#add-director').val('');
        $('#add-studio').val('');
        $('#add-note').val('');
        $('#validationErrors').empty();
        loadDVDs();
    }).error(function (data, status) {
        $.each(data.responseJSON.fieldErrors, function (index, validationError) {
            var errorDiv = '#error-' + validationError.fieldName;
            console.log(errorDiv);
            $(errorDiv)
                    .append(validationError.message)
                    .append($('<br>'));
//            console.log(validationError);
//            var errorDiv = $('#validationErrors');
//            errorDiv.append(validationError.message).append($('<br>'));
        });
    });
});

$('#search-button').click(function (event) {
    event.preventDefault();
    $.ajax({
        type: 'POST',
        url: '/DVDLibrary/search/dvds',
        data: JSON.stringify({
            title: $('#search-title').val(),
            year: $('#search-year').val(),
            mpaa: $('#search-mpaa').val(),
            studio: $('#search-studio').val(),
            director: $('#search-director').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {
        $('#search-title').val('');
        $('#search-year').val('');
        $('#search-mpaa').val('');
        $('#search-studio').val('');
        $('#search-director').val('');
        fillDVDTable(data, status);
    });
});

$('#details-modal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var id = element.data('dvd-id');
    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: '/DVDLibrary/dvd/' + id
    }).success(function (dvd) {
        modal.find('#dvd-title').text(dvd.title);
        modal.find('#dvd-year').text(dvd.year);
        modal.find('#dvd-mpaa').text(dvd.mpaa);
        modal.find('#dvd-director').text(dvd.director);
        modal.find('#dvd-studio').text(dvd.studio);
        modal.find('#dvd-note').text(dvd.note);
    });
});

$('#edit-modal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var id = element.data('dvd-id');
    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: '/DVDLibrary/dvd/' + id
    }).success(function (dvd) {
        modal.find('#edit-id').val(dvd.id);
        modal.find('#edit-title').val(dvd.title);
        modal.find('#edit-year').val(dvd.year);
        modal.find('#edit-mpaa').val(dvd.mpaa);
        modal.find('#edit-director').val(dvd.director);
        modal.find('#edit-studio').val(dvd.studio);
        modal.find('#edit-note').val(dvd.note);
    });
});

$('#edit-button').click(function (event) {
    event.preventDefault();

    $.ajax({
        type: 'PUT',
        url: '/DVDLibrary/dvd/' + $('#edit-id').val(),
        data: JSON.stringify({
            id: $('#edit-id').val(),
            title: $('#edit-title').val(),
            year: $('#edit-year').val(),
            mpaa: $('#edit-mpaa').val(),
            director: $('#edit-director').val(),
            studio: $('#edit-studio').val(),
            note: $('#edit-note').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function () {
        loadDVDs();
    });
});

function deleteDVD(id) {
    var answer = confirm("Do you really want to delete this DVD?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: '/DVDLibrary/dvd/' + id
        }).success(function () {
            loadDVDs();
        });
    }
}

function clearTable() {
    $('#content-rows').empty();
}