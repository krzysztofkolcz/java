package com.kkolcz;

import java.io.*;
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;
import java.net.URISyntaxException;
import java.net.URL;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class App {

	public static void main( String[] args ) throws Exception{
		App app = new App();
    File file = app.getFile();
		Stream<String> ls = app.getLinesFromFile().stream();
		List<Country> clist = ls.map(Country::new).collect(toList());
		ls.close();

//		String nazwa = app.getCountryStartWith(clist,"P");
//		System.out.println(nazwa);
//		clist.stream().forEachOrdered(System.out::println);
//		app.calculatePopDencity(clist);
//		clist.stream().forEachOrdered(System.out::println);
//		app.sortByMostPopulatedCountries(clist);
//		Country biggestInEu = app.getBigestCountryInEurope(clist);
//		System.out.println(biggestInEu);
//		List<Country> smallestEu = app.getFiveSmallestInEurope(clist);
//		smallestEu.stream().forEach(c -> System.out.println(c));
//		System.out.println(String.format("%.2f",app.getPopulationEurope(clist)));
//		app.listToSet();
//      System.out.println(app.getChCountriesAsSingleString(clist));
//		app.getContinentsWithCountriesMap(clist);
		app.createMapIso2WithPopulation(clist);
	}


	public void coutriesWithMostPopulatedNaighbours(){

	}

	public void calculatePopDencity(List<Country> clist){
		clist.stream()
				.forEach(c -> {
					c.evalPopDensity();
					switch(c.getContinent()) {
						case "AF": c.setContinentName("Africa"); break;
						case "AN": c.setContinentName("Antarctica"); break;
						case "AS": c.setContinentName("Asia"); break;
						case "AU": c.setContinentName("Australia"); break;
						case "EU": c.setContinentName("Europe"); break;
						case "NA": c.setContinentName("North America"); break;
						case "OC": c.setContinentName("Oceania"); break;
						case "SA": c.setContinentName("South America"); break;
					}
				});
	}

	public String getCountryStartWith(List<Country> clist, String start){
		Optional<String> first = clist.stream()
				.map(Country::getName) // strumień wszystkich nazw
				.filter(s-> s.startsWith(start)) // strumień nazw na B
				.findFirst(); // pierwsza nazwa na B
		String nazwa = first.orElse("Nie ma kraju, którego nazwa zaczyna się na: "+start);
		return nazwa;
	}

	public File getFile(){
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("countryInfo.txt").getFile());
    return file;
	}

	public List<String> getLinesFromFile(){
		File file = getFile();
		List<String> result = new ArrayList<>();

			try (Scanner scanner = new Scanner(file)) {
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					result.add(line);
				}
				scanner.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return result;
	}

	//sortowanie po najbardziej zaludnionych krajach - ograniczenie do 5, kod 10.5
	//największy kraj w Europie
	//5 najmniejszych krajów w Europie
	//liczba ludności w Europie - redukcja, kod 10.6
	//wrzucenie listy do seta List<String> words = Arrays.asList("pies", "ala", "kot", "ala", "kot" );
	//napis, z elementami strumienia rozdzielonymi separatorem - przecinkiem - kraje zaczynające się na "Ch"
	//kolektory budujące mapy - zrobic strukturę, zawierającą kod kontynentu, oraz listę krajów - Map<String, List<Country>> contMap; - kod 10.7
	//utworzyć mapę Map<String, Double> popMap - kod iso2, liczba ludności
	//wykorzystać powyższą mapę do określenia krajów, których sąsiedzi mają największą liczbę ludności
	//generator - liczba liter 1 - 10, 5 takich wyrazów

	public void sortByMostPopulatedCountries(List<Country> clist){
		Comparator<Country> byPopulated = Comparator.comparing(Country::getPopulation);
		clist.stream()
				.sorted(byPopulated.reversed())
				.limit(4)
				.forEach(c -> System.out.println(c.getName() +":"+c.getPopulation()));
	}

	public Country getBigestCountryInEurope(List<Country> clist){
		Comparator<Country> byArea = Comparator.comparing(Country::getCountryCapitalArea);
		return clist.stream()
				.filter(c -> "EU".equals(c.getContinent()))
				.max(byArea).orElse(null);

	}

	public List<Country> getFiveSmallestInEurope(List<Country> clist){
		Comparator<Country> byArea = Comparator.comparing(Country::getCountryCapitalArea);
		return clist.stream()
				.filter(c -> c.getCountryCapitalArea() != null && "EU".equals(c.getContinent()))
				.sorted(byArea)
				.limit(5)
				.collect(toList());
	}

	public Double getPopulationEurope(List<Country> clist){
		return clist.stream()
				.filter(c -> "EU".equals(c.getContinent()))
				.mapToDouble(c -> c.getPopulation())
				.reduce(0.0, (n1,n2) -> n1 + n2)
				;
	}

	public Set<String> listToSet(){
		List<String> words = Arrays.asList("pies", "ala", "kot", "ala", "kot" );
		Set<String> wordsSet = words.stream().collect(Collectors.toSet());
		System.out.println(wordsSet);
		return wordsSet;
	}


	public String getChCountriesAsSingleString(List<Country> clist){
		return clist.stream()
				.filter(c -> c.getName().startsWith("Ch"))
				.map(c -> c.getName())
				.collect(Collectors.joining(" / "))
				;
	}

	public void getContinentsWithCountriesMap(List<Country> clist){
	  Map<String, List<Country>> contMap = clist.stream()
		.collect(groupingBy(Country::getContinent));
	  contMap.forEach(
			  (cont, cclist) -> System.out.println(cont + " - " + cclist.size())
	  );
	}

	public void createMapIso2WithPopulation(List<Country> clist){
		Map<String,Double> isoPopMap = clist.stream()
				.collect(toMap(Country::getIso,Country::getPopulation));
		isoPopMap.forEach(
				(iso,population) -> System.out.println(iso + " - " + population)
		);

		Map<String,Double> neighboursPopulation = clist.stream().filter( c -> c.getNeighbours() != null).collect(
			toMap(
				c -> c.getName(),
				c -> c.getNeighbours()
						.stream()
						.filter(nc -> isoPopMap.get(nc) != null)
						.mapToDouble(isoPopMap::get)
						.reduce(0.0, (n1,n2) -> n1 + n2)
			)
		);

//		neighboursPopulation.forEach(
//				(iso,population) -> System.out.println(iso + ":" + population)
//		);

		neighboursPopulation.entrySet()
				.stream()
				.sorted( (e1, e2) -> (int) (e2.getValue() - e1.getValue()) )
				.limit(5)
				.forEach( en ->
						System.out.printf("%s - %.3f\n", en.getKey(), en.getValue() / 1000)
		);
	}
}
