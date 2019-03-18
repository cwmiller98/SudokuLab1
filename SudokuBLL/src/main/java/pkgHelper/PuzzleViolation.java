package pkgHelper;
import pkgEnum.ePuzzleViolation;

public class PuzzleViolation {
	private ePuzzleViolation pv;
	private int val;
	
	public PuzzleViolation(pkgEnum.ePuzzleViolation pv, int val) {
		super();
		pv = pv;
		val = val;
	}
	
	public ePuzzleViolation getPuzzleViolation() {
		return pv;
	}
	public int getiValue() {
		return val;
	}
	}



