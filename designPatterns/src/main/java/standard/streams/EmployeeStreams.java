package standard.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStreams {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee.EmployeeBuilder().setFirstName("Jan").setLastName("Kowalski").setSalary(3500d).build());
        list.add(new Employee.EmployeeBuilder().setFirstName("Marian").setLastName("Nowak").setSalary(7777.78d).build());
        List<Double> salaryList = list.stream().map((e) -> e.getSalary()).collect(Collectors.toList());
        System.out.println(salaryList);

        list.stream().allMatch((e) -> e.getSalary() > 1000);
    }
}
