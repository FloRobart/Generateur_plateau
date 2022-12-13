@echo off

echo Ca compile...
call javac -encoding utf8 *.java

echo Lancement du programme...
call java Controleur.java

echo Fin de l'execution.
del /q *.class

goto :eof