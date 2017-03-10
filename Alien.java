package spaceinvaders;
import java.util.ArrayList;
import java.util.Random;
import processing.core.*;
public class Alien {
	Random random = new Random();
	PApplet parent;
	float x;
	float y;
	SpaceInvaders spaceInvaders;
	PImage texture;
	int position;
	static float speed = 2f;
	public Alien(PApplet parent, SpaceInvaders spaceInvaders, int x, int y, int position, int type) {
		this.parent = parent;
		this.spaceInvaders = spaceInvaders;
		this.x = x;
		this.y = y;
		this.position = position;
		switch (type) {
		case 0:
			texture = SpaceInvaders.alienI;
			break;
		case 1:
			texture = SpaceInvaders.alienI2;
			break;
		case 2:
			texture = SpaceInvaders.alienI3;
			break;
		case 3:
			texture = SpaceInvaders.alienI2;
			break;
		case 4:
			texture = SpaceInvaders.alienI3;
			break;
		}
	}
	public void update() {
		move();
		render();
		if (bottomAlien() && random.nextInt(1000) <= 10 && spaceInvaders.eb == null) {
			dropBomb();
		}
	}
	public void move() {
		x = spaceInvaders.alienX + (position * 35);
		if (x + (texture.width / 2) > spaceInvaders.width || x - (texture.width / 2) < 0) {
			spaceInvaders.switchDirection();
		}
	}
	public boolean bottomAlien() {
		boolean out = true;
		ArrayList<Alien> aliens = spaceInvaders.aliens;
		for (int i = 0; i < aliens.size(); i++) {
			float aX = aliens.get(i).x;
			float aY = aliens.get(i).y;
			if (aY >= y && aX < x && aX + aliens.get(i).texture.width > x) {
				return false;
			}
		}
		return out;
	}
	public void dropBomb() {
		spaceInvaders.eb = new Bomb(parent, (int) x, (int) y, spaceInvaders);
	}
	public void render() {
		parent.image(texture, x, y);
	}
}