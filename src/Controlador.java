import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controlador extends JFrame
{
    private Modelo mod;
    private JButton btnDerecha = new JButton("Mover Derecha");
    private JButton btnIzquierda = new JButton("Mover Izquierda");
    private LabelPos lblPos;
    private JPanel pnlBotones = new JPanel();
    private Vista canvas;

    public Controlador()
    {
        mod = new Modelo();
        lblPos = new LabelPos(mod);
        canvas = new Vista(mod);
        mod.addObserver(canvas);
        mod.addObserver(lblPos);

        setLayout(new BorderLayout());
        setTitle("MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnlBotones.setLayout(new FlowLayout());
        pnlBotones.add(btnIzquierda);
        pnlBotones.add(btnDerecha);

        add(lblPos, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(pnlBotones, BorderLayout.SOUTH);

        btnDerecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                mod.moverDerecha();
            }
        });
        btnIzquierda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                mod.moverIzquierda();
            }
        });

        canvas.setFocusable(true);
        canvas.requestFocusInWindow();
        canvas.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_LEFT)
                {
                    mod.moverIzquierda();
                }else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    mod.moverDerecha();
                }
            }
        });

        setBounds(300, 300, 400, 200);
        setVisible(true);
        pack();
    }
}
