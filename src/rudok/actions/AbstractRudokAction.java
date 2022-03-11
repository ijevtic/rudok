package rudok.actions;

import rudok.model.error.ErrorFactory;
import rudok.model.error.ErrorType;
import rudok.model.graphictree.MyTreeNode;
import rudok.model.logictree.workspace.Project;
import rudok.utils.ProjectFileFilter;
import rudok.view.MainFrame;
import rudok.view.prezentacija.PrezentacijaView;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;

public abstract class AbstractRudokAction extends AbstractAction{
    public Icon loadIcon(String fileName) {
        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if(imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        else {
            System.out.println("Resource not found: " + fileName);
        }
        return icon;
    }

    public PrezentacijaView getFocusPresentation() {
        int index = MainFrame.getMainFrame().getProjectView().getTabbedPane().getSelectedIndex();
        if(index == -1) {
            ErrorFactory.getInstance().makeError(ErrorType.ILLEGAL_ACTION);
            return null;
        }
        PrezentacijaView p = MainFrame.getMainFrame().getProjectView().getListaPView().get(index);
        return p;
    }

    public void saveProject(Project project, File parentFile) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ProjectFileFilter());

        File projectFile=project.getProjectFile();
        if (!project.isChanged())
            return;

        if (project.getProjectFile()==null){
            if(parentFile != null)
                projectFile = new File(parentFile.getAbsolutePath() + "/" + project.getIme().replace(' ', '_') + ".gpf");
            else if(jfc.showSaveDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION) {
                projectFile=jfc.getSelectedFile();
                File p2 = projectFile.getParentFile();
                System.out.println(projectFile.getAbsolutePath());
                System.out.println(p2.getAbsolutePath());
                System.out.println(p2.getAbsolutePath() + "/" + project.getIme().replace(' ', '_') + ".gpf");
//                File novi = projectFile.getAbsolutePath() +
            }
            else return;
        }

        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(projectFile));
            os.writeObject(project);
            project.setProjectFile(projectFile);
            project.setChanged(true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
