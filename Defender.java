package spaceinvaders;

import processing.core.*;

public class Defender {
	PApplet parent;
	int x;
	int y;
	SpaceInvaders p;

	public Defender(PApplet parent, int x, int y, SpaceInvaders p) {
		this.parent = parent;
		this.x = x;
		this.y = y;
		this.p = p;
	}
	public void render() {
		if (SpaceInvaders.selection == 0) {
			parent.image(SpaceInvaders.ship, x, y);
		}
		else if (SpaceInvaders.selection == 1) {
			parent.image(SpaceInvaders.ship2, x, y);
		}
		else if (SpaceInvaders.selection == 2) {
			parent.image(SpaceInvaders.ship3, x, y);
		}
		}
	}