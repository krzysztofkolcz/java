#ch01 
## Importy i deklaracja pakietów
java.lang.* - imortowane domyślnie

nadmiarowość:
import java.util.Random;
import java.util.*;

import java.nio.file.*;
równoważne: 
import java.nio.file.Files;
import java.nio.file.Paths;

Now let’s consider some imports that don’t work:
import java.nio.*; // NO GOOD – a wildcard only matches class names, not "file.*Files"
import java.nio.*.*; // NO GOOD – you can only have one wildcard and it must be at the end
import java.nio.files.Paths.*; // NO GOOD – you cannot import methods only class names

## Creating objects
public class Chick{
	public Chick() { } // CONSTRUCTOR
	public void Chick() { } // NOT A CONSTRUCTOR - NORMAL METHOD
}

{} - Code block

Code block outside method - instance initializer

public class A{
	String name = "Bla";
	public A(){
		name = "W konstruktorze";
	}
	public static void main(String[] args){
		A a = new A();
		System.out.println(a.name);//"W konstruktorze"
	}
}

Nie można się odwołać do zmiennej zanim zostanie zainicjalizowana:
...
{ System.out.println(name); } // DOES NOT COMPILE
private String name = "Fluffy";


### Order of initialization
Fields and instance initializer blocks are run in the order in which they appear in
the file.
The constructor runs after all fields and instance initializer blocks have run.

public class A{
	public A(){
		id = 3;
	}
	public static void main(String[] args){
		A a = new A();
		System.out.println(a.id);//3
	}
	int id = 1;
	{id = 2;}
}

### Typy proste 
boolean - true or false - np.: true
byte - 8-bit integral value - np.: 123
short - 16-bit integral value - np.: 123
int - 32-bit integral value - np.: 123
long - 64-bit integral value - np.: 123
float - 32-bit floating-point value - np.: 123.45f
double - 64-bit floating-point value - np.: 123.456
char - 16-bit Unicode value - np.: 'a'

long max = 3123456789; // DOES NOT COMPILE
long max = 3123456789L; // ok - long


podstawa inna niz dziesiętna:
0[0-7]* - oktalna
0x[0-9A-F]*  - hexadecymalna
0b[0-1]* - binarna (b lub B)


double d1 = 0xE;//OK
double d1 = 0xE.0;// DOES NOT COMPILE
double d2 = 10;// DOES NOT COMPILE

underscores:
int million1 = 1000000;
int million2 = 1_000_000;
Podkrelśnienie nie może być na poczatku, na końcu i przy kropce.
to jest ok:
int i = 1____0_____________________0;
float j = 1______________2.4_5f;

to nie jest ok:
double notAtStart = _1000.00; // DOES NOT COMPILE
double notAtEnd = 1000.00_; // DOES NOT COMPILE
double notByDecimal = 1000_.00; // DOES NOT COMPILE
double annoyingButLegal = 1_00_0.0_0; // this one compiles

podkreślenia moga być chyba przy wszystkich typach liczbowych:

## Typy referencyjne i proste różnice:
typy proste nie moga byc null, typy referencyjne moga
typy proste nie maja metod

## deklaracja i inicjalizacja zmiennych
### deklaracja wielu wartości
String s1, s2;//ok - deklaracja
String s3 = "yes", s4 = "no";//ok - deklaracja + inicjalizacja
int i1, i2, i3 = 0;//ok, inicjalizacja tyko i3, 
int num, String value; // DOES NOT COMPILE
boolean b1, b2;//ok	
String s1 = "1", s2;//ok
double d1, double d2;//DOES NOT COMPILE
int i1; int i2;//OK
int i3; i4;//DOES NOT COMPILE

### nazwy zmiennych
nazwa zaczyna się od litery, lub znaku $ lub _
pozostałe znaki moga być liczbami
nie można używać nazw zastrzeżonych. UWAGA: java jest case sensitive, więc zmienna o nazwie 'Public' jest legalna.

OK:
okidentifier
$OK2Identifier
_alsoOK1d3ntifi3r
__SStillOkbutKnotsonice$

NOT OK:
3DPointClass // identifiers cannot begin with a number
hollywood@vine // @ is not a letter, digit, $ or _
*$coffee // * is not a letter, digit, $ or _
public // public is a reserved word

## inicjalizacja domyślna
### zmienne lokalne - w metodach
musi zostać zainicjalizowana, zanim zostanie użyta

public void notValid() {
	int y = 10;
	int x;
	int reply = x + y; // DOES NOT COMPILE
	//variable x might not have been initialized
}

uwaga na rozgałęzienia

int oneBranch;
int y;
if(someVariable){
	oneBranch = 1;
	y = 1;
}else{ 
	y = 2;
}
System.out.println(oneBranch);//DOES NOT COMPILE

### zmienne klasy i instancji (class variables, instance variables)
nie trzeba ich inicjalizować - otrzymuja wartość domylślna.

#### wartości domylśne:
boolean: false
byte, short, int, long: 0 (in the type’s bit-length)
float, double: 0.0 (in the type’s bit-length)
char: '\u0000' (NUL)
All object references (everything else): null

## Zakres zmiennych
public void method(int x) {
	int y = 1;
}
dwie zmienne lokalne: x i y

Zmienna lokalna ma zakres bloku, w którym została zadeklarowana.

Local variables—in scope from declaration to end of block
Instance variables—in scope from declaration until object garbage collected
Class variables—in scope from declaration until program ends

## Kolejność elementów w klasie

package - nie wymagany, jeżeli jest, to na samym poczatku.
import - nie wymagane, jeżeli sa, to po deklaracji pakietu
public class - deklarazja publicznej klasy - wymagana, zaraz po deklaracji importów
deklaracja zmiennych klasy i instancji - nie wymagane. Gdziekolwiek w ciele klasy.
deklaracja metod - nie wymagana. Gdziekolwiek w ciele klasy.
ok:
```
package structure; // package must be first non-comment
import java.util.*; // import must come after package
public class Meerkat { // then comes the class
double weight; // fields and methods can go in either order
public double getWeight() {
return weight; }
double height; // another field – they don't need to be together
}
```

ok:
```
/* header */
package structure;
// class Meerkat
public class Meerkat { }
```

Przykład z błędami:
```
import java.util.*;
package structure; // DOES NOT COMPILE
String name; // DOES NOT COMPILE
public class Meerkat { }
```

w pliku może być wiele klas, jednak tylko jedna publiczna:
ok:
```
public class Meerkat { }
class Paw { }
```

