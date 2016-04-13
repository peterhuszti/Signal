package beadando;

@FunctionalInterface
public interface Joiner<S, V, W> {

	public S join(V t1, W t2);
}
