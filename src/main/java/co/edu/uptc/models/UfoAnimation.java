package co.edu.uptc.models;

public class UfoAnimation implements Runnable {
    private UfoGameModel ufoGameModel;
    private int spawnRate;

    public UfoAnimation(UfoGameModel ufoGameModel, int spawnRate) {
        this.ufoGameModel = ufoGameModel;
    }

    @Override
    public void run() {
        while (true) {
            ufoGameModel.moveAll();
            try {
                Thread.sleep(spawnRate); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

