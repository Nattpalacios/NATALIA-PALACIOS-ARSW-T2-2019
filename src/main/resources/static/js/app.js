var module = (function () {
    var nombre = document.getElementById("inputCiudad");
    var aeropuertos = {};

    var addRows = function(aeropuertoss){
        aeropuertos = aeropuertoss;
        for(var i = 0; i < aeropuertos.length; i++){
            var aeropuerto = aeropuertos[i];
            var code = aeropuerto.code;
            var name = aeropuerto.name;
            var city = aeropuerto.city;
            var countryCode = aeropuerto.countryCode;
            var txt = '<tr id="'+(i + 1)+'">'+
            '<th scope="row">'+code+'</th>'+
            '<td>'+name+'<td>'+
            '<td>'+city+'<td>'+
            '<td>'+countryCode+'<td>';
            $("#airports").append(txt);
        }
    };

    return {
        mostrarAeropuerto: function(){
            $('#airports').find('tbody').empty();
            var nombre = $('#inputCiudad').val();
            apiclient.getAirportByName(nombre,addRows);
        }
    }
  })();