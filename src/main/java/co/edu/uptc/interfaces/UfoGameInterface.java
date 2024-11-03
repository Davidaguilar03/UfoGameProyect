package co.edu.uptc.interfaces;

import java.util.List;

import co.edu.uptc.pojos.Ufo;

public class UfoGameInterface {

    public interface Model {
        public void setPresenter(Presenter presenter);

        public void addUfo(int speed);

        public List<Ufo> getUfos();

        public void startGame();
    }

    public interface View {
        public void setPresenter(Presenter presenter);

        public void updateUFOs();

        public void begin();

    }

    public interface Presenter {

        public void setView(View view);

        public void setModel(Model model);

        public void addUfo(int speed);

        public List<Ufo> getUfos();

        public void startGame();

        public void updateUFOs();
    }
}
