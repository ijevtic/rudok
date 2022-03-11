package rudok.view;

import rudok.model.logictree.RuNode;
import rudok.model.logictree.workspace.Prezentacija;
import rudok.model.logictree.workspace.Project;
import rudok.view.prezentacija.PrezentacijaView;
import rudok.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends JPanel implements ISubscriber {
    private Project model = null;
    private JLabel lImeProjekta;
    private JTabbedPane tabbedPane;
    private List<PrezentacijaView> listaPView;

    public ProjectView() {
        lImeProjekta = new JLabel("  ");
        listaPView = new ArrayList<>();

        this.setLayout(new BorderLayout());
        add(lImeProjekta, BorderLayout.NORTH);
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
    }

    @Override
    public void update(Object notification) {
        System.out.println("Usao u update Project View");
        if(model == null || model.getParent() == null || model.isObrisan()) {
            tabbedPane.removeAll();
            listaPView.clear();
            lImeProjekta.setText("Projekat nije obeležen");
            repaint();
            revalidate();
            return;
        }

        lImeProjekta.setText(model.getIme());
        List<Prezentacija> listaPrezentacija = pretvoriUPrezentaciju(model.getChildren());
        for (int i = 0; i < listaPView.size() && tabbedPane.getTabCount() > 0; i++) {
            Prezentacija p = listaPView.get(i).getModel();
            if(!listaPrezentacija.contains(p)){
                tabbedPane.remove(i);
                listaPView.remove(i);
                i--;
            }
        }
        List<Prezentacija> listaNaEkranu = uzmiSveSaEkrana();
        for(Prezentacija p:listaPrezentacija) {
            if(!listaNaEkranu.contains(p)) {
                PrezentacijaView view = new PrezentacijaView(p);
                dodajNaEkran(view);
                listaPView.add(view);
            }
        }
        osveziImena();
        validate();
    }

    public Project getModel() {
        return model;
    }

    public void setModel(Project model) {
        if(this.model != null)
            this.model.removeSubscriber(this);
        this.model = model;
        this.model.addSubscriber(this);
        this.update(new Object());
    }

    private PrezentacijaView uzmiSaEkrana(int index) {
        return (PrezentacijaView)tabbedPane.getComponentAt(index);
    }

    private void osveziImena() {
        for(int i = 0; i < tabbedPane.getTabCount(); i++) {
            tabbedPane.setTitleAt(i, uzmiSaEkrana(i).getModel().getIme());
        }
    }

    private void dodajNaEkran(PrezentacijaView view) {
        tabbedPane.addTab(view.getModel().getIme(), view);
    }

    private List<Prezentacija> pretvoriUPrezentaciju(List<RuNode> lista) {
        List<Prezentacija> l = new ArrayList<>();
        if(lista == null) return l;
        for(RuNode r:lista)
            l.add((Prezentacija) r);
        return l;
    }

    private List<Prezentacija> uzmiSveSaEkrana() {
        List<Prezentacija> lista = new ArrayList<>();
        for(int i = 0; i < listaPView.size(); i++)
            lista.add(listaPView.get(i).getModel());
        return lista;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public List<PrezentacijaView> getListaPView() {
        return listaPView;
    }

    public void setListaPView(List<PrezentacijaView> listaPView) {
        this.listaPView = listaPView;
    }
}
