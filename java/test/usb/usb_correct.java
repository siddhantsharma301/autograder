import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class usb_correct {
	public static void main(String[] args) {
		try {
			File inFile = new File("C:\\Users\\siddh\\Documents\\GitHub\\autograder\\java\\test\\usb\\usb.in.txt");
			FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            
            PrintWriter w = new PrintWriter("C:\\Users\\siddh\\Documents\\GitHub\\autograder\\java\\test\\usb\\usb_correct.out.txt", "UTF-8");

            int T = Integer.parseInt(br.readLine());

			while (T-- > 0) {
                String[] info = br.readLine().split("GB: ");
                int storage = Integer.parseInt(info[0]);
                String[] usbs = info[1].split(" ");
                int usb1GB = Integer.parseInt(usbs[0]);
                int usb3GB = Integer.parseInt(usbs[1]);
                int usb5GB = Integer.parseInt(usbs[2]);
                int total = usb1GB + 3 * usb3GB + 5 * usb5GB;

                w.println(storage + "GB" + ":");

                if (total < storage) {
                    w.println("Buy more USBs!");
                    continue;
                }

                int num1GB = 0, num3GB = 0, num5GB = 0;

                while (storage > usb1GB + 3 * usb3GB) {
                    num5GB++;
                    storage -= 5;
                }

                while (storage > usb1GB) {
                    num3GB++;
                    storage -= 3;
                }

                if (storage < 0) {
                    w.println("Buy more USBs!");
                    continue;
                }

                num1GB = storage;

                if (num1GB != 0) w.println(num1GB + " " + "1GB USBs");
                if (num3GB != 0) w.println(num3GB + " " + "3GB USBs");
                if (num5GB != 0) w.println(num5GB + " " + "5GB USBs");
            }

			fr.close();
            br.close();
            w.close();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}