## Destroying - garbage collector
System.gc() - info do garbage collector, że może działać.

referencja - zmienna posiadajaca nazwę, dzięki niej można się odwoływać do zawartości obiektu.
			wszystkie referencje maja ten sam rozmiar, niezależnie na jaki obiekt wskazuja.
			to referencja jest przekazywana przez metody.
obiekt - siedzi na stercie. obiekty sa czyszczone przez gc, a nie referencje.

jeżeli na obiekt nie wskazuje żadna referencja, to może on zostać usunięty przez garbage collectora.

### finalize()
metoda wywoływana, gdy gc usuwa obiekt.
Czyli może ale nie musi być wywołana.
Nie może być wywołana więcej niż 1 raz.



## Ważne
nazwy zmiennych
inicjalizacja zmiennych statycznych, klasowych i lokalnych - jakie wartości
importy - co jeżeli dwie klasy o tych samych nazwach w różnych pakietach
priorytet importów - nazwa klasy, nazwa_pakietu.*,
java.lang - importowany domyślnie
wywołanie z linii komend - parametry od 0, bez nazwy klasy jako parametr.
pytanie - czy 'public static final void main(String[] args)' - jest poprawne?
liczby o podstawie innej niż dziesiętna
kolejność - package,import,class. package i import sa opcjonalne.
kiedy garbage collector - zakres zmiennych
finalize
dokłdnie jak wyglada konstruktor, czy moze istniec metoda 'public void Salmon()' w klasie Salmon?

#ch02 

## Java operators
### Order of operator precedence
Post-unary operators expression++, expression--
Pre-unary operators ++expression, --expression
Other unary operators +, -, !
Multiplication/Division/Modulus *, /, %
Addition/Subtraction +, -
Shift operators <<, >>, >>>
Relational operators <, >, <=, >=, instanceof
Equal to/not equal to ==, !=
Logical operators &, ^, |
Short-circuit logical operators &&, ||
Ternary operators boolean expression ? expression1 : expression2
Assignment operators =, +=, -=, *=, /=, %=, &=, ^=, !=, <<=, >>=, >>>=

## Numeric Promotion Rules
1. If two values have different data types, Java will automatically promote one of the values
to the larger of the two data types.
long <- int + long 
2. If one of the values is integral and the other is floating-point, Java will automatically
promote the integral value to the floating-point value’s data type.
double <- int + double
3. Smaller data types, namely byte, short, and char, are first promoted to int any time
they’re used with a Java binary arithmetic operator, even if neither of the operands is
int.
byte + short -> (int)byte + (int)short -> int
4. After all promotion has occurred and the operands have the same data type, the resulting
value will have the same data type as its promoted operands.


Parenthases changes order.

Takie coś się nie skompiluje:
float y = 2.91;//to sie nie skompiluje
domyślnie typy zmiennoprzecinkowe sa typami double. Chyba że dodamy f na końcu
float y = 2.91f;//to jest ok

int x = 1;
long y = 33;
x * y -> long

short x = 10;
short y = 3;
x / y -> int

short x = 14;
float y = 13;
double z = 30;
x * y / z
1. x -> int
2. x -> float 
3. x*y -> double
4. result -> double

## Operatory unarne
+ 	Indicates a number is positive, although numbers are assumed
to be positive in Java unless accompanied by a negative unary operator
- 	Indicates a literal number is negative or negates an expression
++ 	Increments a value by 1
-- 	Decrements a value by 1
! 	Inverts a Boolean’s logical value

#### Uwaga
int x = !5; // DOES NOT COMPILE
boolean y = -true; // DOES NOT COMPILE
boolean z = !0; // DOES NOT COMPILE

0 i false nie sa polaczone
podobnie jak 1 i true

### Inkrementacja i dekrementacja
--x -> przed działaniem 
x-- -> po działaniu
int x = 3;
int y = ++x * 5 / x-- + --x;
4 * 5 / 4 + 2 
y = 7
x = 2

## Dodatkowe operatory binarne
### Assignment Operators
Wyjatek, jezeli spróbujemy przypisać większy typ na mniejszy typ
int x = 1.0; // DOES NOT COMPILE
short y = 1921222; // DOES NOT COMPILE - 1921222 jest poza zakrsem short
int z = 9f; // DOES NOT COMPILE - f oznacza, żeby traktować to jako typ float.
long t = 192301398193810323; // DOES NOT COMPILE - interpretuje liczbe jako int. Aby interpretowała jako long trzeba dodać "L" na końcu.


#### Casting
int x = (int)1.0; //ok
short y = (short)1921222; //ok Stored as 20678
int z = (int)9l; //ok
long t = 192301398193810323L; //ok

#### Overflow,underflow
Zakres
System.out.print(2147483647+1); // -2147483648

short x = 10;
short y = 3;
short z = x * y; // DOES NOT COMPILE
x i y sa zmieniane na int, a inta nie mozna przypisac bez castowania na short.
short z = (short)(x * y);//ok

### Compound assignment operators
+=
-=
x += z;// x = x + z;//x musi być wcześniej zdefiniowane (tylko zadeklarowane? czy się skompiluje, jeżeli x nie będzie miało przypisanej wartości?)


long x = 10;
int y = 5;
y = y * x; // DOES NOT COMPILE
y *= x; //OK - chyba y castuje do lang, a następnie do int?


long x = 5;
long y = (x=3);//(x=3) - pryzpisuje 3 do x oraz zwraca wartość 3.
System.out.println(x); // Outputs 3
System.out.println(y); // Also, outputs 3


### Relational operators

1. < Strictly less than
2. <= Less than or equal to
3. > Strictly greater than
4. >= Greater than or equal to
5. a instanceof b True if the reference that a points to is an instance of
a class, subclass, or class that implements a particular
interface, as named in b

### Logical operators
x&y AND is only true if both operands are true.
x|y Inclusive OR is only false if both operands are false.
x^y Exclusive OR is only true if the operands are different.

&&, || - short circuit operators - sa prawie identyczne z operatorami & i |,
z takim wyjatkiem, ze prawa strona nie musi byc wywolywana, jeżeli na podstawie lewej strony 
jest jasny wynik operacji. 	
np.:
boolean x = true || (y < 4);
różnica:
to sprawdzenie zapobiega NullPointerException (operator &&)
if(x != null && x.getValue() < 5) {
// Do something
}

