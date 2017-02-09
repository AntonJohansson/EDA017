import se.lth.cs.pt.window.SimpleWindow;

import java.awt.Color;
import java.util.Random;


public class SimpleWindowExample {
	public static void main(String[] args) {
		final int width = 1680;
		final int height = 1050;
		
		SimpleWindow w = new SimpleWindow(width, height, "Konstgenerator");
		Random random = new Random();
		
		int x = width/2; 
		int y = height/2;
		
		w.moveTo(x, y); // flytta pennan till mitten 
		
		long lastTime = System.nanoTime();
		while(true){
			// Räkna ut hur lång tid som passerat sedan lastTime
			long now = System.nanoTime();
			double delta = (now - lastTime) / 1e6;
			
			// Slumpa två nummer mellan -25 till 25
			int rand_dx = random.nextInt(51) - 25;
			int rand_dy = random.nextInt(51) - 25;
			
			// Uppdatera positionen om 0 < x < width   och 0 < y < height
			if(x + rand_dx < width && x + rand_dx > 0) x += rand_dx;
			if(y + rand_dy < height && y + rand_dy > 0) y += rand_dy;
			
			w.lineTo(x, y); // Rita linjen
			
			// Om det passerat minst en sekund, slumpa bredd och färg på linjen
			if(delta >= 1e3){
			
				int rand_width = random.nextInt(10);
				
				w.setLineColor(randomize_color(random));
				w.setLineWidth(rand_width);
				
				lastTime = now;
			}
			
			SimpleWindow.delay(16); // Ta det lugnt så att vi inte ballar ur
		}
		
	}
	
	private static Color randomize_color(Random random){
		float hue = random.nextFloat();
		// Saturation between 0.1 and 0.3
		float saturation = (random.nextInt(2000) + 1000) / 10000f;
		float luminance = 0.9f;
		Color color = Color.getHSBColor(hue, saturation, luminance);
		
		return color;
	}
}
