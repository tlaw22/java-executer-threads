package tlaw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(2); // recycles threads

        Runnable processor = new MessageProcessor(2);
        exe.execute(processor);

        Runnable processor2 = new MessageProcessor(3);
        exe.execute(processor2);

        Runnable processor3 = new MessageProcessor(4);
        exe.execute(processor3);

        Runnable processor4 = new MessageProcessor(5);
        exe.execute(processor4);
        exe.shutdown(); // rejects new tasks from being submitted. Gracefully shuts down.
        // exe.shutdownNow(); // Terminates all currently executing tasks immediately.
        try {
            exe.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // Wait until
        while(!exe.isTerminated()) { // Wait for tasks to complete in the ExecutorService.

        }
        System.out.println("[LESSON COMPLETE]");

    }
}
