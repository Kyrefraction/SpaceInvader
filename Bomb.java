package spaceinvaders;
import processing.core.*;
public class Bomb {
	PApplet parent;
	int x;
	int y;
	SpaceInvaders space;
	Defender p;
	public Bomb(PApplet parent, int x, int y, SpaceInvaders space) {
		this.parent = parent;
		this.x = x;
		this.y = y;
		this.space = space;
		this.p = space.p;
	}
	public void update() {
		move();
		render();
		hitBoxDefender();
	}
	private void move() {
		if (y + 5 > 600) {
			space.destroyBomb();
		}
		y += 12;
	}
	public void render() {
		parent.fill(255, 0, 0);
		parent.rect(x, y, 4, 16);
	}
	public void hitBoxDefender() {
		if (p.x - 25 < x + 2 && p.x + 25 > x + 2 && p.y - 40 < y && p.y + 40 > y + 8) {
			space.playerLives--;
			space.eb = null;
		}
	}
}