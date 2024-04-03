import java.util.Observable;

public class Modelo extends Observable
{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Modelo()
    {
        super();
        x1 = 200;
        y1 = 17;
        x2 = 200;
        y2 = 125;
    }

    public void moverDerecha()
    {
        x1 += 10;
        x2 += 10;
        setChanged();
        notifyObservers();
    }

    public void moverIzquierda()
    {
        x1 -= 10;
        x2 -= 10;
        setChanged();
        notifyObservers();
    }

    public String getPosString()
    {
        return "Posicion: {(x1: " + x1 + " y1: " + y1 + ") (x2: " + x2 + " y2: " + y2 + ")}";
    }

    public int getX1()
    {
        return x1;
    }

    public int getY1()
    {
        return y1;
    }

    public int getX2()
    {
        return x2;
    }

    public int getY2()
    {
        return y2;
    }
}
