package beadando;

@FunctionalInterface
public interface Mapper<TYPE> {

	public TYPE map(TYPE input);
}
