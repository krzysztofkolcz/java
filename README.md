## Rabbitmq
rabbitmq - examples from http://www.rabbitmq.com/getstarted.html
mvn archetype:generate -DgroupId=rabbitmq -DartifactId=rabbitmq -DarchetypeArtifactId=maven-archetype-quickstart
mvn compile exec:java -Dexec.mainClass=rabbitmq.Send
mvn compile exec:java -Dexec.mainClass=rabbitmq.Recv

Zamiast ściągać bibliotekę, dodaję dependency do pom.xml
