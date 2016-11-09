$(document).ready(function () {
    drawChart();
});

//function drawChart() {
//    // dummy data - will be replaced with Ajax call
//    var data = google.visualization.arrayToDataTable([
//        ['Company', '# Contacts'],
//        ['Oracle', 10],
//        ['Apple', 11],
//        ['Microsoft', 6],
//        ['SWC Guild', 18]
//    ]);
//
//    var options = {
//        title: 'Contacts By Company',
//        vAxis: {title: 'Company', titleTextStyle: {color: 'red'}},
//        hAxis: {title: 'Num Contacts', titleTextStyle: {color: 'red'}},
//        'width': 800,
//        'height': 500
//    };
//
//    var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
//
//    chart.draw(data, options);
//}
//;

function drawChart() {
    $.get('/DVDLibrary/stats/mpaachart').success(function (data) {
        var dataTable = new google.visualization.DataTable(data);
        var options = {
            title: 'DVDs By MPAA Rating',
            vAxis: {title: 'MPAA Rating', titleTextStyle: {color: 'red'}},
            hAxis: {title: '# DVDs', titleTextStyle: {color: 'red'}},
            'width': 500,
            'height': 400,
            legend: { position: "none" }
        };
        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        chart.draw(dataTable, options);
    });
}