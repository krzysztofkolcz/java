# ch01 
## Importy i deklaracja pakietów
java.lang.* - imortowane domyślnie

nadmiarowość:

```
import java.util.Random;
import java.util.*;
```

```
import java.nio.file.*;
//równoważne: 
import java.nio.file.Files;
import java.nio.file.Paths;
```

Now let’s consider some imports that don’t work:

```
import java.nio.*; // NO GOOD – a wildcard only matches class names, not "file.*Files"
import java.nio.*.*; // NO GOOD – you can only have one wildcard and it must be at the end
import java.nio.files.Paths.*; // NO GOOD – you cannot import methods only class names
```

## Creating objects

```
public class Chick{
	public Chick() { } // CONSTRUCTOR
	public void Chick() { } // NOT A CONSTRUCTOR - NORMAL METHOD
}
```

`{}` - Code block

Code block outside method - instance initializer

```
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
```

Nie można się odwołać do zmiennej zanim zostanie zainicjalizowana:

```
...
{ System.out.println(name); } // DOES NOT COMPILE
private String name = "Fluffy";
```


### Order of initialization
Fields and instance initializer blocks are run in the order in which they appear in
the file.
The constructor runs after all fields and instance initializer blocks have run.

```
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
```

### Typy proste 

 - boolean - true or false - np.: true
 - byte - 8-bit integral value - np.: 123
 - short - 16-bit integral value - np.: 123
 - int - 32-bit integral value - np.: 123
 - long - 64-bit integral value - np.: 123
 - float - 32-bit floating-point value - np.: 123.45f
 - double - 64-bit floating-point value - np.: 123.456
 - char - 16-bit Unicode value - np.: 'a'

#### podstawa 0,0x,0b

podstawa inna niz dziesiętna:
0[0-7]* - oktalna
0x[0-9A-F]*  - hexadecymalna
0b[0-1]* - binarna (b lub B)


#### boolean, Boolean

Values of type boolean cannot be converted to any other types.

```
//int i = (int)false;//DOES NOT COMPILE
```
konstruktory:
```
Boolean(String);// wrapper true, jeżeli string nie pusty i jego wartość ignorecase to "true"
Boolean(boolean);

new Boolean("true");// Każdy string "true" (ignorecase) - zwróci Boolean wrapper true
new Boolean("no");// Każdy inny string niz "true" (ignorecase) - zwróci Boolean wrapper false

```
```
boolean Boolean.parseBoolean("TrUe");// true - primitive
Boolean.valueOf(boolean);//zwraca Boolean.TRUE, lub Boolean.FALSE
Boolean.TRUE;// Boolean wrapper true (Objekt)
new Boolean("true") == Boolean.TRUE;// porównanie zwróci false - dwa różne obiekty

```
przy porównaniu, jeżeli jedna ze stron jest wartością primitive - unboxing.
Jeżeli dwie wartości są Boolean - porównanie referencji.

```
new Boolean("true") == new Boolean("true")// is false, 
new Boolean("true") == Boolean.parseBoolean("true")// is true
```
#### byte - 8 bit, integral
#### short - 16 bit, integral
#### int - 32 bit, integral, 

#### long - 64 bit, integral

```
l = 2147483647;//OK (Integer.MAX_VALUE: 2147483647)
//l = 2147483648;//DOES NOT COMPILE - literal 2147483648  (Integer.MAX_VALUE + 1) of type int is out of range
l = 2147483648l;//OK - l na końcu
l = 2147483648L;//OK - L na końcu
```

#### char 

#### float

```		
	float f1 = 1;
	System.out.println(f1);//1.0
	float f2 = 2f;
	System.out.println(f2);//2.0

//	float f3 = 3.0;//DOES NOT COMPILE - cannot convert from double to float
	float f3 = (float)3.0;//OK 
	System.out.println(f3);//3.0

	float f4 = 4.0f;//OK
	System.out.println(f4);//4.0

//	float f5 = 43e1;//DOES NOT COMPILE - cannot convert from double to float
	float f6 = 0x0123;//291.0
	System.out.println(f6);

	float f7 = -1;
	System.out.println(f7);//-1.0

	float f8 = -123;//OK - implicit widening conversion
//	float f9 = 0 * 1.5;//DOES NOT COMPILE - cannot convert from double to float
	float f10 = 0 * 1.5f; //OK
	float f11 = 0 * (float)1.5 ; //OK



```
#### double

```
double d1 = 0xE;//OK
//double d1 = 0xE.0;// DOES NOT COMPILE
//double d2 = 10;// DOES NOT COMPILE
```

```
double d1 = 43e1;//OK
System.out.println(d1);

double d2 = 1;//OK
```


#### underscores - podkreślenia

```
int million1 = 1000000;
int million2 = 1_000_000;
```
Podkrelśnienie nie może być na poczatku, na końcu i przy kropce.
to jest ok:

```
int i = 1____0_____________________0;
float j = 1______________2.4_5f;
```

to nie jest ok:

```
double notAtStart = _1000.00; // DOES NOT COMPILE
double notAtEnd = 1000.00_; // DOES NOT COMPILE
double notByDecimal = 1000_.00; // DOES NOT COMPILE
double annoyingButLegal = 1_00_0.0_0; // this one compiles
```

podkreślenia moga być chyba przy wszystkich typach liczbowych:

#### int -> float
```
public class Conversion{    
	public static void main(String[] args){      
		int i = 1234567890;      
		float f = i;//float are not precise to nine significant digits.      
		System.out.println(i - (int)f);// -46 
	} 
}
```

## Typy referencyjne i proste różnice:
typy proste nie moga byc null, typy referencyjne moga
typy proste nie maja metod


## Object
### String toString()
Każda klasa dziedziczy po Object

```
public class x{
String s = this.toString();
}
```

### int hashCode()

### public boolean equals(Object obj)

## Number
### byte byteValue()
### abstract double	doubleValue()
### abstract float floatValue()
### abstract int intValue()
### abstract long longValue()
### short shortValue()


## Integer
### new Integer(int value), new Integer(String s)
Konstruktor - nie ma bezargumentowego
### Integer.parseInt(String str)
```
Integer.parseInt("12.3");//Throws NumberFormatException
```

### ++

obiekt Integer jest niemutowalny.
Po zastosowaniu operatora ++ tworzony jest nowy objekt Integer.

```
Integer ii = new Integer("12");
Integer oii = ii;
oii == ii;//true;
ii++;
oii == ii;//false;
```


## deklaracja i inicjalizacja zmiennych
### deklaracja wielu wartości

```
String s1, s2;//ok - deklaracja
String s3 = "yes", s4 = "no";//ok - deklaracja + inicjalizacja
int i1, i2, i3 = 0;//ok, inicjalizacja tyko i3, 
int num, String value; // DOES NOT COMPILE
boolean b1, b2;//ok	
String s1 = "1", s2;//ok
double d1, double d2;//DOES NOT COMPILE
int i1; int i2;//OK
int i3; i4;//DOES NOT COMPILE
```

### nazwy zmiennych
nazwa zaczyna się od litery, lub znaku $ lub _
pozostałe znaki moga być liczbami
nie można używać nazw zastrzeżonych. UWAGA: java jest case sensitive, więc zmienna o nazwie 'Public' jest legalna.

OK:
 
```
okidentifier
$OK2Identifier
_alsoOK1d3ntifi3r
__SStillOkbutKnotsonice$
```

NOT OK:
 
```
3DPointClass // identifiers cannot begin with a number
hollywood@vine // @ is not a letter, digit, $ or _
*$coffee // * is not a letter, digit, $ or _
public // public is a reserved word
```

## inicjalizacja domyślna
### zmienne lokalne - w metodach
musi zostać zainicjalizowana, zanim zostanie użyta

```
public void notValid() {
	int y = 10;
	int x;
	int reply = x + y; // DOES NOT COMPILE
	//variable x might not have been initialized
}
```

uwaga na rozgałęzienia

```
int oneBranch;
int y;
if(someVariable){
	oneBranch = 1;
	y = 1;
}else{ 
	y = 2;
}
System.out.println(oneBranch);//DOES NOT COMPILE
```

### zmienne klasy i instancji (class variables, instance variables)
nie trzeba ich inicjalizować - otrzymuja wartość domylślna.

#### wartości domylśne:

```
boolean: false
byte, short, int, long: 0 (in the type’s bit-length)
float, double: 0.0 (in the type’s bit-length)
char: '\u0000' (NUL)
All object references (everything else): null
```

## Zakres zmiennych

```
public void method(int x) {
	int y = 1;
}
```

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

# ch02 

## Java operators
### Order of operator precedence

```
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
```

#### Example

```
boolean b1 = false; 
boolean b2 = false; 
if (b2 != b1 = !b2){   //DOES NOT COMPILE  - operator prededence
	System.out.println("true"); 
} else{    
	System.out.println("false"); 
}
//boolean operators have more precedence than =
// != operator have more precedence than =
//first: b2 != b1 -> false
//second: false = !b2 -> compile error

```

#### Jest jeszcze operator castowania i kropka
operator kropki ma wyższy priorytet niż castowania, np.:
```
Object t = new Integer(107);     
//int k = (Integer) t.intValue()/9;//DOES NOT COMPILE
int k = ((Integer)t).intValue()/9;//OK
```


### +
### %
% - może być użyty dla integral oraz floating point (float, double)
5.5 % 3 = 2.5

### &
can have integral as well as boolean operands.
integral types means byte, short, int, long, and char
unlike &&, & will not "short circuit" the expression if used on boolean parameters.

for integral - bit and

### !
Tylko boolean

### &&
Tylko boolean

### ||
Tylko boolean


### ~
~ Operates only on integral types
(bitwise compliment)
 a = 0011 1100
~a = 1100 0011

### ++
wydaje się, że dla wszystkich typów

```
Integer obj = new Integer(5);
obj++;// obj = new Integer( obj.intValue()  + 1);
```

### == 
wydaje się, że porównania możliwe: 
 - pomiędzy wszystkimi typami primitive
 - pomiędzy dowolnym typem primitie a dowolnym typem wrapper class
 - pomiędzy takimi samymi typami wrapper class

```
int i =10;
short s = 20;
if(i == s){}//???
```

### Assignment operators - ważna reguła:

```
char c = 10;
int i = 10;

//c = c/i;//DOES NOT COMPILE!
c /= i;//OK!!!
```

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

```
float y = 2.91; // DOES NOT COMPILE

//domyślnie typy zmiennoprzecinkowe sa typami double. Chyba że dodamy f na końcu

float y = 2.91f;// OK
```

```
int x = 1;
long y = 33;
x * y -> long
```

```
short x = 10;
short y = 3;
x / y -> int
```

```
short x = 14;
float y = 13;
double z = 30;
x * y / z
1. x -> int
2. x -> float 
3. x*y -> double
4. result -> double
```

## Operatory unarne

`+` Indicates a number is positive, although numbers are assumed to be positive in Java unless accompanied by a negative unary operator
`-`	 Indicates a literal number is negative or negates an expression
`++` Increments a value by 1
`--` Decrements a value by 1
`!` Inverts a Boolean’s logical value

#### Uwaga

```
int x = !5; // DOES NOT COMPILE
boolean y = -true; // DOES NOT COMPILE
boolean z = !0; // DOES NOT COMPILE
```

0 i false nie sa polaczone
podobnie jak 1 i true

### Inkrementacja i dekrementacja

```
--x;  //przed działaniem 
x--;  //po działaniu

int x = 3;
int y = ++x * 5 / x-- + --x;

// 4 * 5 / 4 + 2 
// y = 7
// x = 2
```

## Dodatkowe operatory binarne
### Assignment Operators

Wyjatek, jezeli spróbujemy przypisać większy typ na mniejszy typ

```
int x = 1.0; // DOES NOT COMPILE
short y = 1921222; // DOES NOT COMPILE - 1921222 jest poza zakrsem short
int z = 9f; // DOES NOT COMPILE - f oznacza, żeby traktować to jako typ float.
long t = 192301398193810323; // DOES NOT COMPILE - interpretuje liczbe jako int. Aby interpretowała jako long trzeba dodać "L" na końcu.
```

#### Casting

```
int x = (int)1.0; //ok
short y = (short)1921222; //ok Stored as 20678
int z = (int)9l; //ok
long t = 192301398193810323L; //ok
```

#### Overflow,underflow
Zakres

```
System.out.print(2147483647+1); // -2147483648

short x = 10;
short y = 3;
short z = x * y; // DOES NOT COMPILE
//x i y sa zmieniane na int, a inta nie mozna przypisac bez castowania na short.
short z = (short)(x * y);//ok

```

### Compound assignment operators

```
+=
-=
```

```
x += z;
x = x + z;
//x musi być wcześniej zdefiniowane (tylko zadeklarowane? czy się skompiluje, jeżeli x nie będzie miało przypisanej wartości?)
```
 

```
long x = 10;
int y = 5;
y = y * x; // DOES NOT COMPILE
y *= x; //OK - chyba y castuje do lang, a następnie do int?
```

