public class Programa {
    public static void main(String[] args){
        Thread t1 = new Thread(new MinhaThread("Thread1"));
        Thread t2 = new Thread(new MinhaThread("Thread2"));

        t1.start();
        t2.start();
    }
}
