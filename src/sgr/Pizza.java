package sgr;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
/**
 * 
 * @author Stephanie Garcia Ribot
 * 
 *
 */


public class Pizza {

	private JFrame frame;
	private JDialog OrderReceiptDialog;
	private JTextField txtTotal;
	private JTextField totalPriceTextField;
	private JTextField txtsodaDrinks;
	private static ButtonGroup buttonGroupPizzaSize = new ButtonGroup();
	private static ButtonGroup buttonGroupPizzaCrust = new ButtonGroup();
	private static ButtonGroup buttonGroupPizzaStyle = new ButtonGroup();
	private static JRadioButtonMenuItem radioBtnMedium;
	private static JRadioButtonMenuItem radioBtnLarge;
	private static JRadioButtonMenuItem radioBtnSmall;
	private static JRadioButtonMenuItem radioBtnThin;
	private static JRadioButtonMenuItem radioBtnThick;
	private static JRadioButtonMenuItem radioBtnRealistic;
	private static JRadioButtonMenuItem radioBtnCartoon;
	private JButton btnCheckOut;
	private JLabel lblClock;
	
	// JLabels to display images
	private JLabel[] smallCartoonToppings;
	private JLabel[] smallCartoonCrusts;
	private JLabel   smallCartoonCheese;
	private JLabel[] mediumCartoonToppings;
	private JLabel[] mediumCartoonCrusts;
	private JLabel   mediumCartoonCheese;
	private JLabel[] largeCartoonToppings;
	private JLabel[] largeCartoonCrusts;
	private JLabel   largeCartoonCheese;
	private JLabel[] smallRealisticToppings;
	private JLabel[] smallRealisticCrusts;
	private JLabel[] mediumRealisticToppings;
	private JLabel[] mediumRealisticCrusts;
	private JLabel[] largeRealisticToppings;
	private JLabel[] largeRealisticCrusts;
	
	protected static String soda;
	protected static ArrayList<String> toppingsCheckoutArray;
	private ArrayList<Integer> selectedToppingsNumbersArray;
	
	protected static Map<ButtonModel, JRadioButtonMenuItem> modelToRadioButtonPizzaSize = new LinkedHashMap<ButtonModel, JRadioButtonMenuItem>();
	protected static Map<ButtonModel, JRadioButtonMenuItem> modelToRadioButtonPizzaCrust = new LinkedHashMap<ButtonModel, JRadioButtonMenuItem>();
	protected static Map<ButtonModel, JRadioButtonMenuItem> modelToRadioButtonPizzaStyle = new LinkedHashMap<ButtonModel, JRadioButtonMenuItem>();
	
	static float totalPrice = 0; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pizza window = new Pizza();
					window.frame.setVisible(true);
					window.frame.setTitle("PIZZA ORDERING SYSTEM");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pizza() {
		initializeGUI();
		startClock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeGUI() {
		frame = new JFrame();
		frame.setBounds(75, 75, 1200, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/**
		 * Arrays of the selected toppings
		 */
		toppingsCheckoutArray = new ArrayList<String>(); 
		selectedToppingsNumbersArray = new ArrayList<Integer>();
		
		/**
		 * Toppings Label
		 */
		JLabel lblChooseToppings = new JLabel("CHOOSE TOPPINGS");
		lblChooseToppings.setBounds(20, 160, 159, 14);
		frame.getContentPane().add(lblChooseToppings);

		/**
		 * Checkbox Toppings Menu
		 */
		JCheckBoxMenuItem cbBlackOlives = new JCheckBoxMenuItem("Black Olives  $1.00");
		cbBlackOlives.setActionCommand("0");
		cbBlackOlives.setBounds(20, 234, 127, 22);
		frame.getContentPane().add(cbBlackOlives);
		
		JCheckBoxMenuItem cbShrimp = new JCheckBoxMenuItem("Shrimp  $1.25");
		cbShrimp.setActionCommand("1");
		cbShrimp.setBounds(317, 251, 127, 22);
		frame.getContentPane().add(cbShrimp);
		
		JCheckBoxMenuItem cbBroccoli = new JCheckBoxMenuItem("Broccoli  $1.00");
		cbBroccoli.setActionCommand("2");
		cbBroccoli.setBounds(317, 234, 145, 22);
		frame.getContentPane().add(cbBroccoli);
		

		JCheckBoxMenuItem cbHam = new JCheckBoxMenuItem("Ham  $1.25");
		cbHam.setActionCommand("3");
		cbHam.setBounds(317, 201, 127, 22);
		frame.getContentPane().add(cbHam);
		
		JCheckBoxMenuItem cbGreenPeppers = new JCheckBoxMenuItem("Green Peppers  $1.00");
		cbGreenPeppers.setActionCommand("4");
		cbGreenPeppers.setBounds(20, 201, 145, 22);
		frame.getContentPane().add(cbGreenPeppers);
		
		JCheckBoxMenuItem cbMushrooms = new JCheckBoxMenuItem("Mushrooms  $1.00");
		cbMushrooms.setActionCommand("5");
		cbMushrooms.setBounds(20, 267, 127, 22);
		frame.getContentPane().add(cbMushrooms);
		
		JCheckBoxMenuItem cbPepperoni = new JCheckBoxMenuItem("Pepperoni  $1.00");
		cbPepperoni.setActionCommand("6");
		cbPepperoni.setBounds(20, 185, 127, 22);
		frame.getContentPane().add(cbPepperoni);

		JCheckBoxMenuItem cbBacon = new JCheckBoxMenuItem("Bacon  $1.25");
		cbBacon.setActionCommand("7");
		cbBacon.setBounds(20, 218, 127, 22);
		frame.getContentPane().add(cbBacon);

		JCheckBoxMenuItem cbPineapple = new JCheckBoxMenuItem("Pineapple  $1.00");
		cbPineapple.setActionCommand("8");
		cbPineapple.setBounds(317, 218, 127, 22);
		frame.getContentPane().add(cbPineapple);

		JCheckBoxMenuItem cbTomatoes = new JCheckBoxMenuItem("Tomatoes  $1.00");
		cbTomatoes.setActionCommand("9");
		cbTomatoes.setBounds(317, 185, 127, 22);
		frame.getContentPane().add(cbTomatoes);

		JCheckBoxMenuItem cbGarlic = new JCheckBoxMenuItem("Garlic  $1.00");
		cbGarlic.setActionCommand("10");
		cbGarlic.setBounds(20, 251, 127, 22);
		frame.getContentPane().add(cbGarlic);

		/**
		 * Total Text Field
		 */
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setText("TOTAL");
		txtTotal.setBounds(10, 409, 86, 20);
		frame.getContentPane().add(txtTotal);
		txtTotal.setColumns(10);

		/**
		 * Money Counter Text Field
		 */
		totalPriceTextField = new JTextField("0.00");
		totalPriceTextField.setEditable(false);
		totalPriceTextField.setBounds(108, 409, 86, 20);
		frame.getContentPane().add(totalPriceTextField);
		totalPriceTextField.setColumns(10);

		/**
		 * Checkout Button. Displays receipt.
		 */
		btnCheckOut = new JButton("CHECK-OUT");
		btnCheckOut.setBounds(268, 408, 127, 21);
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   	OrderReceiptDialog = new OrderReceipt();
			   	OrderReceiptDialog.setTitle("Order Receipt");
			   	OrderReceiptDialog.setVisible(true);
			}
		});
		frame.getContentPane().add(btnCheckOut);