```
long x = 5;
long y = (x=3);//(x=3) - pryzpisuje 3 do x oraz zwraca wartość 3.
System.out.println(x); // Outputs 3
System.out.println(y); // Also, outputs 3
```

### Relational operators

1. `<` Strictly less than
2. `<=` Less than or equal to
3. `>` Strictly greater than
4. `>=` Greater than or equal to
5. `a instanceof b` True if the reference that a points to is an instance of a class, subclass, or class that implements a particular interface, as named in b

### Logical operators

`x&y` AND is only true if both operands are true.
`x|y` Inclusive OR is only false if both operands are false.
`x^y` Exclusive OR is only true if the operands are different.

`&&, ||` - short circuit operators - sa prawie identyczne z operatorami `&` i `|`,
z takim wyjatkiem, ze prawa strona nie musi byc wywolywana, jeżeli na podstawie lewej strony 
jest jasny wynik operacji. 	
np.:

```
boolean x = true || (y < 4);
```

różnica:
to sprawdzenie zapobiega NullPointerException (operator &&)

```
if(x != null && x.getValue() < 5) {
// Do something
}
```

to sprawdzenie rzuca NullPointerException jeżeli x = null (operator &)

```
if(x != null & x.getValue() < 5) { // Throws an exception if x is null
// Do something
}
```

Uwaga na egzaminie - zmiana wartości po prawej stronie, ale prawa strona może nigdy nie być osignięta.

```
int x = 6;
boolean y = (x >= 6) || (++x <= 7);
System.out.println(x);
```
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

```
boolean x = true == 3; // DOES NOT COMPILE
boolean y = false != "Giraffe"; // DOES NOT COMPILE
boolean z = 3 == "Kangaroo"; // DOES NOT COMPILE
```

#### Uwaga
Uważać na porównywane typy danych!
Dla obiektów - porównania dotycza referencji:

```
File x = new File("myFile.txt");
File y = new File("myFile.txt");
File z = x;
System.out.println(x == y); // Outputs false
System.out.println(x == z); // Outputs true
```

## Understanding Java Statements

### if


```
//W odróżnieniu od while(false) i for(;false;)
if(true){ x = 1; }//jest to poprawne, mimo, ze x=1 jest nieosiagalne.
//jest to wyjatek od reguły w celu optymalizacji wersji kodu,
//przez warunkowa kompilację np.:
if(DEBUG){...}
//jeżeli np. na produkcji DEBUG=false, kompilator wywala cała ta sekcję.

```
### Ternary

```
System.out.println((y > 5) ? 21 : "Zebra");
int animal = (y < 91) ? 9 : "Horse"; // DOES NOT COMPILE

```

#### Uwaga - tylko jedna strona operatora ternarnego jest obliczana

Od javy 7 tylko wynikowa strona operatora ternarnego jest obliczana:

```
int y = 1;
int z = 1;
final int x = y<10 ? y++ : z++;
System.out.println(y+","+z); // Outputs 2,1
```

### Switch
obsługuje:

* do java 5.0 - int (byte, short, char, int)
* java 5.0 - również enum
* java 7.0 - String, Byte, Schort, Character, Integer

1. int and Integer
2. byte and Byte
3. short and Short
4. char and Character
5. String - dla stringa porównuje jakby wykorzystywał String.equals
6. enum values

Nie obsługiwane!:
* boolean, Boolean
* long, Long
* float, Float
* double, Double

####
Here are the rules for a switch statement:
1. Only String, byte, char, short, int, (and their wrapper classes Byte, Character, Short, and Integer), and enums can be used as types of a switch variable. (String is allowed only since Java 7). 
2. The case constants must be assignable to the switch variable. For example, if your switch variable is of class String, your case labels must use Strings as well.
3. The switch variable must be big enough to hold all the case constants. For example, if the switch variable is of type char, then none of the case constants can be greater than 65535 because a char's range is from 0 to 65535.
4.  All case labels should be COMPILE TIME CONSTANTS. 
5. No two of the case constant expressions associated with a switch statement may have the same value.
6. At most one default label may be associated with the same switch statement.

#### kolejność case i default
case i defalut moga byc w dowolnej kolejności.


```
//OK
switch(x){ }
```

```
//OK
switch(x){ 
	case 1:
	case 2:
}
```

```
switch(x){
	default:...
	case 9:...
	case 1:...
}
```

jednak kolejność ma znaczenie

```
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
// Wynik: Weekday
```

```
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
// Wynik: Weekday Saturday
```

czyli jeżeli nie ma odpowiadajacego casa, program leci do default, a ponieważ nie ma break
leci do kolejnej linii.
jeżeli 
dayOfWeek = 6, to tylko odpowiadajcy case by się odpalił
czyli wynik:
Saturday

blok default jest obsługiwany tylko wtedy, gdy nie ma odpowiadajcego casea.

```
int x = 1;
switch(x) {
	case 1: System.out.print("1 ");
	default: System.out.print("default ");
	case 2: System.out.print("2 ");
}
// Wynik: 1 default 2
```
```
int x = 1;
switch(x) {
	default: System.out.print("default ");
	case 1: System.out.print("1 ");
	case 2: System.out.print("2 ");
}
// Wynik: 1 2 
```
```
int x = 3;
switch(x) {
	default: System.out.print("default ");
	case 1: System.out.print("1 ");
	case 2: System.out.print("2 ");
}
// Wynik: default 1 2
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

```
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
		case 'J': // DOES NOT COMPILE - char
			id = 10;
			break;
		case java.time.DayOfWeek.SUNDAY: // DOES NOT COMPILE - to jest typ enum
			id=15;
			break;
	}
	return id;
}
```

#### może nie być default. 
Jeżeli żaden case nie pasuje i nie ma default nic się nie wykona.

```
int i = 3;
switch(i){
	case 1: System.out.println("1"); break;
}
```

#### Przykład z testu - bez średników

```
public void switchTest(byte x){
   switch(x){
      case 'b':   // 1
      default :   // 2
      case -2:    // 3
      case 80:    // 4
   }
}
```

#### Switch bez case
```
switch (1) { default : break; }
```

### while
```
//while (false) { x=3; }//DOES NOT COMPILE - kod x=3; jest nieosiągalny.
UWAGA:
if(false) - jest ok
```
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

```
public static void for006() {
	int i = 0;
	int j = 0;
	for(i = 0, j = 0; j < i; i++, j++) {//i++, j++ nie wykona się!!!
		System.out.println("i:"+i+";j:"+j);
	}
	System.out.println("i:"+i+";j:"+j);
}
//wynik: i:0;j:0
```

```
//DOES NOT COMPILE
for( int i = 0; false; i++) x = 3; 
//is also a compile time error because x= 3 is unreachable.
```

### for(datatype instance : collection)
collection - java array, lub klasa implementujaca java.lang.Iterable

```
String names = "Lisa";
//for(String name : names) { // DOES NOT COMPILE
//	System.out.print(name + " ");
//}
```
```
String[] names = new String[3];
//for(int name : names) { // DOES NOT COMPILE - name jest int, a names tablica String!
//	System.out.print(name + " ");
//}
```
```
Object o;
Collection c = ...;//valid collection object
//for(o : c){}//DOES NOT COMPILE - nie można użyć istniejącej/predefiniowanej zmiennej w części deklaracji
```
```
Collection c = ...;//valid collection object
c.iterator() - nie implementuje Iterable?? - nie może być wykorzytany w for:
//for(Iterator it : c.iterator()){}//DOES NOT COMPILE
```

```
Collection c = ...;//valid collection object
//final jest dopuszczalne!
for(final Object o2 :c){ }
```

# ch03 Core java api

## TODO - string konstruktors
```
//String s = 'a'//DOES NOT COMPILE - 'a' to char, 
//String potrzebuje podwójnego cudzysłowu 
```
## String

implementuje interface Comparable
klasa jest finalna (nie można dziedziczyć po String)
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

```
public static void concatenation() {
	String s;
//	s += 'a';//DOES NOT COMPILE
// the local variable s may not have been initialized
	s = null;
	s += 'a';//OK
	System.out.println(s);//print: nulla

}
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

### replace() - TODO

### other methods and constructors
https://docs.oracle.com/javase/7/docs/api/java/lang/String.html

#### String concat(String str)
```
String abc = "";
abc.concat("abc");
```
Strings are immutable so doing `abc.concat("abc")` will create a new string "abc" but will not affect the original string "".

### String examples
```
String str1 = "one"; 
String str2 = "two"; 
System.out.println( str1.equals(str1=str2) );//false
//1. str1 jest określany str1 = "one"
//2. zanim metoda zostanie wywołana, wyliczany jest argument str1=str2, str1="two"
//3. "one".equals("two");//false
```

### Test - System.out.println(null+true)
```
//System.out.println(null); //DOES NOT COMPILE - the method printlns(char[]) 
//is ambiguou for the type PrintStream

System.out.println(true); //OK - true

//System.out.println(null + true); //1 DOES NOT COMPILE - 
//the argument + is undefined for arguments...
//System.out.println(true + null); //2 DOES NOT COMPILE -  
//System.out.println(null + null); //3 DOES NOT COMPILE -

System.out.println(getString() + true);//OK
...
public static String getString() {
	return null;
}
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

### char charAt(),  length(), and substring()

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

### int indexOf(String str)

```
StringBuilder sb02 = new StringBuilder("1xx");
System.out.println(sb02.indexOf("xx"));//println: 1
```

### append(...)
Parametr - wszystkie typy proste

```
StringBuilder	append(boolean b)
StringBuilder	append(char c)
StringBuilder	append(char[] str)
StringBuilder	append(char[] str, int offset, int len)
StringBuilder	append(CharSequence s)
StringBuilder	append(CharSequence s, int start, int end)
StringBuilder	append(double d)
StringBuilder	append(float f)
StringBuilder	append(int i)
StringBuilder	append(long lng)
StringBuilder	append(Object obj)
StringBuilder	append(String str)
StringBuilder	append(StringBuffer sb)
```
it adds the parameter to the StringBuilder and returns a reference to the current StringBuilder.

```
StringBuilder sb = new StringBuilder().append(1).append('c');
sb.append("-").append(true);
System.out.println(sb); 
// 1c-true
```

### insert(int offset, ...)

```
StringBuilder	 insert(int offset, boolean b)
StringBuilder	 insert(int offset, char c)
StringBuilder	 insert(int offset, char[] str)
StringBuilder	 insert(int index, char[] str, int offset, int len)
StringBuilder	 insert(int dstOffset, CharSequence s)
StringBuilder	 insert(int dstOffset, CharSequence s, int start, int end)
StringBuilder	 insert(int offset, double d)
StringBuilder	 insert(int offset, float f)
StringBuilder	 insert(int offset, int i)
StringBuilder	 insert(int offset, long l)
StringBuilder	 insert(int offset, Object obj)
StringBuilder	 insert(int offset, String str)
```
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

### StringBuilder delete(int start, int end)
StringBuilder delete(int start, int end)
StringBuilder deleteCharAt(int index)

StringBuilder sb = new StringBuilder("abcdef");
sb.delete(1, 3); // sb = adef
sb.deleteCharAt(5); // throws an exception

### StringBuilder deleteCharAt(int index)
### int length()
### String substring()
### StringBuilder reverse()
StringBuilder sb = new StringBuilder("ABC");
sb.reverse();
System.out.println(sb);
//CBA


## Understanding equality (String s1 == String s2)
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

Uwaga, te stringi też sa równe:

```
String s1 = "Hello World";
String s2 = "Hello " + "World";
s1 == s2;//true!

String s3 = "Hello World  ";
s3 = s3.trim().intern();
s1 == s3;//true!
```

przykład z testów:

```
//In File Other.java
package other;
public class Other { public static String hello = "Hello"; }

//In File Test.java
package testPackage;
import other.*;
class Test{
   public static void main(String[] args){
      String hello = "Hello", lo = "lo";
      System.out.print((testPackage.Other.hello == hello) + " ");    //line 1
      System.out.print((other.Other.hello == hello) + " ");   //line 2
      System.out.print((hello == ("Hel"+"lo")) + " ");           //line 3
      System.out.print((hello == ("Hel"+lo)) + " ");              //line 4
      System.out.println(hello == ("Hel"+lo).intern());          //line 5
   }
}
class Other { static String hello = "Hello"; }

```
These are the six facts on Strings:
1. Literal strings within the same class in the same package represent references to the same String object. 
2. Literal strings within different classes in the same package represent references to the same String object. 
3. Literal strings within different classes in different packages likewise represent references to the same String object. 
4. Strings computed by constant expressions are computed at compile time and then treated as if they were literals. 
5. Strings computed at run time are newly created and therefore are distinct. (So line 4 prints false.)
6. The result of explicitly interning a computed string is the same string as any pre-existing literal string with the same contents. (So line 5 prints true.)

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

####  Inicjalizacja wartościami domyślnymi
All the elements of an array of primitives are automatically initialized by default values, which is 0 for numeric types and false for boolean.

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
ArrayList implementuje Collection

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
boolean remove(Object object); // wynik - 
// true - jeżeli element był na liście i został usunięty, false - wpp.
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
Uwaga - konstruktory obiektów Short, Char, Byte, Long, Float, Double 
przyjmuja jako parametr String, lub wartość primitive odpowiadajacego typu:

```
Long(long value);
Long(String s);

