# Agenda
- wstęp i cel prezentacji
- przykłady złego wrażenia
- co moim zdaniem warto, aby rekruter wiedział
- podstawowe pojęcia it
- 'ekosystemy' technologii
- systemy operacyjne
- języki programowania
- bazy danych
- kompatybilność technologii
- bardziej szczegółowo o javie i związanych z nią technologiach (może przykład aplikacji na żywo)

# Wstęp
Zostałem poproszony o zrobienie prezentacji
Co powinien wiedzieć rekruter, jaka wiedza zaplusuje na kontakcie z kandydatem i sprawi dobrze wrażnie
(albo też nie sprawi złego wrażenia).
Oraz o zrobienie ogólnego wprowadzenia do IT oraz bardziej szczegółowo do technologii związanych z javą.

Myślę, że osoby techniczne zdają sobie sprawę, że rekruterzy nie do końca muszą się orientować we wszystkich
pojęciach technicznych.
Jednak oczywiście pewna porcja podstawowej wiedzy (oraz orientowania się w temacie) sprawi lepsze wrażenie,

# Przykłady złego wrażenia
Kilka przykładów, które pamiętam z ostatniego czasu, które zrobiły na mnie złe wrażeni:
- Pani nie wiedziała, czy szukają osoby ze znajomością springa czy swinga.
  Ja np. w pierwszym mam spore doświadczenie, w drugim prawie zerowe.
  Czyli mylenie nazw
- Pan nie do końca wiedział, czy szukają osoby do spring/hibernate, czy jee - wrzucał technologie do jednego worka.
  Choć technologie czerpią i inspirują się na wzajem, to raczej bym ich nie utożsamiał
  Czyli mylenie spokrewnionych technologii, wrzucanie ich do jednego worka
- używanie wyrażeń w złym kontekscie
  np. niezbyt dobrze brzmi powiedzenie, że aplikacja javova działa na bazie Microsoftu ;)
- Przedstawianie mi ofert nie związanych z moim profilem, lub takich, na które mam zbyt małe doświadczenie.

# Co warto wiedzieć
Co powinnyśmy wiedzieć i jaka wiedza zaplusuje w kontakcie z kandydatem
- fajnie, aby rekruter miał ogólne pojęcie czy wyobrażenie - do czego służy dana technologia.
- co kryje się za konkretną nazwą.
- fajnie znać słownictwo/żargon, np. czym jest
    serwer
    front-end
    back-end
    baza danych
    GUI

- fajnie znać, jaki jest ekosystem danej technologii.
    Np. z czym się może wiązać swing? Z php? Z javą? Z Microsoftem?
    Dlaczego do rozwoju pluginów wordpressa nie powinniśmy zatrudniać javowca?

# wersje robią różnice
Warto wiedzieć, że języki programowania, czy też aplikacje mają swoje wersje.
Oraz to, że dla programisty wersja języka lub programu, na którym pracuje może mieć duże znaczenie.

    Często bardzo ważne dla programistów jest również wersja danego języka.
    Obecnie dla javowców znaczenie może mieć wersja - java 6  czy java 8, a niedlugo już java 9.
    Warto też zwrócić uwagę na zmiany w standardzie wersjonowania -
    najpierw 1.5 -> 5
    teraz wersja od roku i miesiąca
    10 -> 18.3
    Myślę, że większość programistów wolałaby pracować w najnowszej wersji softwareu.
    Wiąże się to z rozwojem, z tym, że kolejne wersje często ułatwiają pracę,
    zapewniają konstrukcje języka, dzięki którym praca jest łatwiejsza/szybsza.
    W java 8 jest kilka nowych konstrukcji w porównaniu do java 7, co wiąże się z tym, że programy można pisać w supełnie inny sposób.
    Jest to więc bardzo istotne.


# Ogólne pojęcia IT - USUNĄĆ
- hardware
- języki programowania
    do tworzenia programów, aplikacji
    różnią się składnią
- systemy operacyjne - windows,linux,macos,ios
    - środowisko działania aplikacji
    - umożliwia działanie wielu aplikacji (zarządza czasem procesora, tak, aby każda aplikacja dostawała swój czas)
    - interface użytkownika
    - system plików
- frameworki
    zestawy bibliotek,
    definiują szkielet aplikacji,
    ułatwiają i przyspieszają pracę.
- serwery
    programy/aplikacja zapewniające uslugi na rzecz innych.
    potocznie - komputery, na których działają aplikacje serwerowe.
    Model klient-serwer - np. serwery facebooka
    Aplikacje biznesowe
    Wiele rodzajów - komputer w serwerowni, serwer aplikacji, serwer bazy danych, serwer plików.
- bazy danych -
    zbiory danych,
    również skrótowo - systemy zarządzania bazami danych czyli aplikacje zapewniające obsługe danych.
    Dane przechowywane w odpowiednim formacie, posiadają określone reguły.
