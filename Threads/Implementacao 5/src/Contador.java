public class Contador {
    int valor;

    public synchronized void incrementar(){ this.valor++; }

    public void imprimir(){ System.out.println("Valor: " + valor); }
}
