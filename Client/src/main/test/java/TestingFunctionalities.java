import controllers.IdController;
import controllers.MessageController;
import controllers.ServerController;
import controllers.TransactionController;
import org.junit.Assert;
import org.junit.Test;
import youareell.YouAreEll;

import java.io.IOException;

public class TestingFunctionalities {

    @Test
    public void testGetMessages(){
        YouAreEll urll = new YouAreEll(new TransactionController(new MessageController(ServerController.shared()),
                new IdController(ServerController.shared())));
        String actual = urll.get_messages();
        //System.out.println(actual.split(" ").toString());
        Assert.assertTrue(actual.split(" ").length > 1);
    }
    @Test
    public void testPostNameAndUserNameToServer() throws IOException {
        YouAreEll urll = new YouAreEll(new TransactionController(new MessageController(ServerController.shared()),
                new IdController(ServerController.shared())));

       String results= urll.postId("id", "name", "githubUserName");
       String expected = "Id registered.";
       Assert.assertEquals(results,expected );
    }

    @Test
    public void testPutMethod() throws IOException {
        YouAreEll urll = new YouAreEll(new TransactionController(new MessageController(ServerController.shared()),
                new IdController(ServerController.shared())));
        String results= urll.putId("id", "name", "githubUserName");
      String expected =  "User updated succesfully.";
      Assert.assertEquals(results, expected);
    }

    @Test
    public void testGetMessagesOfUser(){
        YouAreEll urll = new YouAreEll(new TransactionController(new MessageController(ServerController.shared()),
                new IdController(ServerController.shared())));
        String results= urll.get_messagesOfUser("mnaser");
        int expected = results.split(" ").length;
       // System.out.println(expected);
        Assert.assertTrue(expected >1);
    }
    @Test
    public void testSendMessage() throws IOException {
        YouAreEll urll = new YouAreEll(new TransactionController(new MessageController(ServerController.shared()),
                new IdController(ServerController.shared())));
        // will return the new updated message
        String results = urll.sendMessage("mnaser", "howdy");
        int actual = results.split(",").length;
        Assert.assertEquals(actual, 5);
    }

    @Test
    public void testSendMessageToUser() throws IOException {
        YouAreEll urll = new YouAreEll(new TransactionController(new MessageController(ServerController.shared()),
                new IdController(ServerController.shared())));
        // will return the new updated message
        String results = urll.sendMessageToUser("hello world", "mnaser", "mnaser1111");
        //System.out.println(results);
        int actual = results.split(",").length;
        Assert.assertEquals(actual, 5);
    }







}
