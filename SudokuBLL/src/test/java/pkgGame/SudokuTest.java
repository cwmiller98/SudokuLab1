/**
 * 
 */
/**
 * @author CharlieMiller
 *
 */
package pkgGame;
import static org.junit.Assert.*;


import java.util.Arrays;

import org.junit.Test;

public class SudokuTest {

	@Test
	public void Sudoku_Test1()
	{
		int[][] puzzle = { 
				{ 5, 3, 4, 6, 7, 8, 9, 1, 2 }, 
				{ 6, 7, 2, 1, 9, 5, 3, 4, 8 }, 
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, 
				{ 4, 2, 6, 8, 5, 3, 7, 9, 1 }, 
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 },
				{ 2, 8, 7, 4, 1, 9, 6, 3, 5 }, 
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		try {
			Sudoku sod1 = new Sudoku(puzzle);
			assertTrue(sod1.isSudoku());
		} 
			catch (Exception exc) 
		{
			fail("Test failed");
		}
		
	}
	
	@Test
	public void TestRegionNbr() { 
		Sudoku sod1= null;
		int[][] puzzle = { 
				{ 5, 3, 4, 6, 7, 8, 9, 1, 2 }, 
				{ 6, 7, 2, 1, 9, 5, 3, 4, 8 }, 
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, 
				{ 4, 2, 6, 8, 5, 3, 7, 9, 1 }, 
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, 
				{ 2, 8, 7, 4, 1, 9, 6, 3, 5 }, 
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		
		int [] Region2 = {9,1,2,3,4,8,5,6,7};
		try {
			 sod1 = new Sudoku(puzzle);
		} 
			catch (Exception exc) 
		{
			fail("Bad Sudoku");
		}
		assertTrue(Arrays.equals(Region2, sod1.getRegion(2)));	
	}
	
	
	@Test
	public void getPuzzle_Test1() throws Exception
	{
		int arr2[][] = { 
				{ 4, 5, 6 }, 
				{ 5, 6, 4 }, 
				{ 6, 4, 5 } };
		Sudoku sod = new Sudoku(arr2);
		
		assertTrue(Arrays.equals(arr2, sod.getPuzzle()));
	}
	
	@Test
	public void getPuzzle_Test2() throws Exception
	{
		int arr21[][] = { 
				{ 4, 5, 6 }, 
				{ 5, 6, 4 }, 
				{ 6, 4, 5 } };
		int arr22[][] = { 
				{ 7, 7, 7 }, 
				{ 6, 6, 6 }, 
				{ 5, 5, 5 } };
		Sudoku sod = new Sudoku(arr21);
		
		assertFalse(Arrays.equals(arr22, sod.getPuzzle()));
	}
	
	
	@Test
	public void getRegion_Test1() throws Exception
	{int arr2[][] = { 
			{ 1, 3, 4, 2 }, 
			{ 4, 2, 1, 3 }, 
			{ 2, 4, 3, 1 }, 
			{ 3, 1, 2, 4 } };
		int arr1[] = { 2, 4, 3, 1 }; 
		Sudoku sod = new Sudoku(arr2);		
		
		assertTrue(Arrays.equals(arr1, sod.getRegion(1, 2)));
	}
	
	@Test
	public void getRegion_Test2() throws Exception
	{int arr2[][] = { 
			{ 1, 3, 4, 2 }, 
			{ 4, 2, 1, 3 }, 
			{ 2, 4, 3, 1 }, 
			{ 3, 1, 2, 4 } };
		int arr1[] = { 1, 1, 1, 1 }; 
		Sudoku sod = new Sudoku(arr2);
		
		assertFalse(Arrays.equals(arr1, sod.getRegion(1, 2)));
	}
	
	@Test
	public void isPartialSudoku_test1() throws Exception
	{ int arr2[][] = { 
			{ 0, 3, 4, 2 }, 
			{ 4, 2, 1, 3 }, 
			{ 2, 4, 3, 1 }, 
			{ 3, 1, 2, 4 } };
		Sudoku sod = new Sudoku(arr2);	
		assertTrue(sod.isPartialSudoku());
	}
	
	@Test
	public void isPartialSudoku_test2() throws Exception
	{ int arr2[][] = { 
			{ 1, 3, 4, 2 }, 
			{ 4, 2, 1, 3 }, 
			{ 2, 4, 3, 1 }, 
			{ 3, 1, 2, 4 } }; 
		Sudoku sod = new Sudoku(arr2);
		assertFalse(sod.isPartialSudoku());
	}
}