
public class Coffee extends Beverage{ 


	private boolean extraShot; 
	private boolean extraSyrup;

	//declaring the parametrized constructor 
	public Coffee(String Bevname, SIZE size,boolean extraShot, boolean extraSyrup) 
	{
		super(Bevname,TYPE.COFFEE,size); 

		this.extraSyrup = extraSyrup;
		this.extraShot= extraShot;

	}
	
	//return the name, size and price of the coffee drink 
	public String toString(){
		return Bevname + size + calcPrice(); 
	}

	//If statement to determine if there's extra shot and or syrup. Also if the consumer got a medium or large. 
	@Override
	public double calcPrice() {

		double coffePrice = 2.0; 

		if(this.extraSyrup == true) {
			coffePrice +=.50;
		}
		if(this.extraShot== true) {
			coffePrice += .50;
		}
		if(this.size.equals(SIZE.MEDIUM)){
			coffePrice += 1.00;
		}
		if(this.size.equals(SIZE.LARGE)) {
			coffePrice += 2.00;
		}

		return coffePrice; 
	}

	
	public boolean equals(String Bevname, TYPE type, SIZE size, boolean extraShot, boolean extraSyrup) {

		if(this.Bevname.equals(Bevname)) {
			if(this.type.equals(type)) {
				if(this.size.equals(size)) {
					if(this.extraShot == extraShot) {
						if(this.extraSyrup == extraSyrup) {

							return true;
						}
					}

				}
			}
		}
		return false;
	}


	public CharSequence getBevName() {
		// TODO Auto-generated method stub
		return this.Bevname;
	}
	@Override
	protected TYPE getType() {
		// TODO Auto-generated method stub
		return this.type;
	}
	public Object getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}
	public boolean getExtraShot() {
		// TODO Auto-generated method stub
		return this.extraShot;
	}

	public boolean getExtraSyrup() {
		// TODO Auto-generated method stub
		return this.extraSyrup;
	}
}


