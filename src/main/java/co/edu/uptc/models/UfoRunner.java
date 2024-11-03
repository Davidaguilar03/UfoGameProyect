package co.edu.uptc.models;

public class UfoRunner implements Runnable {
    private UfoGameModel ufoGameModel;
    public UfoRunner(UfoGameModel ufoGameModel) {
        this.ufoGameModel = ufoGameModel;
    }

    @Override
    public void run() {
        while (true) {
            ufoGameModel.moveAll();
            ufoGameModel.getPresenter().updateUFOs();
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

