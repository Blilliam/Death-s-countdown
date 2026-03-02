package TurnBased;

public class TurnBasedWave {
	public TurnBasedEnemy[] enemies;
	
	public static final int maxEnemyCount = 5;
	public int enemyCount;
	
	public TurnBasedWave(int enemyCount) {
		this.enemyCount = Math.min(enemyCount, maxEnemyCount);
		
		for (int i = 0; i < enemyCount; i++) {
			enemies[i] = new TurnBasedEnemy();
		}
	}
}
