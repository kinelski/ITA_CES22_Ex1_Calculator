public class Union{
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