package dao.implementation;;

import model.Discipline;
import model.DisciplineUserLink;
import model.User;
import dao.interfaces.AbstractDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;

import java.util.List;

/**
 * Created by romab on 9/23/16.
 */
public class DisciplineUserLinkDao extends AbstractDao{


    public DisciplineUserLink create(DisciplineUserLink link) {
        if (isExist(link)) {
            System.out.println("link user: "+link.getUser().getLogin() +" discipline: "
                    + link.getDiscipline().getName() + " already exist");
            return null;
        }
        else {
            super.create(link);
            System.out.println("link user: "+link.getUser().getLogin() +" discipline: "
                    + link.getDiscipline().getName() +" has been created");
            return link;
        }

    }

    public DisciplineUserLink update(DisciplineUserLink link) {
        return (DisciplineUserLink) super.update(link);
    }

    public void delete(DisciplineUserLink link) {
        if (isExist(link)) {
            super.delete(link);
            System.out.println("link user: "+link.getUser().getLogin() +" discipline: "
                    + link.getDiscipline().getName() +" has been deleted");
        } else {
            System.out.println("you try delete link which does not exist");
        }
    }


    public DisciplineUserLink read(int id) {
        return (DisciplineUserLink) super.read(DisciplineUserLink.class, id);
    }

    public List readAll() {
        return super.readAll(DisciplineUserLink.class);
    }

    public boolean isExist (DisciplineUserLink link){
        if (link == null) return false;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("from DisciplineUserLink where " +
                "user.id = :userId or discipline.id = :disciplineId");
        q.setInteger("userId",link.getUser().getId());
        q.setInteger("disciplineId",link.getDiscipline().getId());
        User newUser = (User)q.uniqueResult();

        session.getTransaction().commit();

        if (newUser == null) return false; else return true;

    }

    public List getUsersDisciplineLinks (int userId){

        List result = null;

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from DisciplineUserLink where user.id =:userId");
            query.setInteger("userId", userId);
            result = query.list();
            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(session.isOpen()){
                System.out.println("Closing session");
                session.close();
            }
        }

        return result;

    }

    public DisciplineUserLink read (User user, Discipline discipline){

        Session session = null;
        DisciplineUserLink result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from DisciplineUserLink where user.id =:userId " +
                    "and discipline.id =:disciplineId ");
            query.setInteger("userId", user.getId());
            query.setInteger("disciplineId", discipline.getId());
            result = (DisciplineUserLink) query.uniqueResult();
            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(session.isOpen()){
                System.out.println("Closing session");
                session.close();
            }
        }

        return result;
    }


}
