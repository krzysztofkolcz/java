Typy primitive:
	Mniejszy typ można przypisać do większego. Np. double <- int, double <- long 
	Do char nie można bez castowania przypisać żadnego typu (oprócz implicite narrowing)
	Można porówynywać wszystkie typy liczbowe primitive np. byte a = ...; double b = ...; a == b;
	implicite narrowing - do zmiennych typu byte, char, shor można przypisać finalne zmienne typu byte, char, short, int mieszczace się w zakresie.
	Numeric promotion rules
	
Wrapper objects:
	Konstruktory - nie ma bezargumentowego. Parametry - String lub primitive np.: Integer(int value)
	Przypisanie tylko do primitiva odpowiadajacego typu, np. 
		double d =...; Double do = d;//OK; 
		int i = ...; //Double do = i;//DOES NOT COMPILE
	Można porównywać typy wrapper z wszystkimi typami primitive

Boolean:
	Boolean.TRUE - objekt typu Boolean. (Chyba zawsze wskazuje na ten sam niemutowalny obiekt)

Double:
	d = Double.parseDouble("12.3");//OK
	d = Double.parseDouble("12.3f");//OK
	d = Double.parseDouble("12.3d");//OK
	
float:
	Do float nie można przypisać double, ale jeżeli robię print - nie wypisuje 'f' na końcu
	float ma chyba 9 miejsc na podstawę , 22 na mantysę i jedno na znak?

Float:
	Float.NaN
	f = Float.parseFloat("12.3");//OK
	f = Float.parseFloat("12.3f");//OK
	f = Float.parseFloat("12.3d");//OK
	
Integer:
	objekty sa niemutowalne. Operator ++ tworzy nowy objekt Integer zwiekszony o 1 i przypisuje do starego.
	
long:
	long l = 1;//OK
	l = 2147483647;//OK
	//l = 2147483648;//DOES NOT COMPILE - literal 2147483648  (Integer.MAX_VALUE + 1) of type int is out of range
	//l = Long.parseLong("12L");//NumberFormatException
	
Operatory:
	++ - dla wszystkich typów primitive i wrapper, oprócz boolean i Boolean 

Array:
	Inicjalizacja w klasie - null, w metodzie - niezainicjalizowana
	public static String[] array2 = new String[2]; - wartości sa domyślnie nullami.
		Niewypełnione tablice obiektów - uzupełniane nullami 
		Niewypełnione tablice liczbowe - uzupełniane 0 
		Niewypełnione tablice boolean - uzupełniane false
	System.out.println(array2);//[Ljava.lang.String;@7852e922
	String[] x = {};//OK
	//Object o = {};//Type mismatch - cannot convert from Object[] to Object
	Object o = x;//OK
	
	Pierwszy wymiar wielowymiarowej tablicy musi być zainicjalizowany
	metody:
		binarySearch()
		sort()
	
Zamienna finalna:
	musi zostać zainicjalizowana w miejscu deklaracji lub w bloku - nie otrzymuje wartości domyślnej! 
	(field may not have been initialized)
	
	
Operatory:
	Compound assignment - typy sa tu ok, np.: int i = 1; long o = 1; 
		//i = i + o;//DOES NOT; 
		i+=o;//OK
	ternary - tylko wynikowa strona operatora ternarnego jest wyliczana
	&&, || - short circuit operators
	equality - 
		primitive i primitive (with numeric promotion), 
		boolean i boolean
		objects - dotyczy referencji
	
	
switch:
	jeżeli nie ma odpowiadajacego case - leci do default, jezeli nie ma case i nie ma default - kończy blok (nic się nie wykona).
	jeżeli trafi na case, lub default bez break - leci do kolejnej linii
	tylko byte,short,char,int,String,enum (i odpowiadajace typy wrapper)
	case:
		literal,
		enum constant,
		final constant variable.
		
while
	//while(false)//DOES NOT COMPILE - nieosiagalny kod
	
for
	//for(;false;)//DOES NOT COMPILE - nieosiagalny kod
	jeżeli warunek dla pierwszego wykonania jest false, kod w trzeciej sekcji ani w bloku nie wykona się
	
if
	if(false)//OK - przydatne przy optymalizacji więc zostawili - if(DEBUG)
	
String
	niemutowalny
	klasa finalna
	concatenation - od lewej do prawej, jeżeli obydwa argumenty to numery - dodawanie, jeżeli jeden to string - konkatenacja
	String s = null;//!
	s += 'a';//OK! print: nulla
	różnica pomiędzy obiektami tworzonymi runtime, a tymi ze string pool.
	Uwaga "a"+"b" - jest również compile time constant
	metody:
		lenght()
		charAt()
		concat()
		indexOf()
		substring(int start), substring(int start, int end)
		toLowerCase(), toUpperCase()
		equals()
		equalsIgnoreCase()
		startsWith(), endsWith()
		contains()
		replace()
		
StringBuilder
	mutowalny
	klasa finalna
	konstruktory
		StringBuilder(), StringBuilder(String arg), StringBuilder(int size)
	przypisanie String do StringBuilder nie zadziała
	//StringBulder s = "test";//NOT!
	metody:
		append()
		charAt()
		delete()
		deleteCharAt()
		indexOf()
		insert()
		length()
		substring()
		reverse()
		
ArrayList
	metody:
		add()
		clear()
		equals()
		isEmpty()
		remove()
		set()
		size()
	auboboxing:
		List<Integer> heights = new ArrayList<>();
		heights.add(null);
		Integer hobj = heights.get(0);
		System.out.println(hobj);//OK - print: null
		//int h = heights.get(0); // NullPointerException - wywołanie metody na wartości null
		
	z listy na tablice:
		Object[] array = list.toArray();
		String[] array = list.toArray(new String[0]);
	
	z tablicy na listę (sa połaczone):
		String[] array = { "hawk", "robin" }; // [hawk, robin]
		List<String> list = Arrays.asList(array); // returns fixed size list
		
LocalDate, LocalTime, LocalDateTime
	Nie ma konstruktora - metoda of
		public static LocalDate of(int year, int month, int dayOfMonth)
		public static LocalDate of(int year, Month month, int dayOfMonth)
		itp.:
	jest niemutowalna
	metody:
		plusDays
		plusWeeks
		plusMonths
		plusYears
		plusMinutes
		...
	Uwaga, na typ obiektu, czy zawiera odpowiedni komponent (czasu lub daty)
	
Period
	
	
DateTimeFormatter 
	DateTimeFormatter formater = DateTimeFormatter.ISO_LOCAL_DATE
	date.format(formatter) jest równoważne formatter.format(date):
	DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
	DateTimeFormatter.ofLocalizedDate(...); .ofLocalizedTime(...); .ofLocalizedDateTime(...)
	FormatStyle.SHORT; FormatStyle.MEDIUM
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
	parse(String,DateTimeFormatter); LocalDate date = LocalDate.parse("01 02 2015", f);
	
	
varargs 
	musi być ostatnim parametrem
	uwaga na override i arrays

	
		
		
Interface
	wszystkie metody public
	wszystkie zmienne public static final
	
Interface - static method:
	nie dziedziczone
	odwołanie przez I.m() 
	(jeżeli C implements I, to nie można się odwołać przez C.m(), ani przez c.m(), gdze C c = new C();)
	można nadpiwywać w podklasie metoda niestatyczna
	
		
	
Klasa - static method:
	można wywołać na objekcie, który wskazuje na null:
		Statics2 s2 = null;
		s2.m();



Interface - default method:
	odwołanie do metody rodzica
	I extends I1,I2, m(){	I1.super.m(); I2.super.m(); 	}