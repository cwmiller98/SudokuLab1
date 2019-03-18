package pkgHelper;
import pkgEnum.ePuzzleViolation;
import java.util.Arrays;
import java.util.ArrayList;
import org.apache.commons.lang.ArrayUtils;

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



