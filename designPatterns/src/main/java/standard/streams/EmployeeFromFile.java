package standard.streams;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeFromFile {
    public static void main(String[] args) throws IOException, URISyntaxException {
        EmployeeFromFile emp = new EmployeeFromFile();
        System.out.println("K lastName list:");
        emp.findEmployeeWithLastNameStartingWithK();
        System.out.println("\n");
        System.out.println("Boss list:");
        emp.bossFromEmployee();
        System.out.println("\n");

        System.out.println("Tax & initials:");
        emp.countTax();
        System.out.println("\n");
        System.out.println("OrderBy salary:");
        emp.orderBySalary();
        System.out.println("\n");
        System.out.println("Salary sum:");
        emp.sumSalary();

        System.out.println("Employee set:");
        emp.employeeLastNameSet();

        System.out.println("Employee first name tree set:");
        emp.employeeFirstNameTreeSet();

        System.out.println("Group by map:");
        emp.createGroupByMap();
    }

    public Stream<String> fileLinesStream() throws IOException, URISyntaxException {
        URL url = this.getClass().getClassLoader().getResource("streams/employee.txt");
        Path p = Paths.get(url.toURI());
        Stream<String> ls = Files.lines(p);
        return ls;
    }

    public void openFile() {
        URL url = this.getClass().getClassLoader().getResource("streams/employee.txt");
        File file = null;
        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public Optional<List<Employee>> redEmployeeFromFile(){
        try{
            Stream<String> stream = fileLinesStream();
            List<Employee> employeeList = stream.map(Employee::new).collect(Collectors.toList());
            return Optional.of(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void findEmployeeWithLastNameStartingWithK(){
        List<Employee> employeeList =redEmployeeFromFile().get();
        employeeList.stream().filter(e -> e.getLastName().startsWith("K")).forEach(System.out::println);
    }

    public void bossFromEmployee(){
        List<Employee> employeeList =redEmployeeFromFile().get();
        List<Boss> bossList = employeeList.stream().filter(e -> e.getSalary() > 4000).map(Boss::new).collect(Collectors.toList());
        bossList.forEach(System.out::println);
    }

    public void countTax(){
        List<Employee> employeeList =redEmployeeFromFile().get();
        employeeList.stream().forEach(Employee::countTax);
        employeeList.stream().map(e -> e.getTax()).forEach(System.out::println);
        employeeList.stream().forEach(Employee::defineInitials);
        employeeList.stream().map(e -> e.getInitials()).forEach(System.out::println);
    }

    public void orderBySalary(){
        List<Employee> employeeList =redEmployeeFromFile().get();
        Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary);
        employeeList.stream().sorted(comparator).forEach(System.out::println);
        employeeList.stream().sorted(comparator.reversed()).forEach(System.out::println);
    }

    public void sumSalary(){
        List<Employee> employeeList =redEmployeeFromFile().get();
        Double salary = employeeList.stream().map(Employee::getSalary).reduce(0.0, (e1,e2) -> e1+e2);
        System.out.println(salary);
    }

    public void employeeLastNameSet(){
        List<Employee> employeeList =redEmployeeFromFile().get();
        Set<String> lastNameSet = employeeList.stream().map(Employee::getLastName).collect(Collectors.toSet());
        lastNameSet.stream().forEach(System.out::println);
    }

    public void employeeFirstNameTreeSet(){
        List<Employee> employeeList = redEmployeeFromFile().get();
        Set<String> firstNameSet = employeeList.stream().map(Employee::getFirstName).collect(Collectors.toCollection(TreeSet::new));
        firstNameSet.stream().forEach(System.out::println);
    }

    public void createGroupByMap(){
        List<Employee> employeeList = redEmployeeFromFile().get();

        Map<String,List<Employee>> empMap = employeeList.stream().collect(
          Collectors.groupingBy(
                  e -> e.getLastName().substring(0,1)
          )
        );

        empMap.forEach(
                (e,list) -> System.out.println(e + ":" + list.size())
        );

        for(Map.Entry<String,List<Employee>> entry : empMap.entrySet()){
            System.out.println(entry.getKey());
            Double salarySum = entry.getValue().stream().mapToDouble(Employee::getSalary).sum();
            System.out.println(salarySum);
        }
    }
}
