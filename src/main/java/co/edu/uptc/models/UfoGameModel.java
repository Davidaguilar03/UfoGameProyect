package co.edu.uptc.models;
import co.edu.uptc.interfaces.UfoGameInterface;
import co.edu.uptc.interfaces.UfoGameInterface.Presenter;
import lombok.Data;

@Data
public class UfoGameModel implements UfoGameInterface.Model {
    private UfoGameInterface.Presenter presenter;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter=presenter;
    }

}
