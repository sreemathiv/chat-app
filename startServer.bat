@echo off
if "%1"=="" (
  set PORT=2000 
) else (
  set PORT=%1
)
java -cp target/chat-app-0.0.1-SNAPSHOT.jar com.chat.server.ChatServer %PORT%