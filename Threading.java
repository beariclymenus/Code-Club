package src;

public class Threading {
    public static void main(String args[]) {
        Thread newT = new Thread(new RunPractice()); //Threads require a Runnable Object to Run
        
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    System.out.println("Hello world again");
                    try {
                        Thread.sleep(500);
                    } catch(InterruptedException e) {

                    }
                } //end of while loop
            }
        }); //end of t2

        newT.start();
        t2.start();

        
    }
}
