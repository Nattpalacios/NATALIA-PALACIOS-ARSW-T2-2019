package edu.eci.arsw.Airports.persistence.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import edu.eci.arsw.Airports.model.Airport;
import edu.eci.arsw.Airports.persistence.AirportPersistence;

@Service
public class AirportPersistenceImpl implements AirportPersistence{
	@Singleton
    @Autowired
    private ConcurrentHashMap<String, Airport> aeropuertos = new ConcurrentHashMap<>();
	@Singleton
    private ConcurrentHashMap<String, Long> tiempo =  new ConcurrentHashMap<>();
    private static final String USER_AGENT = "";

    @Override
    public ArrayList<Airport> getAirportByName(String ciudad) throws IOException {
        ArrayList<Airport> aero = new ArrayList<>();
        if(aeropuertos.contains(ciudad)) {
            long ini = tiempo.get(ciudad);
            long fin = System.currentTimeMillis();
            if(fin-ini <= 300000) {
                aero.add(aeropuertos.get(ciudad));
            }else {
                //conectar con api
                String aeropuerto = getHttpConnection(ciudad);
                try {
                    JSONArray jsonArray = new JSONArray(aeropuerto);
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject jsonObj = jsonArray.getJSONObject(i);

                        Airport air = new Airport(jsonObj.get("airportId").toString(), jsonObj.get("code").toString(), jsonObj.get("name").toString(), jsonObj.get("cityId").toString(), jsonObj.get("city").toString(), jsonObj.get("countryCode").toString());
                        aero.add(air);
                    }
                }catch (JSONException err){
                    System.err.println(err);
                }
            }
        } else {
            // conectar con api
            String aeropuerto = getHttpConnection(ciudad);
            System.err.println(aeropuerto);
            try {
                JSONArray jsonArray = new JSONArray(aeropuerto);
                for (int i = 0; i < jsonArray.length(); i++)
                {
                    JSONObject jsonObj = jsonArray.getJSONObject(i);

                    Airport air = new Airport(jsonObj.get("airportId").toString(), jsonObj.get("code").toString(), jsonObj.get("name").toString(), jsonObj.get("cityId").toString(), jsonObj.get("city").toString(), jsonObj.get("countryCode").toString());
                    aero.add(air);
                    System.err.println(aeropuerto);
                }
            }catch (JSONException err){
                System.err.println(err);
            }

        }
        return aero;
    }

    public static String getHttpConnection(String name) throws IOException {
        String url = "https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=" + name;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("x-rapidapi-key", "b02742e1cfmsh794c496267578c6p1f52bdjsn82383be54781");

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.err.println(inputLine);
            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return null;
    }

}