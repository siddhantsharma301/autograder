import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class frame {
	public static void main(String[] args) {
		try {
			File inFile = new File("C:\\Users\\siddh\\Documents\\GitHub\\autograder\\java\\test\\frame\\frame.in.txt");
			FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            
            PrintWriter w = new PrintWriter("C:\\Users\\siddh\\Documents\\GitHub\\autograder\\java\\test\\frame\\frame.out.txt", "UTF-8");

            int T = Integer.parseInt(br.readLine());

			while (T-- > 0) {
                String txt = br.readLine();
                String[] words = txt.split(" ");
                String msg = "";
                int maxLen = 0;

                for (String s : words) maxLen = (s.length() > maxLen) ? s.length() : maxLen;

                msg += "*";
                for (int i = 0; i < maxLen; i++) msg += "*";
                msg += "*\n";

                for (int i = 0; i < words.length; i++) {
                    msg += "*";
                    int len = words[i].length();
                    int diff = maxLen - len;
                    msg += words[i];
                    for (int x = 0; x < diff; x++) msg += " ";
                    msg += "*\n";
                }

                msg += "*";
                for (int i = 0; i < maxLen; i++) msg += "*";
                msg += "*";

                w.println(msg);
            }

			fr.close();
            br.close();
            w.close();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}