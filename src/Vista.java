import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Vista extends JPanel implements Observer {
    Modelo model;
    public Vista(Modelo m) {
        setBackground(Color.CYAN);
        model = m;
        setPreferredSize(new Dimension(400, 150));
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(model.getX1(), model.getY1(), model.getX2(), model.getY2());
    }
    public void update(Observable obs, Object obj) {
        repaint();
        requestFocusInWindow();
    }
}