to sprawdzenie rzuca NullPointerException jeżeli x = null (operator &)
if(x != null & x.getValue() < 5) { // Throws an exception if x is null
// Do something
}

Uwaga na egzaminie - zmiana wartości po prawej stronie, ale prawa strona może nigdy nie być osignięta.
int x = 6;
boolean y = (x >= 6) || (++x <= 7);
System.out.println(x);
wynikiem jest 6.

### Equality Operators
The equality operators are used in one of three scenarios:
1. Comparing two numeric primitive types. If the numeric values are of different data
types, the values are automatically promoted as previously described. For example,
5 == 5.00 returns true since the left side is promoted to a double.
2. Comparing two boolean values.
3. Comparing two objects, including null and String values.
The comparisons for equality are limited to these three cases, so you cannot mix and
match types. For example, each of the following would result in a compiler error:
boolean x = true == 3; // DOES NOT COMPILE
boolean y = false != "Giraffe"; // DOES NOT COMPILE
boolean z = 3 == "Kangaroo"; // DOES NOT COMPILE

#### Uwaga
Uważać na porównywane typy danych!

Dla obiektów - porównania dotycza referencji:
File x = new File("myFile.txt");
File y = new File("myFile.txt");
File z = x;
System.out.println(x == y); // Outputs false
System.out.println(x == z); // Outputs true

## Understanding Java Statements
### Ternary
System.out.println((y > 5) ? 21 : "Zebra");
int animal = (y < 91) ? 9 : "Horse"; // DOES NOT COMPILE

#### Uwaga - tylko jedna strona operatora ternarnego jest obliczana
Od javy 7 tylko wynikowa strona operatora ternarnego jest obliczana:
int y = 1;
int z = 1;
final int x = y<10 ? y++ : z++;
System.out.println(y+","+z); // Outputs 2,1

### Switch
obsługuje:
do java 5.0 - int (byte, short, char, int)
java 5.0 - również enum
java 7.0 - String
Byte, Schort, Character, Integer

int and Integer
byte and Byte
short and Short
char and Character
int and Integer
String
enum values

Nie obsługiwane:
boolean, long i wrapper classes nie sa obsługiwane!!!
również double, Double, float i Float nie sa obsługiwane!!!


#### kolejność case i default
case i defalut moga byc w dowolnej kolejności.

switch(x){
	default:...
	case 9:...
	case 1:...
}

jednak kolejność ma znaczenie
int dayOfWeek = 5;
switch(dayOfWeek) {
	default:
		System.out.println("Weekday");
		break;
	case 0:
		System.out.println("Sunday");
		break;
	case 6:
		System.out.println("Saturday");
		break;
}
wynik:
Weekday

int dayOfWeek = 5;
switch(dayOfWeek) {
	case 0:
		System.out.println("Sunday");
	default:
		System.out.println("Weekday");
	case 6:
		System.out.println("Saturday");
	break;
}
wynik:
Weekday
Saturday

czyli jeżeli nie ma odpowiadajacego casa, program leci do default, a ponieważ nie ma break
leci do kolejnej linii.
jeżeli 
dayOfWeek = 6, to tylko odpowiadajcy case by się odpalił
czyli wyni:
Saturday

blok default jest obsługiwany tylko wtedy, gdy nie ma odpowiadajcego casea.

```
int x = 1;
switch(x) {
	case 1: System.out.println("1");
	default: System.out.println("default");
	case 2: System.out.println("2");
}
/* Wynik:
1
default
2
*/
```
```
int x = 1;
switch(x) {
	default: System.out.println("default");
	case 1: System.out.println("1");
	case 2: System.out.println("2");
}
/* Wynik:
1
2
*/
```
```
int x = 3;
switch(x) {
	default: System.out.println("default");
	case 1: System.out.println("1");
	case 2: System.out.println("2");
}
/* Wynik:
default
1
2
*/
```
Wszystkie typy w caseach musza odpowiadać typowi danych w switch
Widzę, że dla switch(Integer) może być case 1:

#### Uwaga
na egzaminie czesto nie ma break.

#### Typy case:
We conclude our discussion on switch statements by acknowledging that the data type
for case statements must all match the data type of the switch variable. As already discussed,
the case statement value must also be a: 
- literal, 
- enum constant, 
- or final constant variable.

private int getSortOrder(String firstName, final String lastName) {
	String middleName = "Patricia";
	final String suffix = "JR";
	int id = 0;
	switch(firstName) {
		case "Test":
			return 52;
		case middleName: // DOES NOT COMPILE - nie jest finalne
			id = 5;
			break;
		case suffix: //- ok
			id = 0;
			break;
		case lastName: // DOES NOT COMPILE - jest finalne, ale zmienne, bo parametr
			id = 8;
			break;
		case 5: // DOES NOT COMPILE - nie jest string
			id = 7;
			break;
		case 'J': // DOES NOT COMPILE - to nie jest String?
			id = 10;
			break;
		case java.time.DayOfWeek.SUNDAY: // DOES NOT COMPILE - to jest typ enum
			id=15;
			break;
	}
	return id;
}

### while
### do while
```
int x = 0;
do {
	x++;
} while(false);
System.out.println(x); // Outputs 1
```
### for

```
//pętla nieskończona
for( ; ; ) {
	System.out.println("Hello World");
}
//średniki sa wymagane - for(;) i for() się nie skompiluje
```
```
int x = 0; //inicjalizacja przed pętla
for(long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
	System.out.print(y + " ");
	//z jest zainicjalizowane, ale nie jest inkrementowane ani wykorzystywane
	//w części aktualizacyjnej można zmieniać wiele zmiennych
}
System.out.print(x);
```
```
//NIE SKOMPILUJE SIĘ!!!
// int x = 0;
// for(long y =0, x = 1; x < 5;x++) {
// 	System.out.println(x);
// }
//zmienna x jest już zadeklarowana w zakresie
```
```
// NIE SKOMPILUJE SIE!!!
// for(long y = 0, int x = 4; x < 5 && y<10; x++, y++) { 
// 	System.out.print(x + " ");
// }
//zmienna x i y maja inne typy
```
```
// NIE SKOMPILUJE SIĘ!!!
// for(long y = 0, x = 4; x < 5 && y < 10; x++, y++) {
// 		System.out.print(y + " ");
// }
// System.out.print(x); 
// Zmienna x poza blokiem
```

### for(datatype instance : collection)
collection - java array, lub klasa implementujaca java.lang.Iterable