		/**
		 * Pizza size radio buttons.
		 */
		JLabel lblChooseSize = new JLabel("CHOOSE SIZE");
		lblChooseSize.setBounds(20, 11, 107, 14);
		frame.getContentPane().add(lblChooseSize);

		radioBtnSmall = new JRadioButtonMenuItem("Small");
		buttonGroupPizzaSize.add(radioBtnSmall);
		radioBtnSmall.setBounds(20, 36, 123, 22);
	    ButtonModel buttonModel = radioBtnSmall.getModel();
	    modelToRadioButtonPizzaSize.put(buttonModel, radioBtnSmall);		
		frame.getContentPane().add(radioBtnSmall);

		radioBtnMedium = new JRadioButtonMenuItem("Medium");
		buttonGroupPizzaSize.add(radioBtnMedium);
		radioBtnMedium.setSelected(true);
		radioBtnMedium.setBounds(183, 36, 123, 22);
	    buttonModel = radioBtnMedium.getModel();
	    modelToRadioButtonPizzaSize.put(buttonModel, radioBtnMedium);		
		frame.getContentPane().add(radioBtnMedium);

		radioBtnLarge = new JRadioButtonMenuItem("Large");
		buttonGroupPizzaSize.add(radioBtnLarge);
		radioBtnLarge.setBounds(339, 36, 123, 22);
	    buttonModel = radioBtnLarge.getModel();
	    modelToRadioButtonPizzaSize.put(buttonModel, radioBtnLarge);		
		frame.getContentPane().add(radioBtnLarge);

		/**
		 * Pizza crust radio buttons.
		 */
		JLabel lblChooseCrust = new JLabel("CHOOSE CRUST");
		lblChooseCrust.setBounds(20, 90, 107, 14);
		frame.getContentPane().add(lblChooseCrust);

		radioBtnThin = new JRadioButtonMenuItem("Thin");
		buttonGroupPizzaCrust.add(radioBtnThin);
		radioBtnThin.setBounds(20, 115, 123, 22);
		modelToRadioButtonPizzaCrust.put(radioBtnThin.getModel(), radioBtnThin);
		frame.getContentPane().add(radioBtnThin);
	
		radioBtnThick = new JRadioButtonMenuItem("Thick");
		buttonGroupPizzaCrust.add(radioBtnThick);
		radioBtnThick.setBounds(183, 115, 123, 22);
		radioBtnThick.setSelected(true);
		modelToRadioButtonPizzaCrust.put(radioBtnThick.getModel(), radioBtnThick);	
		frame.getContentPane().add(radioBtnThick);
		
		/**
		 * Realistic or cartoon pizza buttons 
		 */
		JLabel lblChooseStyle = new JLabel("CHOOSE STYLE");
		lblChooseStyle.setBounds(801, 7, 89, 22);
		frame.getContentPane().add(lblChooseStyle);

		radioBtnRealistic = new JRadioButtonMenuItem("Realistic");
		buttonGroupPizzaStyle.add(radioBtnRealistic);
		radioBtnRealistic.setBounds(912, 22, 86, 22);
		modelToRadioButtonPizzaStyle.put(radioBtnRealistic.getModel(), radioBtnRealistic);
		frame.getContentPane().add(radioBtnRealistic);
	
