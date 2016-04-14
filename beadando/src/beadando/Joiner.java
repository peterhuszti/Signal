package beadando;

@FunctionalInterface
public interface Joiner<RES, LEFT, RIGHT> {

	public RES join(LEFT s1, RIGHT s2);
}