```
String names = "Lisa";
for(String name : names) { // DOES NOT COMPILE
	System.out.print(name + " ");
}
```
```
String[] names = new String[3];
for(int name : names) { // DOES NOT COMPILE - name jest int, a names tablica String!
	System.out.print(name + " ");
}
```

#ch03 Core java api
## String
### concatenation
Ważne:
1. If both operands are numeric, + means numeric addition.
2. If either operand is a String, + means concatenation.
3. The expression is evaluated left to right.
Now let’s look at some examples:

```
System.out.println(1 + 2); // 3
System.out.println("a" + "b"); // ab
System.out.println("a" + "b" + 3); // ab3
System.out.println(1 + 2 + "c"); // 3c
```

```
int three = 3;
String four = "4";
System.out.println(1 + 2 + three + four);
//wynik: "64"
```

```
s += "2";//s = s + "2"
```

```
String s = "1"; // s currently holds "1"
s += "2"; // s currently holds "12"
s += 3; // s currently holds "123"
System.out.println(s); // 123
```
### Immutability
```
String s1 = "1";
String s2 = s1.concat("2");
s2.concat("3");
System.out.println(s2);
//wynik: "12"
//jeżeli byłoby s2 = s2.concat("3");, wynikiem byłoby "123"
```

### String pool
```
String name = "Fluffy";//korzysta ze string pool
String name = new String("Fluffy");//nie korzysta ze string pool
```

### important string methods
#### length()
#### charAt()

```
String string = "animals";
System.out.println(string.charAt(0)); // a
System.out.println(string.charAt(6)); // s
System.out.println(string.charAt(7)); // throws exception
```

#### indexOf(int ch), indexOf(int ch,int fromIndex), indexOf(String str), int indexOf(String str, index fromIndex) - czemu ch jest int?

-1 jeżeli nie znajdzie szukanego znaku/ciagu znakow?

```
int indexOf(char ch)
int indexOf(char ch, index fromIndex)
int indexOf(String str)
int indexOf(String str, index fromIndex)
The following code shows how to use indexOf():
String string = "animals";
System.out.println(string.indexOf('a')); // 0
System.out.println(string.indexOf("al")); // 4
System.out.println(string.indexOf('a', 4)); // 4
System.out.println(string.indexOf("al", 5)); // -1
System.out.println(string.indexOf(97)); // 0 (97 - 'a') - tabela kodow ascii
```

#### substring(int start), substring(int start,int end)

```
String string = "animals";
System.out.println(string.substring(3)); // mals - od trójki do końca
System.out.println(string.substring(string.indexOf('m'))); // mals - 
System.out.println(string.substring(3, 4)); // m
System.out.println(string.substring(3, 7)); // mals

System.out.println(string.substring(3, 3)); // empty string
System.out.println(string.substring(3, 2)); // throws exception
System.out.println(string.substring(3, 8)); // throws exception
```

#### toLowerCase() and toUpperCase()

```
String toLowerCase(String str)
String toUpperCase(String str)
```
```
String string = "animals";
System.out.println(string.toUpperCase()); // ANIMALS
System.out.println("Abc123".toLowerCase()); // abc123
```

### equals() and equalsIgnoreCase()

```
boolean equals(String str)
boolean equalsIgnoreCase(String str)
```
```
System.out.println("abc".equals("ABC")); // false
System.out.println("ABC".equals("ABC")); // true
System.out.println("abc".equalsIgnoreCase("ABC")); // true
```

### startsWith() and endsWith()

```
boolean startsWith(String prefix)
boolean endsWith(String suffix)
```

```
System.out.println("abc".startsWith("a")); // true
System.out.println("abc".startsWith("A")); // false
System.out.println("abc".endsWith("c")); // true
System.out.println("abc".endsWith("a")); // false
```

### contains()

```
boolean contains(String str)
```
```
System.out.println("abc".contains("b")); // true
System.out.println("abc".contains("B")); // false
```

## StringBuilder

### StringBuilder jest mutowalny.

```
StringBuilder sb = new StringBuilder("start");
sb.append("+middle"); // sb = "start+middle"
StringBuilder same = sb.append("+end"); // "start+middle+end"
```

```
4: StringBuilder a = new StringBuilder("abc");
5: StringBuilder b = a.append("de");
6: b = b.append("f").append("g");
7: System.out.println("a=" + a);
8: System.out.println("b=" + b);
//wynik w obydwu przypadkach: abcdefg
//a i b wskazuja na ten sam obiekt
```

### StringBuilder - konstruktor
```
StringBuilder sb1 = new StringBuilder();//pusty 
StringBuilder sb2 = new StringBuilder("animal");//przypisane znaki
StringBuilder sb3 = new StringBuilder(10);//o rozmiarze 10
```

#### UWAGA na przypisanie String do StringBuilder!!! - nie zadziała!!!

```
StringBuilder sb = "napis";//DOES NOT COMPILE!
```

### charAt(), indexOf(), length(), and substring()

substring zwraca String. Nie zmienia samego StringBuildera.

```
String substring(int startIndex,int endIndex);
```

```
StringBuilder sb = new StringBuilder("animals");
String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
//substring() returns a String rather than a StringBuilder sb is not changed
int len = sb.length();
char ch = sb.charAt(6);
System.out.println(sub + " " + len + " " + ch);
//anim 7 s
```

### append()
```
StringBuilder append(String str)
```
it adds the parameter to the StringBuilder and returns a reference to the current StringBuilder.

```
StringBuilder sb = new StringBuilder().append(1).append('c');
sb.append("-").append(true);
System.out.println(sb); 
// 1c-true
```

### insert()
The insert() method adds characters to the StringBuilder at the requested index and
returns a reference to the current StringBuilder

```
StringBuilder insert(int offset, String str)
Pay attention to the offset in these examples. It is the index where we want to insert the requested parameter.

3: StringBuilder sb = new StringBuilder("animals");
4: sb.insert(7, "-"); // sb = animals-
5: sb.insert(0, "-"); // sb = -animals-
6: sb.insert(4, "-"); // sb = -ani-mals-
7: sb.insert(10, "***"); // sb = -ani-mals-***
8: System.out.println(sb);
```

### delete(int start, int end), deleteCharAt(int index)
StringBuilder delete(int start, int end)
StringBuilder deleteCharAt(int index)

StringBuilder sb = new StringBuilder("abcdef");
sb.delete(1, 3); // sb = adef
sb.deleteCharAt(5); // throws an exception

