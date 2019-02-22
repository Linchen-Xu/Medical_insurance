package medic.dao;

public class Medicine {
	private String id,name;
	private int chargelevel,hoslevel;
	private boolean approval;
	private double limit;
	public Medicine(){}
	public Medicine(String id,String name,int chargelevel,
			double limit,boolean approval,int hoslevel){
		this.id=id;
		this.name=name;
		this.chargelevel=chargelevel;
		this.limit=limit;
		this.approval=approval;
		this.hoslevel=hoslevel;
	}
	String getname(){
		return this.name;
	}
	String getid(){
		return this.id;
	}
	int getchargelevel(){
		return this.chargelevel;
	}
	int gethoslevel(){
		return this.hoslevel;
	}
	boolean needapproval(){
		return this.approval;
	}
	double getlimit(){
		return this.limit;
	}
	void setid(String s){
		this.id=s;
	}
	void setname(String s){
		this.name=s;
	}
	void setclev(int s){
		this.chargelevel=s;
	}
	void sethoslev(int s){
		this.hoslevel=s;
	}
	void setlimit(double s){
		this.limit=s;
	}
	void needapprove(boolean s){
		this.approval=s;
	}
}
