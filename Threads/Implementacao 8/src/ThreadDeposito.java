import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDeposito extends Thread{
    private final Conta conta;
    private final Random random = new Random();
    private final ReentrantLock lock = new ReentrantLock();

    public ThreadDeposito(Conta conta) { this.conta = conta; }

    public void run(){
        while(true){
            lock.lock();
            try{
                double valor = random.nextDouble(10);
                conta.deposito(valor);
                System.out.printf("Depósito de %.2f | Saldo conta: %.2f%n", valor, conta.saldo());
                Thread.sleep(1000);
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
