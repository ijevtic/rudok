package rudok;


import rudok.view.MainFrame;

public class MyApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        InfoPopup pop = new InfoPopup();
        MainFrame b = MainFrame.getMainFrame();
        b.setLocationRelativeTo(null);
        b.setVisible(true);
    }



}

