package dao.implementation;

import dao.interfaces.AbstractDao;
import model.Item;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;

import javax.persistence.UniqueConstraint;
import java.util.List;

/**
 * Created by romab on 10/2/16.
 */
public class UserDao extends AbstractDao {

    public User create(User user) {
        if (isExist(user)) {
            System.out.println("user with login: " + user.getLogin() + "or with email: " + user.getEmail() + " already exist");
            return null;
        } else {

            super.create(user);

            System.out.println("user with login: " + user.getLogin() + " has been created");
            return user;


        }
    }

    public User read (int id ){

        return (User) super.read(User.class, id);

    }

    public User update(User user) {
        return (User) super.update(user);
    }

    public void delete(User user) {
        if (isExist(user)) {
            super.delete(user);
            super.delete(user.getAvatar());
            System.out.println("user with login: "+ user.getLogin()+ " has been deleted");
        } else {
            System.out.println("you try delete user which does not exist");
        }
    }

    public List readAll() {
        return super.readAll(User.class);
    }

    public boolean isPasswordCorrect (User user, String password){

        User chekedUser = read(user.getId());

        if (chekedUser.getPassword().equals(password)) return true; else return false;


    }

    public User read (String login){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("from User where login = :login");
        q.setString("login",login);


        User newUser = (User)q.uniqueResult();

        session.getTransaction().commit();

        if (newUser != null) return newUser; else return null;

    }

    public boolean isExist (User user){
        if (user == null) return false;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("from User where " +
                "login = :login or email = :email");
        q.setString("login",user.getLogin());
        q.setString("email",user.getEmail());
        User newUser = (User)q.uniqueResult();

        session.getTransaction().commit();
        if (newUser == null) return false; else return true;

    }

    public List readAllFullNames (){

        List result = null;

        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("select firstName, lastName from User");
            result = q.list();
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }


        return result;
    }

}
