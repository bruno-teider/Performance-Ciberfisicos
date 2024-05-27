import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Jantar {
    public static void main(String[] args){
        Scanner  scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao Jantar dos Filósofos!");
        System.out.print("Quantos filósofos estarão na mesa: ");
        int n = scanner.nextInt();

        // Pares de garfos (quantos podem ser usados ao mesmo tempo)
        Semaphore semaphore = new Semaphore(n/2);

        for(int i = 0; i < n; i++){
            new Filosofo((i+1), semaphore).start();
        }
    }
}
