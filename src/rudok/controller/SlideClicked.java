package rudok.controller;

import rudok.view.SlajdView;
import rudok.view.slot.SlotView;
import rudok.view.prezentacija.PrezentacijaView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SlideClicked extends MouseAdapter {
    private SlajdView slajdView;
    public SlideClicked(SlajdView s){
        this.slajdView = s;
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("kliknut");
        PrezentacijaView prezentacijaView = slajdView.getPrezentacijaView();
        if(prezentacijaView == null) return;
        for(SlotView s:slajdView.getListaSlotova())
            if(s.slotElementAt(e.getX(), e.getY()))
                slajdView.setSelektovaniSlot(s);
        prezentacijaView.executeSlotState(e.getX(), e.getY(), slajdView);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        System.out.println("vuce se");
        PrezentacijaView prezentacijaView = slajdView.getPrezentacijaView();
        if(prezentacijaView == null) return;
        prezentacijaView.executeSlotState(e.getX(), e.getY(), slajdView);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        slajdView.setSelektovaniSlot(null);
    }
}
