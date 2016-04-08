package beadando;

public class Bead {

	public static Object print(Object value) {
		System.out.println(value);
		return null;
	}
	
	public static void main(String[] args) {
	/*	Signal<Integer> signal = Signal.createConstSignal(42); 
		signal = signal.map(a->a+1);
		signal = signal.map(a->a+1);
		signal.action.act(signal.getLastValue());*/
		
		(new Thread(TimeSignal.every(1, TimeUnit.SECOND))).start();
	}

}
