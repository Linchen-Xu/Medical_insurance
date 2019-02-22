package medic.dao;



public class Recipe {
	private int category;
	private String names;
	private double price,total;
	private int number;
	public Recipe(){}
	public Recipe(int category,String names,double price,double total,int number){
		this.category=category;
		this.names=names;
		this.price=price;
		this.total=total;
		this.number=number;
	}
	int getcate(){
		return this.category;
	}
	String getname(){
		return this.names;
	}
	double getprice(){
		return total;
	}
	double gettotal(){
		return this.total;
	}
	int getnum(){
		return this.number;
	}
	void setcate(int s){
		this.category=s;
	}
	void setname(String s){
		this.names=s;
	}
	void setprice(double s){
		this.price=s;
	}
	void settotal(double s){
		this.total=s;
	}
	void setnum(int s){
		this.number=s;
	}
	Recipe get(){
		return new Recipe(category,names,price,total,number);
	}
}
