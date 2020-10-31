package com.techelevator.controller;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;

import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CatController {

	private CatCardDAO catCardDao;
	private CatFactService catFactService;
	private CatPicService catPicService;

	public CatController(CatCardDAO catCardDao, CatFactService catFactService, CatPicService catPicService) {
		this.catCardDao = catCardDao;
		this.catFactService = catFactService;
		this.catPicService = catPicService;
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<CatCard> list() {
		return catCardDao.list();

	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public CatCard get(@PathVariable long id) {
		return catCardDao.get(id);

	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public boolean save(@RequestBody CatCard cardToSave) {
		return catCardDao.save(cardToSave);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public boolean update(@PathVariable long id, @Valid @RequestBody CatCard card) throws CatCardNotFoundException {

		return catCardDao.update(id, card);

	}

	@RequestMapping(path = "/random", method = RequestMethod.GET)
	public CatCard random() {

		CatCard random = new CatCard();
		
		CatFact randomCatFact = catFactService.getFact();
		random.setCatFact(randomCatFact.getText());

		CatPic randomCatPic = catPicService.getPic();
		random.setImgUrl(randomCatPic.getFile());
		random.setCaption("Radom Cat");
		
		return random;

	}

}
