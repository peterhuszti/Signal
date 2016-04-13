package beadando;

@FunctionalInterface
public interface Mapper<RES, PAR> {

	public RES map(PAR input);
}
