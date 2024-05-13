public class Programa {
    public static void main(String[] args){
        System.out.println("-- Início do programa --");

        Execucoes.umaThread();
        Execucoes.duasThread();
        Execucoes.tresThread();
        Execucoes.quatroThread();

        System.out.println("-- Fim do programa --");
    }
}
