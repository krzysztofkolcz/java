package collections.maps;

import java.util.*;
import java.io.*;

public class CompaniesFromFile{

  private String s;

  public CompaniesFromFile(String s){
    this.s = s;
  }

  public void test(){
    Scanner scanner = new Scanner(
        getClass().getResourceAsStream(this.s)
        // new File("/resources/companies.txt")
        );
    String name;
    String address;
    Map<String,String> map = new HashMap<>();
    while(scanner.hasNextLine()){
      name = scanner.nextLine();
			System.out.println(name);
      address = scanner.nextLine();
			System.out.println(address);
      map.put(name,address);
    }
    map.forEach( (key,val) -> System.out.println("\n Key:"+key+";\n Val:"+val) );
    System.out.println();
  }
  
  public static void main(String[] args) throws IOException{
    String s = "/resources/bla.txt";
    CompaniesFromFile c = new CompaniesFromFile(s);
    c.test();
  }

}
