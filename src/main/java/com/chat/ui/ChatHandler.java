package com.chat.ui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.chat.common.FileMessage;
import com.chat.common.Message;
import com.chat.common.TextMessage;

public class ChatHandler implements Runnable {
    private Socket socket;
    private ChatWindow chatWindow;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    
    public ChatHandler(Socket socket) {
        this.socket = socket;
        
        chatWindow = new ChatWindow();
        chatWindow.setChatHandler(this);
        chatWindow.setVisible(true);
        System.out.println("Chat window launched.");
    }
    
    public void run() {
        try {
            System.out.println("Reading socket stream");
            this.out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            while(true){
                Message message = (Message) in.readObject();
                if (message instanceof TextMessage) {
                    processTextMessage((TextMessage)message);
                } else if (message instanceof FileMessage) {
                	//TODO need to implement this
                    //processFileMessage(message, in, out);
                }    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void processTextMessage(TextMessage textMessage) {
        chatWindow.append(textMessage);
    }

    private void processFileMessage(FileMessage fileMessage) {
        /*(String fileName = chatWindow.getSelectedFile();
        try(FileOutputStream fout = new FileOutputStream(fileName)){
            fout.write(fileMessage.getContent());
        }catch(IOException e){
            e.printStackTrace();
        }
        */
    }

    /**
     * This method will be called from ChatWindow to send message to other end
     * @param text
     */
    public void send(String text) {
        TextMessage msg = new TextMessage();
        msg.setText(text);
        try {
            out.writeObject(msg);
            out.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
