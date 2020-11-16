
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public final class TwoDimRaggedArrayUtility extends java.lang.Object{
	public static double[][] readFile (java.io.File file)
			throws java.io.FileNotFoundException
	{

		Scanner readFile = new Scanner(file);
		int nLines;
		nLines = 0; 

		do { 
			readFile.nextLine();
			nLines++; 

		}while(readFile.hasNextLine()); 

		readFile.close();


		readFile = new Scanner(file);
		double[][] dataArray = new double[nLines][];


		for(int i = 0; i < nLines; i++){
			String[] theLine;
			theLine = readFile.nextLine().split(" ");
			dataArray[i] = new double[theLine.length];

			for(int j = 0; j < theLine.length; j++){
				dataArray[i][j] = Double.parseDouble(theLine[j]);
			}
		}

		readFile.close();

		return dataArray;

	}
	//definition of the method writeToFile
	//pass in a two dimensional ragged array of doubles and a file,
	//and writes the ragged array into the file. Each row is on a
	//separate line and each double is separated by a space.
	public static void writeToFile(double[][] data,java.io.File outputFile)
			throws java.io.FileNotFoundException
	{

		try {


			PrintWriter openFile = new PrintWriter(outputFile);
			String theLine;

			for(int i = 0; i < data.length; i++){
				theLine = "" + data[i][0];

				for(int j = 1; j < data[i].length; j++){
					theLine += " " + data[i][j];
				}
				openFile.println(theLine);
			}
			openFile.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}



	public static double getTotal(double[][] data)
	{
		double ArraySum = 0;

		//This loop will find the sum of the array. 
		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[i].length;j++)
			{
				ArraySum += data[i][j];
			}
		}
		return ArraySum;
	}

	public static double getAverage(double[][] data)
	{
		double ArrayNumber=0;
		double ElementNumber=0;

	
		for(int i=0 ; i<data.length; i++)
		{
			for(int j=0; j<data[i].length; j++)
			{
				ArrayNumber += data[i][j];
				ElementNumber ++;

			}
		}

		return new Double(ArrayNumber/ElementNumber);
	}

	public static double getRowTotal(double[][] data,int row)
	{
		double ArrayNumber = 0; 

		for(int j=0; j<data[row].length; j++) {

			ArrayNumber += data[row][j]; 

		}
		return ArrayNumber; 
	}

	public static double getColumnTotal(double[][] data,int col)
	{
		double ArrayNumber = 0;
		double[][] num = data; 

		for(int i=0; i<num.length; i++)
		{
			try {

				ArrayNumber += data[i][col];

			}catch (Exception e) 
			{
				continue;
			}
		}
		return ArrayNumber;
	}

	public static double getHighestInRow(double[][] data,int row)
	{
		double HighInRow;
		HighInRow = data[row][0];

		for(int i=0; i<data[row].length; i++)
		{
			if(HighInRow < data[row][i])
			{
				HighInRow = data[row][i];
			}
		}
		return HighInRow;
	}
	public static int getHighestInRowIndex(double[][] data, int row) {

		int Index = 0;

		for (int j=0; j<data[row].length; j++)
		{
			if (data[row][Index] < (data[row][j]))
			{
				Index = j;
			}
		}

		return Index;

	}

	public static double getLowestInRow(double[][] data,int row)
	{
		double LowInRow;
		LowInRow = data[row][0];

		for(int i=0; i<data[row].length; i++)
		{
			if(LowInRow > (data[row][i]))	
			{
				LowInRow= data[row][i];
			}

		}	
		return LowInRow;

	}
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		int Index = 0;

		for (int j=0; j<data[row].length; j++)
		{
			if(data[row][Index] > (data[row][j])) 
			{
				Index = j;
			}
		}
		return Index;

	}

	public static double getHighestInColumn(double[][] data,int col)
	{
		double HighInColumn;
		HighInColumn = data[col][0];

		for(int i=0; i<data[col].length; i++)
		{
			if(HighInColumn < data[col][i])
			{
				HighInColumn = data[col][i];
			}
		}

		return data[getHighestInColumnIndex(data, col)][col];    
	}
	public static int getHighestInColumnIndex(double[][] data, int col)
	{

		int Index = 0;
		double ColumnHighest =-1; 

		for(int i=0; i<data.length; i++){

			try {
				if(ColumnHighest < data[i][col])
				{
					Index = i;
					ColumnHighest = data[i][col];

				}
			}catch(Exception e) 
			{
				continue;
			}
		}
		return Index;

	}

	public static double getLowestInColumn(double[][] data,int col)
	{
		double LowInColumn;
		LowInColumn = data[col][0];

		for(int i=0; i<data[col].length; i++)
		{
			if(LowInColumn > (data[col][i]))	
			{
				LowInColumn = data[col][i];
			}

		}	

		return data[getLowestInColumnIndex(data, col)][col]; 
	}
	public static int getLowestInColumnIndex(double data[][], int col){

		int Index = 0;
		double ColumnLowest = Integer.MAX_VALUE;

		for(int i=0; i<data.length; i++) {

			try {
				if(ColumnLowest > data[i][col]) 
				{
					Index = i;
					ColumnLowest = data[i][col];

				}
			}catch(Exception e)
			{
				continue;
			}
		}
		return Index;

	}
	public static double getHighestInArray(double[][] data)
	{
		double ArrayHighest;
		ArrayHighest = -1;

		for(int i=0; i<data.length; i++)
		{
			for(int j=0; j<data[i].length; j++)
			{
				if(data[i][j ]> ArrayHighest) 
				{
					ArrayHighest= data[i][j];

				}
			}
		}
		return ArrayHighest;

	}

	public static double getLowestInArray(double[][] data)
	{
		double ArrayLowest; 
		ArrayLowest = Integer.MAX_VALUE;

		for(int i=0; i<data.length; i++)
		{
			for(int j=0; j<data[i].length; j++)
			{
				if(ArrayLowest > data[i][j])
				{
					ArrayLowest= data[i][j];
				}
			}
		}
		return ArrayLowest;
	}
	

}
