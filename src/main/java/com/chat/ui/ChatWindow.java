package com.chat.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.chat.common.Message;
import com.chat.common.TextMessage;

public class ChatWindow extends javax.swing.JFrame {

    /**
     * Creates new form ChatWindow
     */
    public ChatWindow() {
        initComponents();
        initChat();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        chatPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        chatPane = new javax.swing.JTextPane();
        chatField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        attachButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Window");
        setName("chatWindow"); // NOI18N
        setResizable(false);

        chatPane.setEditable(false);
        chatPane.setText("");
        scrollPane.setViewportView(chatPane);

        chatField.setName(""); // NOI18N
        chatField.setNextFocusableComponent(sendButton);
        chatField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatFieldActionPerformed(evt);
            }
        });

        sendButton.setMnemonic('s');
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        attachButton.setMnemonic('a');
        attachButton.setText("Attach");
        attachButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chatPanelLayout.createSequentialGroup()
                        .addComponent(scrollPane)
                        .addContainerGap())
                    .addGroup(chatPanelLayout.createSequentialGroup()
                        .addComponent(chatField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(attachButton)
                        .addGap(0, 8, Short.MAX_VALUE))))
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chatField, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(sendButton)
                    .addComponent(attachButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String text = chatField.getText();
        append("Client", text);
        chatField.setText("");
        chatHandler.send(text);
    }                                          

    private void chatFieldActionPerformed(java.awt.event.ActionEvent evt) {                                          
        sendButtonActionPerformed(evt);
    }                                         

    private void attachButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            
    private void append(String from, String message){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        String newText = String.format("%s %s: %s",from, df.format(new Date()), message);
        String existingText = chatPane.getText();
        
        if(existingText.isEmpty()){
            chatPane.setText(newText);
        }else {
            chatPane.setText(existingText + "\n" + newText);
        }
        
        
    }
    /**
     * Initializes the chat window
     */
    private void initChat() {
        chatField.requestFocusInWindow();
    }
    
    public void append(TextMessage message){
        append("Client",message.getText());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatWindow().setVisible(true);
            }
        });
    }
    
    public void setChatHandler(ChatHandler chatHandler) {
        this.chatHandler = chatHandler;
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton attachButton;
    private javax.swing.JTextField chatField;
    private javax.swing.JTextPane chatPane;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton sendButton;
    // End of variables declaration                   
    private ChatHandler chatHandler;

   

}
