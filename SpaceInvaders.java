package spaceinvaders;
import java.util.ArrayList;
import processing.core.*;
public class SpaceInvaders extends PApplet {
	public static boolean[] keys;
	static int frameCount;
	int switchDirectionFrameCount;
	int playerLives = 3; //amount of lives the player has
	public Defender p = new Defender(this, 300, 550, this); //create the defender at 300,550 
	Projectile b;
	Projectile b2;
	Bomb eb;
	Bomb eb2;
	Bomb eb3;
	ArrayList<Alien> aliens = new ArrayList<Alien>(); // create the array list for the aliens
	int y = 0;
	public static PImage background, alienI, alienI2, alienI3, ship, ship2, ship3; //all images used in the program
	final int LEFT = -1; // left is specified using negative increments
	final int RIGHT = 1; // Right is specified using positive increments
	int direction = RIGHT; // create the direction and set it to be initially right
	public static int score = 0; // create score which starts at 0
	float alienX = 15; // x-coordinate of aliens
	int aliennum = 10; // amount of aliens per row
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	final int LV2 = 3;
	final int LV3 = 4; // gamemodes
	int GAMEMODE = MENU; // set the initial gamemode to menu
	final int SPD = 0;
	final int PWR = 1;
	final int BAL = 2; // ship types
	int SHIPSELECT = SPD; // set the initial ship type to the speed ship
	static int selection = 0; // create a static int variable to transfer ship select information into
	int selectCooldown = 60; // cooldown before being able to scroll between ships
	PFont titleFont; // setup for font
	public void settings() {
		size(600, 600); // create a 600 by 600 window
	}
	public void setup() {
		background = loadImage("data/background3.jpg");
		background.resize(width, height);
		alienI = loadImage("data/alienthree.png");
		alienI2 = loadImage("data/alientwo.png");
		alienI3 = loadImage("data/alienone.png");
		ship = loadImage("data/ship.png");
		ship2 = loadImage("data/shiptwo.png");
		ship3 = loadImage("data/shipthree.png"); // load all the images from the specified places
		alienI.resize(30, 30);
		alienI2.resize(30, 30);
		alienI3.resize(30, 30);
		ship.resize(50, 80);
		ship2.resize(50, 80);
		ship3.resize(50, 80); // resize all the images to the appropriate size
		titleFont = loadFont("data/titleFont.vlw"); // load the titlefont
		rectMode(CENTER); // make co-ordinates determine the center of a rectangle
		imageMode(CENTER); // make co-ordinates determine the center of an image
		System.out.println("Made By Vincenzo"); // watermark
		for (int i = 0; i < aliennum; i++) { // amount of aliens per row
			for (int j = 0; j < 3; j++) { // amount of rows (3)
				aliens.add(new Alien(this, this, 20 * (i + 1), 25 * (j + 1), i, j)); // add alien into the array
			}
		}
		keys = new boolean[29];
	}
	public void keyPressed() {
		keys[0] = (key == ' ') ? true : keys[0];
		keys[1] = (key == 'a' || key == 'A') ? true : keys[1];
		keys[2] = (key == 'b' || key == 'B') ? true : keys[2];
		keys[3] = (key == 'c' || key == 'C') ? true : keys[3];
		keys[4] = (key == 'd' || key == 'D') ? true : keys[4];
		keys[5] = (key == 'e' || key == 'E') ? true : keys[5];
		keys[6] = (key == 'f' || key == 'F') ? true : keys[6];
		keys[7] = (key == 'g' || key == 'G') ? true : keys[7];
		keys[8] = (key == 'h' || key == 'H') ? true : keys[8];
		keys[9] = (key == 'i' || key == 'I') ? true : keys[9];
		keys[10] = (key == 'j' || key == 'J') ? true : keys[10];
		keys[11] = (key == 'k' || key == 'K') ? true : keys[11];
		keys[12] = (key == 'l' || key == 'L') ? true : keys[12];
		keys[13] = (key == 'm' || key == 'M') ? true : keys[13];
		keys[14] = (key == 'n' || key == 'N') ? true : keys[14];
		keys[15] = (key == 'o' || key == 'O') ? true : keys[15];
		keys[16] = (key == 'p' || key == 'P') ? true : keys[16];
		keys[17] = (key == 'q' || key == 'Q') ? true : keys[17];
		keys[18] = (key == 'r' || key == 'R') ? true : keys[18];
		keys[19] = (key == 's' || key == 'S') ? true : keys[19];
		keys[20] = (key == 't' || key == 'T') ? true : keys[20];
		keys[21] = (key == 'u' || key == 'U') ? true : keys[21];
		keys[22] = (key == 'v' || key == 'V') ? true : keys[22];
		keys[23] = (key == 'w' || key == 'W') ? true : keys[23];
		keys[24] = (key == 'x' || key == 'X') ? true : keys[24];
		keys[25] = (key == 'y' || key == 'Y') ? true : keys[25];
		keys[26] = (key == 'z' || key == 'Z') ? true : keys[26];
		keys[27] = (key == ENTER) ? true : keys[27];
		keys[28] = (key == BACKSPACE) ? true : keys[28];
	}
	public void keyReleased() {
		keys[0] = (key == ' ') ? false : keys[0];
		keys[1] = (key == 'a' || key == 'A') ? false : keys[1];
		keys[2] = (key == 'b' || key == 'B') ? false : keys[2];
		keys[3] = (key == 'c' || key == 'C') ? false : keys[3];
		keys[4] = (key == 'd' || key == 'D') ? false : keys[4];
		keys[5] = (key == 'e' || key == 'E') ? false : keys[5];
		keys[6] = (key == 'f' || key == 'F') ? false : keys[6];
		keys[7] = (key == 'g' || key == 'G') ? false : keys[7];
		keys[8] = (key == 'h' || key == 'H') ? false : keys[8];
		keys[9] = (key == 'i' || key == 'I') ? false : keys[9];
		keys[10] = (key == 'j' || key == 'J') ? false : keys[10];
		keys[11] = (key == 'k' || key == 'K') ? false : keys[11];
		keys[12] = (key == 'l' || key == 'L') ? false : keys[12];
		keys[13] = (key == 'm' || key == 'M') ? false : keys[13];
		keys[14] = (key == 'n' || key == 'N') ? false : keys[14];
		keys[15] = (key == 'o' || key == 'O') ? false : keys[15];
		keys[16] = (key == 'p' || key == 'P') ? false : keys[16];
		keys[17] = (key == 'q' || key == 'Q') ? false : keys[17];
		keys[18] = (key == 'r' || key == 'R') ? false : keys[18];
		keys[19] = (key == 's' || key == 'S') ? false : keys[19];
		keys[20] = (key == 't' || key == 'T') ? false : keys[20];
		keys[21] = (key == 'u' || key == 'U') ? false : keys[21];
		keys[22] = (key == 'v' || key == 'V') ? false : keys[22];
		keys[23] = (key == 'w' || key == 'W') ? false : keys[23];
		keys[24] = (key == 'x' || key == 'X') ? false : keys[24];
		keys[25] = (key == 'y' || key == 'Y') ? false : keys[25];
		keys[26] = (key == 'z' || key == 'Z') ? false : keys[26];
		keys[27] = (key == ENTER || key == RETURN) ? false : keys[27];
		keys[28] = (key == BACKSPACE) ? false : keys[28];
	}
	public void draw() {
		image(background, width / 2, y + (height / 2));
		image(background, width / 2, y - background.height + (height / 2)); // draw the background
		y = y + 3; // move the background up
		if (y >= 600)
			y = 0; // make the background constantly loop moving up
		if (GAMEMODE == MENU) {
			showShip(); // show the current ship
			textFont(titleFont); // set the font
			textAlign(CENTER, CENTER);
			textSize(70); // set the font size
			text("NORTHSPACE", 300, 100); // title
			textSize(60); // set a new font size
			text("PLAY [f]", 300, 200); // play and instruction
			textSize(30); // set a new font size
			text("Ship selection [m,n]", 300, 500); // ship selection and instruction
			if (keys[13] && SHIPSELECT == SPD && selectCooldown >= 60) {  // if right is pressed and is on speed
				SHIPSELECT = PWR; // go to power
				resetCooldown();
			}
			if (keys[13] && SHIPSELECT == PWR && selectCooldown >= 60) { // if right is pressed and is on power
				SHIPSELECT = BAL; // go to balance
				resetCooldown();
			}
			if (keys[13] && SHIPSELECT == BAL && selectCooldown >= 60) { // if right is pressed and is on balance
				SHIPSELECT = SPD; // go to speed
				resetCooldown();
			}
			if (keys[14] && SHIPSELECT == BAL && selectCooldown >= 60) { // if left is pressed and is on balance
				SHIPSELECT = PWR; // go to power
				resetCooldown();
			}
			if (keys[14] && SHIPSELECT == PWR && selectCooldown >= 60) { // if left is pressed and is on power
				SHIPSELECT = SPD; // go to speed
				resetCooldown();
			}
			if (keys[14] && SHIPSELECT == SPD && selectCooldown >= 60) { // if left is pressed and is on speed 
				SHIPSELECT = BAL; // go to balance
				resetCooldown();
			}
			selectCooldown++;
			if (keys[6]) {
				if (SHIPSELECT == BAL) {
					selection = 2;
				} else if (SHIPSELECT == PWR) {
					selection = 1;
				} else if (SHIPSELECT == SPD) {
					selection = 0;
				} // when play is pressed convert the selection into the static variable
				GAMEMODE = GAME; // change the gamemode to the game
			} // title screen
		} else if (GAMEMODE == GAME) {
			for (int i = 0; i < aliens.size(); i++) {
				aliens.get(i).update(); // update each alien
			}
			if (b != null) {
				b.update(); // if the bomb isn't destroyed move it
			}
			if (b2 != null) {
				b2.update();
			}
			endgame(); // check if the endgame requirements have been met
			if (eb != null) {
				eb.update(); // if the enemy bomb isn't destroyed, move it 
			}
			p.render(); // render the player
			noLives(); // check if the player has no lives
			if (keys[1] && p.x - 25 > 0 && selection == 0) { // if they press left and are the fast ship
				p.x = p.x - 7; // move left
			}
			if (keys[4] && p.x + 25 < width && selection == 0) { // if they press right and are the fast ship
				p.x = p.x + 7; // move right
			}
			if (keys[1] && p.x - 25 > 0 && selection == 1) { // if they press left and are the slow ship
				p.x = p.x - 2; // move left
			}
			if (keys[4] && p.x + 25 < width && selection == 1) { // if they press right and are the slow ship
				p.x = p.x + 2; //move right
			}
			if (keys[1] && p.x - 25 > 0 && selection == 2) { // if they press left and are the balanced ship
				p.x = p.x - 4; // move left
			}
			if (keys[4] && p.x + 25 < width && selection == 2) { // if they press right and are the balanced ship
				p.x = p.x + 4; // move right
			}
			if (keys[0] && b == null && selection == 0) { // if they press enter and are the fast ship
				b = new Projectile(this, p.x, p.y, this); // shoot
			}
			if (keys[0] && b == null && selection == 1) { // if they press enter and are the power ship
				b = new Projectile(this, p.x + 15, p.y, this);
				b2 = new Projectile(this, p.x - 15, p.y, this); // fire two projectiles
			}
			if (keys[0] && b == null && selection == 2) { // if they press enter and are the balanced ship
				b = new Projectile(this, p.x, p.y, this); // shoot
			}
			alienX += direction * Alien.speed; // aliens move
			frameCount++;
			if(aliens.size() == 0) { // if all aliens have been destroyed
				resetlv2(); // set up for level two
				GAMEMODE = LV2; // move to level two
			}
			fill(255, 255, 255); // white fill
			textSize(20); // set font size
			text("Score: " + score + " Lives: " + playerLives, 470, 30); // show the player's score and their lives
		} else if (GAMEMODE == LV2) {
			for (int i = 0; i < aliens.size(); i++) {
				aliens.get(i).update(); // move aliens
			}
			if (b != null) {
				b.update(); // move bullet
			}
			if (b2 != null) {
				b2.update(); // move second bullets
			}
			endgame(); // check to see if endgame requirements have been met or not
			if (eb != null) {
				eb.update();
			}
			p.render(); // render the player
			noLives(); // check if the player has lost all of their lives
			if (keys[1] && p.x - 25 > 0 && selection == 0) {
				p.x = p.x - 7;
			}
			if (keys[4] && p.x + 25 < width && selection == 0) {
				p.x = p.x + 7;
			}
			if (keys[1] && p.x - 25 > 0 && selection == 1) {
				p.x = p.x - 2;
			}
			if (keys[4] && p.x + 25 < width && selection == 1) {
				p.x = p.x + 2;
			}
			if (keys[1] && p.x - 25 > 0 && selection == 2) {
				p.x = p.x - 4;
			}
			if (keys[4] && p.x + 25 < width && selection == 2) {
				p.x = p.x + 4;
			}
			if (keys[0] && b == null && selection == 0) {
				b = new Projectile(this, p.x, p.y, this);
			}
			if (keys[0] && b == null && selection == 1) {
				b = new Projectile(this, p.x + 15, p.y, this);
				b2 = new Projectile(this, p.x - 15, p.y, this);
			}
			if (keys[0] && b == null && selection == 2) {
				b = new Projectile(this, p.x, p.y, this);
			}
			alienX += direction * Alien.speed;
			frameCount++;
			if(aliens.size() == 0) { // if all aliens are destroyed
				resetlv3();
				GAMEMODE = LV3; // move onto the next level
			}
			fill(255, 255, 255);
			textSize(20);
			text("Score: " + score + " Lives: " + playerLives, 450, 30);
		} else if (GAMEMODE == LV3) {
			for (int i = 0; i < aliens.size(); i++) {
				aliens.get(i).update();
			}
			if (b != null) {
				b.update();
			}
			if (b2 != null) {
				b2.update();
			}
			endgame();
			if (eb != null) {
				eb.update();
			}
			p.render();
			noLives();
			if (keys[1] && p.x - 25 > 0 && selection == 0) {
				p.x = p.x - 7;
			}
			if (keys[4] && p.x + 25 < width && selection == 0) {
				p.x = p.x + 7;
			}
			if (keys[1] && p.x - 25 > 0 && selection == 1) {
				p.x = p.x - 2;
			}
			if (keys[4] && p.x + 25 < width && selection == 1) {
				p.x = p.x + 2;
			}
			if (keys[1] && p.x - 25 > 0 && selection == 2) {
				p.x = p.x - 4;
			}
			if (keys[4] && p.x + 25 < width && selection == 2) {
				p.x = p.x + 4;
			}
			if (keys[0] && b == null && selection == 0) {
				b = new Projectile(this, p.x, p.y, this);
			}
			if (keys[0] && b == null && selection == 1) {
				b = new Projectile(this, p.x + 15, p.y, this);
				b2 = new Projectile(this, p.x - 15, p.y, this);
			}
			if (keys[0] && b == null && selection == 2) {
				b = new Projectile(this, p.x, p.y, this);
			}
			alienX += direction * Alien.speed;
			frameCount++;
			if(aliens.size() == 0) {
				GAMEMODE = END;
			}
			fill(255, 255, 255);
			textSize(20);
			text("Score: " + score + " Lives: " + playerLives, 450, 30);
		} else {
			textFont(titleFont);
			textSize(75);
			text("GAME OVER", 300, 130);
			textSize(55);
			text("Score: " + score, 300, 250);
			textSize(45);
			text("Reset [g]",300,320);
			if (keys[7]) {
				reset();
				GAMEMODE = MENU;
			}
		}
	}
	public void destroyProjectile() {
		b = null;
		b2 = null;
	}
	public void destroyBomb() {
		eb = null;
	}
	public void AlienHit(int i) {
		aliens.remove(i); // remove the alien that was hit
		destroyProjectile(); // destroy the bullet that hit the alien
	}
	public void showShip() { // show ship and ship information
		if (SHIPSELECT == SPD) {
			image(ship, 300, 350);
			textSize(25);
			text("Velocita", 300, 550);
			text("Speed: 3", 450,330);
			text("Power: 1", 455,400); // show ship info
		} else if (SHIPSELECT == PWR) {
			image(ship2, 300, 350);
			textSize(25);
			text("Duofire", 300, 550);
			text("Speed: 1", 450,330);
			text("Power: 3", 460,400);
		} else if (SHIPSELECT == BAL) {
			image(ship3, 300, 350);
			textSize(25);
			text("Ebraser", 300, 550);
			text("Speed: 2", 450,330);
			text("Power: 2", 460,400);
		}
	}
	public void resetCooldown() {
		selectCooldown = 0;
	}
	public void defenderHit() {
		playerLives = playerLives - 1; // take off a life
		destroyBomb(); // destroy the projectile that hit the player
	}
	public void noLives() {
		if (playerLives == 0) { // if the player has lost all of their lives
			GAMEMODE = END; // end the game
		}
	}
	public void endgame() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).y >= 500) { // if the aliens have reached the end
				GAMEMODE = END; // end the game
			}
		}
	}
	public void reset() { // get the level ready
		aliens = new ArrayList<Alien>();
		p = new Defender(this, 50, 550, this);
		b = null;
		b2 = null;
		eb = null;
		playerLives = 3;
		direction = RIGHT;
		score = 0;
		alienX = 15;
		aliennum = 10;
		for (int i = 0; i < aliennum; i++) {
			for (int j = 0; j < 3; j++) {
				aliens.add(new Alien(this, this, 20 * (i + 1), 25 * (j + 1), i, j));
			}
		}
	}
	public void resetlv2() { // get level 2 ready
		aliens = new ArrayList<Alien>();
		p = new Defender(this, 300, 550, this);
		b = null;
		b2 = null;
		eb = null;
		direction = RIGHT;
		alienX = 15;
		aliennum = 10;
		for (int i = 0; i < aliennum; i++) {
			for (int j = 0; j < 4; j++) {
				aliens.add(new Alien(this, this, 20 * (i + 1), 25 * (j + 1), i, j));
			}
		}
	}
	public void resetlv3() { // get level 3 ready
		aliens = new ArrayList<Alien>();
		p = new Defender(this, 300, 550, this);
		b = null;
		b2 = null;
		eb = null;
		direction = RIGHT;
		alienX = 15;
		aliennum = 10;
		for (int i = 0; i < aliennum; i++) {
			for (int j = 0; j < 5; j++) {
				aliens.add(new Alien(this, this, 20 * (i + 1), 25 * (j + 1), i, j));
			}
		}
	}
	public void switchDirection() { // make the aliens change direction
		if (frameCount - switchDirectionFrameCount > 5) {
			switchDirectionFrameCount = frameCount;
			if (direction == LEFT) {
				direction = RIGHT; // if they're going left, go right
				for (int i = 0; i < aliens.size(); i++) {
					aliens.get(i).y = aliens.get(i).y + 20; // move down
				}
			} else {
				direction = LEFT; // if they're going right, go left
				for (int i = 0; i < aliens.size(); i++) {
					aliens.get(i).y = aliens.get(i).y + 20; // move down
				}
			}
		}
	}
	public static void main(String _args[]) {
		PApplet.main(new String[] { spaceinvaders.SpaceInvaders.class.getName() });
	}
}