Short(short value);
Short(String s);
```



błędne wartości:

```
int bad1 = Integer.parseInt("a"); // throws NumberFormatException
Integer bad2 = Integer.valueOf("123.45"); // throws NumberFormatException
```

```
Wrapper class 	Converting String to primitive	 	Converting String to wrapper class
Boolean 			Boolean.parseBoolean("true"); 		Boolean.valueOf("TRUE");
Byte 				Byte.parseByte("1"); 					Byte.valueOf("2");
Short 				Short.parseShort("1"); 				Short.valueOf("2");
Integer 			Integer.parseInt("1"); 				Integer.valueOf("2");
Long 				Long.parseLong("1"); 					Long.valueOf("2");
Float 				Float.parseFloat("1"); 				Float.valueOf("2.2");
Double 			Double.parseDouble("1"); 				Double.valueOf("2.2");
Character 		None 										None
```

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

implementuje java.time.temporal.TemporalAccessor

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
//LocalDate d = new LocalDate(); // DOES NOT COMPILE
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


# ch04 Methods and Encapsulation

## methods
### specifiers
static 
abstract  - metody abstrakcyjne tylko w klasach abstrakcyjnych
final 
synchronized 
native 
strictfp 
default - tylko dla interfaceów
### return type

```
public void walk1() { }
public void walk2() { return; }
public String walk3() { return ""; }
public String walk4() { } // DOES NOT COMPILE - nic nie zwraca
public walk5() { } // DOES NOT COMPILE - brak zwracanego typu
String walk6(int a) { if (a == 4) return ""; } // DOES NOT COMPILE - nie wszystkie ścieżki zwracaja wartość.
```

```
int integer() {
	return 9;
}
int long() {]
	return 9L; // DOES NOT COMPILE
}

//jest równoważne z wprowadzeniem lokalnej zmiennej:

int integerExpanded() {
	int temp = 9;
	return temp;
}
int longExpanded() {
	int temp = 9L; // DOES NOT COMPILE
	return temp;
}
```

### method name
An identifier may only contain letters, numbers, $, or _.
Also, the fi rst character is not allowed to be a number, and reserved words are not allowed.

### parameter list
parametry w nawiasach. oddzielone przecinkami.


### optional Exception list

```
public void zeroExceptions() { }
public void oneException() throws IllegalArgumentException { }
public void twoExceptions() throws
IllegalArgumentException, InterruptedException { }
```

```
public void method1() throws Exception001{
	return ;
}

public void method1() throws Exception002{//DOES NOT COMPILE
	return ;
}
```

### method body
code block.

## Varargs
vararg - musi być ostatnim parametrem.

```
public void walk1(int... nums) { }
public void walk2(int start, int... nums) { }
public void walk3(int... nums, int start) { } // DOES NOT COMPILE
public void walk4(int... start, int... nums) { } // DOES NOT COMPILE
```

wywołanie metody z lista argumentów vararg:
-przekazanie tablicy
-przekazanie argumentów rozdzielonych przecinkami

```
public void walk2(int start, int... nums) { 
	System.out.println(nums.length);
}

walk2(1);//0
walk2(1,2);//1
walk2(1,2,3);//2
walk2(1,new int[]{1,2});//2
```

czyli poprawne sa tez poniższe przykłady.
Tyle, ze argument tablicowy różni się od vararg - do arumentu tablicowego
nie mogę przekazać argumetnów po przecinku.

```
public void walk1(int[] params,int... nums) { }
```


## Applying modifier access

private: Only accessible within the same class
default (package private) access: private and other classes in the same package
protected: default access and child classes
public: protected and classes in the other packages

### default (package private)

pond.duck.MotherDuck;

metody 'package private' sa widoczne w tym samym pakiecie. (new MotherDuck)
pond.duck.GoodDuckling;

metody 'package private' nie sa widoczne w podpakietach.(new MotherDuck)
pond.duck.second.SadSecondDuckling;//DOES NOT COMPILE

metody 'package private' nie sa widoczne w innych pakietach.(new MotherDuck)
pond.shore.BadCygnet;//DOES NOT COMPILE


metody 'package private' nie sa widoczne dla 'dzieci' w innych pakietach.(extends MotherDuck)
pond.shore.SadMotherDuckChild;//DOES NOT COMPILE

```
package pond.duck;
public class MotherDuck {
	String noise = "quack";
	void quack() {
		System.out.println(noise); // default access is ok
	}
	private void makeNoise() {
		quack(); // default access is ok
	}
}


package pond.duck;
public class GoodDuckling {
	public void makeNoise() {
		MotherDuck duck = new MotherDuck();
		duck.quack(); // default access
		System.out.println(duck.noise); // default access
	} 
}


package pond.duck.second;
import pond.duck.MotherDuck;
public class SadSecondDuckling {
	public void makeNoise() {
		MotherDuck duck = new MotherDuck();
		duck.quack(); // DOES NOT COMPILE
		System.out.println(duck.noise); // DOES NOT COMPILE
	} 
}


package pond.shore;
import pond.duck.MotherDuck;// import another package
public class BadCygnet {
	public void makeNoise() {
		MotherDuck duck = new MotherDuck();
		duck.quack(); // DOES NOT COMPILE
		System.out.println(duck.noise); // DOES NOT COMPILE
	} 
}


package pond.shore;
import pond.duck.MotherDuck;
public class SadMotherDuckChild extends MotherDuck{
	public void sadQuack() {
		quack();//DOES NOT COMPILE
	}
}
```


### Protected


pond.shore.Bird;

metody 'protected'  sa widoczne zarowno przy wywolaniu jako self, jak i new Bird w tym samym pakiecie
pond.shore.BirdChild; (extends Bird)

metody 'protected'  sa wiodczne przy wywolaniu na obiekcie new Bird w tym samym pakiecie
pond.shore.BirdWatcher; 

metody 'protected' nie sa widoczne przy wywolaniu na obiekcie new Bird w innym pakiecie
pond.inland.BirdWatcherFromAfar ;

metody 'protected'
-sa widoczne przy wywolaniu 'self'
-sa widoczne przy wywolaniu new Goosling (innego obiektu)
-nie sa widoczne przy wywolaniu new Bird w innym pakiecie
pond.goose.Goosling; (extends Bird)

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
		//bird.floatInWater();//??? - raczej nie - inny pakiet
		//Gosling gosling = new Gosling();
		//gosling.floatInWater();//??? - raczej tak - ten sam pakiet
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

### metody statyczne

```
public class Koala {
	public static int count = 0; // static variable
	public static void main(String[] args) { // static method
		System.out.println(count);
	}
}
```

Wywołanie main:

```
public class KoalaTester {
	public static void main(String[] args) {
		Koala.main(new String[0]); // call static method
	}
}
```

Wywołanie metody statycznej na null:

```
Koala k = new Koala();
System.out.println(k.count); // k is a Koala
k = null;
System.out.println(k.count); // k is still a Koala
```

jednak zmienna musi najpierw zostac zainicjalizowana, dopiero potem przypisane null:

```
public class Statics {
	static int test = 11;
	public static void main(String[] args) {
		Statics s;
	//	System.out.println(s.test);//DOES NOT COMPILE
	}
}
```

#### static vs instance

```
public class Static {
	private String name = "Static class";
	public static void first() { }
	public static void second() { }
	public void third() { System.out.println(name); }
	public static void main(String args[]) {
		first();
		second();
		third(); // DOES NOT COMPILE
	} 
}
```

#### static variables (static final) 
zmienne static final - nie zmieniaja sie nigdy podczas dzialania programu.
Mozna je zainicjalizować w momencie deklaracji, lub jeżeli w momencie deklaracji
nie sa zainicjalizowana, to w bloku statycznym. Nie można przypisywać im wartości pózniej.

```
public class Initializers {
	private static final int NUM_BUCKETS = 45;
	public static void main(String[] args) {
		NUM_BUCKETS = 5; // DOES NOT COMPILE
	} 
}
```

Można natomiast operować na tych obiektach:

```
private static final ArrayList<String> values = new ArrayList<>();
public static void main(String[] args) {
	values.add("changed");
}
```

#### Inicjalizacja statyczna

```
private static final int NUM_SECONDS_PER_HOUR;
static {
	int numSecondsPerMinute = 60;
G	int numMinutesPerHour = 60;
	NUM_SECONDS_PER_HOUR = numSecondsPerMinute * numMinutesPerHour;
}
```

```
private static int one;
private static final int two;
private static final int three = 3;
private static final int four; // DOES NOT COMPILE - nie zainicjalizowane ani
//w miejscu deklaracji, ani w bloku statycznym. 
//Pózniej juz nie mozna zainicjalizowac

static {
	one = 1;
	two = 2;
	three = 3; // DOES NOT COMPILE - zainicjalizowane dwukrotnie
	two = 4; // DOES NOT COMPILE - zainicjalizowane dwukrotnie
}
```

#### Importy statyczne
importy statyczne - dla metod lub zmiennych statycznych klasy

```
import java.util.List;
// static import - import metody statycznej
import static java.util.Arrays.asList; 

public class StaticImports {
	public static void main(String[] args) {
		List<String> list = asList("one", "two"); // no Arrays.
	} 
}
```

```
import static java.util.Arrays; // DOES NOT COMPILE - nie statyczny element 
import static java.util.Arrays.asList; // ok
static import java.util.Arrays.*; // DOES NOT COMPILE - przestawiona kolejność

public class BadStaticImports {
	public static void main(String[] args) {
		//Arrays.asList("one"); //DOES NOT COMPILE - nie zaimportowana klasa Arrays!
		asList("one"); // ok
	} 
}
```

## Passing Data Among Methods
Zmienne przekazywane przez wartość. Tworzona jest kopia zmiennej i metoda otrzymuje ta kopię.

primitives:

```
public static void main(String[] args) {
	int num = 4;
	newNumber(5);
	System.out.println(num); // 4
}
public static void newNumber(int num) {
	num = 8;
}
```

referencje:

```
public static void main(String[] args) {
	String name = "Webby";
	speak(name);
	System.out.println(name);//Webby
}
public static void speak(String name) {
	name = "Sparky";
}
```

operowanie na zmiennych:
tworzona jest kopia referencji, jednak ta kopia wskazuje na ten sam obiekt. 

name ---> StringBuilder object <---- s

```
public static void main(String[] args) {
	StringBuilder name = new StringBuilder();
	speak(name);
	System.out.println(name); // Webby
}

public static void speak(StringBuilder s) {
	s.append("Webby");
}
```

returning
tworzona jest kopia wartości lub referencji do obiektu i zwracana.

```
public class ReturningValues {

	public static void main(String[] args) {
		int number = 1; // 1
		String letters = "abc"; // abc
		number(number); // 1
		letters = letters(letters); // abcd
		System.out.println(number + letters); // 1abcd
	}

	public static int number(int number) {
		number++;
		return number;
	}

	public static String letters(String letters) {
		letters += "d";
		return letters;
	}

}
```

## Overloading

- istotne - zmiany na liście parametrów
- nieistotne - modyfikatory dostępu, lista wyjatkow


```
public void fly(int[] lengths) { }
public void fly(int... lengths) { } // DOES NOT COMPILE
```


```
//Jeżeli metoda
public void fly(int[] lengths) { }
//odwołanie:
fly(new int[] { 1, 2, 3 });
```

```
//Jeżeli metoda
public void fly(int... lengths) { }
//odwołania:
fly(new int[] { 1, 2, 3 });
fly(1, 2, 3);
```

### Autoboxing

jeżeli jest tylko metoda:

```
public void fly(Integer numMiles) { }
```
można ja wywołać:

```
fly(4);
```

java wykorzysta autoboxing i zmieni wartość primitive int na Integer 

jeżeli istnieja przeładowane metody, wówczas wywołana zostanie najbardziej pasujaca.

```
public void fly(int numMiles) { }
public void fly(Integer numMiles) { }
```

### Reference Types ~!

```
public class ReferenceTypes {
	public void fly(String s) {
		System.out.print("string ");
	}

	public void fly(Object o) {
		System.out.print("object ");
	}

	public static void main(String[] args) {
		ReferenceTypes r = new ReferenceTypes();
		r.fly("test"); // string
		r.fly(56); // int -> (autoboxing) Integer -> Object
	} 
}
```

### Reference types


```
public class Plane {
	public void fly(int i) {
		System.out.print("int ");
	}

	public void fly(long l) {
		System.out.print("long ");
	}

