import java.io.*;
import java.util.*;

/**
 * The FileIO class executes file read/write operations.
 * 
 * @author fiorfe
 * 
 */
public class FileIO {

	String file; // file name

	/**
	 * No-arg constructor. It sets file to default.
	 * 
	 */
	public FileIO() {

		file = "";
	}

	/**
	 * Getter for file
	 * 
	 * @return file
	 */
	public String getFile() {

		return file;
	}

	/**
	 * Setter for file
	 * 
	 * @param file
	 */
	public void setFile(String file) {

		this.file = file;
	}

	/**
	 * This method reads the file.
	 * 
	 * @param rf
	 */
	public Scanner readFile(String rf) {

		try {

			File inFile = new File(rf);
			Scanner testFile = new Scanner(inFile);

			return testFile;

		} catch (IOException ex) {

			System.out.println("Cannot read file");

			return null;
		}
	}

	/**
	 * This method writes the file.
	 * 
	 * @param maze
	 * 
	 */
	public void writeFile(String maze) {

		try {

			FileWriter fwriter = new FileWriter("mazes.out", true);
			PrintWriter outputFile = new PrintWriter(fwriter);

			outputFile.println(maze);

			outputFile.close();

		} catch (IOException ex) {

			System.out.println("Cannot write file");
		}
	}
}