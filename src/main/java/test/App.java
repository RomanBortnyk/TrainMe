package test;

import dao.implementation.*;
import model.*;
import persistence.HibernateUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {

//        DisciplineDao disciplineDao = new DisciplineDao();
//
//        File n1 = new File("/home/romab/Desktop/kickboxing.png");
//        File n2 = new File("/home/romab/Desktop/bodybuilding.png");
//
//        disciplineDao.createFromFile("kickboxing", n1);
//        disciplineDao.createFromFile("bodybuilding", n2);
//        disciplineDao.createFromFile("weightlifting", weightlifting);
//        disciplineDao.createFromFile("swimming", swimming);
//        disciplineDao.createFromFile("baseball", baseball);
//        disciplineDao.createFromFile("basketball", basketball);


//        DisciplineUserLinkDao disciplineUserLinkDao = new DisciplineUserLinkDao();
//
//        List current = disciplineUserLinkDao.find("coach","kickboxing");

        UserDao userDao = new UserDao();

        List current = userDao.read("Vlad", "Gutov");

        Iterator iter = current.iterator();
        while (iter.hasNext() ){
            System.out.println(iter.next());
        }

        HibernateUtil.shutdown();

    }


}
