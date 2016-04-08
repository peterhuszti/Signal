package beadando;

@FunctionalInterface
public interface Accumulater<T> {

	public Signal<T> accumulate(Signal<T> s, T initialState); 
}
