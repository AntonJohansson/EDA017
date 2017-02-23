import java.awt.Color;

import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalker {
	private Turtle turtle;
	
	public MazeWalker(Turtle turtle){
		this.turtle = turtle;
	}
	
	/** Låter sköldpaddan vandra genom labyrinten maze **/
	public void walk(Maze maze){
		turtle.jumpTo(maze.getXEntry(), maze.getYEntry());
		turtle.penDown();
		
		int steps = 0, turns = 0;
		int x, y, alpha;
		while(!maze.atExit(turtle.getX(), turtle.getY())){
			x = turtle.getX();
			y = turtle.getY();
			alpha = turtle.getDirection();
			
			if(!maze.wallAtLeft(alpha, x, y)){
				turtle.left(90);
				turns++;
			}else if(maze.wallInFront(alpha, x, y)){
				turtle.left(-90);
				turns++;
			}
			
			turtle.forward(1);
			steps++;
			
			turtle.setColor(new Color((int)(255 * Math.abs(Math.sin(steps * 0.001))), (int)(255 * Math.abs(Math.cos(steps * 0.001))), (int)(255 * Math.abs(Math.sin(steps * 0.001 + Math.PI/4)))));
			
			SimpleWindow.delay(1);
		}
		
		System.out.printf("Sköldpaddan tog %d steg och bytte riktning %d ggr.", steps, turns);
	}
}
