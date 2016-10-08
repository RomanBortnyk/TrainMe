package test;

import dao.implementation.*;
import model.Avatar;
import model.Discipline;
import model.Message;
import model.User;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;

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

        File weightlifting = new File("/home/romab/Desktop/weightlifting.png");
        File swimming = new File("/home/romab/Desktop/swimming.png");
        File baseball = new File("/home/romab/Desktop/baseball.png");
        File basketball = new File("/home/romab/Desktop/basketball.png");

        DisciplineDao disciplineDao = new DisciplineDao();

        disciplineDao.createFromFile("weightlifting", weightlifting);
        disciplineDao.createFromFile("swimming", swimming);
        disciplineDao.createFromFile("baseball", baseball);
        disciplineDao.createFromFile("basketball", basketball);



    }
}
