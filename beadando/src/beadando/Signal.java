package beadando;

import java.util.ArrayList;

public class Signal<TYPE> {

	protected TYPE lastValue;
	protected ArrayList<Signal<?>> dependants;
	
	protected Signal(TYPE value) {
		
		dependants = new ArrayList<>();		
		lastValue = value;
	}
	
	public static <S> Signal<S> createSignal(S value) {
		Signal<S> result = new Signal<S>(value);
				
		return result;
	}

	public MappedSignal<TYPE> map(Mapper<TYPE> mapper) {
		MappedSignal<TYPE> result = new MappedSignal<TYPE>(mapper.map(lastValue));
		
		result.creatingAction = mapper;
		result.parent = this;
		dependants.add(result);
		
		return result;
	}
	
	public <RES, RIGHT> JoinedSignal<RES, TYPE, RIGHT> join(Signal<RIGHT> right, Joiner<RES, TYPE, RIGHT> joiner) {
		JoinedSignal<RES, TYPE, RIGHT> result = new JoinedSignal<RES, TYPE, RIGHT>(joiner.join(lastValue, right.getLastValue()));
		
		result.creatingAction = joiner;
		result.leftParent = this;
		result.rightParent = right;
		
		dependants.add(result);
		right.dependants.add(result);
		
		return result;
	}

	
	public <T> void changeValue(T newValue) {
		lastValue = (TYPE) newValue;
		
		for(int i=0; i<dependants.size(); ++i) {
			dependants.get(i).notify((Signal<T>)this, newValue);
		}
	}

	public <T> void notify(Signal<T> parent, T newValue) {}

	public TYPE getLastValue() {
		return lastValue;
	}
	
}
