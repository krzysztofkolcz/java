package ch04.sub11_inner_class;

import ch01.sub_07.VehState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ch04_04_05_CarInnerClass {

    private int fuel;
    private static int tankCapacity = 200;
    private VehState state = VehState.STOPPED;
    private Timer timer;

    public Ch04_04_05_CarInnerClass() {
        timer = new Timer(1000,new FuelController());
    }

    private class FuelController implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(fuel > 0) {
                fuel--;
            }
            if(fuel == 0){
               stop();
            }

        }
    }

    public void fillTank(int fill){
        if(fill > tankCapacity){
            fuel = tankCapacity;
        }else{
            fuel += fill;
        }
    }

    public Ch04_04_05_CarInnerClass start(){
        switch(state){
            case MOVING:
                System.out.println("Already moving");
                break;
            case STOPPED:
                System.out.println("Vehicle started");
                state = VehState.MOVING;
                timer.start();
                break;
            case BROKEN:
                System.out.println("Vehicle broken");
                break;
        }
        return this;
    }

    public Ch04_04_05_CarInnerClass stop(){
        state = VehState.STOPPED;
        timer.stop();
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "fuel=" + fuel +
                ", state=" + state +
                '}';
    }

    public class Inner{
        @Override
        public String toString() {
            return "Inner{} Car{" +
                "fuel=" + fuel +
                ", state=" + state +
                '}';
        }
    }

    public static void main(String[] args) {
        Ch04_04_05_CarInnerClass car = new Ch04_04_05_CarInnerClass();
        car.fillTank(3);
        car.start();
        /*
        for (int i=1; i<=9; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Po " + i+ " sek. - " + car);
        }
        */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Ch04_04_05_CarInnerClass.Inner inner = car.new Inner();
        System.out.println(inner);
    }
}
