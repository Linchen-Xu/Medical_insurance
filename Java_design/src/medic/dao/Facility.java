package medic.dao;

public class Facility {
	private String id,name;
	public Facility(){}
	public Facility(String id,String name){
		this.id=id;
		this.name=name;
	}
	String getname(){
		return this.name;
	}
	String getid(){
		return this.id;
	}
	void setid(String s){
		this.id=s;
	}
	void setname(String s){
		this.name=s;
	}
}
