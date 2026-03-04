package Open;

import java.awt.*;

public class OpenEnemy {
    public int x, y;
    public int width;
    public int height;
    public int speed;
    public int hp;
    
    public OpenEnemy() {
    	width = 28;
    	height = 28;
    	speed = 2;
    	hp = 30;
    }

    public void update(int playerX, int playerY) {
        if(x < playerX) x += speed;
        if(x > playerX) x -= speed;
        if(y < playerY) y += speed;
        if(y > playerY) y -= speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }
}