package rudok.view;

import rudok.controller.SlideClicked;
import rudok.model.logictree.workspace.Prezentacija;
import rudok.model.logictree.workspace.Slajd;
import rudok.model.Slot;
import rudok.view.prezentacija.PrezentacijaView;
import rudok.observer.ISubscriber;
import rudok.view.slot.EditSlotHandler;
import rudok.view.slot.ISlotHandler;
import rudok.view.slot.SlotView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SlajdView extends JPanel implements ISubscriber{
    private JLabel brojSlajda;
    private Slajd model;
    private List<SlotView> listaSlotova;
    private PrezentacijaView prezentacijaView;
    private int x;
    private SlotView selektovaniSlot = null;
    private ISlotHandler slotHandler;

    public SlajdView(Slajd m, VelicinaSlajda v) {
        setLayout(null);
        if(v == VelicinaSlajda.LARGE) x = 120;
        else slotHandler = new EditSlotHandler();
        if(v == VelicinaSlajda.MEDIUM) x = 100;
        if(v == VelicinaSlajda.SMALL) x = 30;
        setPreferredSize(new Dimension((int)(x*3.6),2*x));
        setMaximumSize(new Dimension((int)(x*3.6),2*x));

        listaSlotova = new ArrayList<>();
        brojSlajda = new JLabel();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black,2));
        add(brojSlajda, BorderLayout.SOUTH);
        setModel(m);

        SlideClicked listener = new SlideClicked(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        String url = ((Prezentacija)model.getParent()).getBackground();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(url));
        } catch (IOException e) { }
        g.drawImage(img,0,0,getWidth(),getHeight(),null);

        for(SlotView s: listaSlotova)
            s.paint((Graphics2D) g);
        SwingUtilities.updateComponentTreeUI(this);
    }

    @Override
    public void update(Object notification) {
        if(model != null) {
            brojSlajda.setText(String.valueOf(model.getRedniBroj()));
        }

        List<Slot> modelSlotovi = model.getChildren();
        for(int i = 0; i < listaSlotova.size(); i++)
        {
            SlotView s = listaSlotova.get(i);
            if(!modelSlotovi.contains(s.getModel())) {
                listaSlotova.remove(s);
                i--;
            }
        }
        List<Slot> ekranSlotovi = uzmiSveSaEkrana();
        for(int i = 0; i < modelSlotovi.size(); i++)
        {
            if(!ekranSlotovi.contains(modelSlotovi.get(i)))
                listaSlotova.add(new SlotView(modelSlotovi.get(i), this, slotHandler));
        }

        SwingUtilities.updateComponentTreeUI(this);
//        repaint();
    }

    private List<Slot> uzmiSveSaEkrana() {
        List<Slot> lista = new ArrayList<>();
        for(SlotView s: listaSlotova)
            lista.add(s.getModel());
        return lista;
    }

    public Slajd getModel() {
        return this.model;
    }

    public void setModel(Slajd model) {
        if(this.model != null)
            model.removeSubscriber(this);
        this.model = model;
        this.model.addSubscriber(this);
        this.update(new Object());
    }

    public PrezentacijaView getPrezentacijaView() {
        return prezentacijaView;
    }

    public void setPrezentacijaView(PrezentacijaView prezentacijaView) {
        this.prezentacijaView = prezentacijaView;
    }

    public List<SlotView> getListaSlotova() {
        return listaSlotova;
    }

    public void setListaSlotova(List<SlotView> listaSlotova) {
        this.listaSlotova = listaSlotova;
    }

    public SlotView getSelektovaniSlot() {
        return selektovaniSlot;
    }

    public void setSelektovaniSlot(SlotView selektovaniSlot) {
        this.selektovaniSlot = selektovaniSlot;
    }
}
