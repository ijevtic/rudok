package rudok.view.slot;

import rudok.model.Slot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSlotHandler implements ISlotHandler{
    @Override
    public void draw(Graphics2D g, SlotView slotView, int w, int h) {
        String url = slotView.getModel().getContent().getS();
        Slot model = slotView.getModel();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(url));
        } catch (IOException e) {
        }
        g.drawImage(img, (int)(model.getStartX()*w), (int)(model.getStartY()*h), (int)(model.getW()*w), (int)(model.getH()*h), null);
    }
}
