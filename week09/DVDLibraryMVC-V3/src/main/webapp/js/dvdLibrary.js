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
    var dvdTable = $('#dvd-table');

    $.each(data, function (index, dvd) {
        var imgDiv = 'dvd-img-' + index;

        dvdTable.append($('<div>')
                .attr({
                    'class': 'col-md-3 col-sm-4 col-xs-6 dvd-outer-tile'
                })
                .append($('<a>')
                        .attr({
                            'data-dvd-id': dvd.id,
                            'data-toggle': 'modal',
                            'data-target': '#details-modal'
                        }).append($('<div>')
                        .attr({
                            'class': 'dvd-inner-tile'
                        }).append($('<img>')
                        .attr({
                            'class': 'dvd-image img-responsive',
                            'id': imgDiv,
                            'src': dvd.image
                        })
                        ) // ends the <img>
                        )// ends the <div> 
                        .append($('<p>').attr({
                            'class': 'dvd-title'
                        })
                                .text(dvd.title)

                                ) // ends <p>
                        ) // ends the <a> tag
                ); // ends the <div> 

        if (dvd.image.length < 1 || dvd.image === '/DVDLibrary/img/dvd-placeholder.jpg') {
            imgDiv = '#' + imgDiv;
            getExtras(dvd, imgDiv);            
        }

        if ((index + 1) % 4 === 0) {
            dvdTable.append($('<div class="clearfix visible-md-block visible-lg-block"></div>'));
        }
        if ((index + 1) % 3 === 0) {
            dvdTable.append($('<div class="clearfix visible-sm-block"></div>'));
        }
        if ((index + 1) % 2 === 0) {
            dvdTable.append($('<div class="clearfix visible-xs-block"></div>'));
        }
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
        loadDVDs();
    }).error(function (data, status) {
        $('.validationErrors').empty();
        $.each(data.responseJSON.fieldErrors, function (index, validationError) {
            var errorDiv = '#error-' + validationError.fieldName;
            $(errorDiv)
                    .append(validationError.message)
                    .append($('<br>'));
        });
    });
});

$('#edit-button').click(function (event) {
    event.preventDefault();
    $('.validationErrors').empty();

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
        $('#edit-modal').modal('toggle');
        loadDVDs();
    }).error(function (data, status) {
        $('.validationErrors').empty();
        $.each(data.responseJSON.fieldErrors, function (index, validationError) {
            var errorDiv = '#error-modal-' + validationError.fieldName;
            $(errorDiv)
                    .append(validationError.message)
                    .append($('<br>'));
        });
    });
});

$('#edit-button-cancel').click(function () {
    $('.validationErrors').empty();
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
        modal.find('#dvd-overview').text(dvd.overview);
        modal.find('#dvd-note').text(dvd.note);
//        modal.find('#dvd-image').html('<img class="img-responsive" src="' + dvd.image + '">');
        modal.find('#dvd-image').attr('src', dvd.image);
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
    $('#dvd-table').empty();
}


//console.log($.getJSON("https://api.themoviedb.org/3/discover/movie?api_key=15d2ea6d0dc1d476efbca3eba2b9bbfb"));
//$('#poster').html('<img src=\"http://image.tmdb.org/t/p/w500/' + json.results[0].poster_path + '\" class=\"img-responsive\" >');
//var film = $('#term').val();



var getExtras = function (dvd, imgDiv) {
    $.getJSON("https://api.themoviedb.org/3/search/movie?api_key=15d2ea6d0dc1d476efbca3eba2b9bbfb&query=" + dvd.title + "&callback=?", function (json) {
        if (json != "Nothing found.") {

            console.log(json); // can delete
            var imageLink = 'http://image.tmdb.org/t/p/w500/' + json.results[0].poster_path;
            $(imgDiv).attr('src', imageLink);
            
            $.ajax({
                    type: 'PUT',
                    url: '/DVDLibrary/dvd/' + dvd.id,
                    data: JSON.stringify({
                        id: dvd.id,
                        title: dvd.title,
                        year: dvd.year,
                        mpaa: dvd.mpaa,
                        director: dvd.director,
                        studio: dvd.studio,
                        note: dvd.note,
                        image: imageLink,
                        overview: json.results[0].overview                        
                    }),
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    'dataType': 'json'
                })
        }
    });
};
