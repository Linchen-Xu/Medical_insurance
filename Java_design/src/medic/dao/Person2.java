package medic.dao;
import java.util.Set;


public class Person2 {
	private String institution,category,code,illname,indate,outdate,reason,hosid;
	private Set<Recipe>list;
	Person2(String institution,String category,String code,String illname,
			String indate,String outdate,String reason,String hosid){
		this.institution=institution;
		this.category=category;
		this.code=code;
		this.illname=illname;
		this.indate=indate;
		this.outdate=outdate;
		this.reason=reason;
		this.hosid=hosid;
	}
	void add(Recipe a){
		list.add(a);
		return;
	}
	String getinsti(){
		return this.institution;
	}
	String getcat(){
		return this.category;
	}
	String getcode(){
		return this.code;
	}
	String getill(){
		return this.illname;
	}
	String getindate(){
		return this.indate;
	}
	String getoutdate(){
		return this.outdate;
	}
	String getreason(){
		return this.reason;
	}
	String gethosid(){
		return this.hosid;
	}
	
}
