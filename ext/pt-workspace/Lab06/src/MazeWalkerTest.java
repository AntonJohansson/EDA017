import java.util.Scanner;

import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalkerTest {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(400, 400, "MazeWalkerTest");
		w.setLineWidth(2);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Välj labyrint: ");
		
		int maze_n = scanner.nextInt();
		scanner.close();
			
		Maze maze = new Maze(maze_n);
		Turtle turtle = new Turtle(w, 0, 0);
		MazeWalker walker = new MazeWalker(turtle);
		
		maze.draw(w);
		walker.walk(maze);
	}

}
