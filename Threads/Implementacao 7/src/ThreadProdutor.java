import java.util.Random;

public class ThreadProdutor extends Thread{
    private Lista lista;
    private Random random = new Random();
    private int id;

    public ThreadProdutor(int id, Lista lista){
        this.lista = lista;
        this.id = id;
    }

    public void run(){
        try {
            while(true){
                lista.adicionar(random.nextInt(100), id);
                Thread.sleep(3000);
            }
        } catch (InterruptedException e){System.out.println(e.getMessage());}
    }
}
