package standard.streams;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void employeeBuilderTest() {
        Employee.EmployeeBuilder builder = new Employee.EmployeeBuilder();
        Employee janKowalski = builder.setFirstName("Jan").setLastName("Kowalski").setSalary(3500d).build();
        Employee marianWiszko = builder.setFirstName("Marian").setLastName("Wiszko").setSalary(7777.78d).build();
        assertEquals("Kowalski", janKowalski.getLastName());
        assertEquals("Marian", marianWiszko.getFirstName());
    }

    @Test
    public void sumsIntegers() throws Exception {
        final Integer b = 3;
        final Integer c = 1;

        assertEquals(4, b + c);

    }

}