### reverse()
StringBuilder sb = new StringBuilder("ABC");
sb.reverse();
System.out.println(sb);
//CBA


## Understanding equality
jeżeli klasa nie implementuje metody equals, wywołanie equals porównuje referencje!

```
StringBuilder one = new StringBuilder();
StringBuilder two = new StringBuilder();
StringBuilder three = one.append("a");
System.out.println(one == two); // false
System.out.println(one == three); // true
```

```
String x = "Hello World";
String y = "Hello World";
System.out.println(x == y); // true
```

Stringi sa niemutowalne 

```
String x = "Hello World"; // String tworzony podczas compile time w string pool
String z = " Hello World".trim(); // string obliczany w czasie runtime.
System.out.println(x == z); // false
```

```
String x = new String("Hello World"); // ten string jest tworzony podczas Runtime
String y = "Hello World"; // ten string jest już znany podczas Compiletime - jest więc dodawany do StringPool
System.out.println(x == y); // false
```

Nigdy nie używać == do porównywania stringów!

```
String x = "Hello World";
String z = " Hello World".trim();
System.out.println(x.equals(z)); // true
```

operator == porównuje referencje.
```
public class Tiger {
	String name;
	public static void main(String[] args) {
	Tiger t1 = new Tiger();
	Tiger t2 = new Tiger();
	Tiger t3 = t1;
	System.out.println(t1 == t1); // true
	System.out.println(t1 == t2); // false
	System.out.println(t1.equals(t2)); // false
 } 
}
```

## Understanding Java Arrays
### Creating an Array of Primitives

Wszystkie sa poprawne:

```
int[] numbers1 = new int[3];
int[] numbers2 = new int[] {42, 55, 99};
int[] numbers2 = {42, 55, 99};

int[] numAnimals;
int [] numAnimals2;
int numAnimals3[];
int numAnimals4 [];
```

Uwaga:

```
int[] ids, types; //dwie zmienne typu int[]
int ids[], types; // jedna zmienna typu int[], jedna zmienna typu int

```

#### UWAGA - pierwszy wymiar w wielowymiarowych tablicach musi być zainicjalizowany

```
int[][] array = new int[][];//DOES NOT COMPILE!!!
int[][][] array2 = new int[][][];//DOES NOT COMPILE!!!

int[][] array = new int[4][];//OK
int[][][] array2 = new int[4][][];//OK
```

### length

```
array.length;
```


### Creating an Array with Reference Variables

```
class Names {
	String names[]; // names jest to zmienna referencyjna i wskazuje na null
}
```


### Sorting

```
int[] numbers = { 6, 9, 1 };
Arrays.sort(numbers);//1,6,9
```
Sortowanie stringów
najpierw liczby, potem duże litery, potem małe litery

```
String[] strings = { "10", "9", "100" };
Arrays.sort(strings);//10,100,9
String[] strings2 = { "A", "9", "100", "a", "b001" };
Arrays.sort(strings2);//100 9 A a b001
```

### Searching
```
Arrays.binarySearch(sortedArray,searchElement);

3: int[] numbers = {2,4,6,8};//tablica musi być posortowana, dla nieposortowanej wynik jest niezdeterminowany.
4: System.out.println(Arrays.binarySearch(numbers, 2)); // 0 index odnalezionego elementu
5: System.out.println(Arrays.binarySearch(numbers, 4)); // 1 j.w.
6: System.out.println(Arrays.binarySearch(numbers, 1)); // -1 (- id - 1)
//id - index na którym element zostałby wstawiony - 1
7: System.out.println(Arrays.binarySearch(numbers, 3)); // -2
8: System.out.println(Arrays.binarySearch(numbers, 9)); // -5
```

### varargs

równoważne:

```
public static void main(String[] args)
public static void main(String args[])
public static void main(String... args) // varargs
```

### Multidimensional Arrays

```
int[][] vars1; // 2D array
int vars2 [][]; // 2D array
int[] vars3[]; // 2D array
int[] vars4 [], space [][]; // a 2D AND a 3D array
```
```
String [][] rectangle = new String[3][2];
```

Tablica nie musi być 'prostokatna':

```
int[][] differentSize = {{1, 4}, {3}, {9,8,7}};
//lub
int [][] args = new int[4][];
args[0] = new int[5];
args[1] = new int[3];
```

iteracje:

```
int[][] twoD = new int[3][2];
for (int i = 0; i < twoD.length; i++) {
for (int j = 0; j < twoD[i].length; j++)
System.out.print(twoD[i][j] + " "); // print element
System.out.println(); // time for a new row
}
```

```
for (int[] inner : twoD) {
	for (int num : inner)
		System.out.print(num + " ");
	System.out.println();
}
```

## ArrayList
Uporzadkowana sekwencja, pozwala na duplikaty

### Creating ArrayList

```
ArrayList list1 = new ArrayList();//lista z domyślna liczba pustych pozycji
ArrayList list2 = new ArrayList(10);//lista z 10 pustymi pozycjami
ArrayList list3 = new ArrayList(list2);//kopia rozmiaru oraz zawartości
```

od java 5 również typy generyczne:

```
ArrayList<String> list4 = new ArrayList<String>();
ArrayList<String> list5 = new ArrayList<>();
```

ArrayList implementuje interface List

```
List<String> list6 = new ArrayList<>(); // OK
ArrayList<String> list7 = new List<>(); // DOES NOT COMPILE
```

### size()

### add()

```
boolean add(E element);//zawsze zwraca true - musi być ze względu na interface?
void add(int index, E element);
```

```
ArrayList list = new ArrayList(); // bez typu generycznego jest to lista elementów typu Object, więc można dodawać wszystko oprócz typów prostych.
list.add("hawk"); // [hawk]
list.add(Boolean.TRUE); // [hawk, true]
System.out.println(list); // [hawk, true]

//w sumie na podsatwie testów przechodzi takie coś:
ArrayList al = new ArrayList();
al.add(new Integer(1));
al.add(3);
al.add(4.4f);
al.add("dtes");
al.add(Boolean.TRUE);
for(int i = 0;i < al.size(); i++) {
	System.out.println(al.get(i));
}
```

```
ArrayList<String> safer = new ArrayList<>();
safer.add("sparrow");
safer.add(Boolean.TRUE); // DOES NOT COMPILE
```

