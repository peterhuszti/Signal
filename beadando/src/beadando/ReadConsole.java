package beadando;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {

	public static BufferedReader br = null;
	public static File file = new File("console.txt");
	
	/*public static Signal<String> console() {
		if(br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		return Signal.createSignal("", a->readLastLine());
	}*/

	private static void readLastLine() {
		if (file.exists()) {
			file.delete();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String last = "";
		while(true) {
			try {
				if(br.ready()) {
					last = br.readLine();
				} else {
					Thread.sleep(1000);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(String.valueOf(last) + "\n");
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
