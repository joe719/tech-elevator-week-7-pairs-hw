package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatFact;

@Component
public class RestCatFactService implements CatFactService {
	private RestTemplate restTemplate =new RestTemplate();

	@Override
	public CatFact getFact() {
		
		return  restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random", CatFact.class);
	}

}
