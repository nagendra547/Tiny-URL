package com.nagendra547.tinyurl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author nagendra
 *
 */
@Entity
public class TinyURL {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated tiny URL ID")
	private Integer id;

	@ApiModelProperty(notes = "The longURL name", required = true)
	private String longURL;

	@ApiModelProperty(notes = "The shortURL", required = true)
	private String shortURL;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShortURL() {
		return shortURL;
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}

	public String getLongURL() {
		return longURL;
	}

	public void setLongURL(String longURL) {
		this.longURL = longURL;
	}

}
