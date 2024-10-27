package main;

import entity.Entity;

public class Collisioncheck {
    Gamepanel gp;

    public Collisioncheck(Gamepanel gp) {
        this.gp = gp;
    }

    // Method để check va chạm của entity với tiles
    public void CheckTile(Entity entity) {
        int entityleftworldx = entity.worldx + entity.solidarea.x;
        int entityrightwordx = entity.worldx + entity.solidarea.x + entity.solidarea.width;
        int entitytopworldy = entity.worldy + entity.solidarea.y;
        int entitybotworldy = entity.worldy + entity.solidarea.y + entity.solidarea.height;

        int entityleftcol = entityleftworldx / gp.tilesize;
        int entityrightcol = entityrightwordx / gp.tilesize;
        int entitytoprow = entitytopworldy / gp.tilesize;
        int entitybotrow = entitybotworldy / gp.tilesize;

        int tilenum1, tilenum2;
        switch (entity.direction) {
            case "up":
                entitytoprow = (entitytopworldy - entity.speed) / gp.tilesize;
                tilenum1 = gp.tileM.maptilenum[entityleftcol][entitytoprow];
                tilenum2 = gp.tileM.maptilenum[entityrightcol][entitytoprow];
                if (gp.tileM.tile[tilenum1].collision == true || gp.tileM.tile[tilenum2].collision == true) {
                    entity.collisionon = true;
                }
                break;
            case "down":
                entitybotrow = (entitybotworldy + entity.speed) / gp.tilesize;
                tilenum1 = gp.tileM.maptilenum[entityleftcol][entitybotrow];
                tilenum2 = gp.tileM.maptilenum[entityrightcol][entitybotrow];
                if (gp.tileM.tile[tilenum1].collision == true || gp.tileM.tile[tilenum2].collision == true) {
                    entity.collisionon = true;
                }
                break;
            case "left":
                entityleftcol = (entityleftworldx - entity.speed) / gp.tilesize;
                tilenum1 = gp.tileM.maptilenum[entityleftcol][entitytoprow];
                tilenum2 = gp.tileM.maptilenum[entityleftcol][entitybotrow];
                if (gp.tileM.tile[tilenum1].collision == true || gp.tileM.tile[tilenum2].collision == true) {
                    entity.collisionon = true;
                }
                break;
            case "right":
                entityrightcol = (entityrightwordx + entity.speed) / gp.tilesize;
                tilenum1 = gp.tileM.maptilenum[entityrightcol][entitytoprow];
                tilenum2 = gp.tileM.maptilenum[entityrightcol][entitybotrow];
                if (gp.tileM.tile[tilenum1].collision == true || gp.tileM.tile[tilenum2].collision == true) {
                    entity.collisionon = true;
                }
                break;
        }
    }

    // Method để check va chạm của entity với objects
    public int CheckObject(Entity entity, boolean player) {
        int index = 999;
        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                // Lưu giá trị gốc của solidArea
                int entitySolidAreaX = entity.solidarea.x;
                int entitySolidAreaY = entity.solidarea.y;
                int objectSolidAreaX = gp.obj[i].solidArea.x;
                int objectSolidAreaY = gp.obj[i].solidArea.y;

                // Thiết lập tọa độ thực tế của solidArea
                entity.solidarea.x += entity.worldx;
                entity.solidarea.y += entity.worldy;
                gp.obj[i].solidArea.x += gp.obj[i].worldx;
                gp.obj[i].solidArea.y += gp.obj[i].worldy;

                switch (entity.direction) {
                    case "up":
                        entity.solidarea.y -= entity.speed;
                        if (entity.solidarea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionon = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidarea.y += entity.speed;
                        if (entity.solidarea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionon = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidarea.x -= entity.speed;
                        if (entity.solidarea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionon = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidarea.x += entity.speed;
                        if (entity.solidarea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionon = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                }

                // Đặt lại tọa độ gốc của solidArea
                entity.solidarea.x = entitySolidAreaX;
                entity.solidarea.y = entitySolidAreaY;
                gp.obj[i].solidArea.x = objectSolidAreaX;
                gp.obj[i].solidArea.y = objectSolidAreaY;
            }
        }
        return index;
    }
}
