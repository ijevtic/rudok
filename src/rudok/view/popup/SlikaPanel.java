package rudok.view.popup;

import rudok.model.logictree.workspace.Prezentacija;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SlikaPanel extends JPanel {
    private String path = "";
    public SlikaPanel(String path) {
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
        SwingUtilities.updateComponentTreeUI(this);
    }

    public String getPath() {
        return path;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String url = path;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(url));
        } catch (IOException e) { }
        g.drawImage(img,0,0,getWidth(),getHeight(),null);
    }
}
