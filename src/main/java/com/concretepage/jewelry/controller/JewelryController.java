package com.concretepage.jewelry.controller;

import com.concretepage.auth.service.IUserService;
import com.concretepage.auth.sucurity.util.CreateUserService;
import com.concretepage.jewelry.entity.Jewelry;
import com.concretepage.jewelry.service.JewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("jewelry")
public class JewelryController {

	@Autowired
	private JewelryService jewelryService;
	CreateUserService create = new CreateUserService();


	@RequestMapping(value = "/add", method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> createUser(@RequestBody Jewelry jewelry, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Jewelry " + jewelry.getArticle());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		boolean flag = jewelryService.addJewelry(jewelry);
		if (flag == false) {
			return new ResponseEntity<String>("already exsist", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String >("complete", HttpStatus.CREATED);

	}
	@RequestMapping(value = "/{barcode}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Jewelry> getUser(@PathVariable("barcode") Long barCode) {
		System.out.println("Fetching Jewelry with barcode " + barCode);
		Jewelry jewelry = jewelryService.getJewelryByBarCode(barCode);

		if (jewelry == null) {
			System.out.println("User with name " + barCode + " not found");
			return new ResponseEntity<Jewelry>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Jewelry>(jewelry, HttpStatus.OK);
	}
} 