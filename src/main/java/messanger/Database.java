package messanger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by romab on 10/28/16.
 */
public class Database implements Observable {

    List<Observer> observers = new ArrayList<Observer>();
    List<String> waitingUsers = new ArrayList<String>();
    private HashMap<Integer,Message> messages;
    private int currentId = 1;



//    private Message currentMessage;
    private String waitObject = "wait";

    public Database(Message firstMessage){
        messages = new HashMap<Integer, Message>();
        messages.put(currentId,firstMessage);
        currentId ++;
    }

    public Database() {
        messages = new HashMap<Integer, Message>();
    }

    public void addMessage (Message message){


        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал");
//        currentMessage = message;

            synchronized (waitObject) {
                messages.put(currentId,message);
                currentId++;
                notifyObservers(message);
                waitObject.notifyAll();
                System.out.println(name + " поток Notifier отработал");

        }
    }

    public Message getMessage (int id){
        return messages.get(id);
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

    public String getWaitObject() {
        return waitObject;
    }
}
