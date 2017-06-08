mvn archetype:generate -DgroupId=com.kkolcz -DartifactId=sslNaskCon -Dpackage=com.kkolcz -Dversion=1.0-SNAPSHOT
mvn archetype:generate -DartifactId=streams -Dversion=1.0-SNAPSHOT

mvn compile exec:java -Dexec.mainClass=com.kkolcz.HTTPSTest
## Rabbitmq
rabbitmq - examples from http://www.rabbitmq.com/getstarted.html
mvn archetype:generate -DgroupId=rabbitmq -DartifactId=rabbitmq -DarchetypeArtifactId=maven-archetype-quickstart
mvn compile exec:java -Dexec.mainClass=rabbitmq.Send
mvn compile exec:java -Dexec.mainClass=rabbitmq.Recv

Zamiast ściągać bibliotekę, dodaję dependency do pom.xml

## Collections
mvn archetype:generate -DgroupId=collections -DartifactId=collections -DarchetypeArtifactId=maven-archetype-quickstart
mvn compile exec:java -Dexec.mainClass=collections.PrintingContainers 

## Concurrent and parallell
z książki Java - Krzysztof Barteczko


## Lambda 
z książki Java - Krzysztof Barteczko
oraz
https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

mvn archetype:generate -DgroupId=lambdaExpr -DartifactId=lambdaExpr -DarchetypeArtifactId=maven-archetype-quickstart
mvn compile exec:java -Dexec.mainClass=lambdaExpr.RosterTest 

## regexExamples
RegexTextHarness* - nie wiem skąd


## CleanCode
mvn archetype:generate -DgroupId=cleancode -DartifactId=cleancode -DarchetypeArtifactId=maven-archetype-quickstart

