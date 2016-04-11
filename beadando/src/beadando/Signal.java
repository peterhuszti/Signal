package beadando;

public class Signal<T> implements Runnable {

	private T lastValue;
	Action<T> action;
	
	private Signal(T value, Action<T> action) {
		lastValue = value;
		this.action = action;
	}
	
	public static <S> Signal<S> createConstSignal(S value) {
		Signal<S> result = new Signal<S>(value, ((a) -> System.out.println(a)));
		
		return result;
	}
	
	public static <S> Signal<S> createSignal(S value, Action<S> action) {
		return new Signal<S>(value, action);
	}

	public Signal<T> map(Mapper<T> mapper) {
		Signal<T> result = createConstSignal(mapper.map(lastValue));
		action.act(lastValue);
		
		return result;
	}
	
	public Signal<T> join(Signal<T> s, Joiner<T> joiner) {
		return joiner.join(this, s);
	}
	
	public Signal<T> accumulate(Accumulater<T> acc, T initialState) {
		return acc.accumulate(this, initialState);
	}
	
	public T getLastValue() {
		return lastValue;
	}

	@Override
	public void run() {
		action.act(lastValue);
	}
	
}
