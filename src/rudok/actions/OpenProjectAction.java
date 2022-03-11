package rudok.actions;

import rudok.model.logictree.workspace.Project;
import rudok.utils.ProjectFileFilter;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenProjectAction extends AbstractRudokAction {



    public OpenProjectAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/fileopen.png"));
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open project");
    }

    public void actionPerformed(ActionEvent arg0) {
        JFileChooser jfc = new JFileChooser();
//        jfc.setFileFilter(new ProjectFileFilter());

        if(jfc.showOpenDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION){
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));

                Project p=null;
                try {
                    p = (Project) os.readObject();
                } catch (ClassNotFoundException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                MainFrame.getMainFrame().getMyTree().addProject(p);
                MainFrame.getMainFrame().getProjectView().setModel(p);

//                for (int i=0;i<p.getChildCount();i++){
//                    DiagramView view=new DiagramView();
//                    p.getDiagram(i).getModel().addUpdateListener(p);
//                    view.setDiagram(p.getDiagram(i));
//
//                    AppCore.getInstance().getDesktop().add(view);
//                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }


        }
    }
}
