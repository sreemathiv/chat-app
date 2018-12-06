if [ -z $1 ];
then
    PORT=2000
else
    PORT=$1
fi
java -cp target/chat-app-0.0.1-SNAPSHOT.jar com.chat.server.ChatServer $PORT