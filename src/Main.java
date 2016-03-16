public class Main {
	public static void main (String[] args){
		
		//testing Calculator methods
		Calculator calc = new Calculator();
		
		calc.insert(3);
		calc.insert(Op.SUM);
		calc.insert(4);
		calc.insert(Op.MUL);
		calc.insert(2);
		calc.insert(Op.DIV);
		calc.insert(Op.OPP);
		calc.insert(1);
		calc.insert(Op.SUB);
		calc.insert(5);
		calc.insert(Op.CLP);
		calc.insert(Op.POW);
		calc.insert(2);
		calc.insert(Op.POW);
		calc.insert(3);
		System.out.println(calc.getParent());
		System.out.println(calc.computeAnswer());
		
		calc.clear();
		
		calc.insert(4);
		calc.insert(Op.MUL);
		calc.insert(Op.OPP);
		calc.insert(3);
		calc.insert(Op.SUM);
		calc.insert(5);
		calc.insert(Op.CLP);
		System.out.println(calc.getParent());
		System.out.println(calc.computeAnswer());
		
	}
}