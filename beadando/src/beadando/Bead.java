package beadando;

public class Bead {
	
	public static void main(String[] args) {
		/*Signal<Integer> signal = Signal.createConstSignal(42); 
		Signal<Integer> signal2 = Signal.createConstSignal(42); 
		signal = signal.map(a->a+1);
		signal = signal.map(a->a+1);
		signal.action.act(signal.getLastValue());
		signal = signal.join(signal2, (a,b)->Signal.createConstSignal(a.getLastValue().intValue()+b.getLastValue().intValue()));
		signal.action.act(signal.getLastValue());*/
		
		(new Thread(TimeSignal.every(1, TimeUnit.SECOND))).start();
		(new Thread(ReadConsole.console())).start();
	}

}
