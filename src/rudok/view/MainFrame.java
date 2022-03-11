package rudok.view;

import rudok.actions.ActionManager;
import rudok.command.CommandManager;
import rudok.model.error.ErrorClass;
import rudok.model.error.ErrorDialog;
import rudok.model.error.ErrorFactory;
import rudok.model.graphictree.MyTree;
import rudok.model.MyTreeModel;
import rudok.model.graphictree.MyTreeNode;
import rudok.model.logictree.workspace.Workspace;
import rudok.view.popup.SharePresentationDialog;
import rudok.view.popup.WorkspacePopup;
import rudok.view.toolbar.Toolbar;
import rudok.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainFrame extends JFrame implements ISubscriber
{
    private static MainFrame mainFrame = null;
    private rudok.view.Menu menu;
    private Toolbar toolbar;
    private ActionManager actionManager;
    private ProjectView projectView;
    private MyTreeModel myTreeModel;
    private MyTree myTree;
    private File workspaceFile;
    private CommandManager commandManager;
    private SharePresentationDialog sharePresentationDialog;


    private MainFrame() { }

    private void initialize() {

        actionManager = new ActionManager();
        projectView = new ProjectView();
        workspaceFile = null;
        commandManager = new CommandManager();


        myTree = new MyTree();

        WorkspacePopup popup = new WorkspacePopup();
        popup.setVisible(true);

        if(workspaceFile == null)
            myTreeModel = new MyTreeModel(new MyTreeNode(new Workspace("Workspace")));
        else
            myTreeModel = new MyTreeModel(new MyTreeNode(new Workspace("Workspace")), workspaceFile);
        myTree.setModel(myTreeModel);

        ErrorFactory.getInstance().addSubscriber(this);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(3*screenWidth / 5, 3*screenHeight / 5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu=new Menu();
        setJMenuBar(menu);
        toolbar=new Toolbar();
        add(toolbar, BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(myTree);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, projectView);
        add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);
    }

    public static MainFrame getMainFrame() {
        if(mainFrame == null){
            mainFrame = new MainFrame();
            mainFrame.initialize();
        }
        return mainFrame;
    }

    @Override
    public void update(Object notification) {
        ErrorDialog dialog = new ErrorDialog((ErrorClass)notification);
        dialog.setVisible(true);
    }

    public static void setMainFrame(MainFrame mainFrame) {
        MainFrame.mainFrame = mainFrame;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public MyTreeModel getMyTreeModel() {
        return myTreeModel;
    }

    public void setMyTreeModel(MyTreeModel myTreeModel) {
        this.myTreeModel = myTreeModel;
    }

    public MyTree getMyTree() {
        return myTree;
    }

    public void setMyTree(MyTree myTree) {
        this.myTree = myTree;
    }

    public ProjectView getProjectView() {
        return projectView;
    }

    public void setProjectView(ProjectView projectView) {
        this.projectView = projectView;
    }

    public File getWorkspaceFile() {
        return workspaceFile;
    }

    public void setWorkspaceFile(File workspaceFile) {
        this.workspaceFile = workspaceFile;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public SharePresentationDialog getSharePresentationDialog() {
        return sharePresentationDialog;
    }

    public void setSharePresentationDialog(SharePresentationDialog sharePresentationDialog) {
        this.sharePresentationDialog = sharePresentationDialog;
    }
}
