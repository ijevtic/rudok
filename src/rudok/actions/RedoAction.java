package rudok.actions;

import rudok.view.MainFrame;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractRudokAction {

        public RedoAction(){
            putValue(NAME, "Redo");
            putValue(SHORT_DESCRIPTION, "Redo");
            putValue(SMALL_ICON,loadIcon("img/redo.png"));

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MainFrame.getMainFrame().getCommandManager().doCommand();
        }
}
