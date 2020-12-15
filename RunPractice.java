package src;


public class RunPractice implements Runnable {
    public void run() {
        while(true) {
            System.out.println("Hello world");
            try {
                Thread.sleep(500); //the int is in milliseconds
            } catch(InterruptedException e) {

            }
        } //end of while loop
    }

}
