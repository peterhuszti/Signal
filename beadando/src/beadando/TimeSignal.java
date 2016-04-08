package beadando;

public class TimeSignal {
		
	public static Signal<Integer> every(int freq, TimeUnit tu) {		
		return Signal.createSignal(0, a->imhere(a, freq, tu));
	}

	private static Object imhere(Integer a, int freq, TimeUnit tu) {
		for(int i=0; i<5; ++i) {
			System.out.println(a++);
			try {
				Thread.sleep(tu.getTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	
}
