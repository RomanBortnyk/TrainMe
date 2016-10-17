package test;

import dao.implementation.*;
import model.Avatar;
import model.Discipline;
import model.Message;
import model.User;
import persistence.HibernateUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
//        System.out.println("Maven + Hibernate + MySQL");
//
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        File image = new File(classLoader.getResource("image.png").getFile());
//        byte[] bFile = new byte[(int) image.length()];
//        try {
//            FileInputStream fileInputStream = new FileInputStream(image);
//            //convert file into array of bytes
//            fileInputStream.read(bFile);
//            fileInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////
//        Avatar avatar = new Avatar();
//        avatar.setImage(bFile);

//        AvatarDao avatarDao = new AvatarDao();


//        File hipsta1 = new File("/home/romab/Desktop/hipsta1.png");
//        File hipsta2 = new File("/home/romab/Desktop/hipsta2.png");
//        File hipsta3 = new File("/home/romab/Desktop/hipsta3.png");
//        File hipsta4 = new File("/home/romab/Desktop/hipsta4.png");
//
//        avatarDao.createFromFile(hipsta1);
//        avatarDao.createFromFile(hipsta2);
//        avatarDao.createFromFile(hipsta3);
//        avatarDao.createFromFile(hipsta4);

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

        UserDao userDao = new UserDao();
        List list =  userDao.readAllFullNames();

//        System.out.println(list.get(0) instanceof Object[]);
        Object[] oarray = (Object[]) list.get(0);
//        String [] names = Arrays.copyOf(oarray,oarray.length, String[].class);

        String[] names = Arrays.asList(oarray).toArray(new String[oarray.length]);

        for (Object f: list){

        }
        String s [] = "roman bortnyk".split(" ");

        HibernateUtil.shutdown();
    }
}
