package medic.dao;

public class Company {
	private String id,name,category;
	public Company(){}
	public Company(String id,String name,String category){
		this.id=id;
		this.name=name;
		this.category=category;
	}
	String getid(){
		return this.id;
	}
	String getname(){
		return this.name;
	}
	String getcat(){
		return this.category;
	}
	void setid(String s){
		this.id=s;
	}
	void setname(String s){
		this.name=s;
	}
	void setcate(String s){
		this.category=s;
	}
}