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
	 
	 public String getPolish (){
		 computePolish();
		 
		 Iterator<Union> it = polish.iterator();
		 String s_parent = "";
		 
		 while (it.hasNext())
			 s_parent += it.next().toString() + " ";
		 
		 return s_parent;
	 }
	 
	 public void clear (){
		 parent.clear();
	 }
	 
	 //Shunting-yard algorithm
	 private void computePolish (){
		 Iterator<Union> it = parent.iterator();
		 Stack<Union> op_stack = new Stack<Union>();
		 Union union;
		 
		 polish.clear();
		 
		 while (it.hasNext()){
			 union = it.next();
			 
			 if (union.isNumber())
				 polish.addLast (union);
			 else {
				 switch (union.getOp()){
				 case SUM: case SUB:
					 while (!op_stack.empty() &&
							 op_stack.peek().getOp() != Op.OPP)
						 polish.addLast (op_stack.pop());
					 
					 op_stack.push(union);
					 break;
					 
				 case MUL: case DIV:
					 while (!op_stack.empty() &&
							 op_stack.peek().getOp() != Op.SUM &&
							 op_stack.peek().getOp() != Op.SUB &&
							 op_stack.peek().getOp() != Op.OPP)
						 polish.addLast(op_stack.pop());
					 
					 op_stack.push(union);
					 break;
					 
				 case POW: case OPP:
					 op_stack.push(union);
					 break;
					 
				 case CLP:
					 while (op_stack.peek().getOp() != Op.OPP)
						 polish.addLast(op_stack.pop());
					 
					 op_stack.pop();
					 break;
				 }
			 }
		 }
		 
		 while (!op_stack.empty())
			 polish.addLast(op_stack.pop());
	 }
	 
	 public void delete (){
		 parent.removeLast();
	 }
	 
	 public void insert (Op op){
		 parent.addLast(new Union(op));
	 }
	 
	 public void insert (double num){
		 parent.addLast (new Union(num));
	 }
}