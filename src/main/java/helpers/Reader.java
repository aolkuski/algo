package helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
	BufferedReader br;
	private Character next;
	private long fileSize;
	
	public Reader(String fileName) throws FileNotFoundException{
		File f = new File("src/main/resources/textfiles/"+fileName);
		fileSize = f.length();
		br = new BufferedReader(new FileReader(f));
	}
	
	public long getFileSize(){
		return fileSize;
	}
	
	public String getNextLine() throws IOException{
		return getLine();
	}
	
	public ArrayList<String> getFileAsTextArray() throws IOException{
		ArrayList<String> textLines = new ArrayList<String>();
		
		String line = br.readLine();
		while(line != null){
			textLines.add(line);
			line = br.readLine();
		}
		
		return textLines;
	}
	
	private String getLine() throws IOException{
		try {
			return br.readLine();
		} catch (IOException e) {
			if(br != null) {
				br.close();
			}
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<ArrayList<String>> getFilesAsListOfStringArrays(String splitRegex) throws IOException{
		
		ArrayList<ArrayList<String>> allLines = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> textFile = getFileAsTextArray();
		for(String str : textFile){
			String[] parts = str.split(splitRegex);
			ArrayList<String> line = new ArrayList<String>();
			for(int i=0;i<parts.length;i++){
				line.add(parts[i]);
			}
			allLines.add(line);
			
		}
		return allLines;
	}
	
	public boolean hasNext() throws IOException{
		int i = br.read();
		Character c = (char)i;
		if(i == -1) return false;
		next = c;
		return true;
	}
	
	public Character getChar(){
		return next;
	}
}













