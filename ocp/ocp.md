#ch01
## enum

```
public enum Season {
WINTER, SPRING, SUMMER, FALL
}

Season s = Season.SUMMER;
System.out.println(Season.SUMMER); // SUMMER
System.out.println(s == Season.SUMMER); // true - enum are like static final constants


for(Season season: Season.values()) {
	System.out.println(season.name() + " " + season.ordinal());
}

//print:
//WINTER 0
//SPRING 1
//SUMMER 2
//FALL 3
```

Enum to nie int:

```
//if ( Season.SUMMER == 2) {} // DOES NOT COMPILE
```

Enum ze Stringa:

```
Season s1 = Season.valueOf("SUMMER"); // SUMMER
Season s2 = Season.valueOf("summer"); // exception
//Exception in thread "main" java.lang.IllegalArgumentException: No enum constant
//enums.Season.summer
```

Nie można dziedziczyć po enum:

```
//public enum ExtendedSeason extends Season { } // DOES NOT COMPILE
```

### Enum w switch

```
Season summer = Season.SUMMER;
switch (summer) {
	case WINTER:
		System.out.println("Get out the sled!");
		break;
	case SUMMER:
		System.out.println("Time for the pool!");
		break;
	default:
		System.out.println("Is it summer yet?");
}

// switch (summer) {
// case Season.WINTER: //DOES NOT COMPILE

// enum to nie int:
// switch (summer) {
// case 0: //DOES NOT COMPILE
```

### Enum constructor, methods 

```
public enum Season {
	WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");

	private String expectedVisitors;
	private Season(String expectedVisitors) {
		this.expectedVisitors = expectedVisitors;
	}

	public void printExpectedVisitors() {
		System.out.println(expectedVisitors);
	}
}

Season.SUMMER.printExpectedVisitors();
```

The first time that we ask for any of the enum values, Java constructs all of the enum
values. After that, Java just returns the already‐constructed enum values.

```
public enum OnlyOne {
	ONCE (true);
	private OnlyOne(boolean b) {
		System. out .println("constructing");
	}
	public static void main(String[] args) {
		OnlyOne firstCall = OnlyOne. ONCE ; // prints constructing
		OnlyOne secondCall = OnlyOne. ONCE ; // doesn't print anything
	} 
}
```

```
public enum Season {
	WINTER {
		public void printHours() { System.out.println("9am-3pm"); }
	}, 
	SPRING {
		public void printHours() { System.out.println("9am-5pm"); }
	}, 
	SUMMER {
		public void printHours() { System.out.println("9am-7pm"); }
	}, 
	FALL {
		public void printHours() { System.out.println("9am-5pm"); }
	};
	public abstract void printHours();
}
```

```
public enum Season3 {
	WINTER {
		public void printHours() { System.out.println("short hours"); }
	}, 
	SUMMER {
		public void printHours() { System.out.println("long hours"); }
	}, 
	SPRING, 
	FALL;
	public void printHours() { System.out.println("default hours"); }
}
```

## Nested classes

member inner class
local inner class
anonymous inner class
static nested class

### Member inner class

- Access modifiers: public, private, or protected or use default access
- Can extend any class and implement interfaces
- Can be abstract 
- Can be final
- Cannot declare static fields or methods
- Can access members of the outer class including private members
- TODO - Cannot access local variables (in functions?) of the outer class 

```
public class Outer {
	private String greeting = "Hi";
	protected class Inner {
		System.out.println(greeting);//dostęp do zmiennej private klasy Outer
	}
	public void callInner() {
		Inner inner = new Inner();
		inner.go();
	}
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.callInner();
	} 
}
```	
```	
public static void main(String[] args) {
	Outer outer = new Outer();
	Inner inner = outer.new Inner(); // create the inner class
	inner.go();
}
```	

#### Access to variables

```
public class A {
	private int x = 10;
	class B {
		private int x = 20;
		class C {
			private int x = 30;
			public void allTheX() {
				System.out.println(x); // 30
				System.out.println(this.x); // 30
				System.out.println(B.this.x); // 20
				System.out.println(A.this.x); // 10
			} 
		} 
	}
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		A.B.C c = b.new C();
		c.allTheX();
	}
}
```

#### inner interfaces

```
public class CaseOfThePrivateInterface {
	private interface Secret {
		public void shh();
	}
	class DontTell implements Secret {
		public void shh() { }
	} 
}
```

### Local Inner Classes

A local inner class is a nested class defined within a method.

- Access modifiers: none
- Can extend any class and any number of interfaces
- Can be abstract 
- Can be final
- Can access all instance members of enclosing class
- Can access local variables of enclosing class: Yes—if final or effectively final
- They cannot be declared static and cannot declare static fields or methods.

```
public class Outer {
	private int length = 5;
	public void calculate() {
		final int width = 20;
		class Inner {
			public void multiply() {
				System.out.println(length * width);
			}
		}
		Inner inner = new Inner();
		inner.multiply();
	}
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.calculate();
	}
}
```

### Anonymous Inner Classes
#### Anonymous Inner Classes extends Inner Abstract Class

```
public class AnonInner {

	abstract class SaleTodayOnly {
		abstract int dollarsOff();
	}

	public int admission(int basePrice) {
		SaleTodayOnly sale = new SaleTodayOnly() {
			int dollarsOff() { return 3; }
		};
		return basePrice - sale.dollarsOff();
	} 
}
```

#### Anonymous Inner Classes extends Inner Interface

- Access modifiers: none
- Can extend any class and any number of interfaces: no - must have exactly one superclass or one interface
- Can be abstract: N/A
- Can be final: N/A
- Can access instance members of enclosing class: Yes
- Can access local variables of enclosing class: Yes—if final or effectively final
- Can declare static methods: No

```
public class AnonInner {
	interface SaleTodayOnly {
		int dollarsOff();
	}
	public int admission(int basePrice) {
		SaleTodayOnly sale = new SaleTodayOnly() {
			public int dollarsOff() { return 3; }
		};
		return basePrice - sale.dollarsOff();
	} 
}
```

### Static Nested Classes

- Access modifiers: public, protected, private, or default access
- Can extend any class and any number of interfaces: Yes
- Can be abstract: Yes
- Can be final: Yes
- Can access instance members of enclosing class: No (not directly; requires an instance of the enclosing class)
- Can access local variables of enclosing class: No
- Can declare static methods: Yes

Like regular class, 
- The nesting creates a namespace because the enclosing class name must be used to refer to it.
- It can be made private or use one of the other access modifiers to encapsulate it.
- The enclosing class can refer to the fields and methods of the static nested class.

```
package nested;

public class Enclosing {
	static class Nested {
		private int price = 6;
	}
	public static void main(String[] args) {
		//no need to instantiate Enclosing
		Nested nested = new Nested();
		//access to private filed
		System.out.println(nested.price);
	} 
}
```

#### Importing Static Nested Classes

```
package bird;
public class Toucan {
	public static class Beak {}
}

package watcher;
import bird.Toucan.Beak; // regular import ok

public class BirdWatcher {
	Beak beak;
}


//alternatively
import static bird.Toucan.Beak;
```


### Effectively final
If the code could still compile with the keyword final inserted before the local variable, the variable is effectively final.

### Summary
