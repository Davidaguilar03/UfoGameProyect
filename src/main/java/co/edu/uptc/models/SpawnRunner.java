package co.edu.uptc.models;

public class SpawnRunner implements Runnable {
    private UfoGameModel ufoGameModel;

    public SpawnRunner(UfoGameModel ufoGameModel) {
        this.ufoGameModel = ufoGameModel;
    }

    @Override
    public void run() {
        int createdUfos = 0;
        while (createdUfos < ufoGameModel.getNumberofUfos()) {
            ufoGameModel.addUfo(ufoGameModel.getSpeed()); 
            createdUfos++;
            ufoGameModel.getPresenter().updateUFOs(); 
            try {
                Thread.sleep(ufoGameModel.getSpawnRate()); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}