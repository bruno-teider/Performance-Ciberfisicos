import java.util.Random;

public class MinhaThread extends Thread{
    double[] vetor;
    int inicio;
    int fim;

    public MinhaThread(double[] vetor, int inicio, int fim){
        this.vetor = vetor;
        this.inicio = inicio;
        this.fim = fim;
    }

    public void run(){
        Random rand = new Random();

        for(int i = inicio; i < fim; i++){
            vetor[i] = rand.nextDouble();
        }
    }
}
