
package com.sanjeet.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectInsideJsonObject{

	public static Map<String,String> parse(JSONObject json , Map<String,String> out) throws JSONException{
		Iterator<String> keys = json.keys();
		while(keys.hasNext()){
			String key = keys.next();
			String val = null;
			try{
				JSONObject value = json.getJSONObject(key);
				parse(value,out);
			}catch(Exception e){
				val = json.getString(key);
			}

			if(val != null){
				out.put(key,val);
			}
		}
		return out;
	}

	public static void main(String[] args) throws JSONException {
		// String json = "{'ipinfo': {'ip_address': '131.208.128.15','ip_type': 'Mapped','Location': {'continent': 'north america','latitude': 30.1,'longitude': -81.714,'CountryData': {'country': 'united states','country_code': 'us'},'region': 'southeast','StateData': {'state': 'florida','state_code': 'fl'},'CityData': {'city': 'fleming island','postal_code': '32003','time_zone': -5}}}}";
		String json="{\"firstName\": \"John\", \"lastName\": \"Smith\", \"age\": 25,\"address\" : {\"streetAddress\": \"21 2nd Street\",\"city\": \"New York\",\"state\": \"NY\",\"postalCode\": \"10021\"},\"phoneNumber\":[{ \"type\": \"home\", \"number\": \"212 555-1234\" },{ \"type\": \"fax\", \"number\": \"646 555-4567\" }]}";
		JSONObject object = new JSONObject(json);
		JSONObject info = object.getJSONObject("address");
		Map<String,String> out = new HashMap<String, String>();
		parse(info,out);
		String streetAddress = out.get("streetAddress");
		String city = out.get("city");
		String state = out.get("state");
		String postalCode = out.get("postalCode");
		System.out.println("city : " + city +" State : "+ state + " streetAddress : "+streetAddress+" postal "+postalCode);
		System.out.println("ALL VALUE " + out);
		System.out.println("\n Json String Data \n");
		System.out.println("First Name:"+object.getString("firstName")+","+"Last Name:"+object.getString("lastName")+","+"Age:"+object.getInt("age"));
		System.out.println("Json Object Data:"+object.getJSONObject("address").getString("streetAddress"));




	}
}
