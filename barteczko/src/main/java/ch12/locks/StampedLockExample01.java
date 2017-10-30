package ch12.locks;

import java.util.concurrent.locks.StampedLock;



public class StampedLockExample01 {
    private int x, y;
    private StampedLock lock = new StampedLock();
    // ...
    public void changeIfBothLessThen(int a, int b) {
        // Próbujemy uzyskać (zamknąć) lock w trybie czytania
        // Uda się, jeśli lock nie jest zamknięty w trybie zapisu
        // Jeśli się nie uda - czekamy na otwarcie dostępu
        // Jeśli się uda - możemy odczytać x i y
        long stamp = lock.readLock(); // dostajemy znacznik (po ew. oczekiwaniu)
        try { // warunek modyfikacji
            while (x < a && y < b) { // jeśli niespełniony -> finally i otwarcie locku
                // skoro mamy modyfikować - trzeba uzyskać lock do zapisu
                long wrtstmp = lock.tryConvertToWriteLock(stamp); // nowy stamp
                if (wrtstmp != 0) { // oznacza, że dostaliśmy dostęp (udane convert)
                    x = a; // więc dokonujemy zmian
                    y = a;
                    stamp = wrtstmp; // aktualizujemy stamp dla unlock w finally
                    break; // koniec i unlock
                } else { // konwersja do writeLock nieudana
                    lock.unlockRead(stamp); // trzeba zwolnić readLock
                    stamp = lock.writeLock(); // i czekać na dostęp w trybie pisania
                }
            }
        } finally {
            lock.unlock(stamp); // samo unlock pozwala otworzyć i write- i read-lock
        }
    }
}
