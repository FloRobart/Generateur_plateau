#!/bin/bash

echo Ca compile...
javac -encoding utf8 @compile.list

echo Lancement du programme...
java -cp ./bin controleur.Controleur

echo Fin de l\'execution.
