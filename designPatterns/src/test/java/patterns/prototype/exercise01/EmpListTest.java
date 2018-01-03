package patterns.prototype.exercise01;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmpListTest {

    @Test
    public void testEmpList(){
        EmpList empList = new EmpList();
        empList.loadData();
        System.out.println(empList.getEmpList());

        try {
            EmpList empList1 = (EmpList)empList.clone();
            empList1.getEmpList().add("Stafan Stefański");
            System.out.println(empList1.getEmpList());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}