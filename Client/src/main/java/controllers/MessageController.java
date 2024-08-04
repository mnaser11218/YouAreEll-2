package controllers;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Id;
import models.Message;

public class MessageController {
    ServerController sc;

    private HashSet<Message> messagesSeen;
    // why a HashSet??

    public MessageController(ServerController shared) {
        sc = shared;
        messagesSeen = new HashSet<Message>();
    }
    public ArrayList<Message> getMessages() {
       String jsonInput = sc.getMessages();
        // convert json to array of Ids
        ObjectMapper mapper = new ObjectMapper();
        List<Message> msgs;
        try {
            msgs = mapper.readValue(jsonInput, mapper.getTypeFactory().constructCollectionType(List.class, Message.class));

            ArrayList<Message> msgList = new ArrayList<>(msgs);
            // return array of Ids
            return msgList;
        } catch (JsonMappingException e) {
            System.out.println("Error processing JSON from response: " + e.getMessage());
        } catch (JsonProcessingException e) {
            System.out.println("Error processing JSON from response: " + e.getMessage());
        }
        return null;
    }
    public ArrayList<Message> getMessagesForId(Id Id) {
        return null;
    }
    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
        return null;
    }

    public List<Message> getMessagesOfUsername(String userName) {
        String jsonInput = sc.getMessagesOfUserName(userName);
        // convert json to array of Ids
        ObjectMapper mapper = new ObjectMapper();
        List<Message> msgs;
        try {
            msgs = mapper.readValue(jsonInput, mapper.getTypeFactory().constructCollectionType(List.class, Message.class));

            ArrayList<Message> msgList = new ArrayList<>(msgs);
            // return array of Ids
            return msgList;
        } catch (JsonMappingException e) {
            System.out.println("Error processing JSON from response: " + e.getMessage());
        } catch (JsonProcessingException e) {
            System.out.println("Error processing JSON from response: " + e.getMessage());
        }
        return null;
    }

//
//    StringWriter writer = new StringWriter();
//    ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(writer, id);
//    String json = writer.toString();
//        System.out.println("this is your string: " + json);
//    // call server, get json result Or error
//    String results = sc.putId(json);
//
//    // result json to Id obj
//
//        return mapper.readValue(results, Id.class);
//}

    public String sendMessage(Message m) throws IOException {
        ///String json;
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, m);
        String jsonBody = writer.toString();
        String results = sc.sendMessage(jsonBody, m.getFromid());

        return results;
    }

    public String sendMessageToUser(Message m) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, m);
        String jsonBody = writer.toString();
        String results = sc.sendMessageToUser(jsonBody, m.getFromid(), m.getToid());

        return results;
    }
}