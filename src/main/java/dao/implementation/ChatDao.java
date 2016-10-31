package dao.implementation;


import dao.interfaces.AbstractDao;
import model.Chat;
import model.Item;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

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

    public List<Chat> getUserChats (int userId){

        List result;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("from Chat where user1.id =:userId " +
                    "or user2.id =:userId");

        q.setInteger("userId",userId);

        result = q.list();

        session.getTransaction().commit();

        return result;

    }



    public Item update(Item item) {
        return super.update(item);
    }


    public void delete(Item item) {
        super.delete(item);
    }


    public List readAll(Class clazz) {
        return super.readAll(clazz);
    }
}
