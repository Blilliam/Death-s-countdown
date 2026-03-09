package Open.Entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import TurnBased.TurnBasedCard;
import main.Animation;
import main.AppPanel;
import main.Assets;
import main.GameObject;
import main.enums.Type;

public class OpenPlayer extends OpenEntity{
	public ArrayList<TurnBasedCard> deck = new ArrayList<>();
	public ArrayList<TurnBasedCard> hand = new ArrayList<>();
	
	public int expToUpgrade = 10;
	public int totalUpgradesAvailible = 1;
	public boolean expCollectedForUpgrade = false;
	
	public boolean isRight;

	// Animation
	private BufferedImage[] walkFrames;
	private Animation walkAnim;
	private int frameWidth = 192, frameHeight = 192;
	
	public OpenPlayer(GameObject gameObj) {
		super(gameObj);
		
		x = gameObj.map.HEIGHT / 2;
		y = gameObj.map.WIDTH / 2;
		
		speed = 5;
		
		isRight = true;
		
		height = 100;
		width = 100;

		// Load walk frames
		int frameCount = 4;
		walkFrames = new BufferedImage[frameCount];
		for (int i = 0; i < frameCount; i++) {
			walkFrames[i] = Assets.playerSheet.getSubimage(i * frameWidth, 0, frameWidth, frameHeight);
		}
		walkAnim = new Animation(walkFrames, 100);

		// Initialize deck
		Type[] types = { Type.WEAPON, Type.BUFF, Type.AURMOR, Type.MANA };
		for (int i = 0; i < 5; i++) {
			TurnBasedCard c = new TurnBasedCard(gameObj);
			c.name = "Card";
			c.type = types[i % 4];
			deck.add(c);
		}
		moveCards(deck, hand, 5);
	}

	public void moveCards(ArrayList<TurnBasedCard> from, ArrayList<TurnBasedCard> to, int count) {
		for (int i = 0; i < count && !from.isEmpty(); i++)
			to.add(from.remove(0));
		layoutHand();
	}

	// Update player movement
	public void updateOpen() {
		updateOpenMovement();
	}
	
	public void updateOpenMovement() {
		if (gameObj.keyH.isMoving)
			walkAnim.update();
		else
			walkAnim.setFrame(3);

		if (gameObj.keyH.up)
			y -= speed;
		if (gameObj.keyH.down)
			y += speed;
		if (gameObj.keyH.left) {
			x -= speed;
			isRight = false;
		}
		if (gameObj.keyH.right) {
			x += speed;
			isRight = true;
		}
	}

	// Draw player at center of screen
	public void drawOpen(Graphics2D g2) {
		int drawX = AppPanel.WIDTH / 2 - 50; // display width = 100
		int drawY = AppPanel.HEIGHT / 2 - 50;
		if (isRight)
			g2.drawImage(walkAnim.getFrame(), drawX, drawY, width, height, null);
		else
			g2.drawImage(walkAnim.getFrame(), drawX + width, drawY, -100, height, null);
	}

	// Turn-based card updates
	public void updateTurnBased() {
		TurnBasedCard clicked = null;
		for (int i = hand.size() - 1; i >= 0; i--) {
			if (hand.get(i).isClicked()) {
				clicked = hand.get(i);
				break;
			}
		}
		if (clicked != null) {
			hand.remove(clicked);
			layoutHand();
		}
		for (TurnBasedCard c : hand)
			c.update();
	}

	public void drawTurnBased(Graphics2D g2) {
		for (TurnBasedCard c : hand)
			c.draw(g2);
	}

	public void layoutHand() {
		int count = hand.size();
		if (count == 0)
			return;

		int centerX = AppPanel.WIDTH / 2 - TurnBasedCard.width / 2;
		int baseY = AppPanel.HEIGHT - 400;
		float spacing = 160f;
		float maxAngle = 24f;
		float curveHeight = 60f;
		float startX = centerX - ((count - 1) * spacing) / 2f;

		for (int i = 0; i < count; i++) {
			TurnBasedCard c = hand.get(i);
			float t = (count == 1) ? 0.5f : (float) i / (count - 1);
			c.x = (int) (startX + i * spacing);
			float curve = (float) (-Math.pow(t - 0.5, 2) + 0.25);
			c.y = (int) (baseY - curve * curveHeight);
			c.rotation = (t - 0.5f) * maxAngle;
		}
	}
	
	private void drawXPBar(Graphics2D g2) {
		if (player1.totalUpgradesAvailible != 0) {
			g2.setColor(Color.WHITE);
			g2.setFont(new Font("Malgun Gothic", Font.PLAIN, 30));
			FontMetrics fm = g2.getFontMetrics();
		}
		// Bar position & size
		int barWidth = 300;
		int barHeight = 25;
		int x = (AppPanel.WIDTH - barWidth) / 2;
		int y = AppPanel.HEIGHT - 50; // below score stats

		// Percentage filled
		float percent = Math.min(1.0f, (float) player1.currExp / player1.expToUpgrade);

		// Background
		g2.setColor(new Color(50, 50, 50, 180));
		g2.fillRect(x, y, barWidth, barHeight);

		// Filled portion
		g2.setColor(new Color(0, 200, 255));
		g2.fillRect(x, y, (int) (barWidth * percent), barHeight);

		// Border
		g2.setColor(Color.WHITE);
		g2.drawRect(x, y, barWidth, barHeight);

		// Text
		g2.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		String text = player1.currExp + " / " + player1.expToUpgrade + " XP";
		int textWidth = g2.getFontMetrics().stringWidth(text);
		g2.drawString(text, x + (barWidth - textWidth) / 2, y + barHeight - 5);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
}