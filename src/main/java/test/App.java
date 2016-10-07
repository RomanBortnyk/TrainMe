package test;

import dao.implementation.AvatarDao;
import dao.implementation.ChatDao;
import dao.implementation.MessageDao;
import dao.implementation.UserDao;
import model.Avatar;
import model.Message;
import model.User;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File image = new File(classLoader.getResource("image.png").getFile());
        byte[] bFile = new byte[(int) image.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(image);
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//
        Avatar avatar = new Avatar();
        avatar.setImage(bFile);

//        AvatarDao avatarDao = new AvatarDao();
//        Avatar avatar1 = avatarDao.create(avatar);

//        ChatDao chatDao = new ChatDao();
//        UserDao userDao = new UserDao();
//
//
//        User user1 = userDao.read("greg");
//        System.out.println(user1.getFirstName());
//
//
//        Message message = new Message();
//
//        message.setChat(chatDao.read(1));
//        message.setCreatedAt(new Timestamp(90, 2, 23,14,32,32,32));
//        message.setText("fdfsdfsfsdfs");
//        message.setUser(userDao.read(1));
//
//
//        MessageDao messageDao = new MessageDao();
//        messageDao.create(message);

        User user = new User("Jack", "Jhonson","11/12/1256","jaksson23","pass",
                "email23s1@gmail.com","customer");

        UserDao userDao = new UserDao();
        userDao.create(user);

//        System.out.println(user1.getFirstName());
        
    }
}
