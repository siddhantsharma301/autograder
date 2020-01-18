import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class darts {
	public static void main(String[] args) {
		try {
			File inFile = new File("C:\\Users\\siddh\\Documents\\GitHub\\autograder\\java\\test\\darts\\darts.in.txt");
			FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            
            PrintWriter w = new PrintWriter("C:\\Users\\siddh\\Documents\\GitHub\\autograder\\java\\test\\darts\\darts.out.txt", "UTF-8");

            int T = Integer.parseInt(br.readLine());

			while (T-- > 0) {
                // Read the number of rings needed
                int n = Integer.parseInt(br.readLine());
                // Calculate the length from one edge of the board to the center
                int width = 2 * n - 1;
                // Keeps track of how many rings have been created
                int rings = 0;
                String s;
                // Keeps track of whether we're creating rings or exiting through rings
                boolean ascending = true;
                
                for (int i = 0; i < width; i++) {
                    s = (i % 2 == 0) ? "X" : " ";
                    for (int x = 0; x < rings; x++) w.print((x % 2 == 0) ? "X" : " ");
                    for (int x = 0; x < width - rings * 2; x++) w.print(s);
                    for (int x = rings; x > 0; x--) w.print((x % 2 != 0) ? "X" : " ");
                    if (ascending) rings++;
                    else rings--;
                    if (rings == n - 1) ascending = false;
                    w.println("");
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