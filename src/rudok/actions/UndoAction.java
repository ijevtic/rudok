package rudok.actions;

import rudok.view.MainFrame;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractRudokAction{

        public UndoAction(){
            putValue(NAME, "Undo");
            putValue(SHORT_DESCRIPTION, "Undo");
            putValue(SMALL_ICON,loadIcon("img/undo.png"));

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MainFrame.getMainFrame().getCommandManager().undoCommand();
        }
}
