package ch12.locks;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public class StampedLockExample02 {
    private int x, y;
    private StampedLock lock = new StampedLock();
    // ...
    public List<Integer> getAsList() {
        long stamp = lock.tryOptimisticRead();
        // Tu czytamy bez żadnego blokowania, nawet gdy jakiś writeLock blokuje
        // w nadziei, że między odczytem a wykorzystaniem dane (x i y) nie będą zmienione
        Integer a = x, b = y;
        // Sprawdźmy to: validate zwraca true, gdy dane niezmienione,
        // false gdy nastąpiła zmiana
        if (lock.validate(stamp)) return Arrays.asList(a, b); // dane niezmienione
        else { // jeśli była zmiana,
            stamp = lock.readLock(); // musimy poczekać na normalny dostęp
            try { // i znowu odczytać dane
                a = x;
                b = y;
                return Arrays.asList(a, b);
            } finally {
                lock.unlockRead(stamp);
            }
        }
    }
}
