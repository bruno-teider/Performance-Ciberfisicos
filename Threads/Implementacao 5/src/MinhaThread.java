public class MinhaThread extends Thread{
    Contador contador;

    public MinhaThread(Contador contador){ this.contador = contador; }

    public void run(){
        for(int i = 0; i < 10_000; i++){
            contador.incrementar();
        }
    }
}
