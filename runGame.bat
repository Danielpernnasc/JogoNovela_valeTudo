:: filepath: C:\Users\Daniel\Desktop\JavaSpringBoot\ValeTudo\Detetive\rodarJogo.bat
@echo off
setlocal EnableExtensions EnableDelayedExpansion
title Detetive - Build ^& Run
pushd "%~dp0"
chcp 65001 >nul

set "MAIN_CLASS=Detetive.Main"

:: Verifica JDK
where javac >nul 2>nul || (echo ERRO: javac nao encontrado no PATH.& goto :PAUSE_EXIT)
where java  >nul 2>nul || (echo ERRO: java nao encontrado no PATH.& goto :PAUSE_EXIT)

:LOOP
cls
echo ============================
echo   Compilando o projeto...
echo ============================

:: Limpa/Cria bin
if exist "bin" rmdir /s /q "bin"
mkdir "bin"

:: Coleta fontes
set "SOURCES="
for /r %%F in (*.java) do (
  set "P=%%~fF"
  set "P=!P:\=/!"
  set "SOURCES=!SOURCES! "!P!""
)

if not defined SOURCES (
  echo ERRO: Nenhum arquivo .java encontrado.
  set "RC=1"
  goto :ASK
)

:: Compila
javac -encoding UTF-8 -d "bin" !SOURCES!
if errorlevel 1 (
  echo.
  echo ERRO: Compilacao falhou.
  set "RC=1"
  goto :ASK
)

echo.
echo ============================
echo   Executando %MAIN_CLASS% ...
echo ============================
java -Dfile.encoding=UTF-8 -cp "bin" %MAIN_CLASS%
set "RC=%ERRORLEVEL%"

:ASK
echo.
choice /C RS /N /M "Reiniciar [R] ou Sair [S]? "
:: Importante: testar em ordem decrescente
if errorlevel 2 goto :PAUSE_EXIT
if errorlevel 1 goto :LOOP

:PAUSE_EXIT
echo.
echo Fim. Codigo de saida: %RC%
pause
popd
exit /b %RC%