	public static void main(String[] args) {
		Plane p = new Plane();
		p.fly(123);//int
		p.fly(123L);//long
	} 
}
```

### Podsumowanie

Kolejność wywołań:
1. Dokładny typ primitive
2. Wiekszy typ primitive
3. Autoboxed typ
4. Varargs

Example of what will be chosen for glide(1,2)

```
Exact match by type: public String glide(int i, int j) {}
Larger primitive type: public String glide(long i, long j) {}
Autoboxed type: public String glide(Integer i, Integer j) {}
Varargs: public String glide(int... nums) {}
```

#### To many conversions

```
public class TooManyConversions {
	public static void play(Long l) { }
	public static void play(Long... l) { }
	public static void main(String[] args) {
		play(4); // DOES NOT COMPILE - za dużo kroków. int -> long lub int -> Integer jest ok
		// int -> long -> Long - ZLE!
		play(4L); // calls the Long version
	} 
}
```

## Konstruktory 
Nazywa się tak samo jak klasa i nie ma zwracanego typu:

public class Bunny{
	public Bunny(){}
}

konstruktor domyślny - generowany przez jave, jeżeli nie ma żadnego innego konstruktora.

### Nie moga być final, static, abstract
### Może być: MyObj(MyObj m)

### Overloading construktors
musza miec różne parametry.

Wywołanie innych konstruktorów:


```
public Hamster(int weight) {
	this(weight, "brown");
}
```
wywołanie this musi być pierwsze!!!

```
public Hamster(int weight) {
	System.out.println("in constructor");
	// ready to call this
	this(weight, "brown"); // DOES NOT COMPILE
}
```

błędne wywołania:

```
public Hamster(int weight) {
	Hamster(weight, "brown"); // DOES NOT COMPILE
}
public Hamster(int weight) {
	new Hamster(weight, "brown"); // Compiles but does not do what we want
}
```

### inicjalizacja zmiennych final w konstruktorze

W konstruktorze możemy zainicjalizować zmienne instancji final.


```
public class MouseHouse {
	private final int volume;
	private final String name = "The Mouse House";
	public MouseHouse(int length, int width, int height) {
		volume = length * width * height;
	}
}
```

### Kolejność inicjalizacji

1. If there is a superclass, initialize it first 
2. Static variable declarations and static initializers in the order they appear in the file.
3. Instance variable declarations and instance initializers in the order they appear in the file.
4. The constructor.

TODO - kiedy inicjalizowane sa pola statyczne? Przy pierwszym wykorzystaniu klasy?


## Encapsulating Data - java beans

## Writing Simple Lambdas (lambda)
```
public class TestClass{     
	public static boolean checkList(List list, Predicate<List> p){       
		return p.test(list);    
	}       
	
	//boolean b - ma być true - przykłady:
	public static void main(String[] args) {       
		boolean b = checkList(new ArrayList(), al -> al.isEmpty());

		//jeżeli jest lista parametrów - musi być w nawiasach - (List al)
		boolean b = checkList(new ArrayList(), (List al) -> al.isEmpty());

		//jeżeli jest return, musi być w ciele metody (średnik na końcu)
		boolean b = checkList(new ArrayList(), al -> { return al.size() == 0; });

		//metoda add zawsze zwraca true.
		boolean b = checkList(new ArrayList(), al -> al.add("hello"));

		//DOES NOT COMPILE!
		//checkList(new ArrayList(), (ArrayList al) -> al.isEmpty());
		//Predicate is typed to List (not ArrayList) in the checkList method, therefore, the parameter type in the lambda expression must also be List. It cannot be ArrayList.

		System.out.println(b);    
	} 
}
```

### Zakres zmiennych w lambda
Remember that a lambda expression does not create a new scope for variables. Therefore, you cannot reuse the variable names that have already been used to define new variables in your argument list . 

```
Data d = new Data(1);
//DOES NOT COMPILE
//filterData(al, d -> d.value%2 == 0 );
```

### Określenie, czy lambda jest ok
There is a simple trick to identify invalid lambda constructs. 
When you write a lambda expression for a functional interface, 
you are essentially providing an implementation of the method declared in that interface but in a very concise manner.  
Therefore, the lambda expression code that you write must contain all the pieces of the regular method code 
except the ones that the compiler can easily figure out on its own such as the parameter types, 
return keyword, 
and brackets. 
So, in a lambda expression, 
just check that all the information is there and that the expression follows the basic syntax -
(parameter list) OR single_variable_without_type -> { regular lines of code } OR just_an_expression_without_semicolon  

# ch05 Class Design 

## Inheritence

Jeżeli jakiś obiekt nie dziedziczy po żadnym innym obiekcie, kompilator javy automatycznie dodaje java.lang.Object.
Czyli każdy obiekt dziedziczy po java.lang.Object.

### Constructor

W javie w każdym konsruktorze na samym poczatku jest albo this(), albo super().


#### super() - wywołanie konstruktora rodzica
zawsze musi być pierwsze w konstruktorze

```
public class Zoo {
	public Zoo() {
		System.out.println("Zoo created");
		super(); // DOES NOT COMPILE
	}
}
```
```
public class Zoo {
	public Zoo() {
		super();
		System.out.println("Zoo created");
		super(); // DOES NOT COMPILE
	}
}
```

super() może się odnosić do każdego konstruktora klasy rodzica.
Wywołane z odpowiednimi argumentami, np.: super("Some string");

#### compiler enhancements

Jeżeli w konstruktorze nie ma wywołania super(), kompilator javy sam je doda.
Przykład - wszystkie klasy po kompilacji będa miały ostatnia postać:

```
public class Donkey {
}

public class Donkey {
	public Donkey() {}
}

public class Donkey {
	public Donkey() {
		super();
	}
}
```

Bezargumentowy konstruktor jest tworzony przez kompilator, tylko gdy użytkownik nie utworzył swojego konstruktora, co oznacza, że poniższy kod się nie skompiluje:

```
public class Mammal {
	public Mammal(int age) {
	}
}

public class Elephant extends Mammal { // DOES NOT COMPILE
}
```

1. The first statement of every constructor is a call to another constructor within the class using this(), or a call to a constructor in the direct parent class using super().
2. The super() call may not be used after the first statement of the constructor.
3. If no super() call is declared in a constructor, Java will insert a no-argument super()
as the first statement of the constructor.
4. If the parent doesn’t have a no-argument constructor and the child doesn’t define any
constructors, the compiler will throw an error and try to insert a default no-argument
constructor into the child class.
5. If the parent doesn’t have a no-argument constructor, the compiler requires an explicit call to a parent constructor in each child constructor.

### calling inherited class members

Klasa dziecka ma dostęp do wszystkich członków klasy rodzica `protected` i `public`
Jeżeli jest w tym samym pakiecie, również do wszystkich pakietowych.
Nie ma nigdy dostępu do członków prywatnych.

```
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

package oca.ch05.inheritance.accesstomembers;
public class Shark extends Fish{
	public Shark(int age) {
		super(age);
	}
	private int numberOfFins = 8;

	public void method(){

		//dostęp do zmiennej protected int size
		System.out.println(this.size);
		System.out.println(super.size);
		System.out.println(size);

		//brak dostępu do zmiennej private int age w klasie dziecka

		//dostęp do metody public int gt:
		System.out.println(this.getAge());
		System.out.println(super.getAge());
		System.out.println(getAge());

		System.out.println(numberOfFins);
		System.out.println(this.numberOfFins);
		//nie można użyć super do zmiennej nie bedaca zmienna z parenta.

		System.out.println(this.speed);//tylko, jezeli klasa rodzica w tym samym pakiecie!!!
		System.out.println(super.speed);//j.w.
	}

	public static void main(String[] args) {
		Shark s = new Shark(17);
		s.method();
	}
}

package oca.ch05.inheritance.accesstomembers.sub;
import oca.ch05.inheritance.accesstomembers.Fish;
public class Karp extends Fish{

	public Karp(int age) {
		super(age);
	}

	public void method() {
		//System.out.println(this.speed);//DOES NOT COMPILE
	}

}

```

```
public class Rabbit extends Animal{
	...
	public Rabbit(int age) {
		super; // DOES NOT COMPILE
		super().setAge(10); // DOES NOT COMPILE
	}
	...
}
```

### Inheriting Methods

Odniesienie się do metody rodzica:

```
public class Canine {
	public double getAverageWeight() {
		return 50;
	}
}

public class Wolf extends Canine {

	//overriding
	public double getAverageWeight() {
		//acces to parent
		return super.getAverageWeight()+20;
	}

	public static void main(String[] args) {
		System.out.println(new Canine().getAverageWeight());//50.00
		System.out.println(new Wolf().getAverageWeight());//70.00
	}
}
```

#### Overriding (nadpisywanie, zastępowanie) rules:

The compiler performs the following checks when you override a nonprivate method:
1. The method in the child class must have the same signature as the method in the parent class.
2. The method in the child class must be at least as accessible or more accessible than the method in the parent class.
3. The method in the child class may not throw a checked exception that is new or broader than the class of any exception thrown in the parent class method.
4. If the method returns a value, it must be the same or a subclass of the method in the parent class, known as covariant return types.

1. Metoda w klasie dziecka musi mieć tą samą sygnaturę co w klasie rodzica
2. Metoda w klasie dziecka musi mieć przynajmniej taki sam lub większy dostęp niż metoda w klasie rodzica
3. Metoda w klasie dziecka nie może rzucać checked exception który jest nowy, lub ma szerwszy zakres niż wyjątek rzucany przez metodą w klasie rodzica
4. Jeżeli metoda zwraa wartość, musi typ wartości musi być taki sam, lub być podklasą typu (typy kowariantne) zwracanego przez metodą w klasie rodzica.

#### Overloading vs. overriding 

```
public class Bird {
	public void fly() { }
	public void eat(int food) { }
}

public class Eagle extends Bird {

	public int fly(int height) {// overloading
		return height;
	}

	public int eat(int food) { // DOES NOT COMPILE - inny typ return
		return food;
	}
}
```

#### Does not compile Example

```
public class Camel {
	protected String getNumberOfHumps() {
		return "Undefined";
	}
}

public class BactrianCamel extends Camel {
	// violates rule 2 - is less accesible
	// violates rule 4 - return type is not covariant
	private int getNumberOfHumps() { // DOES NOT COMPILE
		return 2;
	}
}
```

Any time you see a method that appears to be overridden on the example, 
1. check to make sure it is truly being overridden and not overloaded. 
2. check that the access modifiers
3. check return types
4. check exceptions defined in the method are compatible with one another. 

#### ok exception example

```
public class InsufficientDataException extends Exception {}

public class Reptile {
	protected boolean hasLegs() throws InsufficientDataException {
		throw new InsufficientDataException();
	}
	protected double getWeight() throws Exception {
		return 2;
	}
}

public class Snake extends Reptile {

	//brak wyjątku 
	// ok
	protected boolean hasLegs() {
		return false;
	}

	//wyjątek ma węższy zakres - ok
	// ok
	// InsufficientDataException - subclass of Exceptino
	protected double getWeight() throws InsufficientDataException{
		return 2;
	}
}
```

#### Does not compile exception example

```
public class InsufficientDataException extends Exception {}
public class Reptile {
	protected double getHeight() throws InsufficientDataException {
		return 2;
	}
	protected int getLength() {
		return 10;
	}
}

public class Snake extends Reptile {

	// DOES NOT COMPILE
	// Exception is not subclass of InsufficientDataException
	protected double getHeight() throws Exception { 
		return 2;
	}

	// DOES NOT COMPILE
	// Child class defines new exception.
	protected int getLength() throws InsufficientDataException { 
		return 10;
	}
}
```

#### Redeclaring private Methods

Może istnieć metoda prywatna w klasie dziecka o takiej samej sygnaturze jak metoda prywatna w klasie rodzica.
Klasa dziecka nie widzi metody prywatnej rodzica. Metody sa niezależne.

#### Hiding Static Methods 5. Rule

Zasady takie same jak przy przeciażaniu metod.
Dodatkowa zasada:

5. The method defined in the child class must be marked as static if it is marked as
static in the parent class (method hiding). Likewise, the method must not be marked
as static in the child class if it is not marked as static in the parent class (method
overriding). 


#### Hiding Static Methods OK Example

```
public class Bear {
	public static void eat() {
		System.out.println("Bear");
	}
	public static void onlyinparent() {
                System.out.println("only in parent");
        }

}

public class Panda extends Bear {
	public static void eat() { // static tak jak w parent - metoda ukrywa metodę parenta.
		System.out.println("Panda");
	}
	public static void main(String[] args) {

		 public static void main(String[] args) {
		 Bear.eat();//Bear
		 Panda.eat();//Panda

		 Bear b = new Bear();
		 b.eat();//Bear
		 Panda p = new Panda();
		 p.eat();//Panda
		 
		 Bear pb = new Panda();
		 pb.eat();//Bear - czyli metoda statyczna w zależności od tego jaki jest typ referencji, a nie obiektu na który wskazuje referencja
		 ((Panda)pb).eat();//Panda

		 Panda.onlyinparent();//only in parent - wypisze ok!
		 
	}
}
```

#### Hiding Static Methods Error Example

```
public class Bear {
	public static void sneeze() {
		System.out.println("Bear sneezes");
	}
	public void hibernate() {
		System.out.println("Bear hibernating");
	}
}

public class Panda extends Bear {

