package beadando;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReaderSignal<TYPE> extends Signal<String> implements Runnable {

	public static BufferedReader br = null;
	
	protected ReaderSignal(String value) {
		super(value);
		if(br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	
	public static <T> ReaderSignal<String> createReaderSignal() {
		ReaderSignal<String> result =  new ReaderSignal<String>("");
		
		return result;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if(br.ready()) {
					changeValue(br.readLine());
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		//	System.out.println(lastValue);
		}
	}

	
}
