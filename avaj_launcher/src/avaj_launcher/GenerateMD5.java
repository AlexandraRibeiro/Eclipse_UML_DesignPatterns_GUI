package avaj_launcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class GenerateMD5 {
	
	ArrayList<String> allLines = new ArrayList<String>();
	private String filenameWithOutExt;
	private ArrayList<String> arrMD5 = new ArrayList<String>();
	private Crypted crypted;
	private String sCycle;
	
	GenerateMD5 (ArrayList<String> arrAllLines, String filenameWithExt, int nb_cycle) throws IOException, NoSuchAlgorithmException {
		allLines = arrAllLines;
		filenameWithOutExt = filenameWithExt.replaceFirst("[.][^.]+$", "");
		sCycle = Integer.toString(nb_cycle);
		crypted = new Crypted();
		generator();
	}
	
	private void generator() throws IOException, NoSuchAlgorithmException {
		addMD5Sentence();
		addMD5Buffer();
		
		Path sim = Paths.get(filenameWithOutExt + "_MD5.txt");
		Files.write(sim, arrMD5);
		System.out.println(Tools.GREEN + "=> " + filenameWithOutExt + "_MD5.txt created" + Tools.RESET);
	}
	
	public void addMD5Sentence() throws NoSuchAlgorithmException {
		String[] MD5Sentences = Tools.getMD5Sentences();
		int index = new Random().nextInt(MD5Sentences.length);
	
	
		arrMD5.add(crypted.cryptedStr(MD5Sentences[index]));
	}
	
	private void addMD5Buffer() throws NoSuchAlgorithmException {
		int i = 0;
		int j = 0;
		String[] sArrayLine;
		
		arrMD5.add(crypted.cryptedStr(sCycle)); //add cycle
		
		while (i < allLines.size()) {
			j = 0;
			
			sArrayLine = allLines.get(i).split(" ");
			arrMD5.add(crypted.cryptedStr(sArrayLine[j] + ' ' + sArrayLine[++j]));	// add ex: 'Baloon B1'
			j++;
			while (j < 5) {
				arrMD5.add(crypted.cryptedStr(sArrayLine[j])); //add longitude, latitude, height
				j++;
			}
			i++;
		}
	}
	
}
