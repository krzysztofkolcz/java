https://github.com/rabbitmq/rabbitmq-tutorials/tree/master/java

http://www.rabbitmq.com/tutorials/tutorial-one-java.html
Skąd ja wziąłem kod do one.Recv?

mvn compile exec:java -Dexec.mainClass=rabbitExamplesMvn.one.Recv
mvn compile exec:java -Dexec.mainClass=rabbitExamplesMvn.one.Send

http://www.rabbitmq.com/tutorials/tutorial-two-java.html

run two workers:

mvn compile exec:java -Dexec.mainClass=rabbitExamplesMvn.two.Worker
mvn compile exec:java -Dexec.mainClass=rabbitExamplesMvn.two.Worker
mvn compile exec:java -Dexec.mainClass=rabbitExamplesMvn.two.NewTask
