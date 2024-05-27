import java.util.Random;
import java.util.concurrent.Semaphore;

public class Filosofo extends Thread{
    Random random = new Random();
    Semaphore semaphore;
    int id;

    public Filosofo(int id, Semaphore semaphore){
        this.id = id;
        this.semaphore = semaphore;
    }

    public void run(){
        try {
            semaphore.acquire();

            System.out.println("Filósofo " + id + " está comendo...");
            Thread.sleep(random.nextInt(4000));

            System.out.println("Filósofo " + id + " pegou um garfo adjacente");
            Thread.sleep(random.nextInt(4000));

            System.out.println("Filósofo " + id + " pegou outro garfo adjacente");
            Thread.sleep(random.nextInt(4000));

            System.out.println("Filósofo " + id + " terminou de comer...");

            semaphore.release();

        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
