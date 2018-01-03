package standard.concurrency.ch01.raceExample01;

public class Main {
    public static void main(String[] args) {
        Workers worker01 ,worker02 ;
        do{
            LazyInitRace lazyInitRace = new LazyInitRace();
            worker01 = new Workers(lazyInitRace);
            worker02 = new Workers(lazyInitRace);
            new Thread(worker01).start();
            new Thread(worker02).start();
            try {
                Thread.sleep(1200);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }while(worker01.getExpensiveObject() == worker02.getExpensiveObject());
        System.out.println("While finished");
        System.out.println(worker01.getExpensiveObject());
        System.out.println(worker02.getExpensiveObject());
    }
}
