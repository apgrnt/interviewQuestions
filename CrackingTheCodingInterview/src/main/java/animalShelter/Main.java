package animalShelter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    boolean firstLine = true;
    int linesToPrint = 0;
    String[] arr = new String[0];
    ArrayList<String> x = new ArrayList<String>();
    while ((line = in.readLine()) != null) {
      if(firstLine){
        firstLine=false;
        linesToPrint=Integer.parseInt(line);
      } else {
        x.add(line);
      }
    }
    StringComparator SC = new StringComparator();
    Collections.sort(x, SC);
    for(int i = 0; i<linesToPrint; i++){
	System.out.println(x.get(i));
    }
  }
  
  private static class StringComparator implements Comparator<String>{

    public int compare(String o1, String o2) {
	return o1.length()-o2.length();
    }
      
  }
}