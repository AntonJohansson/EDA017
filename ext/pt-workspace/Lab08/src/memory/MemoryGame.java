package memory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import cardreader.User;

public class MemoryGame {
	private static ArrayList<Integer> highscore;
	private static ArrayList<String> highscoreName;
	
	private static void readHighscoreData(String filename){
		highscore = new ArrayList<Integer>();
		highscoreName = new ArrayList<String>();
		
		Scanner scan = null;
		try {
			scan = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("Filen '" + filename + "' kunde inte läsas!");
			System.exit(-1);
		}

		while (scan.hasNextLine()) {
			highscore.add(scan.nextInt());
			highscoreName.add(scan.nextLine().trim());
		}
	}
	
	private static void writeHighscoreData(String filename){
		String data = "";
		for(int i = 0; i < highscore.size(); i++){
			data += highscore.get(i) + " " + highscoreName.get(i) + "\n";
		}
		
		Path path = Paths.get(filename);
		try {
			Files.write(path, data.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			System.err.println("Error: Kunde inte spara highscore till filen " + filename + "!");
			e.printStackTrace();
		}
	}
	
	private static String getHighscoreString(){
		String str = "\tFörsök\tNamn\n";
		for(int i = 0; i < highscore.size(); i++){
			str += (i + 1) + ":\t" + highscore.get(i) + "\t" + highscoreName.get(i) + "\n";
		}
		return str;
	}
	
	private static void addHighscore(int score, String name){
		int index = 0;
		while(highscore.size() > 0 && highscore.get(index) < score)index++;
		
		highscore.add(index, score);
		highscoreName.add(index, name);
	}
	
	private static int[] getValidMouseClick(MemoryBoard board, MemoryWindow window){
		int[] vec = new int[2];
		do{
			window.waitForMouseClick();
			vec[0] = window.getMouseRow();
			vec[1] = window.getMouseCol();
		}while(board.frontUp(vec[0], vec[1]));
		
		return vec;
	}
	
	private static int startGame(){
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		
		MemoryBoard board = new MemoryBoard(4, "back.jpg", frontFileNames);
		MemoryWindow window = new MemoryWindow(board);
		
		window.drawBoard();
		
		int[] p1, p2;
		int score = 0;
		while(!board.hasWon()){
			p1 = getValidMouseClick(board, window);
			board.turnCard(p1[0], p1[1]);
			window.drawCard(p1[0], p1[1]);
			
			p2 = getValidMouseClick(board, window);
			board.turnCard(p2[0], p2[1]);
			window.drawCard(p2[0], p2[1]);;
			
			if(!board.same(p1[0], p1[1], p2[0], p2[1])){
				MemoryWindow.delay(1000);
				board.turnCard(p1[0], p1[1]);
				board.turnCard(p2[0], p2[1]);
				window.drawCard(p1[0], p1[1]);
				window.drawCard(p2[0], p2[1]);
			}
			
			score++;
		}
	
		window.close();
		
		return score;
	}
	
	public static void main(String[] args) {
		readHighscoreData("Highscore.txt");
		String[] options = new String[]{"Ny omgång", "Avsluta"};
		
		while(true){
			String hsString = getHighscoreString();
			
			int value = JOptionPane.showOptionDialog(null, new JTextArea(hsString), "Memory", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			
			if(value == 0){
				int score = startGame();
				
				if(highscore.size() == 0 || score < highscore.get(highscore.size() - 1)){
					String name = JOptionPane.showInputDialog(null, "Grattis du slog ett nytt rekord på " + score + " försök!\nSkriv ditt namn:", "Nytt rekord!", JOptionPane.PLAIN_MESSAGE);
					addHighscore(score, name);
				}else{
					JOptionPane.showMessageDialog(null, "Grattis du fick " + score + " poäng!", "Omgång avslutad", JOptionPane.PLAIN_MESSAGE);
				}
			}else{
				break;
			}
		}
		
		writeHighscoreData("Highscore.txt");
	}
}
