public class Alcohol extends Beverage{

    private boolean WeekendDrinks;

    public Alcohol(String Bevname, SIZE size, boolean WeekendDrinks) {
        
    	super(Bevname,TYPE.ALCOHOL,size);
        this.WeekendDrinks = WeekendDrinks;

    }
    public String toString(){
       
    	return Bevname + size + calcPrice();
    }

    @Override
    public double calcPrice() {
        double alcoholPrice = 2.0;


        if(this.WeekendDrinks == true) {
        	alcoholPrice += 0.60;
        }
        if(this.size.equals(SIZE.MEDIUM)){
        	alcoholPrice += 1.00;
        }
        if(this.size.equals(SIZE.LARGE)) {
        	alcoholPrice += 2.00;
        }

        return alcoholPrice; 
    }

    public boolean equals(String Bevname, TYPE type, SIZE size, boolean WeekendDrinks) {
        if(this.Bevname.equals(Bevname)) {
            if(this.type.equals(type)) {
                if(this.size.equals(size)) {
                        if(this.WeekendDrinks == true) {
                            return true;
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

    public Object getSize() {
        // TODO Auto-generated method stub
        return this.size;
    }
    @Override
    protected TYPE getType() {
        // TODO Auto-generated method stub
        return this.type;
    }


}