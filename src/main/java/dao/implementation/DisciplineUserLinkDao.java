package dao.implementation;;

import model.Discipline;
import model.DisciplineUserLink;
import model.User;
import dao.interfaces.AbstractDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;

import java.util.*;

/**
 * Created by romab on 9/23/16.
 */
public class DisciplineUserLinkDao extends AbstractDao{


    public DisciplineUserLink create(DisciplineUserLink link) {

        return (DisciplineUserLink) super.create(link);

    }

    public DisciplineUserLink update(DisciplineUserLink link) {
        return (DisciplineUserLink) super.update(link);
    }

    public void delete(DisciplineUserLink link) {
         super.delete(link);
    }


    public DisciplineUserLink read(int id) {
        return (DisciplineUserLink) super.read(DisciplineUserLink.class, id);
    }

    public List readAll() {
        return super.readAll(DisciplineUserLink.class);
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

    public List find (String userType, String disciplineName){
        List result = new ArrayList();
        List <DisciplineUserLink> tempList = null;

        DisciplineDao disciplineDao = new DisciplineDao();
        Discipline discipline = disciplineDao.read(disciplineName);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("from DisciplineUserLink where " +
                "discipline.id =:disciplineId");

        q.setInteger("disciplineId",discipline.getId());

        tempList =  q.list();

        session.getTransaction().commit();

        if( !userType.equals("all") ){

            for (DisciplineUserLink discUsrLink: tempList){
                User currentUser = discUsrLink.getUser();
                if (currentUser.getUserType().equals(userType))
                    result.add(currentUser);
            }


        }else {
            for (DisciplineUserLink discUsrLink: tempList){
                User currentUser = discUsrLink.getUser();
                result.add(currentUser);
            }
        }

        return result;
    }

}
