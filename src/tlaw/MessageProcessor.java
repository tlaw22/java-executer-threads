package tlaw;

public class MessageProcessor implements Runnable {
    private int message;

    public MessageProcessor(int message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": [Recieved Message] " + message);
        respondMessage(); // Put the thread to sleep to simulate work.
        System.out.println();
        System.out.println(Thread.currentThread().getName() + ": [DONE][MSG PROCESSED] " + message);
        
    }

    private void respondMessage(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Unable to process message." + e.getMessage());
            e.printStackTrace();
        }
    }

}
