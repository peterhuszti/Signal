package beadando;

public enum TimeUnit {

	MILLI (1),
	SECOND (1000);
	
	private final int time;
	TimeUnit(int time) {
		this.time = time;
	}
	
	public int getTime() {
		return time;
	}
}
