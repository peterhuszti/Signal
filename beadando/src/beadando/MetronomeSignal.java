package beadando;

public class MetronomeSignal<TYPE> extends Signal<Integer> implements Runnable {

	private int freq;
	private TimeUnit tu;
	
	protected MetronomeSignal(Integer value) {
		super(value);
	}
	
	public static <T> MetronomeSignal<Integer> createMetronomeSignal(Integer startState, int freq, TimeUnit tu) {
		MetronomeSignal<Integer> result =  new MetronomeSignal<Integer>(startState);
		
		result.freq = freq;
		result.tu = tu;
		
		return result;
	}

	@Override
	public void run() {
		while(true) {
			changeValue(lastValue);
			try {
				Thread.sleep(freq * tu.getTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
