"use strict";

$(function () {

    function getImage() {
        const icon = $("#icon").val();
        // console.log(icon);
        var weatherIcon = '<span><img src="http://openweathermap.org/img/w/' + icon + '.png"' + ' alt="img"' + 'alt="control" width="100" height="100"></span>'
        $("#wxIcon").html(weatherIcon);
    }
    getImage();

    function tempWarning() {
        const temp = $("#temp").val();
        // parseFloat(temp)
        // console.log(temp);
        if (temp > 90.00) {
            var warmWarning = '<h4>Hot Weather Related:</h4>' + '<ul class="list-group list-group-flush">' +
                '<li class="list-group-item">If property is located on exansive soil, consider watering foundation.</li>' +
                '<li class="list-group-item">If property has elderly occupants, ensure they have adequate cooling/ventilation.</li>' +
                '<li class="list-group-item">Keep AC between 75-78 degrees to prevent coil from freezing.</li>' +
                '<li class="list-group-item">Watch pets for signs of heat injury.</li>' +
                '</ul>'
            $("#wxTempWarning").html(warmWarning);
        }
        if (temp < 32.00){
            var coldWarning = '<h4>Cold Weather Related:</h4>' + '<ul class="list-group list-group-flush">' +
                '<li class="list-group-item">Cover exposed exterior pipes and bibs.</li>' +
                '<li class="list-group-item">If property is vacant, keep thermostat to a minimum of 50–55 degrees.</li>' +
                '<li class="list-group-item">Run the taps periodically.</li>' +
                '<li class="list-group-item">Cover plants.</li>' +
                '<li class="list-group-item">Bring in pets.</li>' +
                '</ul>'
            $("#wxTempWarning").html(coldWarning);
        }
    }
    tempWarning();



    // $.get("https://api.mapbox.com/search-js/v1.0.0-beta.14/web.js", {
    //     APPID: OPEN_WEATHER_KEY,
    //     q: "San Antonio, US",
    //     units: "imperial"
    // }).done(function (data) {
    //     $('#five-day-forecast-location').html(
    //         '<h4> Current Weather:  San Antonio, TX </h4>' + '<br>' +
    //         '<h4> Temperature : ' + 'High ' + data.main.temp_max + ' / ' + 'Low ' + data.main.temp_min + ' , ' +
    //         'Description : ' + data.weather[0].main + ' , ' +
    //         'Humidity : ' + data.main.humidity + ' , ' +
    //         'Pressure : ' + data.main.pressure + '. </h4>'
    //     );
    // });


    // const apikey = $("#apikey").val();
//     const apikey = $("#apikey").val();
//     console.log(apikey);
//     $('#blue').click(function() {
//     console.log(apikey);
//
//
//         alert('h1 with id "codeup" was clicked');
//         //// Calling function ////
//
//         airQuality(29.4260, -98.4916);
//
//
// //// San Antonio 5 Day Forecast Code ////
//
//         getFiveDay(29.4260, -98.4916);
//     });




//// Open Weather Map Code w/ Current Weather Code ////

    // $.get("http://api.openweathermap.org/data/2.5/weather", {
    //     APPID: apikey,
    //     q: "San Antonio, US",
    //     units: "imperial"
    // }).done(function (data) {
    //     $('#five-day-forecast-location').html(
    //         '<h4> Current Weather:  San Antonio, TX </h4>' + '<br>' +
    //         '<h4> Temperature : ' + 'High ' + data.main.temp_max + ' / ' + 'Low ' + data.main.temp_min + ' , ' +
    //         'Description : ' + data.weather[0].main + ' , ' +
    //         'Humidity : ' + data.main.humidity + ' , ' +
    //         'Pressure : ' + data.main.pressure + '. </h4>'
    //     );
    // });

//// Open Weather Pollution Data - Current ////

    // function airQuality (lat, lng){
    //     $.get("http://api.openweathermap.org/data/2.5/air_pollution?lat=" + lat + "&lon=" + lng + "&appid=" + apikey + "&units=imperial").done(function (data) {
    //         var airQualreport = data.list;
    //         var airQual = airQualreport[0].main.aqi
    //         var airQaulData = airQualreport[0].components.no2 + ',  ---  Particulate Matter (PM10): ' + airQualreport[0].components.pm10 + ',  ---  Ozone: ' + airQualreport[0].components.o3 + ',  ---   Particulate Matter (PM2.5): ' + airQualreport[0].components.pm2_5
    //         if (airQual === 1){
    //             $('#air-qual').html( 'Air Quality Index:  GOOD,  ---  Nitrogen Dioxide: ' + airQaulData)
    //         } else if (airQual === 2){
    //             $('#air-qual').html( 'Air Quality Index:  FAIR,  ---  Nitrogen Dioxide: ' + airQaulData)
    //         } else if (airQual === 3){
    //             $('#air-qual').html( 'Air Quality Index:  MODERATE,  ---  Nitrogen Dioxide: ' + airQaulData)
    //         } else if (airQual === 4){
    //             $('#air-qual').html( 'Air Quality Index:  POOR,  ---  Nitrogen Dioxide: ' + airQaulData)
    //         } else if (airQual === 5){
    //             $('#air-qual').html( 'Air Quality Index:  VERY POOR,  ---  Nitrogen Dioxide: ' + airQaulData)
    //         }
    //     });
    // }

//// Calling function ////

    // airQuality(29.4260, -98.4916);


//// San Antonio 5 Day Forecast Code ////

    // getFiveDay(29.4260, -98.4916);


////5-day forecast function.  I used information from the following post to figure this out:  https://javascript.plainenglish.io/display-7-day-weather-forecast-with-openweather-api-aac8ba21c9e3 ////

    // function getFiveDay(lat, lng) {
    //     $.get("http://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lng + "&appid=" + apikey + "&units=imperial").done(function (data) {
    //         var reports = data.list;
    //         let weatherCards = '';
    //         for (let i = 0; i < reports.length; i += 8) {
    //             var icon = reports[i].weather[0].icon;
    //             var date = new Date(reports[i].dt_txt).toLocaleDateString('en-US');
    //             var formatDate = date.split('/').join('-');
    //             weatherCards += '<div class="card d-flex fiveDay" style="width: 18rem;">' +
    //                 '<div class="card-header">' + 'Day: ' + formatDate + '<span><img src="http://openweathermap.org/img/w/' + icon + '.png"' + ' alt="img"' + '></span>' +'</div>' +
    //                 '<ul class="list-group list-group-flush">' +
    //                 '<li class="list-group-item">' + 'Temp (High/Low): ' + reports[i].main.temp_max + ' / ' + reports[i].main.temp_min + '</li>' +
    //                 '<li class="list-group-item">' + 'Description: ' + reports[i].weather[0].main + ' / ' + reports[i].weather[0].description + '</li>' +
    //                 '<li class="list-group-item">' + 'Humidity: ' + reports[i].main.humidity + '</li>' +
    //                 '<li class="list-group-item">' + 'Pressure: ' + reports[i].main.pressure + '</li>' +
    //                 '</ul>' +
    //                 '</div>'
    //         }
    //         $('#five-day-card').html(weatherCards);
    //     });
    // }


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
