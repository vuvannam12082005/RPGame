package main;

import object.OBJ_Key;
import object.OBJ_Door;
import object.OBJ_Chest;


public class AssetSetter {

	Gamepanel gp;

	public AssetSetter(Gamepanel gp) {

		this.gp = gp ;

	}

	public void setObject() {
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldx = 23 * gp.tilesize; 
		gp.obj[0].worldy = 7 * gp.tilesize;
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldx = 23 * gp.tilesize;
		gp.obj[1].worldy = 40 * gp.tilesize;
		gp.obj[2] = new OBJ_Key();
		gp.obj[2].worldx = 37 * gp.tilesize;
		gp.obj[2].worldy = 7 * gp.tilesize;
		gp.obj[3] = new OBJ_Door();
		gp.obj[3].worldx = 10 * gp.tilesize;
		gp.obj[3].worldy = 11 * gp.tilesize;
		gp.obj[4] = new OBJ_Door();
		gp.obj[4].worldx = 8 * gp.tilesize;
		gp.obj[4].worldy = 28 * gp.tilesize;
		gp.obj[5] = new OBJ_Door();
		gp.obj[5].worldx = 12 * gp.tilesize;
		gp.obj[5].worldy = 22 * gp.tilesize;
		gp.obj[6] = new OBJ_Chest();
		gp.obj[6].worldx = 10 * gp.tilesize;
		gp.obj[6].worldy = 7 * gp.tilesize;
		

	}

}