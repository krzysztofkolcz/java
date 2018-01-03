package standard.streams;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeFromFile02 {

    public static void main(String[] args) {
        EmployeeFromFile02 employeeFromFile02 = new EmployeeFromFile02();
        List<Employee> employeeList = employeeFromFile02.readEmployees();
        employeeList.forEach(System.out::println);
    }

    public Stream<String> readStringsFromFile(){
        URL url = this.getClass().getClassLoader().getResource("streams/employee.txt");
        try {
            Path p = Paths.get(url.toURI());
            return Files.lines(p);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> readEmployees(){
        Stream<String> stringStream = readStringsFromFile();
        List<Employee> employeeList = stringStream.map(Employee::new).collect(Collectors.toList());
        return employeeList;
    }
}
