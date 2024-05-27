public class ThreadConsumidor extends Thread{
    private Lista lista;
    private int id;

    public ThreadConsumidor(int id, Lista lista){
        this.lista = lista;
        this.id = id;
    }

    public void run(){
        try {
            while (true){
                lista.remover(id);
                Thread.sleep(5000);
            }
        } catch (InterruptedException e){System.out.println(e.getMessage());}
    }
}