		radioBtnCartoon = new JRadioButtonMenuItem("Cartoon");
		buttonGroupPizzaStyle.add(radioBtnCartoon);
		radioBtnCartoon.setBounds(707, 22, 86, 22);
		radioBtnCartoon.setSelected(true);
		modelToRadioButtonPizzaStyle.put(radioBtnCartoon.getModel(), radioBtnCartoon);	
		frame.getContentPane().add(radioBtnCartoon);
		
		/**
		 * Load images 
		 */
		BufferedImage img;
		
		// Load small 'cartoon' pizza toppings
		smallCartoonToppings =  new JLabel[11];
		for(int i = 0; i < 11; i++) {
			try {
				img = ImageIO.read(new File("images/small_cartoon_topping" + Integer.toString(i) + ".png"));
				smallCartoonToppings[i] = new JLabel(new ImageIcon(img));
				smallCartoonToppings[i].setBounds(600, 35, 500, 500);
			 	frame.getContentPane().add(smallCartoonToppings[i]);
			 	smallCartoonToppings[i].setVisible(false); 
			} catch (IOException error) {
		   		error.printStackTrace();
		    }
		}
		
		// Load medium 'cartoon' pizza toppings
		mediumCartoonToppings =  new JLabel[11];
		for(int i = 0; i < 11; i++) {
			try {
				img = ImageIO.read(new File("images/medium_cartoon_topping" + Integer.toString(i) + ".png"));
				mediumCartoonToppings[i] = new JLabel(new ImageIcon(img));
				mediumCartoonToppings[i].setBounds(600, 35, 500, 500);
			 	frame.getContentPane().add(mediumCartoonToppings[i]);
			 	mediumCartoonToppings[i].setVisible(false); 
			} catch (IOException error) {
		   		error.printStackTrace();
		    }	
		}
		
		// Load large 'cartoon' pizza toppings
		largeCartoonToppings =  new JLabel[11];
		for(int i = 0; i < 11; i++) {
			try {
				img = ImageIO.read(new File("images/large_cartoon_topping" + Integer.toString(i) + ".png"));
				largeCartoonToppings[i] = new JLabel(new ImageIcon(img));
				largeCartoonToppings[i].setBounds(600, 35, 500, 500);
			 	frame.getContentPane().add(largeCartoonToppings[i]);
			 	largeCartoonToppings[i].setVisible(false); 
			} catch (IOException error) {
		   		error.printStackTrace();
		    }	
		}
		
		// Load small 'realistic' pizza toppings
		smallRealisticToppings =  new JLabel[11];
		for(int i = 0; i < 11; i++) {
			try {
				img = ImageIO.read(new File("images/small_realistic_topping" + Integer.toString(i) + ".png"));
				smallRealisticToppings[i] = new JLabel(new ImageIcon(img));
				smallRealisticToppings[i].setBounds(600, 35, 500, 500);
			 	frame.getContentPane().add(smallRealisticToppings[i]);
			 	smallRealisticToppings[i].setVisible(false); 
			} catch (IOException error) {
		   		error.printStackTrace();
		    }
		}
		
		// Load medium 'realistic' pizza toppings
		mediumRealisticToppings =  new JLabel[11];
		for(int i = 0; i < 11; i++) {
			try {
				img = ImageIO.read(new File("images/medium_realistic_topping" + Integer.toString(i) + ".png"));
				mediumRealisticToppings[i] = new JLabel(new ImageIcon(img));
				mediumRealisticToppings[i].setBounds(600, 35, 500, 500);
			 	frame.getContentPane().add(mediumRealisticToppings[i]);
			 	mediumRealisticToppings[i].setVisible(false); 
			} catch (IOException error) {
		   		error.printStackTrace();
		    }	
		}
		
		// Load large 'realistic' pizza toppings
		largeRealisticToppings =  new JLabel[11];
		for(int i = 0; i < 11; i++) {
			try {
				img = ImageIO.read(new File("images/large_realistic_topping" + Integer.toString(i) + ".png"));
				largeRealisticToppings[i] = new JLabel(new ImageIcon(img));
				largeRealisticToppings[i].setBounds(600, 35, 500, 500);
			 	frame.getContentPane().add(largeRealisticToppings[i]);
			 	largeRealisticToppings[i].setVisible(false); 
			} catch (IOException error) {
		   		error.printStackTrace();
		    }	
		}
		
	 	// Load plain cheese background for 'cartoon' pizzas
		try {
			img = ImageIO.read(new File("images/small_cartoon_cheese.png"));
			smallCartoonCheese = new JLabel(new ImageIcon(img));
			smallCartoonCheese.setBounds(600, 35, 500, 500);
			smallCartoonCheese.setVisible(false);
			frame.getContentPane().add(smallCartoonCheese);
		} catch (IOException error) {
			error.printStackTrace();
		}
		
		try {
			img = ImageIO.read(new File("images/medium_cartoon_cheese.png"));
		   	mediumCartoonCheese = new JLabel(new ImageIcon(img));
		   	mediumCartoonCheese.setBounds(600, 35, 500, 500);
		   	mediumCartoonCheese.setVisible(true);
			frame.getContentPane().add(mediumCartoonCheese);
		} catch (IOException error) {
			error.printStackTrace();
		}
		
		try {
			img = ImageIO.read(new File("images/large_cartoon_cheese.png"));
		   	largeCartoonCheese = new JLabel(new ImageIcon(img));
		   	largeCartoonCheese.setBounds(600, 35, 500, 500);
		   	largeCartoonCheese.setVisible(false);
			frame.getContentPane().add(largeCartoonCheese);
		} catch (IOException error) {
			error.printStackTrace();
		}

