import java.awt.event.*;
import javax.swing.*;

class ButtonListener implements ActionListener{
	private CalculatorInput calc_i;
	private JTextField output_field;
	private Union union;
	
	public ButtonListener (CalculatorInput calc_i, JTextField output_field, int num){
		this.calc_i = calc_i;
		this.output_field = output_field;
		union = new Union (num);
	}
	
	public ButtonListener (CalculatorInput calc_i, JTextField output_field, Op op){
		this.calc_i = calc_i;
		this.output_field = output_field;
		union = new Union (op);
	}
	
	public void actionPerformed (ActionEvent e){
		if (union.isNumber())
			output_field.setText(calc_i.digit((int)union.getNumber()));
		else
			output_field.setText(calc_i.digit(union.getOp()));
	}
}

public class CalculatorInterface {
	private CalculatorInput calc_i;
	private JButton[] input_buttons;
	private JFrame frame;
	private JPanel main_panel;
	private JTextField output_field;
	
	public CalculatorInterface (){
		calc_i = new CalculatorInput (new Calculator());
		 
		frame = new JFrame();
		
		main_panel = new JPanel();
		output_field = new JTextField(12);
		
		input_buttons = new JButton[20];
		for (int i=0; i<=9; i++)
			input_buttons[i] = createButton(Integer.toString(i), i);
		input_buttons[10] = createButton("+", Op.SUM);
		input_buttons[11] = createButton("-", Op.SUB);
		input_buttons[12] = createButton("*", Op.MUL);
		input_buttons[13] = createButton("/", Op.DIV);
		input_buttons[14] = createButton("^", Op.POW);
		input_buttons[15] = createButton("(", Op.OPP);
		input_buttons[16] = createButton(")", Op.CLP);
		input_buttons[17] = createButton("<", Op.DEL);
		input_buttons[18] = createButton("C", Op.CLR);
		input_buttons[19] = createButton("=", Op.EQL);
		
		frame.add(main_panel);
		frame.setBounds(400, 150, 160, 290);
		
		main_panel.add(output_field);
		
		for (int i=0; i<=19; i++)
			main_panel.add(input_buttons[i]);
		
		frame.setVisible(true);
	}
	
	JButton createButton (String text, int num){
		JButton button = new JButton (text);
		button.addActionListener(new ButtonListener(calc_i, output_field, num));
		return button;
	}
	
	JButton createButton (String text, Op op){
		JButton button = new JButton (text);
		button.addActionListener(new ButtonListener(calc_i, output_field, op));
		return button;
	}
}