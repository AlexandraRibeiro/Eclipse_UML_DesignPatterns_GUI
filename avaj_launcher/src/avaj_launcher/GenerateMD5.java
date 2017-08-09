package avaj_launcher;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GenerateMD5 {
	
	private BufferedReader buffer;
	private String filenameWithOutExt;
	
	GenerateMD5 (BufferedReader buff, String filenameWithExt) {
		buffer = buff;
		filenameWithOutExt = filenameWithExt.replaceFirst("[.][^.]+$", "");
		generator();
	}
	
	private void generator() {
		String strMD5;

		Path sim = Paths.get(filenameWithOutExt + "_MD5.txt");
		Files.write(sim, strMD5);
	}s
	
}
