mvn archetype:generate -DgroupId=com.kkolcz -DartifactId=sslNaskCon -Dpackage=com.kkolcz -Dversion=1.0-SNAPSHOT

mvn compile exec:java -Dexec.mainClass=com.kkolcz.HTTPSTest
## Rabbitmq
rabbitmq - examples from http://www.rabbitmq.com/getstarted.html
mvn archetype:generate -DgroupId=rabbitmq -DartifactId=rabbitmq -DarchetypeArtifactId=maven-archetype-quickstart
mvn compile exec:java -Dexec.mainClass=rabbitmq.Send
mvn compile exec:java -Dexec.mainClass=rabbitmq.Recv

Zamiast ściągać bibliotekę, dodaję dependency do pom.xml
