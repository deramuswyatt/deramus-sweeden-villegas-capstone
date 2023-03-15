"use strict";

$(function () {

    function getImage() {
        const icon = $("#icon").val();
        // console.log(icon);
        var weatherIcon = '<span><img src="http://openweathermap.org/img/wn/' + icon + '@4x.png"' + ' alt="img"' + ' alt="control" ></span>'
        $("#wxIcon").html(weatherIcon);
    }
    getImage();

    // width="100" height="100"
    // "http://openweathermap.org/img/w/'

    function tempWarning() {
        const temp = $("#temp").val();
        // parseFloat(temp)
        console.log("test");
        if (temp > 90.00) {
            var warmWarning = '<div class="card prop-card" id="maintCard">' +
                '<h4 class="card-header">Hot Weather Related</h4>' +
                '<ul class="list-group list-group-flush">' +
                '<li class="list-group-item">If property is located on exansive soil, consider watering foundation.</li>' +
                '<li class="list-group-item">If property has elderly occupants, ensure they have adequate cooling/ventilation.</li>' +
                '<li class="list-group-item">Keep AC between 75-78 degrees to prevent coil from freezing.</li>' +
                '<li class="list-group-item">Watch pets for signs of heat injury.</li>' +
                '</ul>' +
                '</div>'
            $("#wxTempWarning").html(warmWarning);
        }
        if (temp < 32.00){
            var coldWarning =  '<div class="card prop-card" id="maintCard">' +
                '<h4 class="card-header">Cold Weather Related</h4>' +
                '<ul class="list-group list-group-flush">' +
                '<li class="list-group-item">Cover exposed exterior pipes and bibs.</li>' +
                '<li class="list-group-item">If property is vacant, keep thermostat to a minimum of 50–55 degrees.</li>' +
                '<li class="list-group-item">Run the taps periodically.</li>' +
                '<li class="list-group-item">Cover plants.</li>' +
                '<li class="list-group-item">Bring in pets.</li>' +
                '</ul>' +
                '</div>'
            $("#wxTempWarning").html(coldWarning);
        }
    }
    tempWarning();



    // '<h4>Hot Weather Related:</h4>' + '<ul class="list-group list-group-flush">' +
    // '<li class="list-group-item">If property is located on exansive soil, consider watering foundation.</li>' +
    // '<li class="list-group-item">If property has elderly occupants, ensure they have adequate cooling/ventilation.</li>' +
    // '<li class="list-group-item">Keep AC between 75-78 degrees to prevent coil from freezing.</li>' +
    // '<li class="list-group-item">Watch pets for signs of heat injury.</li>' +
    // '</ul>'
    //
    //
    //
    // '<h4>Cold Weather Related:</h4>' + '<ul class="list-group list-group-flush">' +
    // '<li class="list-group-item">Cover exposed exterior pipes and bibs.</li>' +
    // '<li class="list-group-item">If property is vacant, keep thermostat to a minimum of 50–55 degrees.</li>' +
    // '<li class="list-group-item">Run the taps periodically.</li>' +
    // '<li class="list-group-item">Cover plants.</li>' +
    // '<li class="list-group-item">Bring in pets.</li>' +
    // '</ul>'


    // $.ajax({
    //     url: "https://api.weather.gov/points/29.4,-98.4",
    //     dataType: "html"
    // })
    //     .done(function( html ) {
    //         $( "#results1" ).append( html );
    //     });
    //
    //     $.ajax({
    //     url: "https://api.weather.gov/gridpoints/TOP/31,80/forecast",
    //     dataType: "JSON-LD"
    // })
    //     .done(function( html ) {
    //         $( "#results2" ).append( html );
    //     });

});
