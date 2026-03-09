package Open.Entities;

import java.awt.Color;
import java.awt.Graphics2D;

import main.AppPanel;
import main.GameObject;

public abstract class OpenEntity {

    public int x, y; // world coordinates
    
    public int width;
    public int height;
    
    public int speed; // pixels per update
    public int hp;

    public GameObject gameObj;

    public OpenEntity(GameObject gameObj) {
        this.gameObj = gameObj;
    }

    // Follow player
    public abstract void update();

    // Draw relative to player
    public abstract void draw(Graphics2D g);
    
    public static boolean rectCollision(OpenEntity e1, OpenEntity e2) {
        return e1.x < e2.x + e2.width &&
               e1.x + e1.width > e2.x &&
               e1.y < e2.y + e2.height &&
               e1.y + e1.height > e2.y;
    }
}
