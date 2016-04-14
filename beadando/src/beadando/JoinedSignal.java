package beadando;

public class JoinedSignal<RES, LEFT, RIGHT> extends Signal<RES> {
	
	protected Joiner<RES, LEFT, RIGHT> creatingAction = null;
	protected Signal<?> leftParent = null;
	protected Signal<?> rightParent = null;

	protected JoinedSignal(RES value) {
		super(value);
	}
	
	@Override
	public <T> void changeValue(T newValue) {
		lastValue = creatingAction.join((LEFT) leftParent.getLastValue(), (RIGHT) rightParent.getLastValue());
		
		for(int i=0; i<dependants.size(); ++i) {
			dependants.get(i).notify((Signal<T>)this, newValue);
		}
	}

	@Override
	public <T> void notify(Signal<T> signal, T newValue) {
		changeValue(newValue);			
	}
	
}
