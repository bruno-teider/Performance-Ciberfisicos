public class Programa {
    public static void main(String[] args){
        Lista lista = new Lista();

        for(int i = 0; i < 3; i++){
            new ThreadProdutor((i+1), lista).start();
        }

        for(int i = 0; i < 2; i++){
            new ThreadConsumidor((i+1), lista).start();
        }
    }
}
