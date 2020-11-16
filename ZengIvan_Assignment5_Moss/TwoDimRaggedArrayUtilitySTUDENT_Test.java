
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	
	private double[][] DataSetSTUDENT1 = {{1,2,3},{4,5},{6,7,8}};
	private double[][] DATASetSTUDENT2 = {{-2.5,-5.3,6.1},{-4.4,8.2},{2.3,-7.5},{-4.2,7.3,-5.9,2.6}};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		DataSetSTUDENT1 =  DATASetSTUDENT2 = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(36.0,TwoDimRaggedArrayUtility.getTotal(DataSetSTUDENT1),.001);
		assertEquals(-3.3,TwoDimRaggedArrayUtility.getTotal(DATASetSTUDENT2),.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(4.5,TwoDimRaggedArrayUtility.getAverage(DataSetSTUDENT1),.001);
		assertEquals(-.3,TwoDimRaggedArrayUtility.getAverage(DATASetSTUDENT2),.001);
		
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(DataSetSTUDENT1,1),.001);
		assertEquals(3.8,TwoDimRaggedArrayUtility.getRowTotal(DATASetSTUDENT2,1),.001);
		assertEquals(-.2,TwoDimRaggedArrayUtility.getRowTotal(DATASetSTUDENT2,3),.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(11.0,TwoDimRaggedArrayUtility.getColumnTotal(DataSetSTUDENT1,0),.001);
		assertEquals(-8.8,TwoDimRaggedArrayUtility.getColumnTotal(DATASetSTUDENT2,0),.001);
		assertEquals(2.7,TwoDimRaggedArrayUtility.getColumnTotal(DATASetSTUDENT2,1),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(8.0,TwoDimRaggedArrayUtility.getHighestInArray(DataSetSTUDENT1),.001);
		assertEquals(8.2,TwoDimRaggedArrayUtility.getHighestInArray(DATASetSTUDENT2),.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(DATASetSTUDENT2, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(-2.5, array[0][0],.001);
		assertEquals(-5.3, array[0][1],.001);
		assertEquals(6.1, array[0][2],.001);
		assertEquals(-4.4, array[1][0],.001);
		
	}

}