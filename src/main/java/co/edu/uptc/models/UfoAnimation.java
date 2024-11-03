package co.edu.uptc.models;

public class UfoAnimation implements Runnable {
    private UfoGameModel controller;

    public UfoAnimation(UfoGameModel controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        while (true) {
            controller.moveAll();
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

