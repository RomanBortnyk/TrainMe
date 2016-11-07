package test;

import dao.implementation.MessageDao;
import dao.implementation.UserDao;
import messenger.Database;
import messenger.NewMessageListener;
import messenger.SmallerMessage;
import model.Message;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by romab on 11/7/16.
 */
public class Tests {

    // simple tests

    @Test
    public void updateMessageTest(){
        NewMessageListener listener = new NewMessageListener();
        Message message = new Message();
        MessageDao dao = new MessageDao();

        listener.update(dao.read(256));

        assertNotNull(listener.getCurrentMessage());

    }


}
