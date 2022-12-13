#!/bin/bash

echo Ca compile...
javac -encoding utf8 @compile.list

echo Lancement du programme...
java Controleur.java

echo Fin de l\'execution.
