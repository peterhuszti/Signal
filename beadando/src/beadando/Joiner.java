package beadando;

@FunctionalInterface
public interface Joiner<RES, LEFT, RIGHT> {

	public RES join(LEFT t1, RIGHT t2);
}
