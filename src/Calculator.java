import java.util.*;

class Union{
	private boolean isNum;
	private Op op;
	private double num;
	
	public Union (Op op){
		isNum = false;
		this.op = op;
	}
	
	public Union (double num){
		isNum = true;
		this.num = num;
	}
	
	public Op getOp (){
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
		else {
			switch (op){
			case SUM: return "+";
			case SUB: return "-";
			case MUL: return "*";
			case DIV: return "/";
			case POW: return "^";
			case OPP: return "(";
			case CLP: return ")";
			
			default: return "";
			}
		}
	}
}

public class Calculator {
	 private LinkedList<Union> parent;
	 private LinkedList<Union> polish;
	 
	 public Calculator (){
		 parent = new LinkedList<Union>();
		 polish = new LinkedList<Union>();
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
	 
	 public void insert (Op op){
		 parent.addLast(new Union(op));
	 }
	 
	 public void insert (double num){
		 parent.addLast (new Union(num));
	 }
}