package rudok.view.slot;

import rudok.model.Slot;
import rudok.view.MyTextPane;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class TextSlotHandler implements  ISlotHandler{
    @Override
    public void draw(Graphics2D g, SlotView slotView, int w, int h) {
        Slot model = slotView.getModel();
        MyTextPane p = slotView.getPane();
        p.setEditable(false);
        p.setText("");
        System.out.println(slotView.getModel().getContent().getS());
        p.formatString();
        CellRendererPane cellRendererPane=new CellRendererPane();
        cellRendererPane.paintComponent(g,p,slotView.getParent(),(int)(model.getStartX()*w), (int)(model.getStartY()*h)+5,(int)(model.getW()*w), (int)(model.getH()*h)-5);
    }
}
