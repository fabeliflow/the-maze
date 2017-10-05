import java.util.Scanner;

/*
 * Author:     Fabio Fiori
 * Course:     CS26000 Spring 2014
 * Assignment: Project 3
 * Due Date:   April 5 2014 
 *
 * Description. This application retrieves string representations of mazes
 * and finds paths if possible. It then writes the results in an output file.
 *
 */

public class Project3 {

	public static void main(String[] args) {

		// file io object
		FileIO io = new FileIO();

		// scanner for reading the file
		Scanner test = io.readFile("mazes.in");

		while (test.hasNext()) {

			// create new maze
			Maze m = new Maze(test);

			// find the maze(s) path (if possible)
			m.findPath();

			// write the result in the output file
			io.writeFile(m.asText());
		}
	}
}