package sgr;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class OrderReceipt extends JDialog {


	/**
	 * Generated serialVersionUID for the dialog
	 */
	private static final long serialVersionUID = -6437480701974989688L;

	/**
	 * Create the dialog.
	 */
	public OrderReceipt() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(10, 26, 291, 225);
		
		switch(Pizza.verifySelectedPizzaSize()) {
			case "small":
				textArea.append("Small Pizza     $5.00" + "\n");
				break;
			case "medium":
				textArea.append("Medium Pizza     $10.00" + "\n");
				break;
			case "large":
				textArea.append("Large Pizza     $15.00" + "\n");
				break;
		}
		
		switch(Pizza.verifySelectedPizzaCrust()) {
			case "0": // 0 is thin
				textArea.append("Thin Crust" + "\n");
				break;
			case "1": // 1 is thick
				textArea.append("Thick Crust" + "\n");
				break;
		}
	
		if(!Pizza.toppingsCheckoutArray.isEmpty())	{
			for(int i = 0; i < Pizza.toppingsCheckoutArray.size(); i++) {
				textArea.append(Pizza.toppingsCheckoutArray.get(i) + "\n");
			}			
		}
		
		textArea.append(Pizza.soda);
		getContentPane().add(textArea);
		textArea.append("\nThe total value is: $" + Pizza.totalPrice);
		
		JLabel lblPizza = new JLabel("PIZZA PLACE");
		lblPizza.setBounds(10, 0, 61, 30);
		getContentPane().add(lblPizza);
	}
		
	
}