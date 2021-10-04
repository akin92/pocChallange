package com.akin.poc.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.akin.poc.exceptions.CustomException;

@Remote
public interface CalculateSesionBeanRemote {

	public List<String> calculatePairOfParantesis(int n) throws CustomException; 
}
