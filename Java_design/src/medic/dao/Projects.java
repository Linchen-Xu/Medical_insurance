package medic.dao;

public class Projects {
	 String id,name;
	 int kind;
	 int level;
	 boolean approval;
	 public Projects(){}
	 public Projects(String id,String name,int kind,int level,boolean approval){
		 this.id=id;
		 this.name=name;
		 this.kind=kind;
		 this.level=level;
		 this.approval=approval;
	 }
	 String getid(){
		return this.id;
	 }
	 String getname(){
		return this.name;
	 }
	 int getlevel(){
		 return this.level;
	 }
	 int getkind(){
		 return this.kind;
	 }
	 void setid(String s){
		 this.id=s;
	 }
	 void setname(String s){
		 this.name=s;
	 }
	 void setkind(int s){
		 this.kind=s;
	 }
	 void setlev(int s){
		 this.level=s;
	 }
	 void needarpproval(boolean s){
		 this.approval=s;
	 }
}
