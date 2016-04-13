package beadando;

import java.util.ArrayList;

public class Signal<T> implements Runnable {

	public Action<T> action;
	
	protected T lastValue;
	protected ArrayList<MappedSignal<?>> mappedFromMe;
	protected ArrayList<JoinedSignal<?,?,?>> joinedFromMe;
	protected ArrayList<AccumulatedSignal<?,?>> accumulatedFromMe;
	protected ArrayList<Boolean> isRight;
	
	protected <S> void addMapDep(MappedSignal<S> s, Boolean isRight) {
		mappedFromMe.add(s);
		this.isRight.add(isRight);
	}
	
	protected <S, V, W> void addJoinDep(JoinedSignal<S, V, W> s, Boolean isRight) {
		joinedFromMe.add(s);
		this.isRight.add(isRight);
	}
	
	protected <S, V> void addAccDep(AccumulatedSignal<S, V> s, Boolean isRight) {
		accumulatedFromMe.add(s);
		this.isRight.add(isRight);
	}
		
	protected Signal(T value) {
		lastValue = value;
		mappedFromMe = new ArrayList<MappedSignal<?>>();
		joinedFromMe = new ArrayList<JoinedSignal<?,?,?>>();
		accumulatedFromMe = new ArrayList<AccumulatedSignal<?,?>>();
		isRight = new ArrayList<Boolean>();
	}
	
	protected Signal(T value, Action<T> action) {
		this.action = action;
		lastValue = value;
		mappedFromMe = new ArrayList<MappedSignal<?>>();
		joinedFromMe = new ArrayList<JoinedSignal<?,?,?>>();
		accumulatedFromMe = new ArrayList<AccumulatedSignal<?,?>>();
		isRight = new ArrayList<Boolean>();
	}

	public static <S> Signal<S> createConstSignal(S value) {
		return new Signal<S>(value, new Action<S>());
	}
	
	public static <S> Signal<S> createSignal(S value, Action<S> action) {
		return new Signal<S>(value, action);
	}
	
	public static <S> MappedSignal<S> createMappedSignal(S value, Map<S> action) {
		return new MappedSignal<S>(value, action);
	}
	
	public static <S, V, W> JoinedSignal<S, V, W> createJoinedSignal(S value, Join<S, V, W> action) {
		return new JoinedSignal<S, V, W>(value, action);
	}
	
	public static <S, V> AccumulatedSignal<S, V> createAccumulatedSignal(S value, Accumulater<S, V> action) {
		return new AccumulatedSignal<S, V>(value, action);
	}

	public MappedSignal<T> map(Mapper<T> mapper) {
		MappedSignal<T> result = createMappedSignal(mapper.map(lastValue), new Map<T>(mapper));
		this.addMapDep(result, false);
		
		return result;
	}
	
	public <S, V> JoinedSignal<S, T, V> join(Signal<V> s, Joiner<S, T, V> joiner) {
		JoinedSignal<S, T, V> result = createJoinedSignal(joiner.join(lastValue, s.getLastValue()), new Join<S, T, V>(joiner));
		this.addJoinDep(result, false);
		s.addJoinDep(result, true);
		result.setLeft(this);
		result.setRight(s);
		
		return result;
	}

/*	public <S, V> AccumulatedSignal<S, V> accumulate(Accumulater<S, V> acc, V lastState) {
		AccumulatedSignal<S, V> result = createAccumulatedSignal(acc.accumulate(lastState, this.lastValue), new Accumulate<S, V>(acc));
		addAccDep(result, false);
		
		return result;
	}*/
	
	public T getLastValue() {
		return lastValue;
	}
	
/*	public void changeValue(T newValue, Boolean isRight) {
		if(!isRight) {
			if(action instanceof Map) {
				//lastValue = action.act(newValue, left.getLastValue());
				lastValue = ((Map<T>) action).act(newValue);
			} else if(action instanceof Join) {
			//	lastValue = ((Join<T, T, T>) action).act(newValue, left.getLastValue());
			}
		} else {
	//		lastValue = action.act(newValue, right.getLastValue());
		}
		
		for(int i=0; i<dep.size(); ++i) {
			dep.get(i).changeValue(newValue, this.isRight.get(i));
		}
	}*/
	protected void broadcast(T newValue, Boolean isRight) {
		for(int i=0; i<this.mappedFromMe.size(); ++i) {
			((MappedSignal<T>) mappedFromMe.get(i)).changeValue(newValue, this.isRight.get(i));
		}
	/*	for(int i=0; i<this.joinedFromMe.size(); ++i) {
			((JoinedSignal<T,?,?>) joinedFromMe.get(i)).changeValue(newValue, this.isRight.get(i));
		}*/
		/*for(int i=0; i<this.mappedFromMe.size(); ++i) {
			((MappedSignal<T>) mappedFromMe.get(i)).changeValue(newValue, this.isRight.get(i));
		}*/
	}
	
	public void changeValue(T newValue, Boolean isRight) {
	//	lastValue = newValue;
		
		//broadcast(newValue, isRight);
	}
	

	@Override
	public void run() {
		
	}
	
}
