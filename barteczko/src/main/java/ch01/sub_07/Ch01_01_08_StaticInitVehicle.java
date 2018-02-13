package ch01.sub_07;

import java.util.Calendar;
import java.util.Locale;

import static ch01.sub_07.VehState.BROKEN;
import static ch01.sub_07.VehState.MOVING;
import static ch01.sub_07.VehState.STOPPED;

public class Ch01_01_08_StaticInitVehicle {

    private int width, height, length, weight;
    private Person owner;
    private VehState state;
    private static int initNr;
    private static int count = 0;
    // zwraca unikatowy numer pojazdu
    // pola niestatyczne
    private int currNr = ++initNr;

    public Ch01_01_08_StaticInitVehicle(int w, int h, int l, int ww) {
        this(null, w, h, l, ww);
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Ch01_01_08_StaticInitVehicle.count = count;
    }

    public Ch01_01_08_StaticInitVehicle(Person p, int w, int h, int l, int ww) {
        owner = p; width = w; height = h;
        length = l; weight = ww; state = STOPPED;
        // Każde utworzenie nowego obiektu zwiększa licznik o 1
        // bieżąca wartość licznika nadawana jest jako numer pojazdu
        // numer pojazdu jest niestatycznym polem klasy, a więc elementem obiektu
        count++;
    }

    public void start() {
        setState(MOVING);
    }
    public void stop() {
        setState(STOPPED);
    }
    public void repair() {
        if (state != BROKEN) error("Nie można reperować sprawnego pojazdu");
        else state = STOPPED;
    }
    public VehState getState() {
        return state;
    }
    public void sellTo(Person p) {
        owner = p;
    }
    public void crash(Ch01_01_08_StaticInitVehicle v) {
        if (this.state != MOVING && v.state != MOVING)
            error("Żaden z pojazdów nie jest w ruchu - nie ma zderzenia");
        this.state = BROKEN;
        v.state = BROKEN;
    }
    public String toString() {
        String s = (owner == null ? "sklep" : owner.getName());
        return "Pojazd," + currNr + " właścicielem którego jest " + s + " jest w stanie " + state;
    }
    private void setState(VehState newState) {
        if (state == BROKEN)
            error("Nie jest możliwe przejście ze stanu " + state + " do stanu " + newState);
        else
            state = newState;
    }
    protected void error(String msg) {
        throw new IllegalArgumentException(msg);
    }

    // Niestatyczny blok inicjacyjny
    // -- w niedzielę wszystkie samochody inicjalnie stoją
    // -- w poniedziałek te o parzystych numerach inicjalnie jadą,
    //    inne - stoją
    // -- w pozostałe dni tygodnia:
    //    wszystkie jadą
    { // początek bloku
        int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case Calendar.SUNDAY : state = STOPPED; break;
            case Calendar.MONDAY : state = (currNr % 2 == 0 ? MOVING : STOPPED);
                break;
            default : state = MOVING; break;
        }
    } // koniec bloku
    // Konstruktory i metody klasy

    public int getNr() { return currNr; }

    // Statyczny blok inicjacyjny
    // za jego pomocą inicjujemy zmienną initNr w taki sposób,
    // by numery pojazdów zaczynały się w zależności
    // od domyślnej lokalizacji aplikacji
    // np. jeśli aplikacja jest wykonywana w lokalizacji włoskiej,
    // numery zaczynają się od 10000.
    static {
        Locale[] loc = { Locale.UK, Locale.US, Locale.JAPAN, Locale.ITALY, };
        int[] begNr = { 1, 100, 1000, 10000, };
        initNr = 200; // jeżeli aplikacja działa w innej lokalizacji niż wymienione
        // w tablicy, zaczynamy numery od 200
        Locale defLoc = Locale.getDefault(); // jaka jest domyślna lokalizacja?
        for (int i=0; i < loc.length; i++)
        if (defLoc.equals(loc[i])) {
            initNr = begNr[i];
            break;
        }
    }// koniec bloku
}
