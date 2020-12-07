public abstract class Beverage {

	//Instance Variables 
    protected String Bevname;
    protected TYPE type;
    protected SIZE size; 

    static final double BASEPRICE = 2.0; 
    static final int SIZEPRICE = 1; 


Beverage(String Bevname,TYPE type, SIZE size) {
   
	this.Bevname =  Bevname; 
    this.type = type;
    this.size = size; 
}

public abstract double calcPrice();




public String toString() {

    return Bevname + size;
}

public boolean equals(Beverage bev) {

    if(this.Bevname.equals(bev.Bevname)) {
        if(this.type.equals(bev.type)) {
            if(this.size.equals(bev.size)) {

                return true; 

            }
        }

    }
    return false;
}
public double getBasePrice() {
    // TODO Auto-generated method stub
    return BASEPRICE;
}

public CharSequence getBevName() {
    // TODO Auto-generated method stub
    return this.Bevname;
}

public Object getSize() {
    // TODO Auto-generated method stub
    return this.size;
}

protected Object getType() {
    // TODO Auto-generated method stub
    return this.type;
}



}