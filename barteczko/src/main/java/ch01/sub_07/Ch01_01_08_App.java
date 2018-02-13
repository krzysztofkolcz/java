package ch01.sub_07;

public class Ch01_01_08_App {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Zenek");
        Ch01_01_08_StaticInitVehicle vehicle201 = new Ch01_01_08_StaticInitVehicle(person,10,10,10,10);
        Ch01_01_08_StaticInitVehicle vehicle202 = new Ch01_01_08_StaticInitVehicle(person,10,10,10,10);
        System.out.println(vehicle201);
        System.out.println(vehicle202);
    }
}
