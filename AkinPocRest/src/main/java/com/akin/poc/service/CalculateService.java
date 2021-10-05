package com.akin.poc.service;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import com.akin.poc.controller.CalculateController;
import com.akin.poc.exceptions.CustomException;


@Path("/calculate")
public class CalculateService {
	
	private final static Logger logger = Logger.getLogger(CalculateService.class.getName());

	@EJB
	CalculateController calculateController;
	
	public CalculateService() {
		calculateController = new CalculateController();
	}

	@Path("{value}")
	@GET
	@Produces("application/json")
	public Response calculateParantesesCombination(@PathParam("value") int value)  {

		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("combination", calculateController.calculatePairOfParantesis(value).size());
		} catch (CustomException e) {
			jsonObject.put("combination", 0);
			logger.info(e.getMessage());
		}
		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(jsonObject.toString()).build();
	}
}
