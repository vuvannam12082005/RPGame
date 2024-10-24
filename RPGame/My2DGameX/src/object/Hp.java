package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Hp extends Superobject {
	public Hp() {
		this.name = "Hp";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/hp.png"));
           
            
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