- IDE
    edytory tekstu - narzędzia do pracy programisty.
- standardy
    np. JPA - a implementacja - hibernate, eclipselink

TODO - jak działa aplikacja desktopowa (obraz)
TODO - jak działa aplikacja klient-serwer (np. facebook) (obraz)

# Ekosystemy technologii
Z każdym jezykiem wiąże się ekosystem - myślę, że warto wiedzieć, co się z czym wiąże
Z każdym pojęciem wiążą się inne kompatybilne technologie

Można uruchomić aplikację javową na serwerze Microsoftu.
Nic nie stoi na przeszkodzie, żeby aplikacje javowe uruchamiać na serwerach Microsoftu.
Przy czym jako serwer rozumiem tutaj maszynę, na której stoi system operacyjny Windows Serwer.
Natomiast, aby aplikacja javova zadziałała, potrzebny jest odpowiedni serwer aplikacji,
czyli np. tomcat, który rozumie aplikacje napisaną w javie.
Tomcata możemy też połączyć z serwerem IIS microsoftu, choć wymaga to instalacji pluginów

Również aplikacje w .NET można uruchamiać na linuxie, jednak trzeba kombinować, instalować dodatkowy soft,
który będzie taką przejściówką, co wiąże się z gorszą szybkością działania i możliwymi problemami, zawieszaniem sie
Troche tak jak z przejściówką do gniazdka elektrycznego w USA



Systemy operacyjne:
Cóż warto o nich wiedzieć - stanowią podstawę do pracy użytkownika z komputerem.
Czyli zapewniają połączenie pomiędzy tym co można kopnąć, a tym czego nie można.
Ogarniają procesor, wejście/wyjście - czyli myszkę, monitor, klawiaturę itp.
Zapewniają środowisko do działania wyspecjalizowanych aplikacji.

No i warto wiedzieć, że
Na androida będziemy szukać programistów ze znajomością javy
Na ios będziemy szukać programistów objective-c albo swift

Linux/Unix
    Króluje jako system operacyjny serwerów.
Windows, Windows Phone
    Jako os dla komputerów domowych
    Również jako system operacyjny serwerów
MacOs
    Apple
    Nie słyszałem, czy ktoś stawia to na serwerach, być może ;)
iOS
    iphone
Android
    smartfony - mniejsza moc obliczeniowa, bateria itp.

Języki programowania:

java
    wirtualna maszyna, dzięki temu przenośny po skompilowaniu
    gry, apikacje desktopowe, aplikacje biznesowe, aplikacje na adroida
    frameworki - spring, jee, hibernate - do baz danych
    maven, gradle - do budowania
    serwery aplikacji - apache tomcat, weblogic,

    Java SE includes has the following APIs and many more
        applet
        awt
        rmi
        jdbc
        swing
        collections
        xml binding
        JavaFX (Merged to Java SE 8)
        Java 8 Streaming
    Java EE includes the following APIs and many more
        servlet
        websocket
        java faces
        dependency injection
        ejb
        persistence
        transaction
        jms
        batch api
    Java ME includes the following APIs and many more
        Wireless Messaging
        Java ME Web Services
        Security and Trust Services API
        Location
        Mobile XML API


Czyli java se - podstawowa część języka, dzięki której możemy tworzyć podstawowe programy



javscript - język skryptowy interpretowany przez przeglądarki internetowe
            działa na stronach internetowych
            biblioteki/frameworki - jquery, angular
            od kilku lat również aplikacje serwerowe - node.js


html - struktura dokumentu - interpretowany przez przeglądarki
css - nadaje wygląd strukturze

swift, objective-C - iOS, MacOs
COBOL
go

Języki funkcyjne, obiektowe, proceduralne...
nazwy podobne, ale zupełnie co innego:
java a javascript
C, C++, C#

Bazy danych
Wszystkie oparte na SQL - język manipulacji danymi
Systemy zarządzania bazami danych:
-Oracle
-MySql
-Postgresql
-Microsoft SQL Server







Wywalić:
C#
    natywny język dla platform Microsoft, aplikacje desktopowe,
    czerpie z javy
    platforma .NET
    VisualStudio

PHP
    głównie strony internetowe. Język skryptowy (interpretowalny, nie kompilowalny)
    Popularne cms-y, czy systemy e-commerce - wordpress, magento.
    Frameworki - zend, symphony
    Działa na serwerach aplikacji - nginx, apache
    Najczęściej w parze z MySql

C, C++
    kompilacja do kodu maszynowego -> języka rozumianego przez procesor
    język
    największa kontrola nad pamięcią, wydajnością, jednak kosztem czasu.
    systemy operacyjne (windows, linux), gry, sterowniki, aplikacje desktopowe (np. google chrome)

