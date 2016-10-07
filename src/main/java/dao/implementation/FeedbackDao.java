package dao.implementation;

import dao.interfaces.AbstractDao;
import model.Feedback;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;

import java.util.List;

/**
 * Created by romab on 9/21/16.
 */
public class FeedbackDao extends AbstractDao {


    public Feedback create(Feedback feedback) {
        if (feedback != null ) {
            super.create(feedback);
            System.out.println("feedback has been created");
            return feedback;
        } else {
            System.out.println("feedback already exist");
            return null;
        }

    }


    public Feedback update(Feedback feedback) {
        if (feedback != null && isExist(feedback)) {
            super.update(feedback);
            System.out.println("feedback has been updated");
            return feedback;
        } else {
            System.out.println("feedback does not  exist");
            return null;
        }
    }


    public void delete(Feedback feedback) {
        if (isExist(feedback)) {
            super.delete(feedback);
            System.out.println("feedback has been deleted");
        } else {
            System.out.println("you try delete feedback which does not exist");
        }

    }


    public Feedback read(int id) {
        return (Feedback) super.read(Feedback.class, id);
    }


    public List readAll() {
        return super.readAll(Feedback.class);
    }

    public boolean isExist(Feedback feedback) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("from Feedback where " +
                    "author.id = :authorId and user.id = :userId");
        q.setInteger("authorId", feedback.getAuthor().getId());
        q.setInteger("userId", feedback.getUser().getId());
        Feedback newDeal = (Feedback) q.uniqueResult();

        session.getTransaction().commit();

        if (newDeal == null) return false;
            else return true;

    }
}
