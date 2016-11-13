var currentData;

$(document).ready(function () {
    $('#search-form').removeClass('hidden');
    loadDVDs();
});

function loadDVDs() {
    $.ajax({
        type: 'GET',
        url: "/Library/dvds"
    }).success(function (data, status) {
        currentData = data;
        fillDVDTable(currentData);
        setNumOfDvds();
    });
}

function fillDVDTable(data) {
    clearTable();
    var dvdTable = $('#dvd-table');

    $.each(data, function (index, dvd) {
        var imgDiv = 'dvd-img-' + index;

        dvdTable.append($('<div style="position:relative;">')
                .attr({
                    'class': 'col-md-3 col-xs-4 dvd-outer-tile'
                })
                .append($('<a style="cursor:pointer;">')
                        .attr({
                            'data-dvd-id': dvd.id,
                            'data-toggle': 'modal',
                            'data-target': '#details-modal'
                        }).append($('<div>')
                        .attr({
                            'class': 'dvd-inner-tile'
                        })
                        .append($('<img>')
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

        if ((index + 1) % 4 === 0) {
            dvdTable.append($('<div class="clearfix visible-md-block visible-lg-block"></div>'));
        }
        if ((index + 1) % 3 === 0) {
            dvdTable.append($('<div class="clearfix visible-sm-block"></div>'));
        }
        if ((index + 1) % 3 === 0) {
            dvdTable.append($('<div class="clearfix visible-xs-block"></div>'));
        }
    });
}

$('#a-z').click(function() {
    sortByTitle(-1, 1);
});

$('#z-a').click(function() {
    sortByTitle(1, -1);
});

function sortByTitle(num1, num2) {
    currentData.sort(function (a, b) {
        if (a.title < b.title)
            return num1;
        if (a.title > b.title)
            return num2;
        return 0;
    });
    
    fillDVDTable(currentData);
}

$('#search-button').click(function (event) {
    event.preventDefault();
    $.ajax({
        type: 'POST',
        url: '/Library/search/dvds',
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
        currentData = data;
        fillDVDTable(currentData);
        setNumOfDvds();
    });
});

$('#details-modal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var id = element.data('dvd-id');
    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: '/Library/getdvd/' + id
    }).success(function (dvd) {
        modal.find('#dvd-title').text(dvd.title);
        modal.find('#dvd-year').text(dvd.year);
        modal.find('#dvd-mpaa').text(dvd.mpaa);
        modal.find('#dvd-director').text(dvd.director);
        modal.find('#dvd-studio').text(dvd.studio);
        modal.find('#dvd-overview').text(dvd.overview);
        modal.find('#dvd-note').text(dvd.note);
        modal.find('#dvd-image').attr('src', dvd.image);
    });
});

function clearTable() {
    $('#dvd-table').empty();
}

function setNumOfDvds() {
    $('#num-of-dvds').text(currentData.length);
}