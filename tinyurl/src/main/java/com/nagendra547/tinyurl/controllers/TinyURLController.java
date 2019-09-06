package com.nagendra547.tinyurl.controllers;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagendra547.tinyurl.domain.TinyURL;
import com.nagendra547.tinyurl.services.TinyURLService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author nagendra
 *
 */
@RestController
@RequestMapping("/tinyurl")
@Api(value = "tinyurl", description = "Operations pertaining to tinyurl in Online")
public class TinyURLController {

	private TinyURLService tinyURLService;
	private static final Logger logger = LoggerFactory.getLogger(TinyURLController.class);

	@Autowired
	public void settinyURLService(TinyURLService tinyURLService) {
		this.tinyURLService = tinyURLService;
	}

	@ApiOperation(value = "View a list of available tinyURLs", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public Iterable<TinyURL> list(Model model) {
		logger.info("Listing All TinyURLs");
		Iterable<TinyURL> TinyURLList = tinyURLService.listAllTinyURLs();
		return TinyURLList;
	}

	@ApiOperation(value = "Search a tinyURL with an ID", response = TinyURL.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public TinyURL showTinyURL(@PathVariable Integer id, Model model) {
		TinyURL tinyURL = tinyURLService.getTinyURLById(id);
		return tinyURL;
	}

	@ApiOperation(value = "Add a tinyURL")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> saveTinyURL(@RequestBody TinyURL tinyURL) {
		logger.info("Creating TinyURL with tinyURL name : " + tinyURL.getLongURL());
		tinyURLService.saveTinyURL(tinyURL);
		return new ResponseEntity<>("TinyURL saved successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Show Total count of TinyURLs")
	@RequestMapping(value = "/count", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> showTotalCount() {
		
		Iterable<TinyURL> listAllTinyURLs = tinyURLService.listAllTinyURLs();
		int count = 0;
		Iterator<TinyURL> iterator = listAllTinyURLs.iterator();
		while(iterator.hasNext()) {
		    count++;
		    iterator.next();
		}
		logger.info("Getting total count of  TinyURLs: "+ count); 
		return new ResponseEntity<>(Integer.toString(count), HttpStatus.OK);

	}

	 @ApiOperation(value = "Delete a tinyURL")
	 @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE,
	 produces = "application/json")
	 public ResponseEntity<String> delete(@PathVariable Integer id){
		 logger.info("Deleting TinyURL with ID:  "+ id); 
	 tinyURLService.deleteTinyURL(id);
	 return new ResponseEntity<String>("TinyURL deleted successfully", HttpStatus.OK);
	
	 }

}
