public class Programa {
    public static void main(String[] args){
        Conta conta = new Conta();

        Thread saque1 = new ThreadSaque(conta,1);
        Thread saque2 = new ThreadSaque(conta,2);
        Thread saque3 = new ThreadSaque(conta,3);

        Thread deposito1 = new ThreadDeposito(conta,1);
        Thread deposito2 = new ThreadDeposito(conta,2);

        saque1.start();
        saque2.start();
        saque3.start();

        deposito1.start();
        deposito2.start();
    }
}