```
4: List<String> birds = new ArrayList<>();
5: birds.add("hawk"); // [hawk]
6: birds.add(1, "robin"); // [hawk, robin]
7: birds.add(0, "blue jay"); // [blue jay, hawk, robin]
8: birds.add(1, "cardinal"); // [blue jay, cardinal, hawk, robin]
9: System.out.println(birds); // [blue jay, cardinal, hawk, robin]
```

### remove()

```
boolean remove(Object object); // wynik - czy element został usunięty?
E remove(int index); // wynik - usuwany element
```

```
3: List<String> birds = new ArrayList<>();
4: birds.add("hawk"); // [hawk]
5: birds.add("hawk"); // [hawk, hawk]
6: System.out.println(birds.remove("cardinal")); // prints false
7: System.out.println(birds.remove("hawk")); // prints true
8: System.out.println(birds.remove(0)); // prints hawk
9: System.out.println(birds); // []
```

remove usuwa pierwszy element

```
List<String> letters = new ArrayList<>();
letters.add("x"); 
letters.add("x"); 
letters.add("y"); 
System.out.println(letters);//[x, x, y] 
letters.add("x"); 
System.out.println(letters);//[x, x, y, x]
letters.remove("x");
System.out.println(letters);//[x, y, x] 
letters.remove("x");
System.out.println(letters);//[y, x]
```

### set()


```
E set(int index, E newElement)
```
element pod indexe zostaje zastapiony przez nowy element.

```
15: List<String> birds = new ArrayList<>();
16: birds.add("hawk"); // [hawk]
17: System.out.println(birds.size()); // 1
18: birds.set(0, "robin"); // [robin]
19: System.out.println(birds.size()); // 1
20: birds.set(1, "robin"); // IndexOutOfBoundsException
```

### isEmpty(), size()

```
System.out.println(birds.isEmpty()); // true
System.out.println(birds.size()); // 0
birds.add("hawk"); // [hawk]
birds.add("hawk"); // [hawk, hawk]
System.out.println(birds.isEmpty()); // false
System.out.println(birds.size()); // 2
```

### clear()

```
void clear()
The following shows how to use this method:
List<String> birds = new ArrayList<>();
birds.add("hawk"); // [hawk]
birds.add("hawk"); // [hawk, hawk]
System.out.println(birds.isEmpty()); // false
System.out.println(birds.size()); // 2
birds.clear(); // []
System.out.println(birds.isEmpty()); // true
System.out.println(birds.size()); // 0
```

### contains()

```
boolean contains(Object object)
```

```
List<String> birds = new ArrayList<>();
birds.add("hawk"); // [hawk]
System.out.println(birds.contains("hawk")); // true
System.out.println(birds.contains("robin")); // false
```

### equals()
Czy listy zawieraja te same elementy w tej samej kolejności.
Do porównania elementów na liście jest wykorzystywany equals.

```
boolean equals(Object object)
```
```
31: List<String> one = new ArrayList<>();
32: List<String> two = new ArrayList<>();
33: System.out.println(one.equals(two)); // true
34: one.add("a"); // [a]
35: System.out.println(one.equals(two)); // false
36: two.add("a"); // [a]
37: System.out.println(one.equals(two)); // true
38: one.add("b"); // [a,b]
39: two.add(0, "b"); // [b,a]
40: System.out.println(one.equals(two)); // false
```

### Wrapper Classes

```
int primitive = Integer.parseInt("123");
Integer wrapper = Integer.valueOf("123");
```

błędne wartości:

```
int bad1 = Integer.parseInt("a"); // throws NumberFormatException
Integer bad2 = Integer.valueOf("123.45"); // throws NumberFormatException
```

Wrapper class 	Converting String to primitive	 	Converting String to wrapper class
Boolean 		Boolean.parseBoolean("true"); 		Boolean.valueOf("TRUE");
Byte 			Byte.parseByte("1"); 				Byte.valueOf("2");
Short 			Short.parseShort("1"); 				Short.valueOf("2");
Integer 		Integer.parseInt("1"); 				Integer.valueOf("2");
Long 			Long.parseLong("1"); 				Long.valueOf("2");
Float 			Float.parseFloat("1"); 				Float.valueOf("2.2");
Double 			Double.parseDouble("1"); 			Double.valueOf("2.2");
Character 		None 								None

### Autoboxing

java zmienia automatycznie wartość typu podstawowego na klasę obudowujaca.

```
4: List<Double> weights = new ArrayList<>();
5: weights.add(50.5); // [50.5]
6: weights.add(new Double(60)); // [50.5, 60.0]
7: weights.remove(50.5); // [60.0]
8: double first = weights.get(0); // 60.0
```

```
3: List<Integer> heights = new ArrayList<>();
4: heights.add(null);
5: int h = heights.get(0); // NullPointerException - wywołanie metody na wartości null
```

Uwaga na wartości typu Integer!!!

```
List<Integer> numbers = new ArrayList<>();
numbers.add(1);//[1]
numbers.add(2);//[1,2]
numbers.remove(1);//[1] - usuwa element z pozycji 1, a nie element o wartości 1.
System.out.println(numbers);
//wynik: [1]
//aby usunac 2 trzeba by wywołać: numbers.remove(new Integer(2));
```

### Converting between Array and List
#### Object[] array = list.toArray();
#### String[] array = list.toArray(new String[0]);
#### List<String> = Arrays.asList(array);

Zmiana z listy na tablicę:

```
3: List<String> list = new ArrayList<>();
4: list.add("hawk");
5: list.add("robin");
6: Object[] objectArray = list.toArray();
7: System.out.println(objectArray.length); // 2
8: String[] stringArray = list.toArray(new String[0]);
9: System.out.println(stringArray.length); // 2
```

Zmiana z tablicy na liste
UWAGA: tablica i lista sa polaczone - tzn. zmiana elementu w jednym, 
jest odzwierciedlona w drugim.

```
20: String[] array = { "hawk", "robin" }; // [hawk, robin]
21: List<String> list = Arrays.asList(array); // returns fixed size list
22: System.out.println(list.size()); // 2
23: list.set(1, "test"); // [hawk, test]
24: array[0] = "new"; // [new, test]
25: for (String b : array) System.out.print(b + " "); // new test
26: list.remove(1); // throws UnsupportedOperation Exception
```

### Sorting

```
List<Integer> numbers = new ArrayList<>();
numbers.add(99);
numbers.add(5);
numbers.add(81);
Collections.sort(numbers);
System.out.println(numbers); [5, 81, 99]
```

## Date Time

### Creating 

```
import java.time.*;
```


