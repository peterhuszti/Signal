package beadando;

@FunctionalInterface
public interface Accumulater<T, V> {

	public T accumulate(V oldState, T originalSignalState); 
}