		// Load crusts for 'cartoon' pizzas
		smallCartoonCrusts = new JLabel[2];
		for(int i = 0; i < 2; i++) {
			try {
				img = ImageIO.read(new File("images/small_cartoon_crust" + Integer.toString(i) + ".png"));
				smallCartoonCrusts[i] = new JLabel(new ImageIcon(img));
				smallCartoonCrusts[i].setBounds(600, 35, 500, 500);
			 	smallCartoonCrusts[i].setVisible(false); 
			 	frame.getContentPane().add(smallCartoonCrusts[i]);
			} catch (IOException error) {
				error.printStackTrace();
			}

		}
	 	
		mediumCartoonCrusts = new JLabel[2];
		for(int i = 0; i < 2; i++) {
			try {
				img = ImageIO.read(new File("images/medium_cartoon_crust" + Integer.toString(i) + ".png"));
				mediumCartoonCrusts[i] = new JLabel(new ImageIcon(img));
				mediumCartoonCrusts[i].setBounds(600, 35, 500, 500);
			 	frame.getContentPane().add(mediumCartoonCrusts[i]);
			 	mediumCartoonCrusts[0].setVisible(false); 			 	
			} catch (IOException error) {
				error.printStackTrace();
			}

		}
		mediumCartoonCrusts[1].setVisible(true); // Medium size is default
	 	
		largeCartoonCrusts = new JLabel[2];
		for(int i = 0; i < 2; i++) {
			try {
				img = ImageIO.read(new File("images/large_cartoon_crust" + Integer.toString(i) + ".png"));
				largeCartoonCrusts[i] = new JLabel(new ImageIcon(img));
				largeCartoonCrusts[i].setBounds(600, 35, 500, 500);
				largeCartoonCrusts[i].setVisible(false);
			 	frame.getContentPane().add(largeCartoonCrusts[i]);
			} catch (IOException error) {
				error.printStackTrace();
			}

		}
		// Load crusts for 'realistic' pizzas
		smallRealisticCrusts = new JLabel[2];
		for(int i = 0; i < 2; i++) {
			try {
				img = ImageIO.read(new File("images/small_realistic_crust" + Integer.toString(i) + ".png"));
				smallRealisticCrusts[i] = new JLabel(new ImageIcon(img));
				smallRealisticCrusts[i].setBounds(600, 35, 500, 500);
				smallRealisticCrusts[i].setVisible(false); 
			 	frame.getContentPane().add(smallRealisticCrusts[i]);
			} catch (IOException error) {
				error.printStackTrace();
			}

		}
	 	
		mediumRealisticCrusts = new JLabel[2];
		for(int i = 0; i < 2; i++) {
			try {
				img = ImageIO.read(new File("images/medium_realistic_crust" + Integer.toString(i) + ".png"));
				mediumRealisticCrusts[i] = new JLabel(new ImageIcon(img));
				mediumRealisticCrusts[i].setBounds(600, 35, 500, 500);
			 	frame.getContentPane().add(mediumRealisticCrusts[i]);
			 	mediumRealisticCrusts[i].setVisible(false); 			 	
			} catch (IOException error) {
				error.printStackTrace();
			}

		}
	 	
		largeRealisticCrusts = new JLabel[2];
		for(int i = 0; i < 2; i++) {
			try {
				img = ImageIO.read(new File("images/large_realistic_crust" + Integer.toString(i) + ".png"));
				largeRealisticCrusts[i] = new JLabel(new ImageIcon(img));
				largeRealisticCrusts[i].setBounds(600, 35, 500, 500);
				largeRealisticCrusts[i].setVisible(false);
			 	frame.getContentPane().add(largeRealisticCrusts[i]);
			} catch (IOException error) {
				error.printStackTrace();
			}

		}		
		
		
		/**
		 * Adding or removing a drink to the order
		 */
		JCheckBox cbDrinks = new JCheckBox("Soda Drink  $2.00");
		cbDrinks.setBounds(20, 321, 145, 39);
		cbDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCheckBox clickedDrinksCheckbox = (JCheckBox)e.getSource();

