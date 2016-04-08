package beadando;

@FunctionalInterface
public interface Joiner<T> {

	public Signal<T> join(Signal<T> s1, Signal<T> s2);
}