```
System.out.println(LocalDate.now());
System.out.println(LocalTime.now());
System.out.println(LocalDateTime.now());
```

Uwaga! Nie ma konstruktora! Jest metodat statyczna of:

```
LocalDate d = new LocalDate(); // DOES NOT COMPILE
```

```
public static LocalDate of(int year, int month, int dayOfMonth)
public static LocalDate of(int year, Month month, int dayOfMonth)
```

```
public static LocalTime of(int hour, int minute)
public static LocalTime of(int hour, int minute, int second)
public static LocalTime of(int hour, int minute, int second, int nanos)
```

```
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute)
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second)
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanos)
public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute)
public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second)
public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanos)
public static LocalDateTime of(LocalDate date, LocalTime)
```

### Manipulating DateTime

LocalDate, LocalTime, LocalDateTime sa immutable 

```
LocalDate date = LocalDate.of(2014, Month.JANUARY, 20); // 2014-01-20
date = date.plusDays(2); // 2014-01-22
date = date.plusWeeks(1); // 2014-01-29
date = date.plusMonths(1); // 2014-02-28 - uwaga, rok nie jest przestępny, więc nie ma 2014-02-29 - java zmienia na 2014-02-28
date = date.plusYears(5); // 2019-02-28
```

chaining

```
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
LocalTime time = LocalTime.of(5, 15);
LocalDateTime dateTime = LocalDateTime.of(date2, time).minusDays(1).minusHours(10).minusSeconds(30);
```

Uwaga na niemutowalność!

```
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
date.plusDays(10);
System.out.println(date);//2020-01-20 - obiekt daty się nie zmienia, jest niemutowalny.
```

Uwaga - czy mamy poprawny obiekt:

```
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
date = date.plusMinutes(1); // DOES NOT COMPILE, ponieważ obiekt jest typu LocalDate a nie LocalTime
```

#### period

```
public static void main(String[] args) {
	LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
	LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
	Period period = Period.ofMonths(1); // create a period
	performAnimalEnrichment(start, end, period);
}

private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) { 
	// uses the generic period
	LocalDate upTo = start;
	while (upTo.isBefore(end)) {
		System.out.println("give new toy: " + upTo);
		upTo = upTo.plus(period); // adds the period
	}
}
```

przykłady period:

```
Period annually = Period.ofYears(1); // every 1 year
Period quarterly = Period.ofMonths(3); // every 3 months
Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
Period everyOtherDay = Period.ofDays(2); // every 2 days
Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days
```

Uwaga: nie można zrobić chain:

```
Period wrong = Period.ofYears(1).ofWeeks(1); // every week
//This tricky code is really like writing the following:
Period wrong = Period.ofYears(1);
wrong = Period.ofWeeks(7);
```

Również period może być używany tylko z właściwymi obiektami:

```
LocalDate date = LocalDate.of(2015, 1, 20);
LocalTime time = LocalTime.of(6, 15);
LocalDateTime dateTime = LocalDateTime.of(date, time);
Period period = Period.ofMonths(1);
System.out.println(date.plus(period)); // 2015-02-20
System.out.println(dateTime.plus(period)); // 2015-02-20T06:15
System.out.println(time.plus(period)); // UnsupportedTemporalTypeException
```

## Formattery

```
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
date.getDayOfWeek(); // MONDAY
date.getMonth(); // JANUARY
date.getYear(); // 2020
date.getDayOfYear(); // 20
```

### DateTimeFormatter formater = DateTimeFormatter.ISO_LOCAL_DATE
```
date.format(DateTimeFormatter.ISO_LOCAL_DATE); 			//2020-01-20
time.format(DateTimeFormatter.ISO_LOCAL_TIME);			//11:12:33
dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);	//2020-01-20T11:12:34

//Albo
DateTimeFormatter formater = DateTimeFormatter.ISO_LOCAL_DATE;
date.format(formater);
```

### date.format(formatter) jest równoważne formatter.format(date):

### DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

```
DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

System.out.println(shortDateTime.format(dateTime)); 
// ksiażka: 1/20/20; program: 20.1.20 - czyli DD.MM.YY

System.out.println(shortDateTime.format(date)); 
// ksiażka: 1/20/20; program: 20.1.20 - czyli DD.MM.YY

// System.out.println(shortDateTime.format(time)); 
// UnsupportedTemporalTypeException
```

#### DateTimeFormatter.ofLocalizedDate(...); .ofLocalizedTime(...); .ofLocalizedDateTime(...)

#### FormatStyle.SHORT; FormatStyle.MEDIUM

### DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");

```
LocalDateTime dateTime = LocalDateTime.of(...);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
System.out.println(dateTime.format(formatter)); 
System.out.println(formatter.format(dateTime)); 
```

Pattern:
MMMM M - miesiac. 
M - 1
MM - 01 
MMM - Jan
MMMM - January

dd - data?
d - bez wiodacego zera
dd - wiodace zero

yyyy - rok
yy - dwucyfrowy
yyyy - czterocyfrowy

h - godzina
hh - wiodace zero

m - minuta
mm - wiodace zero



```
DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm");
f.format(dateTime);
// f.format(date); // linia rzuci wyjatek - niedostepne sa godziny i minuty
f.format(time);
```


TABLE 3.5 - w ksiażce
### Tabela

```
DateTimeFormatter f = DateTimeFormatter._____ (FormatStyle.SHORT);
DateTimeFormatter f = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
/* 
	f.format(localDate) - ok 
	f.format(localDateTime) - ok
	f.format(localTime) - exception
*/
DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
/* 
	f.format(localDate) - exception
	f.format(localDateTime) - ok
	f.format(localTime) - exception
*/
DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
/* 
	f.format(localDate) - exception
	f.format(localDateTime) - ok 
	f.format(localTime) - ok
*/


```

###  parse(String,DateTimeFormatter); LocalDate date = LocalDate.parse("01 02 2015", f);

```
DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");
LocalDate date = LocalDate.parse("01 02 2015", f);
LocalTime time = LocalTime.parse("11:22");
System.out.println(date); // 2015-01-02
System.out.println(time); // 11:22
```

### Przykłady

```
DateTimeFormatter formatter001 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL); 
DateTimeFormatter formatter002 = DateTimeFormatter.ofPattern("hh:mm"); 
DateTimeFormatter formatter003 = DateTimeFormatter.ISO_DATE_TIME; 
```

## TODO
String a = "" + 3 + true;//itp.

#ch04 Methods and Encapsulation
2 4 6 8 5 

