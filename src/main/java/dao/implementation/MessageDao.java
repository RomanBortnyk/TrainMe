package dao.implementation;

import dao.interfaces.AbstractDao;
import model.Message;

import java.util.List;

/**
 * Created by romab on 10/2/16.
 */
public class MessageDao extends AbstractDao {

    public Message create(Message message) {
        return (Message)super.create(message);
    }


    public Message update(Message message) {
        return (Message) super.update(message);
    }


    public void delete(Message message) {
        super.delete(message);
    }

    public Message read(int id) {
        return (Message) super.read(Message.class, id);
    }

    public List readAll() {
        return super.readAll(Message.class);
    }
}
