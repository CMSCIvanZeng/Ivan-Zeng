public class Customer {
   
	//Instance Variables
	private String name;
    private int age;

public Customer(String name, int age){
        this.name = name;
        this.age = age; 

    }

public Customer(Customer cus) {
    this.name = cus.name;
    this.age = cus.age;

}
public String toString(){
return name + age;
}

public void setName(String string) {
    this.name = string;

}

public String getName() {
    // TODO Auto-generated method stub
    return this.name;
}


public int getAge() {
    // TODO Auto-generated method stub
    return this.age;
}

public void setName(int i) {
    // TODO Auto-generated method stub


}

public void setAge(int i) {
    // TODO Auto-generated method stub
    this.age= i;
}

}