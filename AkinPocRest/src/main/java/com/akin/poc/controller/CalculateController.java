package com.akin.poc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.akin.poc.exceptions.CustomException;
import com.akin.poc.interfaces.CalculateSesionBeanRemote;

@Stateless
public class CalculateController implements CalculateSesionBeanRemote {

	public List<String> calculatePairOfParantesis(int n) throws CustomException{
		
		List<String> parantesisList = new ArrayList<String>();
		if(n == 0) {
			throw new CustomException("You should set value different than 0 ");
		}
		try {
			 if (n == 1) {
				parantesisList.add("()");
				return parantesisList;
			}
			
			for (String st : calculatePairOfParantesis(n - 1)) {
				parantesisList.add(st + "()");
				parantesisList.add("(" + st + ")");
				if (!(st + "()").equals("()" + st)) {
					parantesisList.add("()" + st);
				}
			}
		} catch (Exception e) {
			System.out.println("Got error during calculate combination of Parantesis");
		}

		return parantesisList;
	}

}
