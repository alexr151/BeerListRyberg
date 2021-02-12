package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="beerlist")
public class BeerItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="BREWERY")
	private String brewery;
	
	@Column(name="BEER_NAME")
	private String beerName;
	
	@Column(name="BEER_TYPE")
	private String beerType;
	
	public BeerItem() {
		super();
	}

	public BeerItem(String brewery, String beerName, String beerType) {
		super();
		this.brewery = brewery;
		this.beerName = beerName;
		this.beerType = beerType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrewery() {
		return brewery;
	}

	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}

	public String getBeerName() {
		return beerName;
	}

	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}

	public String getBeerType() {
		return beerType;
	}

	public void setBeerType(String beerType) {
		this.beerType = beerType;
	}
	
	public String returnBeerItemDetails() {
		return this.brewery + ": " + this.beerName + " (" + this.beerType + ").";
	}
}
