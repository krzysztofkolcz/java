#ch01
## enum

```
public enum Season {
WINTER, SPRING, SUMMER, FALL
}

Season s = Season.SUMMER;
System.out.println(Season.SUMMER); // SUMMER
System.out.println(s == Season.SUMMER); // true


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
```

Enum to nie int:

```
switch (summer) {
	case 0: // DOES NOT COMPILE
		System.out.println("Get out the sled!");
		break;
}
```