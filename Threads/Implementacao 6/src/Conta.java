public class Conta {
    double valor;

    public synchronized void Deposito(double d){this.valor += d;}
    public synchronized void Saque(double d){this.valor -= d;}
    public void Saldo(){System.out.println("Saldo na conta: " + valor);}
}
