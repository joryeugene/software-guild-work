$(document).ready(function () {
    drawMpaaChart();
    drawYearChart();
});

function drawMpaaChart() {
    $.get('/Library/stats/mpaachart').success(function (data) {
        var dataTable = new google.visualization.DataTable(data);
        var options = {
            title: 'DVDs By MPAA Rating',
            hAxis: {title: 'MPAA Rating', titleTextStyle: {color: 'red'}},
            vAxis: {title: '# DVDs', titleTextStyle: {color: 'red'}},
            'width': 500,
            'height': 500,
            legend: { position: "none" }
        };
        var chart = new google.visualization.ColumnChart(document.getElementById('mpaa-chart'));
        chart.draw(dataTable, options);
    });
}

function drawYearChart() {
    $.get('/Library/stats/yearchart').success(function (data) {
        var dataTable = new google.visualization.DataTable(data);
        var options = {
            title: 'DVDs By Year',
            vAxis: {title: 'Year', titleTextStyle: {color: 'red'}},
            hAxis: {title: '# DVDs', titleTextStyle: {color: 'red'}},
            'width': 500,
            'height': 500,
            legend: { position: "none" },
            bars: 'horizontal'
        };
        var chart = new google.visualization.BarChart(document.getElementById('year-chart'));
        chart.draw(dataTable, options);
    });
}