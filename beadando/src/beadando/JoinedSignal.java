package beadando;

public class JoinedSignal<RES, LEFT, RIGHT> extends Signal<RES> {
	
	protected Joiner<RES, LEFT, RIGHT> creatingAction = null;
	protected Signal<LEFT> leftParent = null;
	protected Signal<RIGHT> rightParent = null;

	protected JoinedSignal(RES value) {
		super(value);
	}
	
	public <T> void changeValue() {
		lastValue = creatingAction.join((LEFT) leftParent.getLastValue(), (RIGHT) rightParent.getLastValue());
		
		for(int i=0; i<dependants.size(); ++i) {
			dependants.get(i).notifyME();
		}
	}
	
	@Override
	public void notifyME() {
		changeValue();
	}
	
}
