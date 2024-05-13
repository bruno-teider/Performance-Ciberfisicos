public class Programa {
    public static void main(String[] args){
        Thread t1 = new MinhaThread("Thread1");

        t1.start();

        // Faz com que a main aguarde a thread finalizara execução
        try{ t1.join(); }
        catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("Fim do Programa!");
    }
}
