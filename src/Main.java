public class Main {
	public static void main (String[] args){
		
		//testing Calculator methods
		Calculator calc = new Calculator();
		
		calc.insert(1);
		calc.insert(Op.SUM);
		calc.insert(2);
		System.out.println(calc.getParent());
		
		calc.clear();
		
		calc.insert(4);
		calc.insert(Op.MUL);
		calc.insert(Op.OPP);
		calc.insert(3);
		calc.insert(Op.SUM);
		calc.insert(5);
		calc.insert(Op.CLP);
		System.out.println(calc.getParent());
		
	}
}