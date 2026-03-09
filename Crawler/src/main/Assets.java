package main;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Assets {

    // Weapons
    public static BufferedImage knife;
    public static BufferedImage whip;
    public static BufferedImage axe;
    public static BufferedImage cross;
    public static BufferedImage kingBible;
    public static BufferedImage magicWand;
    public static BufferedImage fireWand;
    
    public static BufferedImage manaSphere;

    // Enemies
    public static BufferedImage zombie;
    public static BufferedImage mummy;
    public static BufferedImage skeleton;
    public static BufferedImage ghost;
    public static BufferedImage mantichana;
    public static BufferedImage werewolf;
    public static BufferedImage mudman;
    
    public static BufferedImage playerSheet;

    public static void load(){
        try{
            // Weapons
            knife = ImageIO.read(Assets.class.getResource("/Images/Items/Sprite-Knife.png"));
            whip = ImageIO.read(Assets.class.getResource("/Images/Items/Sprite-Whip.png"));
            axe = ImageIO.read(Assets.class.getResource("/Images/Items/Sprite-Axe.png"));
            cross = ImageIO.read(Assets.class.getResource("/Images/Items/Sprite-Cross.png"));
            kingBible = ImageIO.read(Assets.class.getResource("/Images/Items/Sprite-King_Bible.png"));
            magicWand = ImageIO.read(Assets.class.getResource("/Images/Items/Sprite-Magic_Wand.png"));
            fireWand = ImageIO.read(Assets.class.getResource("/Images/Items/Sprite-Fire_Wand.png"));
            
            manaSphere = ImageIO.read(Assets.class.getResource("/Images/Other/edited mana sphere.png"));
            
            playerSheet = ImageIO.read(Assets.class.getResource("/Images/Player/antonio_spritesheet.png"));

            // Enemies
            zombie = ImageIO.read(Assets.class.getResource("/Images/Enemy/Sprite-Zombie.png"));
            mummy = ImageIO.read(Assets.class.getResource("/Images/Enemy/Sprite-Mummy.png"));
            skeleton = ImageIO.read(Assets.class.getResource("/Images/Enemy/Sprite-Skeleton.png"));
            ghost = ImageIO.read(Assets.class.getResource("/Images/Enemy/Sprite-Ghost.png"));
            mantichana = ImageIO.read(Assets.class.getResource("/Images/Enemy/Sprite-Mantichana.png"));
            werewolf = ImageIO.read(Assets.class.getResource("/Images/Enemy/Sprite-Werewolf.png"));
            mudman = ImageIO.read(Assets.class.getResource("/Images/Enemy/Sprite-Mudman.png"));

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}