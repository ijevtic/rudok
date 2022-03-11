package rudok.view.prezentacija;

import rudok.model.logictree.RuNode;
import rudok.model.logictree.workspace.Prezentacija;
import rudok.model.logictree.workspace.Slajd;
import rudok.view.SlajdView;
import rudok.view.VelicinaSlajda;
import rudok.observer.ISubscriber;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class APrezentacijaView extends JPanel implements ISubscriber {
    private Prezentacija model = null;
    private JPanel container;

    public void setModel(Prezentacija model) {
        if(this.model != null)
            this.model.removeSubscriber(this);
        this.model = model;
        this.model.addSubscriber(this);
        update(new Object());
    }

    public Prezentacija getModel() {
        return model;
    }

    void dodajNaEkran(Slajd s, JPanel panel, VelicinaSlajda v) {
        SlajdView view = new SlajdView(s, v);
        panel.add(view);
    }

    void updateView(VelicinaSlajda velicinaSlajda) {
        System.out.println("usao u A");
        if(container == null)
            return;
        if(model == null || model.getParent() == null) {
            container.removeAll();
            return;
        }
        List<Slajd> listaSlajdova = pretvoriUSlajd(model.getChildren());
        for (int i = 0; i < container.getComponentCount(); i++) {
            Slajd s = ((SlajdView)container.getComponent(i)).getModel();
            if(!listaSlajdova.contains(s)) {
                container.remove(i);
                i--;
            }
        }
        List<Slajd> listaNaEkranu = uzmiSveSaEkrana(container);
        for(Slajd s:listaSlajdova)
            if(!listaNaEkranu.contains(s)) {
                dodajNaEkran(s, container, velicinaSlajda);
            }
        for (int i = 0; i < container.getComponentCount(); i++) {
            ((SlajdView) container.getComponent(i)).update(new Object());
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    List<Slajd> pretvoriUSlajd(List<RuNode> lista) {
        List<Slajd> l = new ArrayList<>();
        if(lista == null) return l;
        for(RuNode r:lista)
            l.add((Slajd) r);
        return l;
    }

    List<Slajd> uzmiSveSaEkrana(JComponent component) {
        List<Slajd> lista = new ArrayList<>();
        for(int i = 0; i < component.getComponentCount(); i++)
            lista.add(((SlajdView)component.getComponent(i)).getModel());
        return lista;
    }

    public void setContainer(JPanel container) {
        this.container = container;
    }

    public JPanel getContainer() {
        return container;
    }
}
