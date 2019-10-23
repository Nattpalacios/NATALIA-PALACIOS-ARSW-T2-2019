apiclient=(function(){
    return {
		getAirportByName: function(name,callback){            
			$.get( "/airport/"+name, function( data ) {
                callback(data);
              });
		}
	}
})();