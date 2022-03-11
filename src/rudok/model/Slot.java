package rudok.model;

import rudok.model.logictree.RuNode;
import rudok.serialization.SerializableStrokeAdapter;

import java.awt.*;

public class Slot extends RuNode {
    private double startX, startY;
    private double w, h;
    private int bojaR, bojaG, bojaB;
    private SerializableStrokeAdapter stroke;
    private SlotContent content;
    public Slot(double startX, double startY, double w, double h, int bojaR, int bojaG, int bojaB, Stroke stroke) {
        this.startX = startX;
        this.startY = startY;
        this.w = w;
        this.h = h;
        this.bojaR = bojaR;
        this.bojaG = bojaG;
        this.bojaB = bojaB;
        this.stroke = new SerializableStrokeAdapter(stroke);
        this.content = new SlotContent("content");
    }

    public void setPosition(double x, double y){
        startX = x;
        startY = y;
        notifySubscribers(new Object());
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public int getBojaR() {
        return bojaR;
    }

    public void setBojaR(int bojaR) {
        this.bojaR = bojaR;
    }

    public int getBojaG() {
        return bojaG;
    }

    public void setBojaG(int bojaG) {
        this.bojaG = bojaG;
    }

    public int getBojaB() {
        return bojaB;
    }

    public void setBojaB(int bojaB) {
        this.bojaB = bojaB;
    }

    public Stroke getStroke() {
        return stroke.getStroke();
    }

    public void setStroke(Stroke stroke) {
        this.stroke.setStroke(stroke);
    }

    public SlotContent getContent() {
        return content;
    }

    public void setContent(SlotContent content) {
        this.content = content;
    }
}
