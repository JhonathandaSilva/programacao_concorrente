package aula3_pcn;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        int N = 5;

        Semaphore[] garfos = new Semaphore[N];

        for (int i = 0; i < N; i++) {
            garfos[i] = new Semaphore(1);
        }

        for (int i = 0; i < N; i++) {
            new JantarDosFilosofos.Filosofo(
                i,
                garfos[i],
                garfos[(i + 1) % N]
            ).start();
        }
    }
}