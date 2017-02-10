package yachk.printoptions;

import java.io.*;

/**
 * Entry point to the program.
 *
 * Parameters from the CL are tools look like "-<comand_name>"
 */
class PrintOptions {
  public static void main(String[] args) throws IOException {
	if (args.length != 0) {
      Searcher.searchTools(args);
	} else {
	  System.out.println("ERROR! There is no options!");
	}
  }	
}
