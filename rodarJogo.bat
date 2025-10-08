@echo off
cd /d %~dp0
if not exist bin mkdir bin

echo Compilando...
cmd /C "C:\Users\Daniel\.jdks\openjdk-23.0.1\bin\java.exe -Dfile.encoding=UTF-8 -XX:+ShowCodeDetailsInExceptionMessages -cp C:\Users\Daniel\AppData\Roaming\Code\User\workspaceStorage\01eef6fc300fd8cb5768c489ce79a67e\redhat.java\jdt_ws\jdt.ls-java-project\bin Detetive.Main "
if %errorlevel% neq 0 (
  echo Erro na compilacao!
  pause
  exit /b
)

echo Tentando executar como Main...
java -cp bin Main
if %errorlevel% equ 0 goto end

echo Tentando executar como Detetive.Main...
java -cp bin Detetive.Main
if %errorlevel% equ 0 goto end

echo Nao foi possivel localizar a classe Main nem Detetive.Main.
echo Verifique se o Main.java tem package correto e se foi compilado.
echo Listando bin\...
dir bin /s /b
:end
pause
