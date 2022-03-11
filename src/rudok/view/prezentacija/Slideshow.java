package rudok.view.prezentacija;

import rudok.view.SlajdView;
import rudok.view.VelicinaSlajda;
import rudok.view.toolbar.SlideshowToolbar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Slideshow extends APrezentacijaView {
    private SlideshowToolbar toolbar;
    private List<SlajdView> listaSlajdova;
    private CardLayout cardLayout;
    private JPanel panel;
    public Slideshow() {
        initialize();
    }

    public void initialize() {
//        this.setLayout(new CardLayout());
        toolbar = new SlideshowToolbar();
        add(toolbar);
        listaSlajdova = new ArrayList<>();
        cardLayout = new CardLayout();
        panel = new JPanel(cardLayout);
        panel.setMinimumSize(new Dimension(300,300));
        panel.setBackground(Color.RED);
        setSize(300,300);

        add(panel);
        setVisible(true);
        setContainer(panel);
    }

    @Override
    public void update(Object notification) {
        updateView(VelicinaSlajda.LARGE);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout c) {
        this.cardLayout = c;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

}
