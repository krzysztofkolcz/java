package com.kkolcz;

import java.util.*;

public class Country {

  private String iso02;
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

  public Country(String line){


  }

  public String getIso02(){
    return iso02;
  }

  public void setIso02(String iso02){
    this.iso02 = iso02;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getCapital(){
    return capital;
  }

  public void setCapital(String capital){
    this.capital = capital;
  }

  public String getCont(){
    return cont;
  }

  public void setCont(String cont){
    this.cont = cont;
  }

  public Double getArea(){
    return area;
  }

  public void setArea(Double area){
    this.area = area;
  }

  public Double getPopul(){
    return popul;
  }

  public void setPopul(Double popul){
    this.popul = popul;
  }

  public Double getPopDensity(){
    return popDensity;
  }

  public void setPopDensity(Double popDensity){
    this.popDensity = popDensity;
  }

  public String getCcode(){
    return ccode;
  }

  public void setCcode(String ccode){
    this.ccode = ccode;
  }

  public String getCname(){
    return cname;
  }

  public void setCname(String cname){
    this.cname = cname;
  }

  public List<String> getLang(){
    return lang;
  }

  public void setLang(List<String> lang){
    this.lang = lang;
  }

  public List<String> getNeighbours(){
    return neighbours;
  }

  public void setNeighbours(List<String> neighbours){
    this.neighbours = neighbours;
  }


}

