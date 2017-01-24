package lambdaExpr;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.math.BigDecimal;

public class Person {

  public enum Sex { MALE, FEMALE }

  String name;
  LocalDate birthday;
  Sex gender;
  String emailAddress;

  public int getAge() {
    LocalDate now = LocalDate.now();
    long numberOfYears = ChronoUnit.YEARS.between(birthday, now);
    int anInt = new BigDecimal(numberOfYears).intValueExact();
    return anInt;
  }
  public void printPerson() {
    System.out.println("Name:"+name+";  birthday:"+birthday+";  age:"+getAge()+";  gender:"+gender+";  emailAddress:"+emailAddress); 
  }



  public static List<Person> createRoster(){

    List<Person> roster = new ArrayList<Person>();

    Person p1 = new Person();
    p1.name = "Aaa";
    p1.birthday = LocalDate.of(1990,Month.JANUARY,1);
    p1.gender = Sex.FEMALE;
    p1.emailAddress = "aaa@aa.aa";

    Person p2 = new Person();
    p2.name = "Bbb";
    p2.birthday = LocalDate.of(1980,Month.JANUARY,10);
    p2.gender = Sex.FEMALE;
    p2.emailAddress = "bbb@bb.bb";

    Person p3 = new Person();
    p3.name = "Ccc";
    p3.birthday = LocalDate.of(1985,Month.JUNE,10);
    p3.gender = Sex.MALE;
    p3.emailAddress = "ccc@cc.cc";

    Person p4 = new Person();
    p4.name = "Ddd";
    p4.birthday = LocalDate.of(1995,Month.JUNE,17);
    p4.gender = Sex.MALE;
    p4.emailAddress = "ddd@dd.dd";

    roster.add(p1);
    roster.add(p2);
    roster.add(p3);
    roster.add(p4);
    return roster;
  }


  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }


  public void setBirthday(LocalDate birthday){
    this.birthday = birthday;
  }

  public LocalDate getBirthday(){
    return this.birthday;
  }


  public void setGender(Sex gender){
    this.gender = gender;
  }

  public Sex getGender(){
    return this.gender;
  }

  public void setEmailAddress(String emailAddress){
    this.emailAddress = emailAddress;
  }

  public String getEmailAddress(){
    return this.emailAddress;
  }
}
