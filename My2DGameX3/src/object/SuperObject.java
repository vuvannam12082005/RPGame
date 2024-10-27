package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.Gamepanel;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldx, worldy;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultx = 0;
	public int solidAreaDefaulty = 0;

    public void draw(Graphics2D g2, Gamepanel gp) {

        int screenx = worldx - gp.player.worldx + gp.player.screenx;
        int screeny = worldy - gp.player.worldy + gp.player.screeny;

        if(worldx + gp.tilesize > gp.player.worldx - gp.player.screenx &&
           worldx - gp.tilesize < gp.player.worldx + gp.player.screenx &&
           worldy + gp.tilesize > gp.player.worldy - gp.player.screeny &&
           worldy - gp.tilesize < gp.player.worldy + gp.player.screeny) {

            g2.drawImage(image, screenx, screeny, gp.tilesize, gp.tilesize, null);
        }
    }
}
