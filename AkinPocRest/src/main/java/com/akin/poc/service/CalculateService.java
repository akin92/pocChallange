package com.akin.poc.service;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;


@Path("/calculate")
public class CalculateService {

	@Path("{value}")
	@GET
	@Produces("application/json")
	
	public Response calculateParantesesCombination(@PathParam("value") int value) throws JSONException {
		
		JSONObject jsonObject = new JSONObject();
		
		if(value==0) {
			jsonObject.put("combination",0);
		}else {
			jsonObject.put("combination",calculatePairOfParantesis(value).size());
		}
	
		String result =  jsonObject.toString();
		return Response.status(200)
				.header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			      .entity(result).build();
	}
	
    public static List<String> calculatePairOfParantesis(int n) {
        List<String> parantesisList = new ArrayList<String>();
        if(n==1) {
            parantesisList.add("()");
            return parantesisList;
        }
        for(String st : calculatePairOfParantesis(n-1)) {
            parantesisList.add(st+"()");
            parantesisList.add("("+st+")");
            if(!(st+"()").equals("()"+st)) {
                parantesisList.add("()"+st);
            }
        }
        return parantesisList;
    }
	
}
