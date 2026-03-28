package aula3_pcn;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        int N = 5; // número de filósofos

        Semaphore[] garfos = new Semaphore[N];
        Semaphore mutex = new Semaphore(1);

        // Inicializa os garfos
        for (int i = 0; i < N; i++) {
            garfos[i] = new Semaphore(1);
        }

        // Cria e inicia os filósofos
        for (int i = 0; i < N; i++) {
            JantarDosFilosofos.Filosofo filosofo =
                new JantarDosFilosofos.Filosofo(
                    i,
                    garfos[i],
                    garfos[(i + 1) % N],
                    mutex
                );

            filosofo.start();
        }
    }
}