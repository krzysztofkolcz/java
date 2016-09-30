https://docs.oracle.com/javase/tutorial/essential/regex/index.html
mvn archetype:generate -DgroupId=regexExamples -DartifactId=regexExamples -DarchetypeArtifactId=maven-archetype-quickstart
mvn compile exec:java -Dexec.mainClass=regexExamples.App
