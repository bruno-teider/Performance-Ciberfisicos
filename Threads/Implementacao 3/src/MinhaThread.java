public class MinhaThread extends Thread{
    String nome;

    public MinhaThread(String nome){ this.nome = nome; }

    public void run(){
        System.out.println("Bem vindo!");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Adeus!");
    }
}
