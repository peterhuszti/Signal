package beadando;

@FunctionalInterface
public interface Action<T> {

	public void act(T t);
}
