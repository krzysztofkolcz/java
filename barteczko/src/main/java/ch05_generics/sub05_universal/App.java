package ch05_generics.sub05_universal;

public class App {

//    public static <S,T> void copy(Para<S,T> src,Para<S,T> dst){ }

    static Para<? super Manager, ? super Manager>
    copy(Para<? extends Employee, ? extends Employee> src,
         Para<? super Manager, ? super Manager> dest) {
        dest.setFirst((Manager) src.getFirst());
        dest.setLast((Manager) src.getLast());
        return dest;
    }

    /*
    ERROR - nie do końca jasne
     */
    public static void main(String[] args) {
        Para<Employee,Employee> employeePara01 = new Para<>();
        Para<? extends Employee,? extends Employee> employeePara02 = new Para<>();
        Para<Manager,Manager> managerPara01 = new Para<>();
        Para<? super Manager,? super Manager> managerPara02 = new Para<>();

        Employee employee01 = new Employee("employee01");
        Employee employee02 = new Employee("employee02");

        Employee employee03 = new Employee("employee03");
        Employee employee04 = new Employee("employee04");

        employeePara01.setFirst(employee01);
        employeePara01.setLast(employee02);

        copy(employeePara01,managerPara02);
        System.out.println(employeePara02);

        Person person01 = new Person("person01");
        Person person02 = new Person("person02");

        Manager manager01 = new Manager("manager01");
        Manager manager02 = new Manager("manager02");

    }
}
