apiclient=(function(){
    return {
		getAirportByName: function(name,callback){            
			$.get( "/airports/"+name, function( data ) {
                callback(data);
              });
		}
	}
})();