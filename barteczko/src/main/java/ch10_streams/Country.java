package ch10_streams;

import java.util.*;
import java.util.Arrays;

public class Country {

/*
  private String iso02;
  private String iso03;
  private String isoNumeric;
  private String fips;
  private String name;
  private String capital;
  private String cont;
  private Double area;
  private Double popul;
  private Double popDensity;
  private String ccode;
  private String cname;
  private List<String> lang;
  private List<String> neighbours;
*/

	private String iso;
	private String iso3 ;
	private String isoNumeric ;
	private String fips ;
	private String name;
	private String capital;
	private Double countryCapitalArea;
	private Double population ;
	private String continent ;

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	private String continentName ;
	private String tld ;
	private String currencyCode ;
	private String currencyName ;
	private String phone ;
	private String postalCodeFormat ;
	private String postalCodeRegex ;
	private List<String> languages ;
	private String geonameid ;
	private List<String> neighbours ;
	private String equivalentFipsCode;
	private Double popDensity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public Country(String line){
    String[] splited = line.split("\\t");
    List<String> splitedList = Arrays.asList(splited);
	this.iso = splitedList.get(0);
	this.iso3 = splitedList.get(1) ;
	this.isoNumeric = splitedList.get(2) ;
	this.fips = splitedList.get(3);
	this.name = splitedList.get(4);
	this.capital = splitedList.get(5);
	this.countryCapitalArea = Double.parseDouble(splitedList.get(6));
	this.population = Double.parseDouble(splitedList.get(7));
	this.continent = splitedList.get(8);
	this.tld = splitedList.get(9);
	this.currencyCode = splitedList.get(10);
	this.currencyName = splitedList.get(11);

	this.phone = splitedList.get(12);
	this.postalCodeFormat = splitedList.get(13);
	this.postalCodeRegex = splitedList.get(14);
	this.languages = Arrays.asList(splitedList.get(15).split(","));
	this.geonameid = splitedList.get(16);
	if(splitedList.size() == 18) {
		this.neighbours = Arrays.asList(splitedList.get(17).split(","));
	}
	this.popDensity = 0.0;
//	System.out.println(this);
  }

  public void evalPopDensity(){
		this.popDensity = this.population / this.countryCapitalArea;
  }

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getIsoNumeric() {
		return isoNumeric;
	}

	public void setIsoNumeric(String isoNumeric) {
		this.isoNumeric = isoNumeric;
	}

	public String getFips() {
		return fips;
	}

	public void setFips(String fips) {
		this.fips = fips;
	}

	public Double getCountryCapitalArea() {
		return countryCapitalArea;
	}

	public void setCountryCapitalArea(Double countryCapitalArea) {
		this.countryCapitalArea = countryCapitalArea;
	}

	public Double getPopulation() {
		return population;
	}

	public void setPopulation(Double population) {
		this.population = population;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getTld() {
		return tld;
	}

	public void setTld(String tld) {
		this.tld = tld;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCodeFormat() {
		return postalCodeFormat;
	}

	public void setPostalCodeFormat(String postalCodeFormat) {
		this.postalCodeFormat = postalCodeFormat;
	}

	public String getPostalCodeRegex() {
		return postalCodeRegex;
	}

	public void setPostalCodeRegex(String postalCodeRegex) {
		this.postalCodeRegex = postalCodeRegex;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public String getGeonameid() {
		return geonameid;
	}

	public void setGeonameid(String geonameid) {
		this.geonameid = geonameid;
	}

	public List<String> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<String> neighbours) {
		this.neighbours = neighbours;
	}

	public String getEquivalentFipsCode() {
		return equivalentFipsCode;
	}

	public void setEquivalentFipsCode(String equivalentFipsCode) {
		this.equivalentFipsCode = equivalentFipsCode;
	}

	public String toString(){

  		return
				"------------------------------------------"+ "\n" +
				this.name + "(" + this.continent + ")" + "\n" +
				"km.kw:" + this.countryCapitalArea + " ludność:" + this.population + "\n" +
				"gęstość zaludnienia:" + this.popDensity + "\n" +
				"------------------------------------------"+ "\n";
	}
}

