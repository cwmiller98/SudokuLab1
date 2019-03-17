/**
 * 
 */
/**
 * @author CharlieMiller
 *
 */
package pkgGame;

import java.util.Arrays;

import pkgHelper.LatinSquare;


public class Sudoku extends LatinSquare {
	public Sudoku( ) {
		super();
	}
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
	}
	
	protected int[][] getPuzzle()
	{
		return super.getLatinSquare();
	}
	protected int[] getRegion(int r)
	{
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		int[] myRegion = new int[puzzle.length];
		int iCnt = 0;
		int iSize = puzzle.length;
		int iSizeSqrt = (int) Math.sqrt(iSize);
				
		
		for (int iRow = (r/iSizeSqrt) * iSizeSqrt; iRow < ((r / iSizeSqrt) * iSizeSqrt) + iSizeSqrt; iRow++)
		{
			for (int iCol = (r % iSizeSqrt) * iSizeSqrt; iCol < ((r % iSizeSqrt) * iSizeSqrt) + iSizeSqrt; iCol++) 
					{
					myRegion[iCnt++] = puzzle[iRow][iCol];
		}
		}
				
				return myRegion;
	}
	protected int[] getRegion(int Col, int Row)
	{
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		int iSize = puzzle.length;
		int iSizeSqrt = (int) Math.sqrt(iSize);
		int i = (Col / iSizeSqrt) + ((Row / iSizeSqrt) * iSizeSqrt);
		
		return getRegion(i);
	}
	
	protected boolean isSudoku()
	{
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		int iSize = puzzle.length;
		boolean isPartialSudoku = true;
		
		if (!super.isLatinSquare())
		{
			isPartialSudoku = false;
		}
		
		for (int i = 0; i < iSize; i++)
		{
			if (super.hasDuplicates(getRegion(i)))
			{
				isPartialSudoku = false;
			}
			
			if (!super.hasAllValues(super.getRow(0), getRegion(i)))
			{
				isPartialSudoku = false;
			}
		}
		
			if (isPartialSudoku && !super.ContainsZero())
		{
			return true;
		}
		
		return false;
	}
	
	protected boolean isPartialSudoku() {
		boolean isPartialSudoku = true;
		
		if (!ContainsZero())
		{
			return false;
		}
		
		return isPartialSudoku;
	}

	protected boolean isValueValid(int iValue, int Col, int Row) {
		boolean isValidValue = true;
		
		if ((super.doesElementExist(super.getColumn(Col), iValue)) || (super.doesElementExist(super.getRow(Row), iValue)))
		{
			isValidValue = false;
		}
		return isValidValue;
	}
	
	@Override
	protected boolean hasDuplicates() throws Exception 
	{
		if (super.hasDuplicates())
			return true;
		
		for (int i = 0; i < this.getPuzzle().length; i++) {
			if (super.hasDuplicates(getRegion(i))) {
				return true;
			}
		}
	}
	
}