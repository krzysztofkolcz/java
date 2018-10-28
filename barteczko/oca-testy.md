#ch01 

19. C,D 
3: one -> Rabbit_01
4: two -> Rabbit_02
5: three -> Rabbit_01
6: one -> null
8: four -> null
9: two -> null (Rabbit_02 nie ma referencji)
10: two -> RAbbit_03
Rabbit_01 (three)
Rabbit_02 (-)
Rabbit_03 (two)
A - false
B - false
C - true
D - true
E - false
F - false

20. B, E
21. A
22. B, E,
23. C, D


## 001 - 21/23
1. A,B,E - ok 
2. D - ok
3. B,D,E - ok
4. A,B - ok
5. C,D - ok
6. E - ok 
7. A,B,C - ok
8. B - ok
9. A,C,D,E - ok
10. E - ok
11. C,D - ok
12. G - ok
13. A,D - ok
14. D - ok
15. A,E - ok
16. B,C - zle, B,C,D - 0x może być pryzpisane do double
17. A,E - ok
18. C,D,E - ok
19. B,D - ok
20. B,E	- ok
21. A - ok
22. B,E - ok
23. C,E - zle, C,D

### 002 - 21/23

1. A,B,C - zle! - A,B,E musiało mi się popieprzyć, bo dobrze wiem, ze tak jest.
2. D - ok
3. B,D,E - ok
4. A,B - ok 
5. C,D - ok
6. E  - ok
7. A,B,C - ok
8. B - ok
9. A,C,D,E - ok
10. E - ok
11. C,D - ok
12. G - ok
13. A,D, - ok
14. D - ok
15. A,E - ok
16. B,C,D(!) - ok - czy double można inicjalizować bez kropki? Wynika z tego, ze dla hex tak
ale tylko dla hex!!!!
17. A,E - ok
18. C,D,E, - ok
19. B,D - ok
20. B,E - ok
21. A - ok
22. B,E  - ok (java has pointers? - nie)
23. C,D,F - zle! java bierze nazwe klasy jako parametr

one,three -> R1
two -> R2
6:
three -> R1
two -> R2
7:
three -> R1
two -> R2
8:
-> R1
two -> R2
9:
-> R1
-> R2
10:
-> R1
-> R2
two -> R3









































#ch02 

#ch03 16 zle, 17 dobrze (51%)
1. A,D - zle
2. A,C,D - ok
3. B,C,E - ok
4. F - zle (zapamietac metody StringBuildera, insert jest ok)
5. F - equals String i StringBuilder - różne typy - odpowiedz ok, rozumowanie zle
- rożne typy ale nie kompiluje się przez == a nie przez equals!!!!!
6. B - ok
7. B,D,E - ok
8. G? - substring potrzebuje 2 argumentów? odp. nie potrzebuje (czyli nauczyć się trzeba argumentów metod) - zle
9. "purr two"  - C - ok
10. F - ok
11. E - ok
12. A - ok
13. B - zle
rumble
rumble4
rumle4
rum4
14. A,C - ok
B - vaJ$
C - avaJ
15. C, E - zle
16. F - zle
17. B,F - zle
18. A,C - zle
19. A,C - zle
20. D - ok
21. C - ok
22. D - ok
23. A - ok
24. A - zle
25. B - zle
26. D - zle
27. C - zle
28. B,F - zle
29. D - ok
30. F - ok
31. F - zle
32. A - zle
33. B - ok

