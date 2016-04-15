package beadando;

public class MappedSignal<TYPE> extends Signal<TYPE> {
 
	protected Mapper<TYPE> creatingAction = null;
	protected Signal<TYPE> parent = null;
	
	protected MappedSignal(TYPE value) {
		super(value);
	}

	@Override
	public void recalcValue() {
		lastValue = creatingAction.map(parent.getLastValue());
		
		for(int i=0; i<dependants.size(); ++i) {
			dependants.get(i).recalcValue();
		}
	}
	
}
