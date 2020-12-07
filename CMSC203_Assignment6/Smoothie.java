public class Smoothie extends Beverage {
    private int amountFruits;
    private boolean addedProtein;

    public Smoothie(String Bevname, SIZE size,int amountFruits, boolean addedProtein) {
        
    	super(Bevname,TYPE.SMOOTHIE,size);
        
        this.amountFruits = amountFruits;
        this.addedProtein = addedProtein;

    }
    public String toString(){
        return Bevname + size + calcPrice();
    }
    //If statement to determine if there's extra fruit and or protein. Also if the consumer got a medium or large.
    @Override
    public double calcPrice() {
       
    	double smoothiePrice = 2.0;


        if(this.addedProtein == true) {
        	smoothiePrice +=1.50;
        }
        if(this.amountFruits > 0) {
        	smoothiePrice += .50 * this.amountFruits;
        }
        if(this.size.equals(SIZE.MEDIUM)){
        	smoothiePrice += 1.00;
        }
        if(this.size.equals(SIZE.LARGE)) {
        	smoothiePrice += 2.00;
        }

        return smoothiePrice; 
    }

    public boolean equals(String Bevname, TYPE type, SIZE size, int amountFruits, boolean addedProtein) {
        if(this.Bevname.equals(Bevname)) {
            if(this.type.equals(type)) {
                if(this.size.equals(size)) {
                    if(this.amountFruits > 0) {
                        if(this.addedProtein == true) {
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
    public Object getSize() {
        // TODO Auto-generated method stub
        return this.size;
    }
    @Override
    protected TYPE getType() {
        // TODO Auto-generated method stub
        return this.type;
    }
    public int getNumOfFruits() {
        // TODO Auto-generated method stub
        return this.amountFruits;
    }
    public boolean getAddProtien() {
        // TODO Auto-generated method stub
        return this.addedProtein;
    }
   
    }