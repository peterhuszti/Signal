package beadando;

public class Bead {
	
	public static void main(String[] args) {		
		
//	MAP TEST
/*		Signal<Integer> s = Signal.createSignal(1);
		System.out.println(s.getLastValue());
		
		Signal<Integer> x = s.map(a -> a+1);
		System.out.println(x.getLastValue());
		
		s.changeValue(2);
		System.out.println(s.getLastValue());
		System.out.println(x.getLastValue());
*/
//	JOIN TEST	
/*		Signal<Integer> s2 = Signal.createSignal(1);
		System.out.println(s2.getLastValue());
		
		Signal<String> t = Signal.createSignal("a");
		System.out.println(t.getLastValue());
		
		Signal<String> x2 = s2.join(t, (a,b) -> a+b);
		System.out.println(x2.getLastValue());
		
		t.changeValue("b");
		System.out.println(x2.getLastValue());
		
		s2.changeValue(2);
		System.out.println(x2.getLastValue());
*/		
// ACCUMULATE TEST
/*		Signal<String> s3 = Signal.createSignal("y");
		System.out.println(s3.getLastValue());
		
		Signal<Integer> x3 = s3.accumulate((p,b) -> b=="y" ? p+1 : p, 0);
		System.out.println(x3.getLastValue());
		
		s3.changeValue("n");
		System.out.println(x3.getLastValue());
		
		s3.changeValue("y");
		System.out.println(x3.getLastValue());
*/
//
		Signal<Integer> metronome = TimeSignal.every(1, TimeUnit.SECOND);
		(new Thread((MetronomeSignal<Integer>) metronome)).start();
		
		Signal<Integer> counter = metronome.accumulate((myState, tick) -> myState+1, 0);
		
		Signal<String> reader = ReaderSignal.createReaderSignal();
		(new Thread((ReaderSignal<String>) reader)).start();
		
		Signal<String> writer = counter.join(reader, (a,b)->{System.out.println(a + " - " + b); return null;});
	}

}
