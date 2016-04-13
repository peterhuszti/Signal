package beadando;

public class Bead {
	
	public static void main(String[] args) {
		
	/*	(new Thread(TimeSignal.every(1, TimeUnit.SECOND))).start();
		(new Thread(ReadConsole.console())).start();*/
		
		
//	MAP TEST
	/*	Signal<Integer> s = Signal.createSignal(1);
		System.out.println(s.getLastValue());
		
		Signal<Integer> x = s.map(a -> a+1);
		System.out.println(x.getLastValue());
		
		s.changeValue(2);
		System.out.println(s.getLastValue());
		System.out.println(x.getLastValue());*/

//	JOIN TEST	
		Signal<Integer> s = Signal.createSignal(1);
		System.out.println(s.getLastValue());
		
		Signal<String> t = Signal.createSignal("a");
		System.out.println(t.getLastValue());
		
		Signal<String> x = s.join(t, (a,b) -> a+b);
		System.out.println(x.getLastValue());
		
		t.changeValue("b", false);
		System.out.println(x.getLastValue());
	}

}
