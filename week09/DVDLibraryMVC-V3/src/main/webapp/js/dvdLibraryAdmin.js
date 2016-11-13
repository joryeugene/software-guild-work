var currentData;

$(document).ready(function () {
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
                .append($('<p id="edit-delete-container">')
                        .append($('<a>').attr({
                            'onClick': 'deleteDVD(' + dvd.id + ')'
                        })
                                .append('<span class="glyphicon glyphicon-remove" id="delete-btn" aria-hidden="true"></span><br>')
                                ) // end <a>
                        .append($('<a>').attr({
                            'data-dvd-id': dvd.id,
                            'data-toggle': 'modal',
                            'data-target': '#edit-modal'
                        })
                                .append('<span class="glyphicon glyphicon-cog" id="edit-btn" aria-hidden="true"></span>')
                                ) // end <a>
                        ) // end <p>
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

        if (dvd.image.length < 1 || dvd.image === '/Library/img/dvd-placeholder.jpg' || dvd.overview.length < 1) {
            imgDiv = '#' + imgDiv;
            getExtras(dvd, imgDiv);
        }

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

$('#add-button').click(function (event) {
    event.preventDefault();
    $('.validationErrors').empty();

    $.ajax({
        type: 'POST',
        url: '/Library/dvd',
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
    var imageVal;
    var overviewVal;
    var titleVal = $('#edit-title').val();

    // this is for validation if input is null
    if (titleVal.length < 1) {
        titleVal = "jaiwejf3jfi3jfiaj23fjkdjf3f";
    }

    $.getJSON("https://api.themoviedb.org/3/search/movie?api_key=15d2ea6d0dc1d476efbca3eba2b9bbfb&query=" + titleVal + "&callback=?", function (json) {

        if (json.result !== undefined) {
            overviewVal = json.results[0].overview;
            imageVal = 'http://image.tmdb.org/t/p/w500/' + json.results[0].poster_path;
        } else {
            overviewVal = "";
            imageVal = '/Library/img/dvd-placeholder.jpg';
        }

        // this is for validation if input is null
        if (titleVal === "jaiwejf3jfi3jfiaj23fjkdjf3f") {
            titleVal = "";
        }

        $.ajax({
            type: 'PUT',
            url: '/Library/dvd/' + $('#edit-id').val(),
            data: JSON.stringify({
                id: $('#edit-id').val(),
                title: titleVal,
                year: $('#edit-year').val(),
                mpaa: $('#edit-mpaa').val(),
                director: $('#edit-director').val(),
                studio: $('#edit-studio').val(),
                overview: overviewVal,
                image: imageVal,
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
});


$('#edit-button-cancel').click(function () {
    $('.validationErrors').empty();
});

$('#search-form-toggle').click(function () {
    $('.validationErrors').empty();
    $('#search-form').removeClass('hidden');
    $('#add-form').addClass('hidden');
});
$('#add-form-toggle').click(function () {
    $('#add-form').removeClass('hidden');
    $('#search-form').addClass('hidden');
});

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

$('#a-z').click(function () {
    sortByTitle(-1, 1);
});

$('#z-a').click(function () {
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

$('#edit-modal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var id = element.data('dvd-id');
    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: '/Library/getdvd/' + id
    }).success(function (dvd) {
        modal.find('#edit-id').val(dvd.id);
        modal.find('#edit-title').val(dvd.title);
        modal.find('#edit-year').val(dvd.year);
        modal.find('#edit-mpaa').val(dvd.mpaa);
        modal.find('#edit-director').val(dvd.director);
        modal.find('#edit-studio').val(dvd.studio);
        modal.find('#edit-note').val(dvd.note);
        modal.find('#edit-overview').val(dvd.overview);
        modal.find('#edit-image').val(dvd.image);
    });
});

function deleteDVD(id) {
    var answer = confirm("Do you really want to delete this DVD?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: '/Library/dvd/' + id
        }).success(function () {
            loadDVDs();
        });
    }
}

function clearTable() {
    $('#dvd-table').empty();
}

function setNumOfDvds() {
    $('#num-of-dvds').text(currentData.length);
}

var getExtras = function (dvd, imgDiv) {
    $.getJSON("https://api.themoviedb.org/3/search/movie?api_key=15d2ea6d0dc1d476efbca3eba2b9bbfb&query=" + dvd.title + "&callback=?", function (json) {
        if (json != "Nothing found.") {
            dvd.overview = json.results[0].overview;
            dvd.image = 'http://image.tmdb.org/t/p/w500/' + json.results[0].poster_path;
            $(imgDiv).attr('src', dvd.image);

            $.ajax({
                type: 'PUT',
                url: '/Library/dvd/' + dvd.id,
                data: JSON.stringify({
                    id: dvd.id,
                    title: dvd.title,
                    year: dvd.year,
                    mpaa: dvd.mpaa,
                    director: dvd.director,
                    studio: dvd.studio,
                    note: dvd.note,
                    image: dvd.image,
                    overview: dvd.overview
                }),
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                'dataType': 'json'
            })
        } else {
            $(imgDiv).attr('src', '/Library/img/dvd-placeholder.jpg');
        }
    });
};

