import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class Graphics {
	private SimpleWindow w;
	private int width;
	private int height;
	private int blockSize;
	
	Graphics(int w, int h, int bs){
		this.width = w;
		this.height = h;
		this.blockSize = bs;
		
		this.w = new SimpleWindow(width * blockSize, height * blockSize, "Digging");
	}
	
	public void block(int x, int y, Color color){
		int left = x * blockSize;
		int right = left + blockSize - 1;
		int top = y * blockSize;
		int bottom = top + blockSize - 1;
		
		w.setLineColor(color);
		
		for(int row = top; row <= bottom; row++){
			w.moveTo(left, row);
			w.lineTo(right, row);
		}
	}
	
	public void rectangle(int x, int y, int width, int height, Color c){
		for(int yy = y; yy < y + height; yy++){
			for(int xx = x; xx < x + width; xx++){
				block(xx, yy, c);
			}
		}
	}
	
	public char waitForKey(){
		return w.waitForKey();
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
