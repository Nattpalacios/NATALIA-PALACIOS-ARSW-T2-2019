var module = (function () {
    var nombre = document.getElementById("inputCiudad");

    return {
        mostrarAeropuerto: function(){
            apiclient.getAirportByName(nombre,alert)
        }
        
    }
  })();