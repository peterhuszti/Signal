package beadando;

public class AccumulatedSignal<TYPE, ORIG> extends Signal<TYPE> {

	protected Accumulater<TYPE, ORIG> creatingAction = null;
	protected Signal<ORIG> parent = null;
	
	protected AccumulatedSignal(TYPE value) {
		super(value);
	}
	
	public void changeValue() {
		lastValue = creatingAction.accumulate(lastValue, parent.getLastValue());
		
		for(int i=0; i<dependants.size(); ++i) {
			dependants.get(i).notifyME();
		}
	}

	@Override
	public void notifyME() {
		changeValue();
	}
	
}
