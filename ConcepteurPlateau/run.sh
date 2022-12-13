#!/bin/bash

echo Ca compile...
javac -encoding utf8 *.java

echo Lancement du programme...
java Controleur.java

echo Fin de l\'execution.
rm -f *.class
