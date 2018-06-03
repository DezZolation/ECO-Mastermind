shopt -s globstar
javac -d classes **/*.java
cd classes
jar cvf eco-rt.jar .
move "D:\Projects\ECO-Mastermind\runtime\classes\eco-rt.jar" "C:\java\ECO-master\lib\eco-rt.jar"