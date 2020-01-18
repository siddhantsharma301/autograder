//
// Import necessary packages
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class usb_wrong
{
    public static void main(String[] args) {
		try {
            // Path to the input file
			File inFile = new File("usb.in.txt");
			FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            
            // Path to the output file
            PrintWriter w = new PrintWriter("usb_wrong.out.txt", "UTF-8");

            // Gets number of test cases
            int T = Integer.parseInt(br.readLine());

            // Loops through all test cases: YOU WILL MAINLY BE CODING WITHIN THE WHILE LOOP FOR EACH TEST CASE
            // Every iteration of the loop is one test case
			while (T-- > 0) {
                // Reads one line of the input text and saves it to "s"
                String s = br.readLine();
                String[] arr = s.split(": ");
                String[] usb = arr[1].split(" ");
                int index = s.indexOf("G");
                //System.out.println(index);
                int capacity = Integer.parseInt(arr[0].substring(0,index));
                //System.out.println(capacity);
                int one_gb = Integer.parseInt(usb[0]);
                int three_gb = Integer.parseInt(usb[1]);
                int five_gb = Integer.parseInt(usb[2]);
                int one_gb_used = 0;
                int three_gb_used = 0;
                int five_gb_used = 0;
                capacity = capacity - one_gb;
                if (capacity <= 0){
                    one_gb_used = capacity + one_gb;
                    w.println(arr[0] + ":");
                    w.println(one_gb_used + " 1GB USBs");
                } else {
                    one_gb_used = one_gb;
                    capacity = capacity - 3*three_gb;
                    if(capacity <= 0){
                        three_gb_used = (capacity + 3*three_gb)/3;
                        w.println(arr[0] + ":");
                        w.println(one_gb_used + " 1GB USBs");
                        w.println(three_gb_used + " 3GB USBs");
                    } else {
                        one_gb_used = one_gb;
                        three_gb_used = three_gb;
                        capacity = capacity - 5*five_gb;
                        if (capacity <= 0){
                            five_gb_used = (capacity + 5*five_gb)/5;
                            w.println(arr[0] + ":");
                            w.println(one_gb_used + " 1GB USBs");
                            w.println(three_gb_used + " 3GB USBs");
                            w.println(five_gb_used + " 5GB USBS");
                        } else {
                            w.println(arr[0] + ":");
                            w.println("Buy more USBs");
                        }
                }
                
                // Writes the string ("s") to the output file
                //w.println(s);
            }
        }

			fr.close();
            br.close();
            w.close();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}
