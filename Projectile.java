package spaceinvaders;

import java.util.ArrayList;

import processing.core.*;

public class Projectile {
	PApplet parent;
	int x;
	int y;
	SpaceInvaders spaceinvaders;

	public Projectile(PApplet parent, int x, int y, SpaceInvaders spaceinvaders) {
		this.parent = parent;
		this.x = x;
		this.y = y;
		this.spaceinvaders = spaceinvaders;
	}

	public void update() {
		move();
		render();
		hitBoxAlien();
	}

	private void move() {
		if (SpaceInvaders.selection == 0) {
			if (y - 5 < 0) {
				spaceinvaders.destroyProjectile();
			}
			y -= 9;
				}
		if (SpaceInvaders.selection == 1) {
			if (y - 5 < 0) {
				spaceinvaders.destroyProjectile();
			}
			y -= 12;
			}
		if (SpaceInvaders.selection == 2) {
			if (y - 5 < 0) {
				spaceinvaders.destroyProjectile();
			}
			y -= 12;
			}
	}
	public void render() {
		parent.fill(255, 0, 0);
		parent.rect(x, y, 5, 15);
	}
	public void hitBoxAlien() {
		ArrayList<Alien> aliens = spaceinvaders.aliens;
		for(int i = 0; i < aliens.size();i++) {
			Alien alien = aliens.get(i);
			if (alien.x - (alien.texture.width / 2) < x + 2 && alien.x + (alien.texture.width / 2) > x - 2 && alien.y - (alien.texture.height / 2) < y + 8 && alien.y + (alien.texture.height/2) > y - 8) {
				spaceinvaders.AlienHit(i);
				SpaceInvaders.score = SpaceInvaders.score + 5;
			}
		}
	}
}
