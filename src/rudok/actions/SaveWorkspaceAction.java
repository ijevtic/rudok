package rudok.actions;

import rudok.model.logictree.workspace.Project;
import rudok.model.logictree.workspace.Workspace;
import rudok.utils.ProjectFileFilter;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveWorkspaceAction extends AbstractRudokAction{

    public SaveWorkspaceAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/filesave.png"));
        putValue(NAME, "Save workspace");
        putValue(SHORT_DESCRIPTION, "Save workspace");
    }

    public void actionPerformed(ActionEvent arg0) {
        JFileChooser jfc = new JFileChooser();
        Workspace ws = ((Workspace)MainFrame.getMainFrame().getMyTreeModel().getRoot().getNode());

        File workspaceFile = ws.getWorkspaceFile();
        if (ws.getWorkspaceFile()==null){
            if(jfc.showSaveDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION)
            {
                workspaceFile=jfc.getSelectedFile();
                try {
                    workspaceFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else return;
        }
        try {
            FileWriter myWriter = new FileWriter(workspaceFile);
            List<Project> lista = MainFrame.getMainFrame().getMyTree().getProjects();
            for(int i = 0; i < lista.size(); i++) {
                Project p = lista.get(i);
                saveProject(p, workspaceFile.getParentFile());
                String s = p.getProjectFile().getAbsolutePath();
                if(i < lista.size() - 1)
                    s += '\n';
                myWriter.write(s);
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

}

