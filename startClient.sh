if [ -z $2 ];
then
    echo "Usage: startClient.sh <host> <port>."
    exit 1
fi
java -cp target/chat-app-0.0.1-SNAPSHOT.jar com.chat.client.ChatClient $1 $2