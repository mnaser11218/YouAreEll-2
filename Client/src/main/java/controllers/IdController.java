package controllers;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Id;

public class IdController {
    ServerController sc;
    private HashMap<String, Id> allIds;

    Id myId;

    public IdController(ServerController shared) {
        sc = shared;
        allIds = new HashMap<String, Id>();
    }

    public ArrayList<Id> getIds() {
        String jsonInput = sc.getIds();
        // convert json to array of Ids
        ObjectMapper mapper = new ObjectMapper();
        List<Id> ids;
        try {
            ids = mapper.readValue(jsonInput, mapper.getTypeFactory().constructCollectionType(List.class, Id.class));

            ArrayList<Id> idList = new ArrayList<>(ids);
            // return array of Ids
            return idList;
        } catch (JsonMappingException e) {
            System.out.println("Error processing JSON from response: " + e.getMessage());
        } catch (JsonProcessingException e) {
            System.out.println("Error processing JSON from response: " + e.getMessage());
        }
        return null;
    }

    public Id postId(Id id) throws IOException {
        // create json from id
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try{
            // call server, get json result Or error
            mapper.writeValue(writer, 1);
            String json = writer.toString();
            System.out.println("this is your string: " + json);

        }catch(IOException e){
            e.getMessage();
        }

        // result json to Id obj

        return null;
    }

    public Id putId(Id id) {
        return null;
    }
 
}