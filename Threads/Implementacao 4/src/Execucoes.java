public class Execucoes {
    public static void umaThread(){
        double[] vetor = new double[200_000_000];
        long inicio = System.currentTimeMillis();

        Thread t1 = new MinhaThread(vetor, 0, vetor.length);

        t1.start();

        try {
            t1.join();
        }
        catch (InterruptedException e) { e.printStackTrace(); }

        long duracao = System.currentTimeMillis() - inicio;
        System.out.println("Tempo de execução com 1 thread: " + duracao);
    }

    public static void duasThread(){
        double[] vetor = new double[200_000_000];
        long inicio = System.currentTimeMillis();

        Thread t1 = new MinhaThread(vetor, 0, (vetor.length/2));
        Thread t2 = new MinhaThread(vetor, (vetor.length/2), vetor.length);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) { e.printStackTrace(); }

        long duracao = System.currentTimeMillis() - inicio;
        System.out.println("Tempo de execução com 2 thread: " + duracao);
    }

    public static void tresThread(){
        double[] vetor = new double[200_000_000];
        long inicio = System.currentTimeMillis();

        Thread t1 = new MinhaThread(vetor, 0, (vetor.length/3));
        Thread t2 = new MinhaThread(vetor, (vetor.length/3), ((vetor.length/3)*2));
        Thread t3 = new MinhaThread(vetor, ((vetor.length/3)*2), vetor.length);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e) { e.printStackTrace(); }

        long duracao = System.currentTimeMillis() - inicio;
        System.out.println("Tempo de execução com 3 thread: " + duracao);
    }

    public static void quatroThread(){
        double[] vetor = new double[200_000_000];
        long inicio = System.currentTimeMillis();

        Thread t1 = new MinhaThread(vetor, 0, (vetor.length/4));
        Thread t2 = new MinhaThread(vetor, (vetor.length/4), ((vetor.length/4)*2));
        Thread t3 = new MinhaThread(vetor, ((vetor.length/4)*2), ((vetor.length/4)*3));
        Thread t4 = new MinhaThread(vetor, ((vetor.length/4)*3), vetor.length);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch (InterruptedException e) { e.printStackTrace(); }

        long duracao = System.currentTimeMillis() - inicio;
        System.out.println("Tempo de execução com 4 thread: " + duracao);
    }
}
