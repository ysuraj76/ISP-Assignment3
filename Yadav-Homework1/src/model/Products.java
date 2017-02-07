package model;

public class Products {
	
	int id;
	String name;
	String type;
	String path;
	String description;
	String ship_time;
	String quantity;
	String price;
	
public Products(int id,String name,String type,String path, String desc, String ship, String qnty, String price){
	this.id=id;
	this.name=name;
	this.type=type;
	this.path=path;
	this.description=desc;
	this.ship_time=ship;
	this.quantity=qnty;
	this.price=price;
}

public int getPid(){
	
	return id;
}


}
