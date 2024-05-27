public class Programa {
    public static void main(String[] args){
        Conta conta = new Conta();

        for(int i = 0; i < 2; i++){ new ThreadDeposito(conta).start(); }
        for(int i = 0; i < 3; i++){ new ThreadSaque(conta).start(); }
    }
}
