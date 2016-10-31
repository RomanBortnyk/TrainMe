package messanger;

/**
 * Created by romab on 10/28/16.
 */
public class NewMessageListener implements Observer {

    private Message currentMessage;
    private String waitObject;

//    private String chatId;


    public NewMessageListener(String waitObject) {
        this.waitObject = waitObject;
    }

    public void update(Message message) {
                currentMessage = message;
    }



    public void justWait(){
        try {

            synchronized (waitObject){

                waitObject.wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public String getMessageText() {
        return currentMessage.getText();
    }

    public String getMessageAuthor(){
        return currentMessage.getAuthor();
    }


}
