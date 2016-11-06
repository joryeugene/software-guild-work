$(document).ready(function () {
    drawChart();
});

function drawChart() {
    // dummy data - will be replaced with Ajax call
    var data = google.visualization.arrayToDataTable([
        ['Company', '# Contacts'],
        ['Oracle', 10],
        ['Apple', 11],
        ['Microsoft', 6],
        ['SWC Guild', 18]
    ]);

    var options = {
        title: 'Contacts By Company',
        vAxis: {title: 'Company', titleTextStyle: {color: 'red'}},
        hAxis: {title: 'Num Contacts', titleTextStyle: {color: 'red'}},
        'width': 800,
        'height': 500
    };

    var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

    chart.draw(data, options);
};