	// DOES NOT COMPILE 
	// nie jest static w odróżnieniu od rodzica
	public void sneeze() { 
		System.out.println("Panda sneezes");
	}

	// DOES NOT COMPILE
	// jest static w odróżnieniu od rodzica
	public static void hibernate() { 
		System.out.println("Panda hibernating");
	}
}


```

#### Overriding vs. Hidden Static Methods in Parent and in Child

##### Hidden Static Methods:
Dla poniższego przykładu metoda `isBiped()` jest statyczna.

```
public class Marsupial {
	public static boolean isBiped() {
		return false;
	}
	public void getMarsupialDescription() {
		System.out.println("Marsupial walks on two legs: "+isBiped());
	}
}

public class Kangaroo extends Marsupial {
	public static boolean isBiped() {
		return true;
	}
	public void getKangarooDescription() {
		System.out.println("Kangaroo hops on two legs: "+isBiped());
	}
	public static void main(String[] args) {
		Kangaroo joey = new Kangaroo();
		joey.getMarsupialDescription();//"Marsupial walks on two legs: false"
		joey.getKangarooDescription();//"Kangaroo hops on two legs: true"
	}
}
```

##### Overriden Methods:

Dla poniższego przykładu `isBiped()` - jest przeładowana, a nie ukryta w klasie dziecka (nie jest static), 
w trakcie runtime, jest więc zastępowana w klasie rodzica odwołaniem do metody dziecka (Polimorfizm).

```
class Marsupial {
	public boolean isBiped() {
		return false;
	}

	public void getMarsupialDescription() {
		System.out.println("Marsupial walks on two legs: "+isBiped());
	}
}

public class Kangaroo extends Marsupial {
	public boolean isBiped() {
		return true;
	}
	public void getKangarooDescription() {
		System.out.println("Kangaroo hops on two legs: "+isBiped());
	}
	public static void main(String[] args) {
		Kangaroo joey = new Kangaroo();
		joey.getMarsupialDescription();//Marsupial walks on two legs: true
		joey.getKangarooDescription();//Kangaroo hops on two legs: true
	}
}
```

#### creating final methods

Final methods cannot be overriden.

```
public class Bird {
	public final boolean hasFeathers() {
		return true;
	}
}
public class Penguin extends Bird {
	public final boolean hasFeathers() { // DOES NOT COMPILE
		return false;
	}
}
```

### Inheriting Variables - dziedziczenie zmiennych

Jeżeli zmienna w klasie dziecka ma taką samą nazwę jak zmienna w klasie rodzica mówimy o ukrywaniu.
przy utworzeniu obiektu klasy dziecka tworzone są dwie instancje tej zmiennej - jedna z klasy rodzica, druga z klasy dziecka.
Inaczej niż w przypadku polimorfizmu:
 - Jeżeli odniesienie do zmiennej następuje z klasy rodzica - wykorzystana jest instancja zmiennej z klasy rodzica.
 - Jeżeli odniesienie do zmiennej następuje z klasy dziecka - wykorzystana jest instancja zmiennej z klasy dziecka.
 - Jeżeli z wewnątrz klasy dziecka chcę się odnieść do zmiennej z klasy rodzica muszę wykorzystać słowo kluczowe `super`


```
public class Rodent {
	protected int tailLength = 4;
	public void getRodentDetails() {
		System.out.println("[parentTail="+tailLength+"]");
	}
}

public class Mouse extends Rodent {
	protected int tailLength = 8;
	public void getMouseDetails() {
		System.out.println("[tail="+tailLength +",parentTail="+super.tailLength+"]");
	}
	public static void main(String[] args) {
		Mouse mouse = new Mouse(); 
		mouse.getRodentDetails();//[parentTail=4]
		mouse.getMouseDetails();//[tail=8,parentTail=4]
		System.out.println(mouse.tailLength);//8
		System.out.println(((Rodent)mouse).tailLength);//4 
	}
}
```

### Ingeriting Variables (z testów)

Zmienne i metody statyczne są dostępne dla typu refernencji, nie dla typu obiektu na który wskazuje referencja.
Jeżeli więc nie ma zmiennej w interfejsie lub klasie po której dziedziczy klasa dziecka, to po rzutowaniu zmienna ta nie będzie dostępna.

```
package oca.ch05.inheritance.interfacevariable;

interface NoVariableInterface{ }
class NoVariableClass{ }

public class ClassWithVariable extends NoVariableClass implements NoVariableInterface{

	public int classVariable = 10;
	
	public static void main(String[] args) {
		ClassWithVariable cwv = new ClassWithVariable();
		System.out.println(cwv.classVariable);
//		System.out.println(((NoVariableInterface)cwv).classVariable);//DOES NOT COMPILE
//		System.out.println(((NoVariableClass)cwv).classVariable);//DOES NOT COMPILE
	}

}

```

## Abstract classes

Klasa abstrakcyjna:
* słowo kluczowe `abstract`
* nie może mieć instancji

Metoda abstrakcyjna:
* słowo kluczowe `abstract`
* brak implementacji (czyli brak ciała metody)

```
public abstract class Animal {
	protected int age;
	public void eat() {
		System.out.println("Animal is eating");
	}
	public abstract String getName();
}

public class Swan extends Animal {
	public String getName() {
		return "Swan";
	}
}
```

### Definicja klasy abstrakcyjnej

```
public abstract class Cow {}
```
Uwaga na:
* metody oznaczone jako `abstract` z ciałem klasy - `{}` - nie skompiluje się
* metoda abstrakcyjna może być zdefiniowana tylko w klasie abstrakcyjnej
* klasa abstrakcyjna nie może być oznaczona jako `final`
* metoda abstrakcyjna nie może być oznaczona jako `final`
* metoda abstrakcyjna nie może być `private`
* metoda abstrakcyjna musi mieć w klasie dziedziczacej taka sama lub wieksza widoczność

```
public class Chicken {
	public abstract void peck(); // DOES NOT COMPILE
}
```

```
public abstract class Turtle {
	public abstract void swim() {} // DOES NOT COMPILE
	public abstract int getAge() { // DOES NOT COMPILE
		return 10;
	}
}
```

```
public final abstract class Tortoise { // DOES NOT COMPILE
}
```

```
public abstract class Goat {
	public abstract final void chew(); // DOES NOT COMPILE
}
```

```
public abstract class Whale {
	private abstract void sing(); // DOES NOT COMPILE
}
public class HumpbackWhale extends Whale {
	private void sing() {
		System.out.println("Humpback whale is singing");
	}
}
```

```
public abstract class Whale {
	protected abstract void sing();
}
public class HumpbackWhale extends Whale {
	private void sing() { // DOES NOT COMPILE
		System.out.println("Humpback whale is singing");
	}
}
```

### public static void main w klasie abstrakcyjnej

```
abstract class Calculator{    
	abstract void calculate();    
	public static void main(String[] args){
	       System.out.println("calculating");       
	       Calculator x = null;       
	       x.calculate();    
   } 
}
```

### Utworzenie konkretnej klasy

```
public abstract class Eel {
	public static void main(String[] args) {
		final Eel eel = new Eel(); // DOES NOT COMPILE
	}
}
```

konkretna klasa rozszerzajaca klase abstrakcyjna musi implementować wszystkie metody abstrakcyjne.

```
public abstract class Animal {
	public abstract String getName();
}
public class Bird extends Animal { // DOES NOT COMPILE
}
```

### Extending abstract class

Klasa abstrakcyjna rozszerzajaca inna klase abstrakcyjna nie musi implementować metod abstrakcyjnych.

```
public abstract class Animal {
	public abstract String getName();
}

public class Walrus extends Animal { // DOES NOT COMPILE
}

public abstract class Eagle extends Animal {
}
```

Natomiast klasa konkretna musi implementować wszystkie metody abstrakcyjne.

```
public abstract class Animal {
	public abstract String getName();
}

public abstract class BigCat extends Animal {
	public abstract void roar();
}

public class Lion extends BigCat {
	public String getName() {
		return "Lion";
	}
	public void roar() {
		System.out.println("The Lion lets out a loud ROAR!");
	}
}
```

Klasa nie musi dostarczać implementacji metody, jeżeli jedna z klas abstrakcyjnyc w hierarchii już to robi.

```
public abstract class Animal {
	public abstract String getName();
}

public abstract class BigCat extends Animal {
	public String getName() {
		return "BigCat";
	}
	public abstract void roar();
}

public class Lion extends BigCat {
	public void roar() {
		System.out.println("The Lion lets out a loud ROAR!");
	}
}
```

TODO - czy klasa abstrakcyjna może nadpisywać metodę nieabstrakcyjna metoda abstrakcyjna?

```
public class Concrete001 {
	public void method(int i) { }
}

public abstract class Abstract002 extends Concrete001{
	public abstract void method(int i); // OK 
}

public class Concrete003 extends Abstract002{
	@Override
	public void method(int i) {
	}
}
```

### Abstract Class Definition Rules
1. Abstract classes cannot be instantiated directly.
2. Abstract classes may be defined with any number, including zero, of abstract and nonabstract
methods.
3. Abstract classes may not be marked as private or final.
4. An abstract class that extends another abstract class inherits all of its abstract methods
as its own abstract methods.
5. The first concrete class that extends an abstract class must provide an implementation
for all of the inherited abstract methods.

Abstract Method Defi nition Rules:

1. Abstract methods may only be defined in abstract classes.
2. Abstract methods may not be declared private or final.
3. Abstract methods must not provide a method body/implementation in the abstract
class for which is it declared.
4. Implementing an abstract method in a subclass follows the same rules for overriding a
method. For example, the name and signature must be the same, and the visibility of
the method in the subclass must be at least as accessible as the method in the parent
class.

## Implementing Interfaces

```
public abstract interface CanBurrow { // abstract - assumed; interface - required
	public static final int MINIMUM_DEPTH = 2; // public static final - assumed
	public abstract int getMaximumDepth(); // public abstract - assumed
}

public class FieldMouse implements CanBurrow {
	public int getMaximumDepth() {
		return 10;
	}
}
```

Wiele interfaceów:

```
public class Elephant implements WalksOnFourLegs, HasTrunk, Herbivore {
}
```

Zasady dot. interfaceów:

1. Interfaces cannot be instantiated directly.
2. An interface is not required to have any methods.
3. An interface may not be marked as final.
4. All top-level interfaces are assumed to have public or default access, and they must
include the abstract modifier in their definition. Therefore, marking an interface as
private, protected, or final will trigger a compiler error, since this is incompatible
with these assumptions. (nie odnosi się do interfaceów wewnętrznych)
5. All nondefault methods in an interface are assumed to have the modifiers abstract
and public in their definition. Therefore, marking a method as private, protected,
or final will trigger compiler errors as these are incompatible with the abstract and
public keywords.

### Przykłady

```
public interface WalksOnTwoLegs {}

public class TestClass {
	public static void main(String[] args) {
		WalksOnTwoLegs example = new WalksOnTwoLegs(); // DOES NOT COMPILE 
		// interface cannot have instance
	}
}

public final interface WalksOnEightLegs { // DOES NOT COMPILE - final
}
```

### public abstract - assumed
```
public interface CanFly {
	void fly(int speed);
	abstract void takeoff();
	public abstract double dive();
}

//zostanie przez kompilator zmienione:

public abstract interface CanFly {
	public abstract void fly(int speed);
	public abstract void takeoff();
	public abstract double dive();
}
```

### does not compile interface examples
```
private final interface CanCrawl { // DOES NOT COMPILE
	private void dig(int depth); // DOES NOT COMPILE
	protected abstract double depth(); // DOES NOT COMPILE
	public final void surface(); // DOES NOT COMPILE
}
```

### Inheriting interface

1. An interface that extends another interface, as well as an abstract class that
implements an interface, inherits all of the abstract methods as its own abstract
methods.
2. The first concrete class that implements an interface, or extends an abstract class
that implements an interface, must provide an implementation for all of the inherited
abstract methods.

Interface może rozszerzać wiele interfaceów

```
public interface HasTail {
	public int getTailLength();
}

public interface HasWhiskers {
	public int getNumberOfWhiskers();
}

public interface Seal extends HasTail, HasWhiskers {
}
```

```
public interface HasTail {
	public int getTailLength();
}

public interface HasWhiskers {
	public int getNumberOfWhiskers();
}

public abstract class HarborSeal implements HasTail, HasWhiskers {
	//klasa abstrakcyjna - musi implementować metody
}

public class LeopardSeal implements HasTail, HasWhiskers { // DOES NOT COMPILE
	//nie zaimplementowane metody
}
```

#### extends keyword

```
public interface CanRun {}
public class Cheetah extends CanRun {} // DOES NOT COMPILE
public class Hyena {}
public interface HasFur extends Hyena {} // DOES NOT COMPILE
```

#### Abstract Methods and Multiple Inheritance

##### Same method signature - ok

```
public interface Herbivore {
	public void eatPlants();
}

public interface Omnivore {
	public void eatPlants();
	public void eatMeat();
}

public class Bear implements Herbivore, Omnivore {
	public void eatMeat() { }
	public void eatPlants() { }
}
```

##### Different method signature - overloading - ok

```
public interface Herbivore {
	public int eatPlants(int quantity);
}

public interface Omnivore {
	public void eatPlants();
}

public class Bear implements Herbivore, Omnivore {
	//overloading
	public int eatPlants(int quantity) {
		return quantity;
	}

