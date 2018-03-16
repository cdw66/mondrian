import java.util.Random;

import processing.core.PApplet;

public class Piet extends PApplet {
	static Random randy = new Random();
	
	public static void main(String[] args) {
		PApplet.main("Piet");
	}
	
	public void settings() {
		this.size(500,500);
	}
	public void setup() {
		this.background(0);
		this.strokeWeight(10);
		this.drawRectangle(0,0,this.width,this.height,3);
	}
	
	public void draw() {
		
	}
	
	public void mouseClicked() {
		this.drawRectangle(0,0,this.width,this.height,3);
	}

	private void drawRectangle(int x, int y, int width, int height, int depth) {
		int randomColor = randy.nextInt(4);
		if (randomColor == 0) { // red
			this.fill(255, 0, 0);
		}
		else if (randomColor == 1) { // blue
			this.fill(0,0,255);
		}
		else if (randomColor == 2) { // yellow
			this.fill(255,255,0);
		}
		else { // white
			this.fill(255);
		}
		
		if (depth == 0) { // base case
			this.rect(x, y, width, height);
		}
		else { // recursion:
			int randX = randy.nextInt(width+1) + x;
			int randY = randy.nextInt(height+1) + y;
			
			
			drawRectangle(x,y,randX-x,randY-y,depth-1);
			drawRectangle(randX,y,width-(randX-x),randY-y,depth-1);
			drawRectangle(x,randY,randX-x,height-(randY-y),depth-1);
			drawRectangle(randX,randY,width-(randX-x),height-(randY-y),depth-1);

		}
		
	}
	
}











