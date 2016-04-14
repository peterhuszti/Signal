package beadando;

public class MappedSignal<TYPE> extends Signal<TYPE> {
 
	protected Mapper<TYPE> creatingAction = null;
	protected Signal<?> parent = null;
	
	protected MappedSignal(TYPE value) {
		super(value);
	}

	@Override
	public <T> void changeValue(T newValue) {
		lastValue = creatingAction.map((TYPE) newValue);
		
		for(int i=0; i<dependants.size(); ++i) {
			dependants.get(i).notify((Signal<T>)this, newValue);
		}
	}
	
	@Override
	public <T> void notify(Signal<T> parent, T newValue) {
		changeValue(newValue);		
	}
}
