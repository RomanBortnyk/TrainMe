package messenger;

import dao.implementation.ChatDao;
import dao.implementation.MessageDao;
import model.Chat;
import model.Message;
import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romab on 10/28/16.
 */
public class Database implements Observable {

    List<Observer> observers = new ArrayList<Observer>();
    List<User> waitingUsers = new ArrayList<User>();

//    private String waitObject = "wait";

    public Database(){

    }


    public void addMessage (Message message){

        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал");
//        currentMessage = message;
        MessageDao messageDao = new MessageDao();
        ChatDao chatDao = new ChatDao();


        for (User user: waitingUsers){
            List<Chat> usersChats = chatDao.getUserChats(user.getId());
            for (Chat chat: usersChats){
                if ( chat.getId() == message.getChat().getId()){
                    synchronized (user) {
                        messageDao.create(message);
                        notifyObservers(message);
                        user.notify();
                        System.out.println(name + " поток Notifier отработал");

                    }
                }

            }
        }

    }


    public void registerObserver(Observer o) {
        observers.add(o);

    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(Message newMessage) {
        for (Observer observer : observers)
            observer.update(newMessage);
    }


    public List<User> getWaitingUsers() {
        return waitingUsers;
    }

    public void setWaitingUsers(List<User> waitingUsers) {
        this.waitingUsers = waitingUsers;
    }
}
