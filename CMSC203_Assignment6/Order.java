import java.util.ArrayList;
import java.util.Random;

class Order implements OrderInterface{

	private int OrderTime;
	private int numOrder;
	
	private Customer customer;
	private DAY day;
	
	private ArrayList<Beverage> theBevs = new ArrayList<Beverage>() ;

	public Order()
	{

	}
	
	public Order(int OrderTime, DAY day, Customer customer)
	{
		this.day = day;
		this.customer = customer;
		this.OrderTime = OrderTime;
		this.numOrder = randomNum();
	
	}

	//Return a random number 
	public int randomNum()
	{
		int randNum;

		Random ranNum = new Random();
		randNum = ranNum.nextInt(90000 - 10000 +1) + 10000;

		return randNum;
	}
	//Return boolean if it's weekends
	@Override
	public boolean isWeekend() {

		if(this.day == DAY.SATURDAY || this.day == DAY.SUNDAY)
		{
			return true;
		}
		return false;
	}
	
	public void addNewBeverage(String name, SIZE size, boolean extraShot, boolean extraSyrup)
	{
		Coffee newCoffeeBev = new Coffee(name, size, extraShot, extraSyrup);

		this.theBevs.add(newCoffeeBev);
	}

	
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtien)
	{
		Smoothie newSmoothieBev = new Smoothie(bevName, size, numOfFruits, addProtien);

		this.theBevs.add(newSmoothieBev);
	}

	
	public void addNewBeverage( String name, SIZE size)
	{
		Alcohol newAlcoholBev = new Alcohol(name, size, this.isWeekend());

		this.theBevs.add(newAlcoholBev);
	}
	
	// Return the order total 
	@Override
	public double calcOrderTotal() {

		double total = 0.0;

		for( int i = 0; i < this.theBevs.size(); i++)
		{
			total += this.theBevs.get(i).calcPrice();
		}
		return total;
	}

	
	//Return the number of same beverages 
	@Override
	public int findNumOfBeveType(TYPE type) {
		int num = 0;

		for(int i = 0; i < this.theBevs.size(); i++)
		{
			if(this.theBevs.get(i).getType() == type)
		{
				num++;
			}
	}
		return num;
	}

	
	public String toString()
	{

		String ListOfBevs = "";
		String completeOrder; 

		for( int x = 0; x < theBevs.size(); x++)
		{
			ListOfBevs = ListOfBevs + theBevs.get(x).toString();
		}
		completeOrder = this.numOrder + " " + this.OrderTime + " " + this.day + " " + this.customer.getName() + " " + this.customer.getAge() + " " + ListOfBevs + " " + calcOrderTotal();

		return completeOrder;
	}

	
	//Return by comparing the order and return if lower,higher and equal orders. 
	public int compareTo(Order order)
	{
		int compareOrders = 0;

		if(order.getOrderNo() > this.numOrder) {
			
			compareOrders = 1;
		}
		else if(order.getOrderNo() < this.numOrder){
			
			compareOrders = -1;
		}
		else if(order.getOrderNo() == this.numOrder){
			
			compareOrders = 0;
		}
		return compareOrders;

	}

	
	public void setnumOrder(int numOrder)
	{
		this.numOrder = numOrder;
	}

	
	public void setTime(int orderTime)
	{
		this.OrderTime = orderTime;
	}

	
	public void setOrderDay(DAY day)
	{
		this.day = day;
	}

	
	public void setCustomer(Customer _customer)
	{
		this.customer = _customer;
	}

	
	public int getOrderNo()
	{
		return this.numOrder;
	}

	
	public int getOrderTime()
	{
		return this.OrderTime;
	}

	
	public DAY getOrderDay()
	{
		return this.day;
	}

	
	public Customer getCustomer()
	{
		return new Customer(this.customer.getName(), this.customer.getAge());
	}



	
	@Override
	public Beverage getBeverage(int itemNo) {

		return theBevs.get(itemNo);
	}

	
	
	public int getTotalItems()
	{	
		return this.theBevs.size();
	}



}
