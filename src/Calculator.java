import java.util.*;

class Union{
	private boolean isNum;
	private char op;
	private double num;
	
	public Union (char op){
		isNum = false;
		this.op = op;
	}
	
	public Union (double num){
		isNum = true;
		this.num = num;
	}
	
	public char getOp (){
		return op;
	}
	
	public double getNumber (){
		return num;
	}
	
	public boolean isNumber (){
		return isNum;
	}
	
	public String toString (){
		if (isNum) return Double.toString(num);
		else return Character.toString(op);
	}
}

public class Calculator {
	 private LinkedList<Union> parent;
	 
	 public Calculator (){
		 parent = new LinkedList<Union>();
	 }
	 
	 public String getParent (){
		 Iterator<Union> it = parent.iterator();
		 String s_parent = "";
		 
		 while (it.hasNext())
			 s_parent += it.next().toString();
		 
		 return s_parent;
	 }
	 
	 public void clear (){
		 parent.clear();
	 }
	 
	 public void insert (char op){
		 parent.addLast(new Union(op));
	 }
	 
	 public void insert (double num){
		 parent.addLast (new Union(num));
	 }
}