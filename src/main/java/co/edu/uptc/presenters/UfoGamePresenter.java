package co.edu.uptc.presenters;
import co.edu.uptc.interfaces.*;
import co.edu.uptc.interfaces.UfoGameInterface.Model;
import co.edu.uptc.interfaces.UfoGameInterface.View;
import lombok.Data;

@Data
public class UfoGamePresenter implements UfoGameInterface.Presenter{
    private UfoGameInterface.Model model;
    private UfoGameInterface.View view;

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

}
