package beadando;

public class Bead {
	
	public static void main(String[] args) {
		
	/*	(new Thread(TimeSignal.every(1, TimeUnit.SECOND))).start();
		(new Thread(ReadConsole.console())).start();*/
		
		
//	MAP TEST
		Signal<Integer> s = Signal.createSignal(1);
		System.out.println(s.getLastValue());
		
		Signal<Integer> x = s.map(a -> a+1);
		System.out.println(x.getLastValue());
		
		s.changeValue(2);
		System.out.println(s.getLastValue());
		System.out.println(x.getLastValue());

//	JOIN TEST	
		Signal<Integer> s2 = Signal.createSignal(1);
		System.out.println(s2.getLastValue());
		
		Signal<String> t = Signal.createSignal("a");
		System.out.println(t.getLastValue());
		
		Signal<String> x2 = s2.join(t, (a,b) -> a+b);
		System.out.println(x2.getLastValue());
		
		t.changeValue("b");
		System.out.println(x2.getLastValue());
		
		s2.changeValue(2);
		System.out.println(x2.getLastValue());
		
// ACCUMULATE TEST
		
//
		Signal<Integer> metronome = TimeSignal.every(1000, TimeUnit.SECOND);
		(new Thread((MetronomeSignal<Integer>) metronome)).start();
		
		Signal<String> reader = ReaderSignal.createReaderSignal();
		(new Thread((ReaderSignal<String>) reader)).start();
		
		Signal<String> writer = metronome.join(reader, (a,b)->{System.out.println(a + " - " + b); return null;});
		System.out.println(writer.getLastValue());
	}

}
