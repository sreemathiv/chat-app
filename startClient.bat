@echo off
if "%2"=="" (
  echo Usage: startClient.bat [host] [port]
  exit /B 1
) 
java -cp target/chat-app-0.0.1-SNAPSHOT.jar com.chat.client.ChatClient %1 %2