	//overloading
	public void eatPlants() {
	}
}
```

##### Parametry takie same, typ return inny - error

```
public interface Herbivore {
	public int eatPlants();
}
public interface Omnivore {
	public void eatPlants();
}
public class Bear implements Herbivore, Omnivore {
	public int eatPlants() { // DOES NOT COMPILE
		return 10;
	}
	public void eatPlants() { // DOES NOT COMPILE
	}
}
```

Również klasy abstraykcyjne nie moga implementować,a interfeacy nie moga rozszerzać interfaceów z konfliktujacymi metodami

```
public interface Herbivore {
	public int eatPlants();
}
public interface Omnivore {
	public void eatPlants();
}
public interface Supervore extends Herbivore, Omnivore {} // DOES NOT COMPILE
public abstract class AbstractBear implements Herbivore, Omnivore {}
// DOES NOT COMPILE
```

### Interface variables

1. Interface variables are assumed to be public, static, and final. Therefore, marking
a variable as private or protected will trigger a compiler error, as will marking any
variable as abstract.
2. The value of an interface variable must be set when it is declared since it is marked as
final.

```
public interface CanSwim {
	int MAXIMUM_DEPTH = 100;
	final static boolean UNDERWATER = true;
	public static final String TYPE = "Submersible";
}
//stanie się:
public interface CanSwim {
	public static final int MAXIMUM_DEPTH = 100;
	public static final boolean UNDERWATER = true;
	public static final String TYPE = "Submersible";
}
```
```
public interface CanDig {
	private int MAXIMUM_DEPTH = 100; // DOES NOT COMPILE - private modifier is used, and all interface variables are assumed to be public.
	protected abstract boolean UNDERWATER = false; // DOES NOT COMPILE - It is marked as protected, which conflicts with the assumed modifi er public, and it is marked as abstract, which confl icts with the assumed modifi er final.
	public static String TYPE; // DOES NOT COMPILE - you must provide a value to a static final member of the class when it is defined.
}
```

```
interface Bozo{          
	int type = 0; 
}

public class Type1Bozo implements Bozo{          
	public Type1Bozo(){             
		type = 1;//DOES NOT COMPILE - type jest public static final, nie można przypisać wartości
	}
	... 
}
```

#### Odwołanie się do zmiennej interfaceu w klasie implementujacej

```
public interface IInt {
	String iIntVariable = "some variable";
}

public class Sample implements IInt{
	public String getIIntVariable() {
		return iIntVariable;
	}
	public static void main(String[] args) {
		Sample sample = new Sample();
		System.out.println(sample.iIntVariable);
		System.out.println(sample.getIIntVariable());
		System.out.println(Sample.iIntVariable);
		System.out.println(IInt.iIntVariable);
	}
}
```

As a rule, fields defined in an interface are public, static, and final. The methods are public. Here, the interface IInt defines thevalue and thus any class that implements this interface gets this field. Therefore, it can be accessed using s.thevalue or just thevalue inside the class. Also, since it is static, it can also be accessed using IInt.thevalue or Sample.thevalue.

#### Dwa interfejsy ze zmienną o tej samej nazwie

```
interface I1{
	int VALUE = 1;
}
interface I2{
	int VALUE = 1;
}
public class TwoInterfacesSameVariable implements I1,I2{

	public static void main(String[] args) {
		TwoInterfacesSameVariable obj = new TwoInterfacesSameVariable();
		obj.method();
	}

	public void method() {
//		System.out.println(this.VALUE);//DOES NOT COMPILE
		System.out.println(((I1)this).VALUE);//OK
		System.out.println(((I2)this).VALUE);//OK
		System.out.println(I1.VALUE);//OK
		System.out.println(I2.VALUE);//OK

	}

}

```

### Default Interface Methods

```
public interface IsWarmBlooded {
	boolean hasScales();
	public default double getTemperature() {
		return 10.0;
	}
}
```

1. A default method may only be declared within an interface and not within a class or
abstract class.
2. A default method must be marked with the default keyword. If a method is marked as
default, it must provide a method body.
3. A default method is not assumed to be static, final, or abstract, as it may be used
or overridden by a class that implements the interface.
4. Like all methods in an interface, a default method is assumed to be public and will not
compile if marked as private or protected.


#### Error example

```
public interface Carnivore {
	public default void eatMeat(); // DOES NOT COMPILE
	public int getRequiredFoodAmount() { // DOES NOT COMPILE
		return 13;
	}
}
```

#### metody default nie moga byc static, final ani abstract

#### rules
1. When an interface extends another interface that contains a default method, it may
choose to ignore the default method, in which case the default implementation for the
method will be used. 
2. Alternatively, the interface may override the defi nition of the default
method using the standard rules for method overriding, such as not limiting the accessibility
of the method and using covariant returns. 
3. Finally, the interface may redeclare the method as abstract, requiring classes that implement the new interface to explicitly provide a method body. 
4. Analogous options apply for an abstract class that implements an interface

#### Example

```
public interface HasFins {
	public default int getNumberOfFins() {
		return 4;
	}

	public default double getLongestFinLength() {
		return 20.0;
	}

	public default boolean doFinsHaveScales() {
		return true;
	}
}
```

```
public interface SharkFamily extends HasFins {

	//override
	public default int getNumberOfFins() {
		return 8;
	}

	//zastapienie metody default metoda abstrakcyjna - kazda klasa musi implementowac
	public double getLongestFinLength();

	public boolean doFinsHaveScales() { // DOES NOT COMPILE - metoda nie jest default
		return false;
	}
}
```

#### Default Methods and Multiple Inheritance

##### Klasa nie nadpisuje metody zdefiniowanej w dwóch interfaceach - error
```
public interface Walk {
	public default int getSpeed() {
		return 5;
	}
}
public interface Run {
	public default int getSpeed() {
		return 10;
	}
}
public class Cat implements Walk, Run { // DOES NOT COMPILE
	public static void main(String[] args) {
		System.out.println(new Cat().getSpeed());
	}
}
```

##### Klasa nadpisuje metode zdefiniowana w dwóch interfaceach - ok 
```
public class Cat implements Walk, Run {
	public int getSpeed() {
		return 1;
	}
	public static void main(String[] args) {
		System.out.println(new Cat().getSpeed());
	}
}
```

### Static Interface Methods

A static method defined in an interface is not inherited in any classes that implement the interface.

1. Like all methods in an interface, a static method is assumed to be public and will not
compile if marked as private or protected.
2. To reference the static method, a reference to the name of the interface must be used.

```
public interface Hop {
	static int getJumpHeight() {
		return 8;
	}
}
```

```
public class Bunny implements Hop {
	public void printDetails() {
		System.out.println(getJumpHeight()); // DOES NOT COMPILE
		// metoda statyczna nie jest dziedziczona
	}
}
```

do metody statycznej mozna sie odwolac tylko przez nazwe interfaceu

```
public class Bunny implements Hop {
	public void printDetails() {
		System.out.println(Hop.getJumpHeight());
	}
}
```

czyli jezeli klasa implementuje dwa interfecy posiadajace metody o tej samej sygnaturze - wszystko jest ok.

## Understanding Polymorphism

Natura polimorfizmu - obiekt moze byc przedstawiony jako instancja klasy abstrakcyjnej lub interfaceu po którym dziedziczy.

```
public class Primate {
	public boolean hasHair() {
		return true;
	}
}
```
```
public interface HasTail {
	public boolean isTailStriped(); 
}

public class Lemur extends Primate implements HasTail {
	public boolean isTailStriped() {
		return false;
	}

	public int age = 10;
	public static void main(String[] args) {
		Lemur lemur = new Lemur();
		System.out.println(lemur.age);//10
		HasTail hasTail = lemur;// instancja interfaceu
		//System.out.println(hasTail.age); // DOES NOT COMPILE - brak dostepu z posiomu interfaceu
		System.out.println(hasTail.isTailStriped());//false
		Primate primate = lemur;
		System.out.println(primate.hasHair());//true
		//System.out.println(primate.isTailStriped()); // DOES NOT COMPILE - brak takiej metody w klasie Primate
	}
}
```

### Object vs. Reference

### Casting objects

```
Lemur lemur = new Lemur();
Primate primate = lemur;
//Lemur lemur2 = primate; // DOES NOT COMPILE - pamietac o castowaniu
Lemur lemur3 = (Lemur)primate;
System.out.println(lemur3.age);
```

1. Casting an object from a subclass to a superclass doesn’t require an explicit cast.
2. Casting an object from a superclass to a subclass requires an explicit cast.
3. The compiler will not allow casts to unrelated types.
4. Even when the code compiles without issue, an exception may be thrown at runtime if
the object being cast is not actually an instance of that class.

Uwaga na nr. 3

```
public class Bird {}
public class Fish {
	public static void main(String[] args) {
		Fish fish = new Fish();
		Bird bird = (Bird)fish; // DOES NOT COMPILE - nie zwiazane ze soba typy.
	}
}
```

```
public class Rodent { }
public class Capybara extends Rodent {
	public static void main(String[] args) {
		Rodent rodent = new Rodent();
		Capybara capybara = (Capybara)rodent; // Throws ClassCastException at runtime
	}
}
```
```
class Super {  }
class Sub extends Super {  }
public class TestClass{
   public static void main(String[] args){
      Super s1 = new Super(); 
      Sub s2 = new Sub();     
      s1 = s2;        
      s2 = (Sub)s1; //OK

      Super s3 = new Super(); 
      Sub s4 = new Sub();     
		//s4 = (Sub)s3;//Runtime - ClassCastException
   }
}
```

# ch06 Exceptions


## Exceptions hierarchy
https://airbrake.io/blog/java-exception-handling/the-java-exception-class-hierarchy

- Throwable
  - Error
  - Exception
    - RuntimeException
      - SecurityException  - np. odwołanie do File I/O z apletu
      - ClassCastException
      - NullPointerException
      - IndexOutOfBoundsException
 	      - ArrayIndexOutOfBoundsException
	      - StringIndexOutOfBoundsException
      - IllegalArgumentException  - If a parameter passed to a method is not valid.
      - IllegalStateException  - Signals that a method has been invoked at an illegal or inappropriate time

## throws clause
You can declare anything that is a Throwable or a subclass of Throwable, in the throws clause.
### CheckedExceptions
#### java.io.IOException extends java.lang.Exception
#### java.io.FileNotFoundException extends java.io.IOException

### RuntimeExceptions - (jvm exceptions?)
Rujntime exceptions extend RuntimeException.
They don’t have to be handled or declared.

They can be thrown by the programmer or by the JVM. 
Common runtime exceptions include the following:
- ArithmeticException Thrown by the JVM when code attempts to divide by zero
- ArrayIndexOutOfBoundsException Thrown by the JVM when code uses an illegal
- index to access an array
- ClassCastException Thrown by the JVM when an attempt is made to cast an exception to a subclass of which it is not an instance
- IllegalArgumentException Thrown by the programmer to indicate that a method has been passed an illegal or inappropriate argument
- NullPointerException Thrown by the JVM when there is a null reference where an object is required
- NumberFormatException Thrown by the programmer when an attempt is made to convert a string to a numeric type but the string doesn’t have an appropriate format

wyjatki runtime rzucane przez jvm:
- ArithmeticException
- ArrayIndexOutOfBoundsException
- ClassCastException 
- NullPointerException

pozostale - TODO - one rzucane tylko przez programiste?
IllegalArgumentException 
NumberFormatException 

#### ArrayStoreException extends RuntimeException
https://examples.javacodegeeks.com/java-basics/exceptions/java-lang-arraystoreexception-example/

```
Object[] s = new Integer[4];
s[0] = 4.4; 
```

#### ArithmeticException extends RuntimeException
```
int i =100/0;
```

#### ClassCastException extends RuntimeException
```
package oca.ch06.runtimeexceptions;
public class ClassCast {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		//a = (A)b;//DOES NOT COMPILE
		Object c = a;
		b = (B)c;
	}
}

class A{}
class B{}
```

#### ConcurrentModificationException extends RuntimeException TODO

#### EnumConstantNotPresentException extends RuntimeException TODO
#### IllegalArgumentException extends RuntimeException TODO
##### IllegalThreadStateException extends IllegalArgumentException TODO
##### NumberFormatException extends IllegalArgumentException TODO
#### IllegalMonitorStateException extends RuntimeException TODO
#### IllegalStateException extends RuntimeException TODO
#### IndexOutOfBoundsException extends RuntimeException TODO
##### ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException TODO
##### StringIndexOutOfBoundsException extends IndexOutOfBoundsException 
https://examples.javacodegeeks.com/java-basics/exceptions/java-lang-stringindexoutofboundsexception-how-to-solve-stringindexoutofboundsexception/

```
public class StringCharAtExample {
	public static void main(String[] args) {
		String str = "Java Code Geeks!";
		System.out.println("Length: " + str.length());
		
		//The following statement throws an exception, because
		//the request index is invalid.
		char ch = str.charAt(50);
	}
}
```
#### NegativeArraySizeException extends RuntimeException TODO
#### NullPointerException extends RuntimeException TODO
#### SecurityException extends RuntimeException
https://examples.javacodegeeks.com/java-basics/exceptions/java-lang-securityexception-how-to-solve-securityexception/

```
package java.util;

