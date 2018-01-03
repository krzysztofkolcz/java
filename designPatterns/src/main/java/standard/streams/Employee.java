package standard.streams;

public class Employee {
    private String firstName;
    private String lastName;
    private Double salary;
    private Double tax;
    private String initials;

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public void countTax(){
        if(this.salary < 4000){
            this.tax = this.salary * 0.35;
        }else{
            this.tax = this.salary * 0.45;
        }
    }

    public void defineInitials(){
        this.initials = this.firstName.substring(0,1) + this.lastName.substring(0,1);
    }

    public Employee(String line){
        String[] splitLine = line.split(",");
        firstName = splitLine[0];
        lastName = splitLine[1];
        salary = Double.valueOf(splitLine[2]);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee(EmployeeBuilder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.salary = builder.salary;
    }

    public String toString(){
        return this.firstName + ":" + this.lastName + ":" + this.salary;
    }

    public static class EmployeeBuilder{
        private String firstName;
        private String lastName;
        private Double salary;


        public String getFirstName() {
            return firstName;
        }

        public EmployeeBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public EmployeeBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Double getSalary() {
            return salary;
        }

        public EmployeeBuilder setSalary(Double salary) {
            this.salary = salary;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