# ch03 11 zle, 22 dobrze (66%)
1. G - do Stringa nie mogę przypisać inta - ok
2. A,C,D - ok
3. B,C,E - ok 
4. B - ok
aaa
abbaa
abbaccca
5. F - ok
6. B - ok
7. B,D,E - ok
8. A,E,G - zle, A,D,E subsring mozna podac 1 argument.
9. C - ok
10. F - ok
11. E - ok
12. A - ok
0189
0189-
01+89-
13. B - zle!!! UWAGA przypisanie String do StringBuildera!!!
rumble4
rumle4    0r 1u 2m 3l 4e 54    3, 5
rum4
14. A,C - ok
JavavaJ$
avaJ$
15. C,E, - zle!!! w tablicach dwuwymiarowych pierwszy wymiar musi być zainicjalizowany
16. D - zle!!!, C. arrays definiuja właściwość length (nie metodę)
17. D - żle!!!, F - ArrayList definiuje metodę size()
18. A, C, - zle, 
19. A,B,C - zle, arrays nie definiuja equals, wiec jest to porównanie obiektów.
20. B - zle. List<String> - nie można dodać int. (nie zadziała autoboxing? :( )
21. C - ok
22. D - ok
23. A - ok
-1, 4, 5, 10
24. C - ok
25. D - ok
30 3A 8 FF
2 1 -3
26. A, D - zle, A,B,D - czemu runtime exception? - pętla for robi unbox na null
ahh, petla for jest po int.

Integer.parseInt("5") -> int 5
ages.add(5) -> autoboxing
Integer.valueOf("6") -> Integer 5
ages.add() -> bez autoboxing
ages.add(7) -> autoboxing
ages.add(null) -> ok

27. B - ok
28. B, F - zle, zwrócić uwagę, że to były konstruktory.
29. D - ok
30. F - ok
31. B - ok
32. A - zle, TODO formattery
33. B - ok










































#ch04 
TODO - czy package private jest widziana prze klase dziedziczaca?

1. B, C,  - ok
2. A, D,  - ok 
3. A, C, D,  - ok 
4. A, B,  - zle
5. D, F, G - zle
6. D,  - ok
7. B, C, D, F - ok
8. B, C, E
9. E - zle, jeszcze getNumWings (mimo ze numberWings)
10. C - zle. import static rope.Rope.* - jest ok
11. B, E - ok
12. E - zle, czyli wywolanie metody main inicuje zmienne statyczne?





























#ch06 Exceptions

1. B, E - źle! Todo czyli mogę również obsłużyć Error?
2. B, D - ok
3. C - źle, A,C
4. B - ok
5. B - źle, A,B,D
6. C
7. B "AEBCD" - źle. Jest rzucony NullPointerException, następnie jest wykonywane finally,
a poniewż null pointer nie jest obsłużony, program kończy wywołanie
8. D? - źle, ważna jest kolejność obsługi wyjątków.
9. B - "Starting up""Problem" - ok
10. E - "1245" - ok
11. A - ok
12. 124 NullPointer - ok
13. C, E - źle, również A i B - można zwrócić obiekt Error i Exception.
14. D - źle, A,C,D,E
15. A, B, D, E
16. - ok
17. A, C, - źle, A,C,D,E - może rzucać przecież runtime exception
18.
19.
20.

8 - zle
11 - ok


1. B, E - zle - B
	E - you can handle only exception classes? Czyli nie mogę obsługiwać errorów - tego nie jestem pewien.
	Mogę obsługiwać Errory! Lecz nie jest to dobry pomysł.
	Mogę obsłużyć np. StackOverflow
2. B, D - ok
3. C - ok
4. B - ok 
5. A, B(error), D - ok
6. C - ok
7. "AEC" - C - ok
8. E - ok
9. "Starting up Problem" - B - ok
10. "1245" - E - ok 
11. "12" NumberFormatException - A (G - w sumie tak, bo leci nieobsłużony wyjatek) - tylko A - ok
12. "124" NullPointer - A,B,D,G - ok
13. A,C,E - zle, A,B,C,E
	Czyli moge zadeklarowac kazda subklase Error w klauzuli throws
14. B,D,E - zle - A,C,D,E
	A - bo nie musze ruzcac wyjatku
	B - zle, bo Exception jest ogolny i nie zadeklarowany w throws!
15. A,B,D,E - ok
16. B - ok
17. A,C,D,E - ok
18. B,E - zle - A,B,C,E
	czyli 'allowed' rowniez zaznaczac
19. B,C, - zle - C,E
	B - zle, bo taki wyjatek nie jest rzucany, wiec program nigdy by nie wszedl do klauzuli catch
	E - nie wiem czemu - Errory nie musza byc obslugiwane?
20. "abcde" RuntimeException - F - zle
	A,E - ok, czaje, catch i throw z catch nie sa na tym samy poziomie.

14 - ok
6 - zle

