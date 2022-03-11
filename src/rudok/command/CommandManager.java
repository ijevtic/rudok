package rudok.command;

import rudok.view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    List<AbstractCommand> commands;
    int currentCommand;

    public CommandManager() {
        this.commands = new ArrayList<>();
        currentCommand = 0;
        MainFrame.getMainFrame().getActionManager().getRedoAction().setEnabled(false);
        MainFrame.getMainFrame().getActionManager().getUndoAction().setEnabled(false);
    }

    public void addCommand(AbstractCommand command){
        while(currentCommand < commands.size())
            commands.remove(currentCommand);
        commands.add(command);
        doCommand();
    }

    public void doCommand(){
        if(currentCommand < commands.size()){
            commands.get(currentCommand).doCommand();
            currentCommand++;
            MainFrame.getMainFrame().getActionManager().getUndoAction().setEnabled(true);
        }
        if(currentCommand==commands.size()){
            MainFrame.getMainFrame().getActionManager().getRedoAction().setEnabled(false);
        }

        MainFrame.getMainFrame().getMyTreeModel().getRoot().napraviMyTreeNodeDecu();
        SwingUtilities.updateComponentTreeUI(MainFrame.getMainFrame().getMyTree());

    }

    public void undoCommand(){
        if(currentCommand > 0){
            MainFrame.getMainFrame().getActionManager().getRedoAction().setEnabled(true);
            currentCommand--;
            commands.get(currentCommand).undoCommand();
        }
        if(currentCommand==0){
            MainFrame.getMainFrame().getActionManager().getUndoAction().setEnabled(false);
        }
        MainFrame.getMainFrame().getMyTreeModel().getRoot().napraviMyTreeNodeDecu();

        SwingUtilities.updateComponentTreeUI(MainFrame.getMainFrame().getMyTree());
    }
}
