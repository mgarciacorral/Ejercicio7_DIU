import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class LabelPos extends JPanel implements Observer
{
    private Modelo mod;
    private JLabel lblPos = new JLabel(" Posicion(X, Y)");

    public LabelPos(Modelo mod)
    {
        this.mod = mod;
        add(lblPos);
    }
    public void update(Observable o, Object arg)
    {
        lblPos.setText(mod.getPosString());
    }
}
