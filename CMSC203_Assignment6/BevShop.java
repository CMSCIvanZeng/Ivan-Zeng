import java.util.ArrayList;

public class BevShop implements BevShopInterface{

	int AlcoholOrder;
	
	ArrayList<Order> tracklist = new ArrayList<Order>();
	
	// return boolean if time is valid
	@Override
	public boolean validTime(int time) {
		
		if(time <= 23 && time >=8){
			return true;
		}
		return false;
	}

	
	//return a boolean if the customer can get more alcohol
	@Override
	
	public boolean eligibleForMore() {

		Order theOrder = getCurrentOrder();
		
		this.AlcoholOrder = theOrder.findNumOfBeveType(TYPE.ALCOHOL);

		if(this.AlcoholOrder < MAX_ORDER_FOR_ALCOHOL)
		{
			return true;
		}
		return false;
	}
	
	//return a boolean if its the min age required
	@Override
	public boolean validAge(int age) {
		
		if(age > MIN_AGE_FOR_ALCOHOL)
		{
			return true;
		}
		return false;
	}
	
	// Start new order with new customer name,age,time, day.
	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {

		Customer newConsumer = new Customer(customerName, customerAge);
		Order orderNew = new Order(time, day, newConsumer);

		this.tracklist.add(orderNew);
	}


	@Override
	public void processCoffeeOrder(String Bevname, SIZE size, boolean Shot, boolean Syrup) {
		
		Order newOrderCoffee = getCurrentOrder();
		newOrderCoffee.addNewBeverage(Bevname,  size,  Shot,  Syrup);

	}

	
	@Override
	public void processAlcoholOrder(String Bevname, SIZE size) {

		Order newOrderAlcohol = getCurrentOrder();
		newOrderAlcohol.addNewBeverage(Bevname, size);

	}


	@Override
	public void processSmoothieOrder(String Bevname, SIZE size, int amountFruits, boolean addedProtien) {

		Order newOrderSmoothie = getCurrentOrder();
		newOrderSmoothie.addNewBeverage(Bevname, size, amountFruits, addedProtien);

	}

	
	//return the order index 
	@Override
	public int findOrder(int orderNo) {

		int index = 0;

		for(int x = 0; x < this.tracklist.size(); x++)
		{
			if(orderNo == tracklist.get(x).getOrderNo())
			{
				index = x;
			}
		}
		return index;

	}

	
	@Override
	public double totalOrderPrice(int orderNo)
	{
		return getOrderAtIndex(findOrder(orderNo)).calcOrderTotal();
	}

	//return monthly sales total 
	@Override
	public double totalMonthlySale() {

		double monthlyTotal = 0.0;

		for (int x = 0; x < tracklist.size(); x++)
		{
			monthlyTotal += tracklist.get(x).calcOrderTotal();
		}
		return monthlyTotal;
	}

	@Override
	public void sortOrders() {

		int lowIndex = 0;

		Order placeOrder = new Order();
		for(int i = 0; i < tracklist.size(); i++)
		{
			placeOrder = tracklist.get(i);
			lowIndex = i;

			for(int j = i + 1; j < tracklist.size(); j++)
			{
				if(tracklist.get(j).getOrderNo() < tracklist.get(i).getOrderNo())
				{
					placeOrder = tracklist.get(j);
					lowIndex = j;
				}
			}

			Order dw = new Order();

			dw = tracklist.get(i);
			tracklist.set(lowIndex, dw);
			tracklist.set(i, placeOrder);

		}

	}

	
	@Override
	public Order getOrderAtIndex(int index) {

		return this.tracklist.get(index);
	}

	
	public Order getCurrentOrder() {
		return tracklist.get(tracklist.size() - 1);
	}


	public Object totalNumOfMonthlyOrders() {

		return tracklist.size();
	}


	
	public String toString()
	{
		String ListofOrders = "";

		for( int i = 0; i < tracklist.size(); i++)
		{
			ListofOrders += tracklist.get(i);
		}

		ListofOrders += totalMonthlySale();

		return ListofOrders;
	}

	
	public boolean isMaxFruit(int x) {

		if(x > MAX_FRUIT)
		{
			return true;
		}
		return false;
	}

	//return the amount of alcohol drinks
	public int getNumOfAlcoholDrink() {

		int AlcoholAmount = 0;

		AlcoholAmount = getCurrentOrder().findNumOfBeveType(TYPE.ALCOHOL);	

		return AlcoholAmount;
	}
	
	//Return the max amount of alcohol order for consumer
	public int getMaxOrderForAlcohol() {		
		return MAX_ORDER_FOR_ALCOHOL ;
	}

	//return the min amount of alcohol order for consumer 
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}

}
