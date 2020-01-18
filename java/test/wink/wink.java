// Import necessary packages
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

// The class name should match the name of the file
public class wink {
	public static void main(String[] args) {
		try {
            // Path to the input file
			File inFile = new File("C:\\Users\\siddh\\Documents\\GitHub\\autograder\\java\\test\\wink\\wink.in.txt");
			FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            
            // Path to the output file
            PrintWriter w = new PrintWriter("C:\\Users\\siddh\\Documents\\GitHub\\autograder\\java\\test\\wink\\wink.out.txt", "UTF-8");

            // Gets number of test cases
            int T = Integer.parseInt(br.readLine());

            // Loops through all test cases: YOU WILL MAINLY BE CODING WITHIN THE WHILE LOOP FOR EACH TEST CASE
            // Every iteration of the loop is one test case
			while (T-- > 0) {
				String re;
                String s = br.readLine();		
		        //String s = "I took $20 from you today haha wink wink wink";
		        String[] arr = s.split(" ");
		        s.replaceAll(" wink ", " ");
		        int winkCount = 0;
		        for(int i = 0; i < arr.length; i++){
		            if(arr[i].equals("wink")){
		                winkCount++;
		            }
		        }
		        String[] arrT = s.split(" wink");
		        if(winkCount % 2 == 0) {
		            re = "\"" + arrT[0] + "\"" + " was SERIOUS";
		        }else {
		            re = "\"" + arrT[0] + "\"" + " was SARCASATIC";
		        }
		        w.println(re);
				
					// Reads one line of the input text and saves it to "s"
	                // Writes the string ("s") to the output file
	            
               
            }

			fr.close();
            br.close();
            w.close();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}