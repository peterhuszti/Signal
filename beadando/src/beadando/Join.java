package beadando;

public class Join<RES, LEFT, RIGHT>  extends Action {
	
	private Joiner<RES, LEFT, RIGHT> joiner;
	
	public Join(Joiner<RES, LEFT, RIGHT> joiner) {
		this.joiner = joiner;
		isConst = false;
	}
	
	public RES act(LEFT left, RIGHT right) {
		return joiner.join(left, right);
	}

/*	public RES act(Object left, Object right) {
		return joiner.join(left, right);
	}*/
}
