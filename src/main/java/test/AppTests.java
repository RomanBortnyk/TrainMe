package test;

import dao.implementation.MessageDao;
import dao.implementation.UserDao;
import messenger.Database;
import messenger.NewMessageListener;
import messenger.SmallerMessage;
import model.Message;
import model.User;
import org.junit.Test;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


/**
 * Created by romab on 11/7/16.
 */
public class AppTests {

    // simple tests

    @Test
    public void updateMessageTest(){
        NewMessageListener listener = new NewMessageListener();
        Message message = new Message();
        MessageDao dao = new MessageDao();

        listener.update(dao.read(256));
        assertNotNull(listener.getCurrentMessage());

    }

    @Test
    public void registerObserverTest(){
        Database database = new Database();
        NewMessageListener messageListener = new NewMessageListener();
        database.registerObserver(messageListener);
        assertEquals(database.getObservers().get(0),messageListener);
    }
    
    @Test
    public void readUserFromDatabaseTest(){
        UserDao userDao = new UserDao();
        assertEquals("Jack",userDao.read(8).getFirstName());

    }
    @Test
    public void isUserExistTest(){

        UserDao userDao = new UserDao();

        assertTrue(userDao.isExist(userDao.read(8)));

    }
    
    @Test
    public void readUserByFirstAndLastNameAndType(){
        UserDao userDao = new UserDao();
        assertTrue(userDao.read("test","test","test").isEmpty());

    }

}
