package messenger;

import model.Message;
import model.User;

/**
 * Created by romab on 10/28/16.
 */
public class NewMessageListener implements Observer {

    private Message currentMessage;
    private User currentUser;

//    private String chatId;

    public NewMessageListener(User currentUser) {
        this.currentUser = currentUser;
    }

    public void update(Message message) {
                currentMessage = message;
    }


    public void justWait(){
        try {

            synchronized (currentUser){

                currentUser.wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public String getMessageText() {
        return currentMessage.getText();
    }

    public Message getCurrentMessage() {
        return currentMessage;
    }

    public void setCurrentMessage(Message currentMessage) {
        this.currentMessage = currentMessage;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
