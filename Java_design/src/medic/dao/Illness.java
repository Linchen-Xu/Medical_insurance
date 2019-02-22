package medic.dao;

public class Illness {
	private String id,name,category;
	private boolean Reimbursement;
	Illness(String id,String name,String category,boolean Reimbursement){
		this.id=id;
		this.name=name;
		this.category=category;
		this.Reimbursement=Reimbursement;
	}
	String getname(){
		return this.name;
	}
	String getid(){
		return this.id;
	}
	String getcat(){
		return this.category;
	}
	boolean canreim(){
		return this.Reimbursement;
	}
}
