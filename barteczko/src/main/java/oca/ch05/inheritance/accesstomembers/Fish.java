package oca.ch05.inheritance.accesstomembers;

public class Fish {
    protected int size;
    private int age;
    //default - package access
    int speed;
    public Fish(int age) {
            this.age = age;
    }
    public int getAge() {
            return age;
    }
}