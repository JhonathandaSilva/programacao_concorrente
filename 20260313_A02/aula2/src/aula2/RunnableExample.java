package aula2;

public class RunnableExample {

    public static void main(String[] args) {

        for (int i = 1; i <= 8; i++) {

            WorkerTask task = new WorkerTask(i);

            Thread thread = new Thread(task);

            thread.start();
        }

    }
}