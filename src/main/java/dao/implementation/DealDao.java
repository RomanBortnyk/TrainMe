package dao.implementation;//package dao.implementation;
//
//import model.Deal;
//import dao.interfaces.AbstractDao;
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import persistence.HibernateUtil;
//
//import java.util.List;
//
///**
// * Created by romab on 9/21/16.
// */
//public class DealDao extends AbstractDao {
//
//
//    public Deal create(Deal deal) {
//        if (deal != null ) {
//            super.create(deal);
//            System.out.println("deal \"" + deal.getName() + "\" has been created");
//            return deal;
//        } else {
//            System.out.println("deal \"" + deal.getName() + "\" already exist");
//            return null;
//        }
//
//    }
//
//
//    public Deal update(Deal deal) {
//        if (deal != null && isExist(deal)) {
//            super.update(deal);
//            System.out.println("deal \"" + deal.getName() + "\" has been updated");
//            return deal;
//        } else {
//            System.out.println("deal \"" + deal.getName() + "\" does not  exist");
//            return null;
//        }
//    }
//
//
//    public void delete(Deal deal) {
//        if (isExist(deal)) {
//            super.delete(deal);
//            System.out.println("deal  \"" + deal.getName() + "\" has been deleted");
//        } else {
//            System.out.println("you try delete deal which does not exist");
//        }
//
//    }
//
//
//    public Deal read(int id) {
//        return (Deal) super.read(Deal.class, id);
//    }
//
//
//    public List readAll() {
//        return super.readAll(Deal.class);
//    }
//
//    public boolean isExist(Deal deal) {
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        Query q = session.createQuery("from Deal where " +
//                    "user1.id = :user1Id and user2.id = :user2Id");
//        q.setInteger("user1Id", deal.getUser1().getId());
//        q.setInteger("user2Id", deal.getUser2().getId());
//        Deal newDeal = (Deal) q.uniqueResult();
//
//        session.getTransaction().commit();
//
//        if (newDeal == null) return false;
//            else return true;
//
//    }
//}
