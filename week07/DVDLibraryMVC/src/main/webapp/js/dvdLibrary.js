$(document).ready(function () {
    loadDVDs();
});

function loadDVDs() {
    clearTable();
    var dvdTable = $('#contentRows');
    $.each(testDVDData, function (index, dvd) {
        dvdTable.append($('<tr>')
                .append($('<td>').append($('<a>').attr({
                    'data-id': dvd.id,
                    'data-toggle': 'modal',
                    'data-target': '#detailsModal'
                }).text(dvd.title)))
                .append($('<td>').text(dvd.year))
                .append($('<td>').text(dvd.mpaa))
                .append($('<td>').text(dvd.director))
                .append($('<td>').text(dvd.studio))
                .append($('<td>').text(dvd.note))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-id': dvd.id,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .html('Edit<br>')
                                ) // ends the <a> tag
                        .append($('<a>')
                                .attr({
//                                    'data-id': dvd.id,
//                                    'data-toggle': 'modal',
//                                    'data-target': '#editModal'
                                })
                                .text('Delete')
                                ) // ends the <a> tag
                        ) // ends the <td> tag for Edit
                );
    });
}

$('#detailsModal').on('show.bs.modal', function (event) {
//    var element = $(event.relatedTarget);
//    var id = element.data('dvd-id');
    var modal = $(this);
    modal.find('#dvd-title').text(testDVDData[0].title);
    modal.find('#dvd-year').text(testDVDData[0].year);
    modal.find('#dvd-mpaa').text(testDVDData[0].mpaa);
    modal.find('#dvd-director').text(testDVDData[0].director);
    modal.find('#dvd-studio').text(testDVDData[0].studio);
    modal.find('#dvd-note').text(testDVDData[0].note);
    //    modal.find('#dvd-id').text(testDVDData[0].id);
});

$('#editModal').on('show.bs.modal', function (event) {
//    var element = $(event.relatedTarget);
//    var id = element.data('dvd-id');
    var modal = $(this);
    modal.find('#edit-title').val(testDVDData[1].title);
    modal.find('#edit-year').val(testDVDData[1].year);
    modal.find('#edit-mpaa').val(testDVDData[1].mpaa);
    modal.find('#edit-director').val(testDVDData[1].director);
    modal.find('#edit-studio').val(testDVDData[1].studio);
    modal.find('#edit-note').val(testDVDData[1].note);
    //    modal.find('#edit-id').val(testDVDData[1].id);
});

function clearTable() {
    $('#contentRows').empty();
}

// TEST DATA
var testDVDData = [
    {
        title: "Spirited Away",
        year: "2001",
        mpaa: "PG",
        director: "Hayao Miyazaki",
        studio: "Studio Ghibli",
        note: "Girl does some dirty work at a bathhouse"},
    {
        title: "My Neighbor Totoro",
        year: "1988",
        mpaa: "G",
        director: "Hayao Miyazaki",
        studio: "Studio Ghibli",
        note: "Scary monsters try to eat two kids"},
    {
        title: "Princess Mononoke",
        year: "1997",
        mpaa: "PG-13",
        director: "Hayao Miyazaki",
        studio: "Studio Ghibli",
        note: "Cute little forest spirits get mad"}
];