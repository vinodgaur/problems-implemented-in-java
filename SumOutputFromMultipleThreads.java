import java.util.concurrent.atomic.AtomicInteger;

public class SumOutputFromMultipleThreads {

    AtomicInteger sum = new AtomicInteger();

    public SumOutputFromMultipleThreads() {
    }

    public static void main(String[] args)
    {
        try {
        SumOutputFromMultipleThreads t = new SumOutputFromMultipleThreads();
            t.process();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void process() throws InterruptedException {

        Thread t1 = new Thread(()->{
            int i=0;
            try {
                while(i++<5) {
                    System.out.println("t1=" + Thread.currentThread().getName());
                    Thread.sleep(2000);
                    sum.set(sum.get() + 10);
                }
                System.out.println("t1="+Thread.currentThread().getName() + "done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            int j=0;
            try {
                while(j++<5) {
                    System.out.println("t2=" + Thread.currentThread().getName());
                    Thread.sleep(1000);
                    sum.set(sum.get() + 10);
                }
                System.out.println("t2="+Thread.currentThread().getName() + "done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join(); t2.join();
        System.out.println(Thread.currentThread().getName() + "= sum="+sum.get());
    }

}
