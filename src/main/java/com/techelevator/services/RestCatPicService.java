package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatPic;


@Component
public class RestCatPicService implements CatPicService {

	RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public CatPic getPic() {
		
		CatPic catPics = null;
             catPics = restTemplate.getForObject("https://random-cat-image.herokuapp.com/", CatPic.class);
             return catPics;

	}

}	
