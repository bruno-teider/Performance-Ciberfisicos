import java.util.Random;

public class ThreadSaque extends Thread{
    Conta conta;
    int cod;

    public ThreadSaque(Conta conta, int cod){
        this.conta = conta;
        this.cod = cod;
    }

    public void run(){
        for(int i = 0; i < 10; i++){
            Random random = new Random();
            double d = random.nextDouble();

            try {
                Thread.sleep(1000);
                if(conta.valor > d) {
                    conta.Saque(d);
                    System.out.println("SAQUE Thread " + cod + " conseguiu sacar " + d + " da conta com saldo: " + conta.valor);
                } else{
                    System.out.println("SAQUE Thread " + cod + " não conseguiu sacar " + d + " da conta com saldo: " + conta.valor);
                }
            } catch (InterruptedException e) { System.out.println("SAQUE Thread " + cod + " não conseguiu sacar " + d + " da conta com saldo: " + conta.valor); }
        }


    }
}
