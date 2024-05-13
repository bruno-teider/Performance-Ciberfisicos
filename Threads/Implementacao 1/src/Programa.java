public class Programa {
    public static void main(String[] args){
        MinhaThread thread1 = new MinhaThread("Thread1");
        MinhaThread thread2 = new MinhaThread("Thread2");

        thread1.start();
        thread2.start();

    }
}