				if (clickedDrinksCheckbox.isSelected()) {
					totalPrice += 2.00;
					soda = "Soda Drink";
				}
				else {
					totalPrice -= 2.00;
					soda = null;
				}
				totalPriceTextField.setText(String.format("%.2f", totalPrice));
			}
		});
		frame.getContentPane().add(cbDrinks);

		txtsodaDrinks = new JTextField();
		txtsodaDrinks.setText("(Soda drinks are not healthy. It is strongly recommended to mix it with tap water)");
		txtsodaDrinks.setBounds(20, 367, 484, 22);
		txtsodaDrinks.setColumns(10);
		frame.getContentPane().add(txtsodaDrinks);
		
		/**
		 * Clock label
		 */
		lblClock = new JLabel("Clock");
		lblClock.setBounds(10, 462, 494, 43);
		frame.getContentPane().add(lblClock);

		/**
		 * Adding listeners to the toppings, size, crust and drinks.
		 */
		ActionListener toppingSelectorActionListener = new ToppingSelector();
		cbPepperoni.addActionListener(toppingSelectorActionListener);
		cbGreenPeppers.addActionListener(toppingSelectorActionListener);
		cbBacon.addActionListener(toppingSelectorActionListener);
		cbBlackOlives.addActionListener(toppingSelectorActionListener);
		cbGarlic.addActionListener(toppingSelectorActionListener);
		cbMushrooms.addActionListener(toppingSelectorActionListener);
		cbTomatoes.addActionListener(toppingSelectorActionListener);
		cbHam.addActionListener(toppingSelectorActionListener);
		cbPineapple.addActionListener(toppingSelectorActionListener);
		cbShrimp.addActionListener(toppingSelectorActionListener);
		cbBroccoli.addActionListener(toppingSelectorActionListener);



		ItemListener sizeSelectorActionListener = new SizeSelector();
		radioBtnSmall.addItemListener(sizeSelectorActionListener);
		radioBtnMedium.addItemListener(sizeSelectorActionListener);
		radioBtnLarge.addItemListener(sizeSelectorActionListener);
		
		ItemListener crustsActionListener = new CrustSelector();
		radioBtnThick.addItemListener(crustsActionListener);
		radioBtnThin.addItemListener(crustsActionListener);
		
		ItemListener styleActionListener = new StyleSelector();
		radioBtnCartoon.addItemListener(styleActionListener);
		radioBtnRealistic.addItemListener(styleActionListener);
		
		/**
		 * Set basic pizza price
		 */
		totalPrice = 10; // The default pizza size is medium, which costs $10
		totalPriceTextField.setText(String.format("%.2f", totalPrice));
	}

	public class ToppingSelector implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JCheckBoxMenuItem clickedCheckbox = (JCheckBoxMenuItem)e.getSource();
			String toppingNumber = e.getActionCommand();
			String size = verifySelectedPizzaSize();
			String style = verifySelectedPizzaStyle();
			
			if (clickedCheckbox.isSelected()) {
				switch(toppingNumber) {
					case "0":
						totalPrice += 1.00;
						toppingsCheckoutArray.add("Black Olives     $1.00");
						selectedToppingsNumbersArray.add(0);
						
						break;
						
					case "1":
						totalPrice += 1.25;
						toppingsCheckoutArray.add("Shrimp     $1.25");
						selectedToppingsNumbersArray.add(1);
						break;
						
					case "2":
						totalPrice += 1.00;
						toppingsCheckoutArray.add("Broccoli     $1.00");
						selectedToppingsNumbersArray.add(2);
						break;
						
					case "3":
						totalPrice += 1.25;
						toppingsCheckoutArray.add("Ham     $1.25");
						selectedToppingsNumbersArray.add(3);
						break;
						
					case "4":
						totalPrice += 1.00;
						toppingsCheckoutArray.add("Green Peppers     $1.00");
						selectedToppingsNumbersArray.add(4);
						break;
						
					case "5":
						totalPrice += 1.00;
						toppingsCheckoutArray.add("Mushrooms     $1.00");
						selectedToppingsNumbersArray.add(5);
						break;
						
					case "6":
						totalPrice += 1.00;
						toppingsCheckoutArray.add("Pepperoni     $1.00");
						selectedToppingsNumbersArray.add(6);
						break;
						
					case "7":
						totalPrice += 1.25;
						toppingsCheckoutArray.add("Bacon     $1.25");
						selectedToppingsNumbersArray.add(7);
						break;
						
					case "8":
						totalPrice += 1.00;
						toppingsCheckoutArray.add("Pineapple     $1.00");
						selectedToppingsNumbersArray.add(8);
						break;
						
					case "9":
						totalPrice += 1.00;
						toppingsCheckoutArray.add("Tomatoes     $1.00");
						selectedToppingsNumbersArray.add(9);
						break;
						
					case "10":
						totalPrice += 1.00;
						toppingsCheckoutArray.add("Garlic     $1.00");
						selectedToppingsNumbersArray.add(10);
						break;
				}
				
				switch(size) {
					case "small":
						if(style.equals("cartoon")) {
							smallCartoonToppings[Integer.parseInt(toppingNumber)].setVisible(true);
						} else {
							smallRealisticToppings[Integer.parseInt(toppingNumber)].setVisible(true);
						}
						
						break;
						
					case "medium":
						if(style.equals("cartoon")) {
							mediumCartoonToppings[Integer.parseInt(toppingNumber)].setVisible(true);
						}
						else {
							mediumRealisticToppings[Integer.parseInt(toppingNumber)].setVisible(true);
						}
						break;	
						
					case "large":
						if(style.equals("cartoon")) {
							largeCartoonToppings[Integer.parseInt(toppingNumber)].setVisible(true);
						} else {
							largeRealisticToppings[Integer.parseInt(toppingNumber)].setVisible(true);
						}
						break;	
				}
				
			} else {
				switch(toppingNumber) {
					case "0":
						totalPrice -= 1.00;
						toppingsCheckoutArray.remove("Black Olives     $1.00");
						selectedToppingsNumbersArray.remove(0);
						break;
						
					case "1":
						totalPrice -= 1.25;
						toppingsCheckoutArray.remove("Shrimp     $1.25");
						selectedToppingsNumbersArray.remove((Integer) 1);
						break;
						
					case "2":
						totalPrice -= 1.00;
						toppingsCheckoutArray.remove("Broccoli     $1.00");
						selectedToppingsNumbersArray.remove((Integer) 2);
						break;
						
					case "3":
						totalPrice -= 1.25;
						toppingsCheckoutArray.remove("Ham     $1.25");
						selectedToppingsNumbersArray.remove((Integer) 3);
						break;
						
					case "4":
						totalPrice -= 1.00;
						toppingsCheckoutArray.remove("Green Peppers     $1.00");
						selectedToppingsNumbersArray.remove((Integer) 4);
						break;
						
					case "5":
						totalPrice -= 1.00;
						toppingsCheckoutArray.remove("Mushrooms     $1.00");
						selectedToppingsNumbersArray.remove((Integer) 5);
						break;
						
					case "6":
						totalPrice -= 1.00;
						toppingsCheckoutArray.remove("Pepperoni     $1.00");
						selectedToppingsNumbersArray.remove((Integer) 6);
						break;
						
					case "7":
						totalPrice -= 1.25;
						toppingsCheckoutArray.remove("Bacon     $1.25");
						selectedToppingsNumbersArray.remove((Integer) 7);
						break;
						
					case "8":
						totalPrice -= 1.00;
						toppingsCheckoutArray.remove("Pineapple     $1.00");
						selectedToppingsNumbersArray.remove((Integer) 8);
						break;
						
					case "9":
						totalPrice -= 1.00;
						toppingsCheckoutArray.remove("Tomatoes     $1.00");
						selectedToppingsNumbersArray.remove((Integer) 9);
						break;
						
					case "10":
						totalPrice -= 1.00;
						toppingsCheckoutArray.remove("Garlic     $1.00");
						selectedToppingsNumbersArray.remove((Integer) 10);
						break;
				}
				
				switch(size) {
				case "small":
					if(style.equals("cartoon")) {
						smallCartoonToppings[Integer.parseInt(toppingNumber)].setVisible(false);
					} else {
						smallRealisticToppings[Integer.parseInt(toppingNumber)].setVisible(false);
					}
					
					break;
					
				case "medium":
					if(style.equals("cartoon")) {
						mediumCartoonToppings[Integer.parseInt(toppingNumber)].setVisible(false);
					}
					else {
						mediumRealisticToppings[Integer.parseInt(toppingNumber)].setVisible(false);
					}
					break;	
					
				case "large":
					if(style.equals("cartoon")) {
						largeCartoonToppings[Integer.parseInt(toppingNumber)].setVisible(false);
					} else {
						largeRealisticToppings[Integer.parseInt(toppingNumber)].setVisible(false);
					}
					break;	
				}
				
			}
				totalPriceTextField.setText(String.format("%.2f", totalPrice));
		}
	}

	public class SizeSelector implements ItemListener {

		public void itemStateChanged(ItemEvent e) {

			Object source = e.getItemSelectable();
			String style = verifySelectedPizzaStyle();
			
			if(style.equals("cartoon")){
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (source == radioBtnSmall) {
						setAllImagesInvisible();
						
						for(int i = 0; i < selectedToppingsNumbersArray.size(); i++) {
							smallCartoonToppings[selectedToppingsNumbersArray.get(i)].setVisible(true);
						}
						
						smallCartoonCrusts[Integer.parseInt(verifySelectedPizzaCrust())].setVisible(true);
						smallCartoonCheese.setVisible(true);
						
						totalPrice += 5.00;	
					}
					else if (source == radioBtnMedium) {
						setAllImagesInvisible();
						
						for(int i = 0; i < selectedToppingsNumbersArray.size(); i++) {
							mediumCartoonToppings[selectedToppingsNumbersArray.get(i)].setVisible(true);
						}
						
						mediumCartoonCrusts[Integer.parseInt(verifySelectedPizzaCrust())].setVisible(true);
						mediumCartoonCheese.setVisible(true);
						
						totalPrice += 10.00;
					}
					else if (source == radioBtnLarge) {
						setAllImagesInvisible();
						
						for(int i = 0; i < selectedToppingsNumbersArray.size(); i++) {
							largeCartoonToppings[selectedToppingsNumbersArray.get(i)].setVisible(true);
						}
						
						largeCartoonCrusts[Integer.parseInt(verifySelectedPizzaCrust())].setVisible(true);
						largeCartoonCheese.setVisible(true);
						
						totalPrice += 15.00;
					}
				}
				else { // Else item was unselected
					if (source == radioBtnSmall) {
						totalPrice -= 5.00;
					}
					else if (source == radioBtnMedium) {
						totalPrice -= 10.00;	
					}
					else if (source == radioBtnLarge) {
						totalPrice -= 15.00;
					}
				}
			} else if(style.equals("realistic")) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (source == radioBtnSmall) {
						setAllImagesInvisible();
						
						for(int i = 0; i < selectedToppingsNumbersArray.size(); i++) {
							smallRealisticToppings[selectedToppingsNumbersArray.get(i)].setVisible(true);
						}
						
						smallRealisticCrusts[Integer.parseInt(verifySelectedPizzaCrust())].setVisible(true);

						totalPrice += 5.00;
					}
					else if (source == radioBtnMedium) {
						setAllImagesInvisible();
						
						for(int i = 0; i < selectedToppingsNumbersArray.size(); i++) {
							mediumRealisticToppings[selectedToppingsNumbersArray.get(i)].setVisible(true);
						}
						
						mediumRealisticCrusts[Integer.parseInt(verifySelectedPizzaCrust())].setVisible(true);	
						
						totalPrice += 10.00;
					}
					else if (source == radioBtnLarge) {
						setAllImagesInvisible();
						
						for(int i = 0; i < selectedToppingsNumbersArray.size(); i++) {
							largeRealisticToppings[selectedToppingsNumbersArray.get(i)].setVisible(true);
						}
						
						largeRealisticCrusts[Integer.parseInt(verifySelectedPizzaCrust())].setVisible(true);
						
						totalPrice += 15.00;
					}
				}
				else { // Else item was unselected
					if (source == radioBtnSmall) {
						totalPrice -= 5.00;
					}
					else if (source == radioBtnMedium) {
						totalPrice -= 10.00;	
					}
					else if (source == radioBtnLarge) {
						totalPrice -= 15.00;
					}
				}
			}

			totalPriceTextField.setText(String.format("%.2f", totalPrice));
		}
	}
	
	public class StyleSelector implements ItemListener {

		public void itemStateChanged(ItemEvent e) {

			Object source = e.getItemSelectable();
			String size = verifySelectedPizzaSize();
			
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (source == radioBtnCartoon) {
					setAllImagesInvisible();
					
					switch(size) {
						case "small":
							for(int i = 0; i < selectedToppingsNumbersArray.size(); i++) {
								smallCartoonToppings[selectedToppingsNumbersArray.get(i)].setVisible(true);
							}
							
							smallCartoonCrusts[Integer.parseInt(verifySelectedPizzaCrust())].setVisible(true);
							smallCartoonCheese.setVisible(true);
							break;
							
						case "medium":
							for(int i = 0; i < selectedToppingsNumbersArray.size(); i++) {
								mediumCartoonToppings[selectedToppingsNumbersArray.get(i)].setVisible(true);
							}
							
							mediumCartoonCrusts[Integer.parseInt(verifySelectedPizzaCrust())].setVisible(true);
							mediumCartoonCheese.setVisible(true);
							break;	
							
						case "large":
							for(int i = 0; i < selectedToppingsNumbersArray.size(); i++) {
								largeCartoonToppings[selectedToppingsNumbersArray.get(i)].setVisible(true);
							}
							
							largeCartoonCrusts[Integer.parseInt(verifySelectedPizzaCrust())].setVisible(true);
							largeCartoonCheese.setVisible(true);
							break;	
					}
				}
				else if (source == radioBtnRealistic) {
					
					setAllImagesInvisible();
					
					switch(size) {
					case "small":
						for(int i = 0; i < selectedToppingsNumbersArray.size(); i++) {
							smallRealisticToppings[selectedToppingsNumbersArray.get(i)].setVisible(true);
						}
						
						smallRealisticCrusts[Integer.parseInt(verifySelectedPizzaCrust())].setVisible(true);
						break;
						
					case "medium":
						for(int i = 0; i < selectedToppingsNumbersArray.size(); i++) {
							mediumRealisticToppings[selectedToppingsNumbersArray.get(i)].setVisible(true);
						}
						
						mediumRealisticCrusts[Integer.parseInt(verifySelectedPizzaCrust())].setVisible(true);
						break;	
						
					case "large":
						for(int i = 0; i < selectedToppingsNumbersArray.size(); i++) {
							largeRealisticToppings[selectedToppingsNumbersArray.get(i)].setVisible(true);
						}
						
						largeRealisticCrusts[Integer.parseInt(verifySelectedPizzaCrust())].setVisible(true);
						break;	
					}

				}
			}
		}
	}

	public class CrustSelector implements ItemListener {

		public void itemStateChanged(ItemEvent e) {

			Object source = e.getItemSelectable();
			String size = verifySelectedPizzaSize();
			String style = verifySelectedPizzaStyle();
					
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (source == radioBtnThin) {
					switch(size) {
						case "small":
							if(style.equals("cartoon")) {
								smallCartoonCrusts[0].setVisible(true); // 0 is thin crust
							} else {
								smallRealisticCrusts[0].setVisible(true); // 0 is thin crust
							}
							
							break;
						
						case "medium":
							if(style.equals("cartoon")) {
								mediumCartoonCrusts[0].setVisible(true); // 0 is thin crust
							} else {
								mediumRealisticCrusts[0].setVisible(true); // 0 is thin crust
							}
							break;
							
						case "large":
							if(style.equals("cartoon")) {
								largeCartoonCrusts[0].setVisible(true); // 0 is thin crust
							} else {
								largeRealisticCrusts[0].setVisible(true); // 0 is thin crust
							}
							break;
					}
				}
				else if(source == radioBtnThick){	
					switch(size) {
						case "small":
							if(style.equals("cartoon")) {
								smallCartoonCrusts[1].setVisible(true); // 1 is thick crust
							} else {
								smallRealisticCrusts[1].setVisible(true); // 1 is thick crust
							}
							break;
						
						case "medium":
							if(style.equals("cartoon")) {
								mediumCartoonCrusts[1].setVisible(true); // 1 is thick crust
							} else {
								mediumRealisticCrusts[1].setVisible(true); // 1 is thick crust
							}
							break;
							
						case "large":
							if(style.equals("cartoon")) {
								mediumCartoonCrusts[1].setVisible(true); // 1 is thick crust
							} else {
								mediumRealisticCrusts[1].setVisible(true); // 1 is thick crust
							}
							break;
					}
				}
			}
			else { // Else item was unselected
				if (source == radioBtnThin) {
					switch(size) {
						case "small":
							if(style.equals("cartoon")) {
								smallCartoonCrusts[0].setVisible(false); // 0 is thin crust
							} else {
								smallRealisticCrusts[0].setVisible(false); // 0 is thin crust
							}
							
							break;
						
						case "medium":
							if(style.equals("cartoon")) {
								mediumCartoonCrusts[0].setVisible(false); // 0 is thin crust
							} else {
								mediumRealisticCrusts[0].setVisible(false); // 0 is thin crust
							}
							break;
							
						case "large":
							if(style.equals("cartoon")) {
								largeCartoonCrusts[0].setVisible(false); // 0 is thin crust
							} else {
								largeRealisticCrusts[0].setVisible(false); // 0 is thin crust
							}
							break;
					}
				}
				else if(source == radioBtnThick){
					switch(size) {
						case "small":
							if(style.equals("cartoon")) {
								smallCartoonCrusts[1].setVisible(false); // 1 is thick crust
							} else {
								smallRealisticCrusts[1].setVisible(false); // 1 is thick crust
							}
							break;
						
						case "medium":
							if(style.equals("cartoon")) {
								mediumCartoonCrusts[1].setVisible(false); // 1 is thick crust
							} else {
								mediumRealisticCrusts[1].setVisible(false); // 1 is thick crust
							}
							break;
							
						case "large":
							if(style.equals("cartoon")) {
								mediumCartoonCrusts[1].setVisible(false); // 1 is thick crust
							} else {
								mediumRealisticCrusts[1].setVisible(false); // 1 is thick crust
							}
							break;
					}
				}
			}
		}
	}

	/**
	 * verifySelectedPizzaSize
	 * @return the size of the pizza that's currently selected
	 */
	public static String verifySelectedPizzaSize() {
		String size = "";
		
		ButtonModel buttonModel = buttonGroupPizzaSize.getSelection();
		
		if (modelToRadioButtonPizzaSize.containsKey(buttonModel)) {
            JRadioButtonMenuItem selectedRadioButton = Pizza.modelToRadioButtonPizzaSize.get(buttonModel);

            if(selectedRadioButton == radioBtnSmall) {
            	size = "small";
            } else if(selectedRadioButton == radioBtnMedium) {
            	size = "medium";
            } else if(selectedRadioButton == radioBtnLarge) {
            	size = "large";
            } 
         }
		
		return size;
	}
	
	/**
	 * verifySelectedPizzaCrust
	 * @return the crust of the pizza that's currently selected
	 */
	public static String verifySelectedPizzaCrust() {
		String crust = "1";
		
		ButtonModel buttonModel = buttonGroupPizzaCrust.getSelection();
		
		if (modelToRadioButtonPizzaCrust.containsKey(buttonModel)) {
            JRadioButtonMenuItem selectedRadioButton = Pizza.modelToRadioButtonPizzaCrust.get(buttonModel);

            if(selectedRadioButton == radioBtnThin) {
            	crust = "0"; // 0 is thin
            } else if(selectedRadioButton == radioBtnThick) {
            	crust = "1"; // 1 is thick
            }
        }
		return crust;
	}
	
	/**
	 * verifySelectedPizzaStyle
	 * @return the style of the pizza that's currently selected
	 */
	public static String verifySelectedPizzaStyle() {
		String style = "cartoon";
		
		ButtonModel buttonModel = buttonGroupPizzaStyle.getSelection();
		
		if (modelToRadioButtonPizzaStyle.containsKey(buttonModel)) {
            JRadioButtonMenuItem selectedRadioButton = modelToRadioButtonPizzaStyle.get(buttonModel);

            if(selectedRadioButton == radioBtnCartoon) {
            	style = "cartoon";
            } else if(selectedRadioButton == radioBtnRealistic) {
            	style = "realistic";
            }
        }
		return style;
	}
	
	/**
	 * Clock 
	 */
	public void startClock() {
		Thread clock = new Thread()
		{
			public void run() 
			{
				try {
					while(true) {
					Date date = new Date();
					Calendar dateFeature = new GregorianCalendar();
					int day = dateFeature.get(Calendar.DAY_OF_MONTH);
					int month = dateFeature.get(Calendar.MONTH);
					int year = dateFeature.get(Calendar.YEAR);
					
				    String strDateFormat12 = "hh:mm:ss a";
				    String strDateFormat24 = "HH:mm:ss";
				    SimpleDateFormat sdf12 = new SimpleDateFormat(strDateFormat12);
				    SimpleDateFormat sdf24 = new SimpleDateFormat(strDateFormat24);
					
					lblClock.setText("Time in 12H format: " + sdf12.format(date)+  
							"\n    Time in 24H format: " + sdf24.format(date)+
							"\n    Date: "+day+"/"+month+"/"+year);
					sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		};
		
		clock.start();
	}
	
	/**
	 * Set all images invisible
	 */
	private void setAllImagesInvisible() {
		// Set all toppings invisible
		for(int i = 0; i < 11; i++) {
			smallCartoonToppings[i].setVisible(false);
			mediumCartoonToppings[i].setVisible(false);
			largeCartoonToppings[i].setVisible(false);
			smallRealisticToppings[i].setVisible(false);
			mediumRealisticToppings[i].setVisible(false);
			largeRealisticToppings[i].setVisible(false);
		}
		
		// Set all crusts invisible
		for(int i = 0; i < 2; i++) {
			smallCartoonCrusts[i].setVisible(false);
			mediumCartoonCrusts[i].setVisible(false);
			largeCartoonCrusts[i].setVisible(false);
			smallRealisticCrusts[i].setVisible(false);
			mediumRealisticCrusts[i].setVisible(false);
			largeRealisticCrusts[i].setVisible(false);
		}
		
		// Set all 'cheeses' invisible
		smallCartoonCheese.setVisible(false);
		mediumCartoonCheese.setVisible(false);
		largeCartoonCheese.setVisible(false);
		
		
	}
}