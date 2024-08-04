package controllers;

import models.Id;
import models.Message;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";
    private MessageController msgCtrl;
    private IdController idCtrl;

    public TransactionController(MessageController m, IdController j) {
        msgCtrl = m;
        idCtrl = j;
    }

    public List<Id> getIds() {
        return idCtrl.getIds();
    }

    public String getId(String id) {
        return null;
    }
    public String putId(String id) {
        return null;
    }

    public String deleteId(String id) {
        return null;
    }

    public String postId(String idtoRegister,String name, String githubName) throws IOException {
         Id tid = new Id(idtoRegister, name, githubName);
         tid = idCtrl.postId(tid);
         return "Id registered.";
       // return null;
    }

    public String putId(String idtoRegister,String name, String githubName) throws IOException {
        Id tid = new Id(idtoRegister, name, githubName);
        tid = idCtrl.putId(tid);
        return "User updated succesfully.";
        // return null;
    }

    public List<Message> getMessages() {
        return msgCtrl.getMessages();
    }

    public List<Message> getMessagesOfUser(String userName) {
        return msgCtrl.getMessagesOfUsername(userName);
    }

    public String sendMessage(String userName, String message) throws IOException {
        Date date = new Date();
        Message m = new Message(message, userName);
        String t = msgCtrl.sendMessage(m);

        return t;
    }
}