class Test {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
```
```
javac java/util/Test.java
java java.util.Test
Exception in thread "main" java.lang.SecurityException: Prohibited package name: java.util
...
```
#### TypeNotPresentException extends RuntimeException TODO
#### UnsupportedOperationException extends RuntimeException TODO

## wyjatki w dziedziczeniu

nie można dodawać wyjatków, jeżeli metoda nadpisuje metodę interfaceu.
można deklarowac mniej wyjatkow, niz jeste w interface lub superclass. Może wcale nie deklarować,
lub deklarować wyjatki, które sa podklasami wyjatkow rzucanych przez metode interfaceu.
Ta zasada tyczy sie tylko wyjatkow checked!!!
metoda moze deklarowac dodatkowe wyjatki (nie bedace zadeklarowanymi w interface), jezeli sa one unchecked.

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

## wypisanie wyjatku:
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

## Metoda nie rzuca wyjatku, w catch może być Exception, RuntimeException, ale nie wyjatek dziedziczacy po Exception(?)

### Jeżeli metoda nie rzuca wyjątku, to dodanie clausuli catch obsługujacej Exception jest ok, natomiast dodanie klausuli konkretnego CheckedException - bład kompilacji:

```
public static void amethod(){ } 

public static void main(String[] args){
	try{          
		amethod();          
		System.out.println("try ");       
	}catch(Exception e){          
		System.out.print("catch ");       
	}finally{          
		System.out.print("finally ");       
	}       
	System.out.print("out ");    

	//DOES NOT COMPILE 
	/*
	try{          
		amethod();          
		System.out.println("try ");       
	}catch(MyException e){//DOES NOT COMPILE 
		//unreacheable block for MyException
		//this exception is never thrown from the try statement body
		System.out.print("catch ");       
	}	
	*/
}    

```

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

## TODO - rzucanie wyjatkow dziedziczacych - co wypisane?

## Argumentem catch może być Throwable, lub wszystko co dziedziczy po Throwable.
## throws Throwable?
```
class MyException extends Exception {}  
public class TestClass{      
	public void myMethod() throws XXXX{          
		throw new MyException();      
	} 
}  
What can replace XXXX?
Wszystkie poniższe:
MyException, Exception, Throwable

```

```
class MyException extends Exception{

	public MyException(String string) {
		super(string);
	}
}

public class ThrowableTryCatch {
	
	public static void main(String[] args) {
		try {
			System.out.println("method()");
			method(); 
		} catch(Exception e) {
			System.out.println(e);
		}

		System.out.println();
		try {
			System.out.println("method(\"string\")");
			method("string"); 
		} catch(Exception e) {
			System.out.println("Exception");
			System.out.println(e);
		} catch (Throwable e) {
			System.out.println("Throwable");
			System.out.println(e);
		}
	}

	
	public static void method() throws MyException{
		throw new MyException("my exception");
	}

	public static void method(String s) throws Throwable{
		throw new MyException("my exception");
	}
}

```

## Można zrobić: throw null!

To jest ok:

```
public class ThrowNullInTryCatch {
	
   public static void main(String args[]){
	  try{
		 RuntimeException re = null;
		 throw re;
	  }
	  catch(Exception e){
		 System.out.println(e);
	  }
   }
}
//print: java.lang.NullPointerException
```

```
public class ThrowNullInMain {

	public static void main(String args[]) throws Exception{       
		Exception e = null;       
		throw e;    
	} 

}
//print: Exception in thread "main" java.lang.NullPointerException
	at oca.ch06.ThrowNullInMain.main(ThrowNullInMain.java:7)
```

To się nie kompiluje, bo nie ma klauzuli `throws` w opisie metody main

```
//DOES NOT COMPILE
//public class TestClass{    
//	public static void main(String args[]){       
//		Exception e = null;       
//		throw e;    
//	} 
//}
```

## System.out.print(exception)

```
package exceptions;
public class TestClass{
    public static void main(String[] args) {
        try{
            hello();
        }
        catch(MyException me){
            System.out.println(me);
        }
    }
    
    static void hello() throws MyException{
        int[] dear = new int[7];
        dear[0] = 747;
        foo();
    }
    
    static void foo() throws MyException{
        throw new MyException("Exception from foo");
    }
}

class MyException extends Exception {
    public MyException(String msg){
        super(msg);
    }
}

//Wynik: exceptions.MyException: Exception from foo
```
## Excepion in static block
Exception w bloku static

```
package oca.ch06;

class MyException003 extends Exception{}

public class ExceptionInStaticBlock {
	/* The blank final x may not have been initialized */
	/*
	static final String x;
	static {
		try {
			x = "bla";
		}catch(Exception e) {
		}
	}
	*/
	static String x;
	static {
		try {
			x = "bla";
			throw new MyException003();
		}catch(Exception e) {
			System.out.println(e.getClass());
		}
	}

	
	public static void main(String[] args) {
		System.out.println("run");
	
	}
}
```
Wynik:
```
class oca.ch06.MyException003
run
```

## Wyjatek rzucany w klausuli catch lub finally - czy musi być deklarowany w metodzie, lub obsługiwany przez catch?

```
//DOES NOT COMPILE
class MyException extends Exception {}
public class TestClass{
   public static void main(String[] args){
      TestClass tc = new TestClass();
      try{
         tc.m1();
      }
      catch (MyException e){
         tc.m1();//DOES NOT COMPILE!!!
      }
      finally{
         tc.m2();//Wyjatek runtime - ok
         //gdyby było tc.m1(); - również DOES NOT COMPILE!!!
      }
   }
   public void m1() throws MyException{
      throw new MyException();
   }
   public void m2() throws RuntimeException{
      throw new NullPointerException();
   }
}
```

## metoda może deklarować wyjatek i go nie rzucać:

```
class XException extends Throwable{}
public class MethodsWithThrows {
	public static void main(String[] args) { } 
	public static void m1() throws XException{ }//OK 
	public static void m2() throws Exception{ }//OK
}
```

## metoda rodzica rzuca wyjatek checked, metoda dziecka nie, czy wywołanie metody dzicka musi być w try{}catch(){}?

```
class OException extends Exception{}

class Parent{
	public void m() throws OException{}
}

class Child extends Parent{
	public void m(){}
}

public class ParentThrowsExceptionChildNot {
	
	public static void main(String[] args) {
		Child ch = new Child();

		ch.m();//OK bez try - catch!

		Parent p = ch;
		/* Tu musi być try - catch! */
		try {
			p.m();
		}catch(OException e) {
			
		}
	}

}
```

## main może deklarować dowolny checked exception, które nie musi być rzucane
```
class RException extends Exception{}
public class X{
	public static void main(String[] args) throws RException{//OK
	}
}
```

## zmienna zdefiniowana w try - niewidoczna w catch

```
public static void method() {
	try {
		int i = 1;
		throw new Exception();
	}catch(Exception e) {
			// System.out.println("i:"+i);//DOES NOT COMPILE 
			// i cannot be resolved to variable
	}
}
```

## zmienna zdefiniowana przed try, z nadana wartoscia w catch przed wyjatkiem - niewidoczna w catch 

```
public static void method1() {
	int i;
	try {
		i = 1;
		throw new Exception();
	}catch(Exception e) {
//			System.out.println("i:"+i);//a local variable may not have been initialized
	}
}
```

## return w finally przykrywa inne return z bloku try - catch

```
public static int method(boolean arg) {
	try {
		if(arg)
			throw new Exception();
		else
			return 0;
	}catch(Exception e) {
		return 1;
	}finally {
		return 2;//Always return 2 
	}
}
```

## metoda rodzica rzuca wyjatek, metoda dziecka nie

```
class OException extends Exception{}
class RException extends Exception{}

class Parent{
	public void m() throws OException{}
}

jclass Child extends Parent{
	public void m(){}
}

public class ParentThrowsExceptionChildNot {
	
	public static void main(String[] args) throws RException{
		Child ch = new Child();

		ch.m();//OK bez try - catch!

		Parent p = ch;
		/* Tu musi być try - catch! */
		try {
			p.m();
		}catch(OException e) {
			
		}
		
		((Child)p).m();//OK bez try - catch!

	}

}
```

## metoda nie musi rzucać wyjatku, nawet jeżeli deklaruje go w throws

```
class XException extends Throwable{}

public class MethodsWithThrows {
	
	public static void main(String[] args) { }
	
	public static void m1() throws XException{ }

	public static void m2() throws Exception{ }

	public static void m3() throws ArrayIndexOutOfBoundsException{ }
}
```

# ch07 - Testy

## break
A break statement with no label attempts to transfer control to the innermost enclosing: 
 - switch, 
 - while, 
 - do, 
 - for statement; 
this statement, which is called the break target, then immediately completes normally. If no switch, while, do, or for statement encloses the break statement, a compile-time error occurs.

A break statement with label Identifier attempts to transfer control to the enclosing labeled statement  that has the same Identifier as its label; this statement, which is called the break target, then immediately completes normally. In this case, the break target need not be a while, do, for, or switch statement.

A continue statement with no label attempts to transfer control to the innermost enclosing: 
 - while, 
 - do,
 - for statement; 
 this statement, which is called the continue target, then immediately ends the current iteration and begins a new one. If no while, do, or for statement encloses the continue statement, a compile-time error occurs.

A continue statement with label Identifier attempts to transfer control to the enclosing labelled statement that has the same Identifier as its label; that statement, which is called the continue target, then immediately ends the current iteration and begins a new one. The continue target must be a while, do, or for statement or a compile-time error occurs. If no labelled statement with Identifier as its label contains the continue statement, a compile-time error occurs.

## break i continue with label

Class.forName(String str)???

## break with label, finally
```
   public static void main(String args[]){
	   Labels l = new Labels(); 
	   l.breakLabel();
   }

	public void breakLabel() {

		int i = 0;
		loop :         // 1
		{
			System.out.println("Loop Lable line");
			try{
				for (  ;  true ;  i++ ){
					if( i >5) break loop;       // 2
				}
			}
			catch(Exception e){
				System.out.println("Exception in loop.");
			}
			finally{
				System.out.println("In Finally");      // 3
			}
		}
	}
}

//Wynik:
//Loop Lable line
//In Finally
```
A break without a label breaks the current loop (i.e. no iterations any more) and a break with a label tries to pass the control to the given label. 'Tries to' means that if the break is in a try block and the try block has a finally clause associated with it then it will be executed.


```
public void label001() {
	int c = 0;
	JACK: while (c < 8){
		JILL: System.out.println(c);
		//if (c > 3) break JILL; else c++;//DOES NOT COMPILE - The label JILL is missing
	}
}
```

	
# Testy
castowanie typów danych
wyjatki - Throwable, Exception, które Runtime
zastosowanie operatorów na typach danych
empty switch block?
members of Boolean class
members of String class
Integer.equals(Long)


## porównianie Integer i int - autoboxing, autounboxing

```
Integer i1 = 1;
Integer i2 = new Integer(1);
int i3 = 1;
Byte b1 = 1;
Long g1 = 1L;

i1 == i2;//false
i1 == i3;//true
i1 == b1;//DOES NOT COMPILE
i1.equals(i2);//true
i1.equals(g1);//false
i1.equals(b1);//false
```

i1 == i2 will return false because both are pointing to different object. 
i1 == i3 will return true because one operand is a primitive int and so the other will be unboxed and then the value will be compared. 
i1 == b1 will not even compile because type of i1 and b1 references are classes that are not in the same class hierarchy. 
So == knows at compile time itself that they can't point to the same object. 
i1.equals(i2) will return true because both are Integer objects and both have the value 1. 
i1.equals(b1) and i1.equals(g1) will return false because they are pointing to objects of different types.
Signature of equals method is : boolean equals(Object o); 
So it can take any object hence there will be no compilation error.
Further, The equals methods of all wrapper classes first check if the two object are of same class or not.
If not, they immediately return false.

```
int a = 1, b = 2, c = 3, k = 0;
Integer m = null;
k = new Integera(a) + new Integer(b);// ok, 3, autounboxing
k = new Integera(a) + b;// ok, 3, autounboxing
m = new Integera(a) + new Integer(b);// ok, 3, autounboxing

```

## Instances

```
interface Automobile { String describe(); }

class FourWheeler implements Automobile{
   String name;
   public String describe(){ return " 4 Wheeler " + name; }
}

class TwoWheeler extends FourWheeler{
    String name;
    public String describe(){ return " 2 Wheeler " + name; }
}

