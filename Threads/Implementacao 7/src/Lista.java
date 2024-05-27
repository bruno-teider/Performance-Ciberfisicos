import java.util.ArrayList;
import java.util.List;

public class Lista {
    List<Integer> lista = new ArrayList<>();

    public synchronized void adicionar(int valor, int id) throws InterruptedException{
        while (lista.size() == 10){ wait(); }

        lista.add(valor);
        System.out.println("p" + id + " produziu " + valor);
        notify();
    }

    public synchronized void remover(int id) throws InterruptedException {
        while (lista.isEmpty()){ wait(); }

        System.out.println("c" + id + " consumiu " + lista.get(0));
        lista.remove(0);
        notify();
    }
}
