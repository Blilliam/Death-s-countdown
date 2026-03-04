package Open;

import java.awt.Color;
import java.awt.Graphics2D;

import main.AppPanel;

public class OpenMap {
    public int tileSize = 10;
    public int rows = 50;
    public int cols = 50;
    public int[][] tiles = new int[rows][cols]; // 0 = floor, 1 = wall

    public OpenMap() {
        // Generate random map
        for(int r = 0; r < rows; r++) {
            for(int c=0; c<cols; c++) {
                if(Math.random() < 0.1) tiles[r][c] = 1; // 10% walls
                else tiles[r][c] = 0;
            }
        }
    }

    public void draw(Graphics2D g) {
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
            	g.setColor(Color.BLACK); // floor
            	g.fillRect((c * tileSize) + (AppPanel.WIDTH/2) - (cols * tileSize)/2, (r * tileSize) + (AppPanel.HEIGHT/2) - (rows * tileSize)/2, tileSize, tileSize);
            	
                if(tiles[r][c] == 0) {
                	g.setColor(Color.GREEN); // floor
                } else {
                	g.setColor(Color.GRAY); // wall
                }
   
                g.fillRect((c * tileSize) + (AppPanel.WIDTH/2) - (cols * tileSize)/2, (r * tileSize) + (AppPanel.HEIGHT/2) - (rows * tileSize)/2, tileSize - 2, tileSize - 2);
            }
        }
    }
}