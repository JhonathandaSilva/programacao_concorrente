package aula3_pcn;

import java.util.concurrent.Semaphore;

public class JantarDosFilosofos {

    static class Filosofo extends Thread {
        private final int id;
        private final Semaphore garfoEsquerdo;
        private final Semaphore garfoDireito;


        public Filosofo(int id, Semaphore garfoEsquerdo, Semaphore garfoDireito) {
            this.id = id;
            this.garfoEsquerdo = garfoEsquerdo;
            this.garfoDireito = garfoDireito;

        }

        public void run() {
            try {
                while (true) {
                    pensar();
                    pegarGarfos();
                    comer();
                    liberarGarfos();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void pensar() throws InterruptedException {
            System.out.println("Filósofo " + id + " está pensando");
            Thread.sleep((long) (Math.random() * 100));
        }

        private void pegarGarfos() throws InterruptedException {
        
            System.out.println("Filósofo " + id + " está com fome");
            garfoEsquerdo.acquire();
            garfoDireito.acquire();
            
        }

        private void comer() throws InterruptedException {
            System.out.println("Filósofo " + id + " está comendo");
            Thread.sleep((long) (Math.random() * 100));
        }

        private void liberarGarfos() {
            garfoEsquerdo.release();
            garfoDireito.release();
        }
    }
}