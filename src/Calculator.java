import java.util.*;

public class Calculator {
	
	private double ans;
	private LinkedList<Union> parent;
	private LinkedList<Union> polish;
	 
	public Calculator (){
		ans = 0;
		parent = new LinkedList<Union>();
		polish = new LinkedList<Union>();
	}
	 
	public double computeAnswer (){
		double num1, num2;
		Iterator<Union> it;
		Stack<Double> num_stack = new Stack<Double>();
		Union union;
		
		computePolish();
		it = polish.iterator();
		
		while (it.hasNext()){
			union = it.next();
			
			if (union.isNumber())
				num_stack.push(union.getNumber());
			else {
				switch (union.getOp()){
				case SUM:
					num2 = num_stack.pop();
					num1 = num_stack.pop();
					num_stack.push(num1 + num2);
					break;
				case SUB:
					num2 = num_stack.pop();
					num1 = num_stack.pop();
					num_stack.push(num1 - num2);
					break;
				case MUL:
					num2 = num_stack.pop();
					num1 = num_stack.pop();
					num_stack.push(num1 * num2);
					break;
				case DIV:
					num2 = num_stack.pop();
					num1 = num_stack.pop();
					num_stack.push(num1 / num2);
					break;
				case POW:
					num2 = num_stack.pop();
					num1 = num_stack.pop();
					num_stack.push(Math.pow(num1, num2));
					break;
					
				default:
				}
			}
		}
		
		ans = num_stack.peek();
		return ans;
	}
	 
	public String getParent (){
		Iterator<Union> it = parent.iterator();
		String s_parent = "";
		 
		while (it.hasNext())
			s_parent += it.next().toString() + " ";
		
		return s_parent;
	}
	 
	public String getPolish (){
		computePolish();
		 
		Iterator<Union> it = polish.iterator();
		String s_polish = "";
		 
		while (it.hasNext())
			s_polish += it.next().toString() + " ";
		 
		return s_polish;
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
					
				default:
				}
			}
		}
		 
		while (!op_stack.empty())
			polish.addLast(op_stack.pop());
	}
	 
	public void delete (){
		if (!parent.isEmpty())
			parent.removeLast();
	}
	 
	public void insert (Op op){
		parent.addLast(new Union(op));
	}
	 
	public void insert (double num){
		parent.addLast (new Union(num));
	}
}