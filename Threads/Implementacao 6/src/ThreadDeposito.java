import java.util.Random;

public class ThreadDeposito extends Thread{
    Conta conta;
    int cod;

    public ThreadDeposito(Conta conta, int cod){
        this.conta = conta;
        this.cod = cod;
    }

    public void run(){
        for(int i = 0; i < 10; i++){
            Random random = new Random();
            double d = random.nextDouble();
            conta.Deposito(d);

            try {
                Thread.sleep(1000);
                System.out.println("DEPOSITO Thread " + cod + " depositou " + d + " na conta");
            } catch (InterruptedException e) {System.out.println("DEPOSITO Thread " + cod + " não conseguiu depositar " + d + " na conta");}
        }
    }
}
