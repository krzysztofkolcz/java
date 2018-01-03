package patterns.prototype.exercise01;

import java.util.ArrayList;
import java.util.List;

public class EmpList implements Cloneable{

    List<String> employeeList;

    public EmpList() {
        this.employeeList = new ArrayList<>();
    }

    public EmpList(List<String> employeeList) {
        this.employeeList = employeeList;
    }

    public List<String> getEmpList(){
        return this.employeeList;
    }

    public void loadData(){
        employeeList.add("Jan Kowalski");
        employeeList.add("Sławomir Nowak");
        employeeList.add("Czesław Zawadzki");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> tmp = new ArrayList<>();
        for(String s : employeeList){
            tmp.add(s);
        }
        return new EmpList(tmp);
    }
}