public static void main(String...args){
	FourWheeler fw = new ...
	fw.describe();//4 Wheeler..
	TwoWheeler tw = new ...
	tw.describe()://2 Wheeler

}
```


## Implicit narrowing
float f = ...
int i = ...
f = i;???

short s = ...
char c = s;???

```
short s = Short.MAX_VALUE; 
char c = s; 
System.out.println( c == Short.MAX_VALUE);
```
This will not compile because a short VARIABLE can NEVER be assigned to a char without explicit casting. A short CONSTANT can be assigned to a char only if the value fits into a char.

short s = 1; byte b = s; => this will also not compile because although value is small enough to be held by a byte but the Right Hand Side i.e. s is a variable and not a constant.
final short s = 1; byte b = s; => This is fine because s is a constant and the value fits into a byte.
final short s = 200; byte b = s; => This is invalid because although s is a constant but the value does not fit into a byte.

Implicit narrowing occurs only for byte, char, short, and int. 
Remember that it does not occur for long, float, or double. 
So, this will not compile: int i = 129L;
An implicit narrowing primitive conversion may be used if all of the following conditions are satisfied:  
1. The expression is a compile time constant expression of type byte, char, short, or int.  
2. The type of the variable is byte, short, or char.  
3. The value of the expression (which is known at compile time, because it is a constant expression) is representable in the type of the variable.  Note that implicit narrowing conversion does not apply to long or double. So, char ch = 30L; will fail even though 30 is representable in char.

```
public class ImplicitNarrowing {

	public static void main(String[] args) {
		byte b = 100;
		short s = 100;
		char c = 100;

//		byte b1 = s;//DOES NOT COMPILE - not 1. - not constant
		final short s0 = 100;//1. compile time constant of type short
		byte b1 = s0;//OK
//		byte b2 = 30L;//DOES NOT COMPILE - not 1. - not byte, char, short or int
	}

}

```



## System.exit

## StringBuilder
```
StringBuilder b1 = new StringBuilder("snorkler");
StringBuilder b2 = new StringBuilder("yoodler");
b1.replace(3,4,b2.substring(4)).append(b2.append(false));

snorkler
sno<b2.substring(4)>kler
b2.substring(4) -> ler
snolerkler
yoodlerfalse

snolerkleryoodlerfalse
```

## Date - TemporalAccessor
TimeZone
LocalDate - TemporalAccessor?

String to klasa finalna!
Podobnie:
StringBuilder, StringBuffer, i wszystkie klasy opakowujace (Integer, Byte ..)


## Members of wrapper class - TODO
Boolean
konstruktory:

```
Boolean(String s);// s.equalsIgnorecase("true") -> obiekt reprezentuje true. wpp. false 
Boolean(boolean)

Boolean.parseBoolean(String s);// returns primitive boolean
Boolean.valueOf(String s);// returns static constant Boolean.TRUE or Boolean.FALSE
Boolean.valueOf(boolean b);//
```

When you use the equality operator ( == ) with booleans, if exactly one of the operands is a Boolean wrapper, it is first unboxed into a boolean primitive and then the two are compared (JLS 15.21.2)

If both are Boolean wrappers, then their references are compared just like in the case of other objects. 
Thus, new Boolean("true") == new Boolean("true") is false, 
but new Boolean("true") == Boolean.parseBoolean("true") is true.

## Switch

Here are the rules for a switch statement:
1. Only String, byte, char, short, int, (and their wrapper classes Byte, Character, Short, and Integer), and enums can be used as types of a switch variable. (String is allowed only since Java 7). 
2. The case constants must be assignable to the switch variable. For example, if your switch variable is of class String, your case labels must use Strings as well.
3. The switch variable must be big enough to hold all the case constants. For example, if the switch variable is of type char, then none of the case constants can be greater than 65535 because a char's range is from 0 to 65535.
Similarly, the following will not compile because 300 cannot be assigned to 'by', which can only hold values from -128 to 127. 

```
byte by = 10; 
switch(by){     
	case 200 :  //some code;     
	case 300 :  //some code; 
}  
```

Swich type char, case type byte - not working:
This will not work in all cases because a byte may have negative values which cannot be assigned to a char. 
For example, 

```
char ch = -1; 
```
does not compile. Therefore, the following does not compile either:         

```
char ch = 'x';        
switch(ch){           
	case -1 : System.out.println("-1"); break; // This will not compile : "possible loss of precision"           
	default: System.out.println("default");            }
}
```
4.  All case labels should be COMPILE TIME CONSTANTS. 
5. No two of the case constant expressions associated with a switch statement may have the same value.
6. At most one default label may be associated with the same switch statement.



## Zmienne w interface
```
interface X{
	int i = 10;
}
//odpowiada:
interface X{
	public static final int i = 10;
}
```

## Cast
Z mniejszego na większy typ można przepisywać bez castowania.
Odwrotnie nie:

```
int i = 10; 
byte b = 20; 
b = i;//will not compile because byte is smaller than int 
b = (byte) i; //OK
```

Further, if you have a final variable and its value fits into a smaller type, then you can assign it without a cast because compiler already knows its value and realizes that it can fit into the smaller type. This is called implicit narrowing and is allowed between ** byte, int, char, and, short ** but not for ** long, float, and double **.

```
public class Casting001 {
	
	final static int k = 700;
	final static int h = 700_000_000;
	final static int l = 32_767;
	
	public static void main(String[] args) {
		int i = 90_000_000;
//		short o = i;//DOES NOT COMPILE
		short s = (short)i;//19072
		short ks = k;//700
//		short hs = h; //DOES NOT COMPILE - h jest poza zakresem short
		short ls = l;//32767 - ok, l jest w zakresie short i final
	}
}
```

```
final float f = 10.0;
//will not compile because 10.0 is a double even though the value 10.0 fits into a float
```

## TODO
String a = "" + 3 + true;//itp.

## String

```
public class String002 {
	String s = this.toString();// ok
//	String s1 = 'a'; // DOES NOT COMPILE
//	String s2 = 'abcd';// DOES NOT COMPILE

	public static void stringFromChar() {
		char charArray[] = new char[] {'g','o','o','d'};
//		String s = 'a';// DOES NOT COMPILE
		String s = null;
		s = s + 'a';// OK s = "nulla"!!!
		String str = null;
		for(char ch : charArray) {
			str = str + ch;// OK
		}
		// str = "nullgood"!!!
	}

}
```

```
String hello = "hello";
String hel_lo = "hel"+"lo";//obliczane w czasie kompilacji, traktowane jak "hello".
String lo = "lo";
String hel_plus_lo = "hel"+lo;//obliczane w czasie runtime - inne niż "hello"
if(hello == hel_lo) {
	System.out.println("==");//ten wynik
}else {
	System.out.println("!=");
}

if(hello == hel_plus_lo) {
	System.out.println("==");
}else {
	System.out.println("!=");//ten wynik
}
```

### intern()

concat()?

String str1 = "one";
String str2 = "two";
str1.equals(str1=str2);//true czy false?

## Math.round()

## Polimorfizm, nadpisywanie
```
public class TestClass{    
	public static void main(String args[ ] ){       
		A o1 = new C( );       
		B o2 = (B) o1;       
		System.out.println(o1.m1( ) );       
		System.out.println(o2.i );    
	} 
}
class A{ int i = 10; int ml(){return i;}}
class B extends A{ int i = 20; int ml(){return i;}}
class C extends B{ int i = 30; int ml(){return i;}}
```

## ArrayList
jest taka metoda jak subList???

## IOException
## switch bez default

## kolejność inicjalizacji
1. zmienne i inicjalizatory statyczne - w kolejności występowania
2. zmienne i inicjalizatory instancji - w kolejności występowania
3. konstruktor

## deklaracja i inicjalizowanie

```
int a = b = c = 100;//DOES NOT COMPILE
```
```
int b, c;
int a = b = c = 100;//OK
```

## Metody i konstruktory klas wrapperów
## Metody i konstruktory klasy Object
toString()
## Metody i konstruktory klasy String 
### substring
### indexOf
## Metody i konstruktory klasy StringBuilder 
## Metody Math
### Math.round()
Math.round(-0.5) = 0.0
Observe that rounding is a standard mathematical procedure where the number that lies exactly between two numbers always rounds up to the higher one. So .5 rounds to 1 and -.5 rounds to 0.

## Object.getClass()
Metoda polimorficzna - wywołuje metodę obiektu, na który wskazuje referencja.

```
class A { }
class AA extends A { } 
public class TestClass {
    public static void main(String[] args) throws Exception {
        A a = new A();
        AA aa = new AA();
        a = aa;
        System.out.println("a = "+a.getClass());//a = class AA
        System.out.println("aa = "+aa.getClass());//aa = class AA
    }
}
```
radix = 2
otuput = 14
radix = 7
output = 49


5 + (5 + 7 + 6)


## TODO - kolejność inicjalizacji w przypadku dziedziczenia
Najpierw zmienne i konstruktor klasy rodzica

## Test 2 - pytania 1 - 8 - TODO

## parametr metody final - czy metoda może zmienić wartość zmiennej instancji w tym objekcie?
odp. - Tak

```
package oca.tests;

public class FinalMethodParam {
	
	int value = 9;
	
	public static void main(String[] args) {
		FinalMethodParam object = new FinalMethodParam();
		FinalMethodParam object2 = new FinalMethodParam();
		System.out.println(object.value);//println: 9
		setValue(object,object2);
		System.out.println(object.value);//println: 100
	}
	
	public static void setValue(final FinalMethodParam object,FinalMethodParam object2){
		object.value = 100;
//		object = new FinalMethodParam();//DOES NOT COMPILE
		object2 = new FinalMethodParam();//OK
	}

}
```
Wynik:
```
9 
100
```

## TODO - modyfikatory dostępu dla zmiennych instancji, oraz statycznych
## TODO - zmienna statyczna x; this.x?
## 
char c = ...
int i = c;//można ???

int i = 4/5;//można ???

## Blok kodu {} - mogę wrzucić w ciele metody

## czy w metodzie interfaceu można użyć super?
```
interface Account{   
	public default String getId(){      
		return "0000";   
	} 
}  

interface PremiumAccount extends Account{   
	public String getId(); 
	//czy może być:
	//public default String getId(){ super.getId(); }
} 
```

## todo
switch - typy
wyjatki Runtime i nie Runtime

```
public class ChangeTest {

    private int myValue = 0;
    
    public void showOne(int myValue){
        myValue = myValue;
    }
    
    public void showTwo(int myValue){
        this.myValue = myValue;
    }    
    public static void main(String[] args) {
        ChangeTest ct = new ChangeTest();
        ct.showOne(100);
        System.out.println(ct.myValue);
        ct.showTwo(200);
        System.out.println(ct.myValue);
    }
}
```

switch - czy może istnieć tylko default

```
switch (1) { default : break; }
```

czy catch może być po finally?

StringBuilder - operator `+`? raczej nie.

inicjalizacja tablicy - jako zmiennej instancji, jako zmiennej lokalnej

## Integer.parseInt("12.3"), zmienna inicjalizowana w try ma wartość w catch

```
Float f = null; 
try{    
	f = Float.valueOf("12.3");    
	String s = f.toString();    
	int i = Integer.parseInt(s);    
	System.out.println(""+i); 
} catch(Exception e){    
	System.out.println("trouble : "+f); 
}
```
Wynik:

```
trouble : 12.3
```


odwołanie do zmiennej static - zmienna lokalna nadpisuje?
```
class ScopeTest{    
	static int x = 5;    
	public static void main(String[] args){       
	int x  = ( x=3 ) * 4;  // 1       
	System.out.println(x);    
	} 
}
```

LocalDateTime.parse

czy może być dostęp default dla klasy abstract?
```
abstract class B implements I1{    int getValue(int i) { return 0; } }

Błędne wywołania metod

```
 System.out.println("12345".charAt(6));
 Integer.parseInt("bla");
```

czy zmienne ustawione w try przed wyjatkiem zachowuja swoja wartosc?

```
public class CrazyMath {     public static void main(String[] args) {         int x = 10, y = 20;         int dx, dy;         try{             dx = x % 5;             dy =  y/dx;         }catch(ArithmeticException ae){             System.out.println("Caught AE");             dx = 2;             dy = y/dx;         }         x = x/dx;         y = y/dy;         System.out.println(dx+" "+dy);         System.out.println(x+" "+y);              } }
```

## break, w if  - TODO

```
//if (true) { break ; } (When not inside a switch block or a loop)

???
    label: if(true){          System.out.println("break label");          break label; //this is valid       }
```

## non public class in different file name, main()

```
//OK!
//In file B.java 
import java.io.*; 
class A{   
	public static void main() throws IOException{ } 
}
```

# TODO
1. kolejność inicjalizacji przy dziedziczeniu
- również bez konstruktorów
2. lambda
3. Date
4. ArrayList, String, StringBuilder, Number, Integer (etc.) - metody
5. labele
6. metody array, Arrays
7. switch - short w switch, int w case.

# URL
https://www.vojtechruzicka.com/bit-manipulation-java-bitwise-bit-shift-operations/

