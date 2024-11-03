package co.edu.uptc.interfaces;
import java.awt.Image;
import java.util.List;

import co.edu.uptc.models.Ufo;

public class UfoGameInterface {
    
 public interface Model {
        public void setPresenter(Presenter presenter);

        public void addUfo();

        public void moveAll();

        public List<Ufo> getUfos();

        public void setUfoImage(Image UfoImage);
    }

    public interface View {
        public void setPresenter(Presenter presenter);

        public void begin();

    }

    public interface Presenter {
        public void addUfo();

        public void moveAll();

        public List<Ufo> getUfos();

        public void setUfoImage(Image UfoImage);

        public void setView(View view);

        public void setModel(Model model);

    }
}
