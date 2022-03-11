package rudok.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {
    public Menu (){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getMainFrame().getActionManager().getNewComponentAction());
        fileMenu.add(MainFrame.getMainFrame().getActionManager().getInfoAction());
        fileMenu.add(MainFrame.getMainFrame().getActionManager().getDeleteComponentAction());
        JMenu editMenu = new JMenu("Edit");
        editMenu.add(MainFrame.getMainFrame().getActionManager().getEditAutorAction());
        editMenu.add(MainFrame.getMainFrame().getActionManager().getEditBackgroundAction());
        this.add(fileMenu);
        this.add(editMenu);

    }

}
