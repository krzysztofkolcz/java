mvn archetype:generate -DgroupId=com.kkolcz -DartifactId=sslNaskCon -Dpackage=com.kkolcz -Dversion=1.0-SNAPSHOT

mvn compile exec:java -Dexec.mainClass=com.kkolcz.HTTPSTest
