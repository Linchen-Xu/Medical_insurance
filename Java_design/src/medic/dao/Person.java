package medic.dao;

public class Person {
	private String id,citicode,name,birthday;
	private boolean sex;
	Person(){}
	Person(String id,String citicode,String name,boolean sex,String birthday){
			this.id=id;
			this.citicode=citicode;
			this.name=name;
			this.sex=sex;
			this.birthday=birthday;
	}
	String getname(){
		return this.name;
	}
	String getid(){
		return this.id;
	}
	String getdocu(){
		return this.citicode;
	}
	String getbirth(){
		return this.birthday;
	}
	boolean ismale(){
		return this.sex;
	}
	void setsex(boolean a){
		this.sex = a;
	}
	void setname(String s){
		this.name=s;
	}
	void setid(String s){
		this.id=s;
	}
	void setciti(String s){
		this.citicode=s;
	}
	void setbirth(String s){
		this.birthday=s;
	}
}
