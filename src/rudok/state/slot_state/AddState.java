package rudok.state.slot_state;

import rudok.view.StrokeType;

import java.awt.*;

public abstract class AddState implements SlotState {
    private int r=0,g=0,b=0;
    private final Stroke fill = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, null, 0);
    private final Stroke dash = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{7}, 0);
    private Stroke stroke = fill;
    public void setColor(Color c) {
        r = c.getRed();
        g = c.getGreen();
        b = c.getBlue();
    }

    public void setStroke(StrokeType type) {
        if(type == StrokeType.DASHED)
            stroke = dash;
        if(type == StrokeType.FULL)
            stroke = fill;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
