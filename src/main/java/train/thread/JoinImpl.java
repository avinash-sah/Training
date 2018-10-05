package train.thread;

public class JoinImpl {

    public static void main(String[] args) {
       Thread t1 = new Thread(new SampleThread());
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("interrrupted");
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Main "+ i);
        }
    }

    static class SampleThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Sample Thread "+ i);
            }
        }
    }
}
