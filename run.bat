@echo off

:: Création des dossiers bin et donnees s'ils n'existent pas
IF NOT EXIST "./bin/"         ( mkdir "./bin" )
IF NOT EXIST "./bin/donnees/" ( mkdir "./bin/donnees/" )

XCOPY "./donnees" "./bin/donnees" /E /Y >NUL

echo Ca compile...
javac -encoding utf8 "@compile.list"

echo Lancement du programme...
java -cp "./jdom.jar;./bin:./bin/donnees" controleur.Controleur

echo Fin de l'execution.
@REM IF EXIST ".\bin\ihm"        rmdir /q /s ".\bin\ihm"       >NUL
@REM IF EXIST ".\bin\controleur" rmdir /q /s ".\bin\controleur">NUL
@REM IF EXIST ".\bin\metier"     rmdir /q /s ".\bin\metier"    >NUL
goto :eof