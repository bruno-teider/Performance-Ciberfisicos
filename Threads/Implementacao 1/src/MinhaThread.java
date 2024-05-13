public class MinhaThread extends Thread{
    String nome;
    int counter = 0;

    public MinhaThread(String nome){ this.nome = nome; }

    public void run(){
        System.out.println("-- Início da " + nome + " --");
        while (counter < 1000){
            System.out.println(nome + ": " + counter);
            counter++;
        }
    }
}
