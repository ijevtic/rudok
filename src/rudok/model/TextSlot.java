package rudok.model;

import java.awt.*;

public class TextSlot extends Slot{
    public TextSlot(double startX, double startY, double w, double h, int bojaR, int bojaG, int bojaB, Stroke stroke) {
        super(startX, startY, w, h, bojaR, bojaG, bojaB, stroke);
        setContent(new SlotContent("ovo je text"));
    }
}
