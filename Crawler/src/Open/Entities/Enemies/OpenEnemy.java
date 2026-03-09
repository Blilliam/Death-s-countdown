package Open.Entities.Enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Open.Entities.OpenEntity;
import main.AppPanel;
import main.Assets;
import main.GameObject;

public class OpenEnemy extends OpenEntity {
	
	public int numberOfEnemySprites = 6;
	public BufferedImage sprite;
	

    public OpenEnemy(GameObject gameObj, int x, int y, int teir) {
        super(gameObj);
        
        sprite = getEnemySprite((int)(Math.random() * 6) + 1);
        
        this.x = x;
        this.y = y;
        
        width = 100;
        height = 100;
        
        speed = 10; // pixels per update
        
        hp = teir * 10;
    }

    // Follow player
    public void update() {
    	double dx = gameObj.player.x - x;
    	double dy = gameObj.player.y - y;
    	double dist = Math.sqrt(dx*dx + dy*dy);

    	if (dist > 0) {
    	    double moveX = (dx / dist) * speed;
    	    double moveY = (dy / dist) * speed;

    	    // Smooth the movement a bit
    	    x += moveX * 0.5 + (Math.random() - 0.5) * 0.3;
    	    y += moveY * 0.5 + (Math.random() - 0.5) * 0.3;
    	}

    }

    public BufferedImage getEnemySprite(int num) {
    	switch (num) {
		case 1: {
			return Assets.zombie;
		} case 2: {
			return Assets.mummy;
		} case 3: {
			return Assets.ghost;
		} case 4: {
			return Assets.werewolf;
		} case 5: {
			return Assets.mudman;
		} case 6: {
			return Assets.skeleton;
		}
		default:
			return null;
		}
    }

    // Draw relative to player
    public void draw(Graphics2D g) {
        int screenX = x - gameObj.player.x + AppPanel.WIDTH / 2 - width/2;
        int screenY = y - gameObj.player.y + AppPanel.HEIGHT / 2 - height/2;
        g.drawImage(sprite, screenX, screenY, width, height, null);
    }
}