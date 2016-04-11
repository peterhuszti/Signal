package beadando;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TimeSignal {
	
	public static File file = new File("console.txt");
	
	public static Signal<Integer> every(int freq, TimeUnit tu) {		
		return Signal.createSignal(0, a->imhere(a, freq, tu));
	}

	private static void imhere(int a, int freq, TimeUnit tu) {
		if (file.exists()) {
			file.delete();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(String.valueOf(a++) + " - ");
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				Thread.sleep(freq * tu.getTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
