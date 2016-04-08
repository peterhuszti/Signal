package beadando;

@FunctionalInterface
public interface Mapper<T> {

	public T map(T input);
}
