package medic.dao;

public class Institution {
	private String id,name;
	private int level;
	public Institution(){}
	public Institution(String id,String name,int level){
		this.id=id;
		this.name=name;
		this.level=level;
	}
	String getname(){
		return this.name;
	}
	String getid(){
		return this.id;
	}
	int getlevel(){
		return this.level;
	}
	void setid(String s){
		this.id=s;
	}
	void setname(String s){
		this.name=s;
	}
	void setlev(int s){
		this.level=s;
	}
}
