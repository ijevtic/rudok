package rudok.view.prezentacija;

import rudok.model.logictree.workspace.Prezentacija;
import rudok.state.appearence_state.AppearenceStateManager;
import rudok.state.slot_state.SlotStateManager;
import rudok.view.SlajdView;
import rudok.view.StrokeType;
import rudok.view.VelicinaSlajda;
import rudok.view.toolbar.EditPresentationToolbar;

import javax.swing.*;
import java.awt.*;

public class PrezentacijaView extends APrezentacijaView {
    private JLabel autor;
    private JPanel slajdPanel;
    private AppearenceStateManager appearenceStateManager;
    private SlotStateManager slotStateManager;
    private EditPresentationToolbar editToolbar;
    private JSplitPane editSplit;
    private JPanel editPanel;
    private Slideshow slideshowPanel;
    private PrezentacijaViewMini miniSlajdovi;

    public PrezentacijaView(Prezentacija m) {
        autor = new JLabel("autor");
        slajdPanel = new JPanel();
        appearenceStateManager = new AppearenceStateManager();
        slotStateManager = new SlotStateManager();
        editToolbar = new EditPresentationToolbar();
        miniSlajdovi = new PrezentacijaViewMini();
        slideshowPanel = new Slideshow();
        editPanel = new JPanel(new BorderLayout());
        JScrollPane scrollLeft = new JScrollPane(miniSlajdovi);
        scrollLeft.setMinimumSize(new Dimension(150,60));
        JScrollPane scrollRight = new JScrollPane(editPanel);

        editSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollLeft, scrollRight);
        setLayout(new BorderLayout());
        setupEditPanel();
        setContainer(slajdPanel);

        setModel(m);
    }

    @Override
    public void update(Object notification) {
        System.out.println("Prezentacija View");
        if(getModel() != null)
            autor.setText(getModel().getAutor());
        updateView(VelicinaSlajda.MEDIUM);
        setParentZaNoveSlajdove();
    }

    @Override
    public void setModel(Prezentacija model) {
        super.setModel(model);
        slideshowPanel.setModel(getModel());
        miniSlajdovi.setModel(getModel());
    }

    public void startEditState() {
        this.appearenceStateManager.setEditState();
        showAppearenceState();
    }

    public void startSlideshowState() {
        this.appearenceStateManager.setSlideshowState();
        showAppearenceState();
    }

    private void showAppearenceState() {
        this.appearenceStateManager.getCurrentState().show(this);
    }

    public void startCursorState() {this.slotStateManager.setCursorState(); }
    public void startDeleteSlotState() {this.slotStateManager.setDeleteSlotState();}
    public void startImageSlotState() {this.slotStateManager.setImageSlotState();}
    public void startTextSlotState() {this.slotStateManager.setTextSlotState();}
    public void startEditSlotState() {this.slotStateManager.setEditSlotState();}
    public void setColor(Color c) {this.slotStateManager.setColor(c);}
    public void setStroke(StrokeType type) {this.slotStateManager.setStroke(type);}

    public void executeSlotState(int x, int y, SlajdView s) {
        this.slotStateManager.getCurrentState().modify(x,y,s);
    }

    private void setupEditPanel() {
        JPanel north = new JPanel(new GridLayout(2,1));
        north.add(autor);
        north.add(editToolbar);
        editPanel.add(north, BorderLayout.NORTH);
        slajdPanel.setLayout(new BoxLayout (slajdPanel, BoxLayout.Y_AXIS));

        editPanel.add(slajdPanel, BorderLayout.CENTER);
        startEditState();
    }

    private void setParentZaNoveSlajdove()
    {
        for(int i = 0; i < slajdPanel.getComponentCount(); i++)
            if(((SlajdView)slajdPanel.getComponent(i)).getPrezentacijaView() == null)
                ((SlajdView)slajdPanel.getComponent(i)).setPrezentacijaView(this);
    }

    public JSplitPane getEditSplit() {
        return editSplit;
    }

    public void setEditSplit(JSplitPane editSplit) {
        this.editSplit = editSplit;
    }

    public AppearenceStateManager getAppearenceStateManager() {
        return appearenceStateManager;
    }

    public void setAppearenceStateManager(AppearenceStateManager stateManager) {
        this.appearenceStateManager = stateManager;
    }

    public Slideshow getSlideshowPanel() {
        return slideshowPanel;
    }

    public void setSlideshowPanel(Slideshow slideshowPanel) {
        this.slideshowPanel = slideshowPanel;
    }
}