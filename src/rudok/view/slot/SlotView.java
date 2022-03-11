package rudok.view.slot;

import rudok.actions.AbstractRudokAction;
import rudok.controller.EditImageSlotController;
import rudok.controller.EditTextSlotController;
import rudok.controller.IEditSlotController;
import rudok.model.Slot;
import rudok.model.TextSlot;
import rudok.observer.ISubscriber;
import rudok.view.MyTextPane;
import rudok.view.SlajdView;

import javax.swing.*;
import java.awt.*;


public class SlotView implements ISubscriber {
    private Slot model;
    private SlajdView parent;
    private Shape shape;
    private IEditSlotController dialogAction;
    private ISlotHandler slotHandler;
    private MyTextPane pane;
    public SlotView(Slot model, SlajdView parent, ISlotHandler slotHandler) {
        this.parent = parent;
        pane = new MyTextPane(this);
        this.slotHandler = slotHandler;
        shape = new Rectangle();
        setModel(model);
    }

    public MyTextPane getPane() {
        return pane;
    }

    public void setPane(MyTextPane pane) {
        this.pane = pane;
    }

    @Override
    public void update(Object notification) {
        setShape();
    }

    private void setShape(){
        double w = parent.getWidth();
        double h = parent.getHeight();
        ((Rectangle)shape).setRect((int)(model.getStartX()*w), (int)(model.getStartY()*h), (int)(model.getW()*w), (int)(model.getH()*h));
    }

    public void paint(Graphics2D g) {
        int w = this.parent.getWidth();
        int h = this.parent.getHeight();
        slotHandler.draw(g, this, w, h);
        g.setColor(new Color(model.getBojaR(), model.getBojaG(), model.getBojaB(), 150));
        g.setStroke(model.getStroke());
        g.drawRect((int)(model.getStartX()*w), (int)(model.getStartY()*h), (int)(model.getW()*w), (int)(model.getH()*h));
    }

    public void setModel(Slot model) {
        if(this.model != null)
            model.removeSubscriber(this);
        this.model = model;
        this.model.addSubscriber(this);
        this.update(new Object());

        if(this.model instanceof TextSlot)
        {
            dialogAction = new EditTextSlotController();
            if(slotHandler == null) {
                slotHandler = new TextSlotHandler();
//                this.parent.add(pane);
            }
        }
        else
            dialogAction = new EditImageSlotController();
        if(slotHandler == null)
            slotHandler = new ImageSlotHandler();
    }

    public boolean slotElementAt(int x, int y) {
        return shape.contains(new Point(x,y));
    }

    public Slot getModel() {
        return this.model;
    }

    public IEditSlotController getDialogAction() {
        return dialogAction;
    }

    public void setDialogAction(IEditSlotController action) {
        this.dialogAction = action;
    }

    public SlajdView getParent() {
        return parent;
    }

    public void setParent(SlajdView parent) {
        this.parent = parent;
    }
}
