@echo off
set cp=C:\Users\BorodinovI\WORK\MyJava\J2EE_CDI\SE\target\cdi-se-1.0.jar
set cp=%cp%;C:\Users\BorodinovI\.m2\repository\org\jboss\weld\se\weld-se\2.3.2.Final\weld-se-2.3.2.Final.jar
set cp=%cp%;C:\Users\BorodinovI\.m2\repository\junit\junit\4.12\junit-4.12.jar
set cp=%cp%;C:\Users\BorodinovI\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar
rem set cp=%cp%;C:\Users\BorodinovI\.m2\repository\org\apache\maven\surefire\surefire-junit4\2.16\surefire-junit4-2.16.jar
rem set cp=%cp%;C:\Users\BorodinovI\.m2\repository\org\apache\maven\surefire\surefire-booter\2.16\surefire-booter-2.16.jar
 
java -cp %cp% ru.unclediga.cdi.se.interceptor.Main 
