package dao.implementation;


import dao.interfaces.AbstractDao;
import model.Chat;

/**
 * Created by romab on 10/2/16.
 */
public class ChatDao extends AbstractDao {

    public Chat create (Chat chat){

        return (Chat) super.create(chat);
    }


    public Chat read(int id) {
        return (Chat) super.read(Chat.class, id);
    }
}
