#!/bin/bash

echo Lancement de l\'interface graphique...
java -cp "./bin:$CLASSPATH" controleur.Controleur  && Fin de l'execution. || echo. & echo Veulliez compiler le projet java avant de la lancer.
