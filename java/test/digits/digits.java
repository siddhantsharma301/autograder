// Import necessary packages
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

// The class name should match the name of the file
public class digits{
	public static void main(String[] args) {
	try {
            // Path to the input file
			File inFile = new File("C:\\Users\\siddh\\Documents\\GitHub\\autograder\\java\\test\\digits\\digits.in.txt");
			FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            
            // Path to the output file
            PrintWriter w = new PrintWriter("C:\\Users\\siddh\\Documents\\GitHub\\autograder\\java\\test\\digits\\digits.out.txt", "UTF-8");

            // Gets number of test cases
            int T = Integer.parseInt(br.readLine());

            // Loops through all test cases: YOU WILL MAINLY BE CODING WITHIN THE WHILE LOOP FOR EACH TEST CASE
            // Every iteration of the loop is one test case
	while (T-- > 0) {
            // Reads one line of the input text and saves it to "s"
            String s = br.readLine();
    	    int re;
    	    String[] arr = s.split(":");
                int numOne = Integer.valueOf(arr[0]);
                int numTwo = Integer.valueOf(arr[1]);           
                if(Integer.valueOf(("" + numOne + numTwo)) > Integer.valueOf(("" + numTwo + numOne))){
                    re = Integer.valueOf(("" + numOne + numTwo));
                }else{
                    re = Integer.valueOf(("" + numTwo + numOne));
                }
                w.println(re);
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