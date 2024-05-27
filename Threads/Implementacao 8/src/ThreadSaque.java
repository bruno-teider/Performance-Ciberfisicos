import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSaque extends Thread{
    private final Conta conta;
    private final Random random = new Random();
    private final ReentrantLock lock = new ReentrantLock();

    public ThreadSaque(Conta conta) { this.conta = conta; }

    public void run(){
        while(true){
            lock.lock();
            try {
                double valor = random.nextDouble(10);
                if(conta.saldo() > valor){
                    conta.saque(valor);
                    System.out.printf("Saque de %.2f | Saldo conta: %.2f%n", valor, conta.saldo());
                } else System.out.printf("Não foi possível realizar saque de %.2f%n", valor);

                Thread.sleep(1000);
            } catch (Exception e){ e.printStackTrace(); }
        }
    }
}
