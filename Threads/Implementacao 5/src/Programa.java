public class Programa {
    public static void main(String[] args){
        Contador contador = new Contador();

        Thread t1 = new MinhaThread(contador);
        Thread t2 = new MinhaThread(contador);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) { e.printStackTrace(); }

        contador.imprimir();
    }
}
