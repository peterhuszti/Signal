package beadando;

public class TimeSignal {
	
	public static MetronomeSignal<Integer> every(int freq, TimeUnit tu) {
		MetronomeSignal<Integer> result = MetronomeSignal.createMetronomeSignal(0, freq, tu);
		
		return result;
	}
		
}
