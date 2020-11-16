
public class HolidayBonus extends java.lang.Object{


	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {

		final int ARRAY_DATA = data.length; 
		double[] theBonus = new double[ARRAY_DATA];


		for(int row = 0; row < ARRAY_DATA; row++) {
			for(int col = 0; col < data[row].length; col++) {

				double SaleHighest= TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
				double SaleLowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);

				if(data[row][col] <= 0){
				}else if(SaleHighest == data[row][col] ) {
					theBonus[row] += high;
				}
				else if(SaleLowest == data[row][col] ){
					theBonus[row] += low;
				}
				else {
					theBonus[row] += other;
				}
			}
		}
		return theBonus;
	}


	public static double calculateTotalHolidayBonus(double [][] data, double high, double low, double other)
	{

		double[] TotalBonus = calculateHolidayBonus(data, high, low, other);
		final int totalLength = TotalBonus.length; 
		double totalHoliday = 0.0;
		int i;    

		for(i = 0; i < totalLength; i++)
		{
			totalHoliday += TotalBonus[i];
		}
		return totalHoliday;
	}

}
