public class Conta {
    private double saldo;

    public synchronized void saque(double valor){ saldo -= valor; }
    public synchronized void deposito(double valor) { saldo += valor; }
    public synchronized double saldo(){ return saldo; }
}
