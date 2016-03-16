public class CalculatorInput {
	private boolean typingNum;
	private double num;
	private Calculator calc;
	
	public CalculatorInput (Calculator calc){
		typingNum = true;
		num = 0;
		this.calc = calc;
	}
	
	public String digit (int alg){
		if (alg < 0 || alg > 9)
			return calc.getParent();
		
		if (typingNum){
			num = 10*num + alg;
			calc.delete();
			calc.insert(num);
		} else {
			num = alg;
			calc.insert(num);
			typingNum = true;
		}
		
		return calc.getParent();
	}
	
	public String digit (Op op){
		switch (op){
		case SUM: case SUB: case MUL: case DIV: case POW: case OPP: case CLP:
			calc.insert(op);
			typingNum = false;
			break;
		case CLR:
			calc.clear();
			typingNum = true;
			num = 0;
			break;
		case EQL:
			return Double.toString(calc.computeAnswer());
			
		default:
		}
		
		return calc.getParent();
	}
}