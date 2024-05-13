public class MinhaThread implements Runnable{
    String nome;

    public MinhaThread(String nome){ this.nome = nome; }

    public void run(){
        int counter = 0;
        System.out.println("-- Início da " + nome + " --");
        while (counter < 1000){
            System.out.println(nome + ": " + counter);
            counter++;
        }
    }
}
