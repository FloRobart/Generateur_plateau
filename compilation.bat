@echo off

:: Création des dossiers bin et donnees s'ils n'existent pas
IF NOT EXIST "./bin/"         ( mkdir "./bin" )
IF NOT EXIST "./bin/donnees/" ( mkdir "./bin/donnees/" )

XCOPY "./donnees" "./bin/donnees" /E /Y >NUL

echo Ca compile...
call javac -encoding utf8 "@compile.list" && echo Compilation terminée. || echo Erreur de compilation.

goto :eof