public class Main {
	public static void main (String[] args){
		
		//testing CalculatorInput methods
		CalculatorInput ci = new CalculatorInput();
		
		System.out.println(ci.digit(1));
		System.out.println(ci.digit(0));
		System.out.println(ci.digit(Op.SUM));
		System.out.println(ci.digit(2));
		System.out.println(ci.digit(3));
		System.out.println(ci.digit(Op.MUL));
		System.out.println(ci.digit(2));
		System.out.println(ci.digit(Op.EQL));
		
	}
}