## Applying modifier access

private: Only accessible within the same class
default (package private) access: private and other classes in the same package
protected: default access and child classes
public: protected and classes in the other packages


### Protected

```
package pond.shore;
public class Bird {
	protected void floatInWater() {} 
}

//inheritance, same package
package pond.shore;// same package as Bird
public class BirdChild extends Bird{
	public void watchBird() {
		Bird bird = new Bird();
		bird.floatInWater(); // calling protected member - ok
	} 
	public void watchSelf() {
		floatInWater();// calling parent member - ok
	}
}

//no inheritance, same package
package pond.shore; // same package as Bird
public class BirdWatcher {
	public void watchBird() {
		Bird bird = new Bird();
		bird.floatInWater(); // calling protected member - ok
	} 
}


//inheritance, different package
package pond.goose;// in a different package
import pond.shore.Bird; 
public class Gosling extends Bird { 
	public void swim() {
		floatInWater(); // calling protected member - ok
		//TODO:
		//Bird bird = new Bird();
		//bird.floatInWater();//???
		//Gosling gosling = new Gosling();
		//gosling.floatInWater();//???
	} 
}


//no inheritence, different package
package pond.inland;// different package than Bird
import pond.shore.Bird; 
public class BirdWatcherFromAfar {
	public void watchBird() {
		Bird bird = new Bird();
		//bird.floatInWater();//DOES NOT COMPILE
	}
}

//inheritance, different package
//self - ok
//instance of exactly same type - ok
//instance of parent - DOES NOT COMPILE
package pond.swan;// in different package than Bird
import pond.shore.Bird; 
public class Swan extends Bird { // but subclass of bird
	public void swim() {
		floatInWater(); // package access to superclass - ok
	}

	public void helpOtherSwanSwim() {
		Swan other = new Swan();
		other.floatInWater(); // package access to superclass - ok
	}

	public void helpOtherBirdSwim() {
		Bird other = new Bird();
		//other.floatInWater(); // DOES NOT COMPILE
	}
}
```

#ch06 Exceptions
Rujntime exceptions extend RuntimeException.
They don’t have to be handled or declared.


They can be thrown by the programmer or by the JVM. 
Common runtime exceptions include the following:
ArithmeticException Thrown by the JVM when code attempts to divide by zero
ArrayIndexOutOfBoundsException Thrown by the JVM when code uses an illegal
index to access an array
ClassCastException Thrown by the JVM when an attempt is made to cast an exception
to a subclass of which it is not an instance
IllegalArgumentException Thrown by the programmer to indicate that a method has
been passed an illegal or inappropriate argument
NullPointerException Thrown by the JVM when there is a null reference where an
object is required
NumberFormatException Thrown by the programmer when an attempt is made to convert
a string to a numeric type but the string doesn’t have an appropriate format

wyjatki runtime rzucane przez jvm:
ArithmeticException
ArrayIndexOutOfBoundsException
ClassCastException 
NullPointerException

pozostale - TODO - one rzucane tylko przez programiste?
IllegalArgumentException 
NumberFormatException 


nie można dodawać wyjatków, jeżeli metoda nadpisuje metodę interfaceu.
można deklarowac mniej wyjatkow, niz jeste w interface lub superclass. Może wcale nie deklarować,
lub deklarować wyjatki, które sa podklasami wyjatkow rzucanych przez metode interfaceu.
Ta zasada tyczy sie tylko wyjatkow checked!!!
metoda moze deklarowac dodatkowe wyjatki (nie bedace zadeklarowanymi w interface), jezeli sa one unchecked.


wypisanie wyjatku:
try {
 hop();
} catch (Exception e) {
 System.out.println(e);
 System.out.println(e.getMessage());
 e.printStackTrace();
}

TODO - obrazek dziedziczenia wyjatków
TODO - lista wyjatkow rzucanych przez JVM
TODO - wyjatek dziedziczacy po Exception, jest cheecked czy unchecked?


Jeżeli wyjatek rzucany z catch, oraz z finally, wyjatek z finally przykrywa ten z catcha.

```
public String exceptions() {
	String result = "";
	String v = null;
	try {
		try {
			result += "before";
			v.length();
			result += "after";
		} catch (NullPointerException e) {
			result += "catch";
			throw new RuntimeException();
		} finally {
			result += "finally";
			throw new Exception();
		}
	} catch (Exception e) {
		result += "done";
	}
	return result;
}
```
result = "before catch finally done"

Jeżeli metoda nie rzuca wyjątku, to dodanie clausuli catch spowoduje błąd kompilacji:

```
public class Oca004 {
    public void bad() {
        try {
            eatCarrot();
        } catch (NoMoreCarrotsException e ) {// DOES NOT COMPILE
            System.out.print("sad rabbit");//ten kod nie jest osiągalny, bo eatCarrot nie rzuca tego wyjątku.
        }
    }
    public void good() throws NoMoreCarrotsException {
        eatCarrot();
    }
    private static void eatCarrot() { }
}
```

metoda nadpisująca metodę nadklasy nie może dodawać dodatkowych wyjątków (dotyczy tylko wyjątków checked!):
CHodzi o to, że kod korzystający z klasy Hopper nie obsługuje tego nowego wyjątku.

```
class CanNotHopException extends Exception { }

class Hopper {
	public void hop() { }
}

class Bunny extends Hopper {
	public void hop() throws CanNotHopException { } // DOES NOT COMPILE
}
```

To jest dozwolone, ponieważ jest to wyjątek unchecked!:

```
class Hopper {
	public void hop() { }
}

class Bunny extends Hopper {
	public void hop() throws IllegalStateException { }
}
```

Jest natomiast dozwolone deklarowanie mniejszej liczby rzucanych wyjątków:

```
class Hopper {
	public void hop() throws CanNotHopException { }
}

class Bunny extends Hopper {
	public void hop() { }
}
```

Metoda nadpisująca może zadeklarować węższy typ wyjątku - zasada ta sama - nadklasa lub interface już ogarnęły ten typ.

```
class Hopper {
	public void hop() throws Exception { }
}

class Bunny extends Hopper {
	public void hop() throws CanNotHopException { }
}
```

Obsługiwanie bardziej ogólnych wyjątków przed bardziej szczegółowymi - error,

```
	try{
		throw new Exception002();
	}catch (Exception001 e){
		e.printStackTrace();
	}catch (Exception002 e){//ERROR!
		e.printStackTrace();
	}
```