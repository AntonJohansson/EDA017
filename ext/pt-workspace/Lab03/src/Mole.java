
public class Mole {
	private Graphics g = new Graphics(30, 50, 10);
	private final int SKY_HEIGHT = 8;
	private final int GRASS_HEIGHT = 5;
	
	public static void main(String[] args){
		Mole m = new Mole();
		m.drawWorld();
		m.dig();
	}
	
	private void drawWorld(){
		g.rectangle(0, 0, 30, SKY_HEIGHT, Colors.SKY);						//Draw sky
		g.rectangle(0, SKY_HEIGHT, 30, GRASS_HEIGHT, Colors.GRASS);			//Draw grass
		g.rectangle(0, SKY_HEIGHT + GRASS_HEIGHT, 30, 50, Colors.SOIL);		//Draw soil
	}
	
	private void dig(){
		int width = g.getWidth();
		int height = g.getHeight();
		int x = width / 2;
		int y = height / 2;
		
		while(true){
			// Hantera kollision med omgivningen
			if(x >= width){
				x = width - 1;
			}else if (x < 0){
				x = 0;
			}
			
			if(y >= height){
				y = height - 1;
			}else if (y < SKY_HEIGHT){
				y = SKY_HEIGHT;
			}
			
			g.block(x, y, Colors.MOLE);
			char key = g.waitForKey();
			
			if(y >= SKY_HEIGHT + GRASS_HEIGHT){
				g.block(x, y, Colors.TUNNEL);
			}else{
				g.block(x, y, Colors.GRASS);
			}
			
			switch(key){
				case 'w':
					y--;
					break;
				case 'a':
					x--;
					break;
				case 's':
					y++;
					break;
				case 'd':
					x++;
					break;
			}
		}
	}
	
}
