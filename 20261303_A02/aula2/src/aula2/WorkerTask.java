package aula2;

class WorkerTask implements Runnable {

    private int taskId;

    public WorkerTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();

        System.out.println("Task " + taskId + " started by " + threadName);

        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task " + taskId + " finished by " + threadName);
    }
}