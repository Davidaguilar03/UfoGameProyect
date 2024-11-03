package co.edu.uptc.models;

public class UfoAnimation implements Runnable {
    private UfoGameModel ufoGameModel;
    public UfoAnimation(UfoGameModel ufoGameModel) {
        this.ufoGameModel = ufoGameModel;
    }

    @Override
    public void run() {
        while (true) {
            ufoGameModel.moveAll();
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

