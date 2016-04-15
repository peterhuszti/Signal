package beadando;

@FunctionalInterface
public interface Accumulater<RES, ORIG> {

	public RES accumulate(RES oldState, ORIG originalSignalState); 
}
