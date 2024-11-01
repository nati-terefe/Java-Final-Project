
// This program is used to book a flight for a passenger. It is connected to a mysql server
// Written by: 	1. Nahom Wondesen 	ID PY0761
//				2. Samuel Messeret 	ID SV9461
// 				3. Michael Getu 	ID ml2612
// 				4. Nathnael Terefe 	ID LF2669
// 				5. Temesgan Fekadu 	ID ZT2452
// 				6. Mohammed Hussen 	ID QB7718
// Written due: 29/05/2022
                

//		----------------IMPORT STATMENTS----------------------------------------------------------------------------------------------------------------

import java.awt.*;// To build a GUI
import javax.swing.*;// To build a GUI
import java.awt.event.*;// For listener class
import javax.swing.table.JTableHeader; //For table header
import java.sql.*;//For database
import javax.swing.table.TableCellRenderer; //For Column auto fit content
import javax.swing.table.TableColumn; //For Column auto fit content

//		----------------PUBLIC CLASS DECLARATION-------------------------------------------------------------------------------------------

public class Airlinereservation {
	
//	----------------VARIABLES ON LOGIN PAGE DECLARATION-------------------------------------------------------------------------------------------
	
	private static JTextField userfield; //Making it static b/c we are not creating object to access it, because we create object on the main frame
	private static JPasswordField passwordField; // Making it static b/c we are not creating object to access it, because we create object on the main frame
	static String username; // It will store the value we get from user on user field
							// Making it static b/c we are not creating object to access it, because we create object on the main frame
	static String password; // It will store the value we get from user on password field
							// Making it static b/c we are not creating object to access it, because we create object on the main frame

//	----------------DECLARATION OF COMPONENT Variables ON MAIN PAGE-------------------------------------------------------------------------------------------
	
	// Variables are private to implement encapsulation and make variables only visible throughout this class
	private JFrame jf; // Creating JFrame variable so that we can access it in the whole class later, when its a reference variable
	private JTextField fieldfirst; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private JTextField fieldlast; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private JTextField fieldphone; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private ButtonGroup malefemalegroup; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private JTextArea textArea; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private JTextArea areaseat; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private JTextArea areaprice; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private JLabel labelphone; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private JComboBox combodateandtime; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private JComboBox comboage; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private JComboBox comboclass; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private JComboBox comboseattp; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private JComboBox combofrom; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private JComboBox comboto; // Creating variables so that we can access them everywhere in the class, when its a reference variable mainly in book button action listener
	private static JFrame frame2; // Creating JFrame variable so that we can access it in the whole class later, when its a reference variable
								  // Making it static b/c we are not creating object to access it, because we create object on the main frame					
	JTable passtable; // Creating a JTable to display table result from database
	JButton buttonview; // Creating a button that is later assigned as view database button
	JButton buttonhide; // Creating a button that is later assigned as hide database button
	JTableHeader header; // Creating a header that is later going to be assigned to hold names of columns of table
	JLabel lsql; // Creating a label that is later going to assigned to store the label "Data from Database"
	JPanel tablepanel; // Creating a panel that will hold the table, it's header and it's label
	
//	----------------DECLARATION OF DATA STORING Variables ON MAIN PAGE-------------------------------------------------------------------------------------------
	
	private String [] desdatapool, datedatapool, seattypedatapool; // Data pool variables that are used to populate the combo boxes
	int availseat; // Variable to hold available seats
	String flightnum=new String(); // Variable to hold flight number
	String dateandtime = new String(); // Variable to hold date and time
	String seat = new String(); // Variable to hold and assign seat
	String seattype;

//		----------------APPLICATION STARTS HERE---------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		
//		----------------LOGIN PAGE----------------------------------------------------------------------------------------------------------------------
		
		frame2 = new JFrame(); // Creating frame using JFrame
		
		frame2.setResizable(false); // Can't resize the window so that it doesn't lose its form
		frame2.getContentPane().setBackground(Color.LIGHT_GRAY); // Setting our background colour
		frame2.getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		frame2.getContentPane().setLayout(null); // Setting layer to absolute
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // To release resource after closing. This makes the program stop sunning when we click X
		frame2.setBounds(400, 160, 516, 375); // x , y and width and height
		frame2.setTitle("Login to Airline Reservation System"); // Setting the title of the page
		
//		----------------USER NAME-----------------------------------------------------------------------------------------------------------------------

		JLabel labeluser = new JLabel("User name"); // User name Label
		
		labeluser.setFont(new Font("SansSerif", Font.BOLD, 20)); // Setting font type and size
		labeluser.setForeground(new Color(255, 250, 250)); // Setting our font colour
		labeluser.setBackground(Color.WHITE); // Setting back ground colour
		labeluser.setBounds(351, 100, 124, 34); // x , y and width and height
		frame2.getContentPane().add(labeluser); // Adding it to the frame
		
		userfield = new JTextField(); // The Field for the user name accepting
		
		userfield.setToolTipText("Enter you're user name here"); // Tip for user when using the software
		userfield.setBounds(351, 137, 139, 27); // x , y and width and height
		frame2.getContentPane().add(userfield);// Adding it to the frame
		
// 		----------------PASS WORD-----------------------------------------------------------------------------------------------------------------------

		JLabel labelpassword = new JLabel("Password\r\n");// password label
		
		labelpassword.setForeground(new Color(255, 250, 250)); // Setting the font colour
		labelpassword.setFont(new Font("SansSerif", Font.BOLD, 20)); // Setting font type and size
		labelpassword.setBounds(351, 160, 124, 34); // x , y and width and height
		frame2.getContentPane().add(labelpassword); // Adding it to the frame		

		passwordField = new JPasswordField(); // The Field for the password accepting
		
		passwordField.setToolTipText("Enter you're password here"); // Tip for user when using the software
		passwordField.setBounds(351, 192, 139, 27); // x , y and width and height
		frame2.getContentPane().add(passwordField); // Adding it to the frame

//		----------------LOGIN BUTTON--------------------------------------------------------------------------------------------------------------------
		
		JButton buttonlogin = new JButton("Login"); // The login button
		
		buttonlogin.setToolTipText("push this button to login"); // Tip for user when using the software
		buttonlogin.setBackground(new Color(0, 255, 255)); // Setting back ground colour
		buttonlogin.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		buttonlogin.setBounds(389, 230, 101, 27); // x , y and width and height
		frame2.getContentPane().add(buttonlogin); // Adding it to the frame
		
//		----------------LOGIN SLOGAN--------------------------------------------------------------------------------------------------------------------

		JLabel labelslogan = new JLabel("A journey of a thousand \r\nmiles beigns with a \r\nsingle step.."); // Slogan on login page
		
		labelslogan.setFont(new Font("Verdana", Font.BOLD, 12)); // Setting font type and colour
		labelslogan.setBounds(10, -5, 392, 139); // x , y and width and height
		frame2.getContentPane().add(labelslogan); // Adding it to the frame
		
//		----------------LOGIN PAGE BACKGROUND PIC-------------------------------------------------------------------------------------------------------

		JLabel loginpic = new JLabel(""); // Label to carry the picture on the login window
		
		loginpic.setIcon(new ImageIcon("src\\login.jpg")); // Using set icon to insert picture
		loginpic.setBounds(0, 0, 760, 340); // Setting x,y height and width
		frame2.getContentPane().add(loginpic); // Adding to the frame
		frame2.setVisible(true); // setting visibility it takes boolean
		
//		----------------ACTION LISTNER FOR LOGIN BUTTON-------------------------------------------------------------------------------------------------
		
		buttonlogin.addActionListener(new ActionListener() { // Adding action listener to the login button
			public void actionPerformed(ActionEvent a) {
				username = userfield.getText(); // Getting and storing what the user enter as a user name
				password = String.valueOf(passwordField.getPassword()); // Getting and storing what the user enter as password
				try { // Try block to catch if there is a problem while creating an object
					Class.forName("com.mysql.cj.jdbc.Driver"); // Establishing connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
							"Lewy1miky"); // Establishing connection
					Statement stm = con.createStatement(); // Establishing connection
					String sql = "SELECT COUNT(*) FROM login WHERE usr='"+username+"' AND psw='"+password+"';"; // Creating Query
					ResultSet rs = stm.executeQuery(sql); //Executing query and retrieving data
					rs.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
					if (rs.getInt(1) == 1) { // Selecting for ones that have a matching login info on data base
						EventQueue.invokeLater(new Runnable() { 
							public void run() {
								try { // Try block to catch if there is a problem while creating an object
									Airlinereservation window = new Airlinereservation(); 
									// Creating object of the airline reservation to access the Constructor
									window.jf.setVisible(true); // Affect visibility of the JFrame
								} catch (Exception e) { // Error catching block of the try block
									e.printStackTrace(); // Error printing
								}
							}
						});
					} else { // Selecting for ones that don't have a matching login info on data base
						JOptionPane.showMessageDialog(new JFrame(),"Incorrect username or password. Please Re-enter!!"); 
						// POP UP message for any incorrect login info
					}
				} catch (Exception ee) { // Error catching block of the try block
					System.out.println(ee); // Error printing
				}
			}
		});
	}

// 	----------------CREATING THE APPLICATION-----------------------------------------------------------------------------------------------------------
	
	public Airlinereservation() { // Constructor of the class airline reservation
		initialize(); // Calling function that carry all the important functions
	}

//	--------------------------------VALIDATING NAME Function-------------------------------------------------------------------------------------------
	
	static boolean validatename(String a) { // Creating a function that validate a name
		char [] b=a.toCharArray(); // Changing the accepting string to character array cause we can't iterate on string
		for(int i=0; i<b.length; i++) { //Iterating on array looking for invalid input
			if(b[i]==' ') { // Selecting invalid inputs of being a letter 
				return false;
			}
			if(!((b[i]>='A' && b[i]<='z'))) { // Selecting invalid inputs of being a space
				return false;
			}
		}
		return true;
	}
	
//	--------------------------------VALIDATING PHONE Function------------------------------------------------------------------------------------------
	
	static boolean validatephone(String a) { // Creating a function that validate a phone
		char [] b=a.toCharArray(); // Changing the accepting string to character array cause we can't iterate on string
		for(int i=0; i<b.length; i++) { //Iterating on array looking for invalid input
			if(b[i]==' ' || (b[i]>='A' && b[i]<='z')) { // Selecting invalid inputs of being a letter or space
				return false;
			}
			else if(b.length<10 || b.length>15) { // Selecting invalid inputs of being less than 10 or greater than 15 long
				return false;
			}
		}
		return true;
	}
	
//	----------------INITIALIZING THE CONTENT PANEL OF JFRAME--------------------------------------------------------------------------------------------
	
	private void initialize() { // Creating function in the class Airline Reservation for the main part (Reservation Window/ Main Page)
		jf = new JFrame("Airline Reservation"); // Creating frame
		jf.setBounds(0, 15, 1500, 710); // Setting bound of frame
		jf.setTitle("Wakanda Airline Reservation"); // Setting title of frame
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // To release resource after closing. This makes the program stop sunning when we click X
		jf.getContentPane().setLayout(null); // By getting the content pane will help us in setting the layout to null
		
//		----------------GENERATING TOP LABEL------------------------------------------------------------------------------------------------------------
		
		JLabel ltop = new JLabel("                                                         Wakanda Airline Reservation"); // The top title
		
		ltop.setForeground(new Color(0, 0, 128)); // Setting font coloUr
		ltop.setBackground(new Color(14,51,75)); // Setting the background colour
		ltop.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 30)); // Setting font type and size
		ltop.setBounds(0, 0, 1370, 53); // x , y and width and height
		jf.getContentPane().add(ltop); // Adding to the JFream
		
//		----------------GENERATING DATA FROM DATABASE LABEL---------------------------------------------------------------------------------------------
		
		lsql = new JLabel("DATA ON DATABASE"); // The top label that says data from database
		
		lsql.setForeground(new Color(0, 0, 0)); // Setting font coloUr
		lsql.setBackground(Color.LIGHT_GRAY); // Setting the background colour
		lsql.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 20)); // Setting font type and size
		lsql.setBounds(1000, 20, 300, 53); // x , y and width and height
		lsql.setVisible(false); // Setting its visibility to false until letter explicitly set to true
		jf.getContentPane().add(lsql);// Adding to the JFream
		
//		--------------------------------FETCHING DESTINATION DATA FROM DATABASE-------------------------------------------------------------------------
		
		try { // Try block to catch if there is a problem while creating an object
			Class.forName("com.mysql.cj.jdbc.Driver"); // Establishing connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
					"Lewy1miky"); // Establishing connection
			Statement stm = con.createStatement(); // Establishing connection
			String sql = "SELECT COUNT(*) FROM destinations";
			// Creating Query that returns how many destinations there are on database
			ResultSet rs = stm.executeQuery(sql); //Executing query and retrieving data
			rs.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
			int rowcount=rs.getInt(1); // Assigning value at row 1 column 1 of rs to row count
			desdatapool= new String[rowcount]; // Creating reference of desdatapool that is the length of the retrieved row count
			String sql1 = "Select city from destinations";
			// Creating Query that returns all cities from destinations table
			ResultSet rs1 = stm.executeQuery(sql1); //Executing query and retrieving data
			rs1.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
			for(int i=1; i<=rowcount; i++) { // Retrieving the table value in rs by assigning it to desdatapool string array
				desdatapool[i-1]=rs1.getString(1); // Assigning value at column 1 of rs to row count [i-1]
				rs1.next(); // Making data reading move down a row
			}
			con.close(); // Closing Established connection
		} catch (Exception ee) { // Error catching block of the try block
			System.out.println(ee); // Error printing
		}
				
//		----------------FIRST NAME----------------------------------------------------------------------------------------------------------------------
		
		JLabel labelfirst = new JLabel("First name"); // Creating first name label
		
		labelfirst.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Ading size and font type
		labelfirst.setBounds(24, 39, 133, 21); // Setting the x,y,height,width
		jf.getContentPane().add(labelfirst); // Adding the Jlabel to the Jframe
		
		fieldfirst = new JTextField(); // Creating first name field that accept first name input from user
		
		fieldfirst.setToolTipText("Enter you're first name"); // Tip for user when using the software
		fieldfirst.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		fieldfirst.setBounds(170, 41, 210, 29); // Setting the x,y,height,width
		jf.getContentPane().add(fieldfirst); // Adding to the Jframe
		//fieldfirst.setColumns(10);
		
//		----------------LAST NAME-----------------------------------------------------------------------------------------------------------------------

		JLabel labellast = new JLabel("Last name"); // Creating first name label
		
		labellast.setFont(new Font("SansSerif", Font.PLAIN, 20));// Setting font type and size
		labellast.setBounds(24, 84, 133, 21);// x , y and width and height
		jf.getContentPane().add(labellast); // Adding the Jlabel to the Jframe
		
		fieldlast = new JTextField(); // Creating last name field that accept first name input from user
		
		fieldlast.setToolTipText("Enter you're last name"); // Tip for user when using the software
		fieldlast.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		fieldlast.setBounds(170, 84, 210, 29); // x , y and width and height
		jf.getContentPane().add(fieldlast); // Adding to the Jframe
		//fieldlast.setColumns(10); 
		
//		----------------GENDER-------------------------------------------------------------------------------------------------------------------------

		JLabel labelgender = new JLabel("Gender"); // Creating Gender label
		
		labelgender.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		labelgender.setBounds(24, 120, 92, 21); // x , y and width and height
		jf.getContentPane().add(labelgender); // Adding the Jlabel to the Jframe
		
		JRadioButton rbmale = new JRadioButton("Male"); // Creating a male radio button
		
		rbmale.setSelected(true); // Selecting male as default but then user can change it if they want female
		rbmale.setToolTipText("choose you're gender"); // Tip for user when using the software
		rbmale.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		rbmale.setBounds(167, 120, 72, 23); // x , y and width and height
		rbmale.setActionCommand("Male"); // Setting how we want to identify the button later with getActionCommand() function
		jf.getContentPane().add(rbmale); // Adding to the Jframe

		JRadioButton rbfemale = new JRadioButton("Female"); // Creating female radio button
		
		rbfemale.setToolTipText("choose you're gender"); // Tip for user when using the software
		rbfemale.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		rbfemale.setBounds(260, 120, 109, 23); // x , y and width and height
		rbfemale.setActionCommand("Female"); // Setting how we want to identify the button later with getActionCommand() function
		jf.getContentPane().add(rbfemale); // Adding to the Jframe

		malefemalegroup = new ButtonGroup(); // Creating a button group that makes male and female radio button communicate so only one can be chosen at a time
		malefemalegroup.add(rbmale); // adding radio button male to the group
		malefemalegroup.add(rbfemale); // adding radio button female to the group
		
//		----------------AGE-----------------------------------------------------------------------------------------------------------------------------

		JLabel labelage = new JLabel("Age"); // Creating age label
		
		labelage.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		labelage.setBounds(24, 152, 72, 23);// x , y and width and height
		jf.getContentPane().add(labelage); // Adding the Jlabel to the Jframe
		
		comboage = new JComboBox(); // Creating combobox for age to be choosen from
		
		comboage.setToolTipText("Choose you're age"); // Tip for user when using the software
		comboage.setMaximumRowCount(10); // Setting max row
		comboage.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		comboage.setModel(new DefaultComboBoxModel(new String[] {"Under 18", "18+"}));
		// passing the elements we want in the combo box using anonymous string creation
		comboage.setSelectedIndex(0); // Making the index start from 0 but the default used to be -1
		comboage.setBounds(170, 149, 210, 29); // x , y and width and height
		jf.getContentPane().add(comboage); // Adding to the Jframe
		
//		----------------PHONE NO------------------------------------------------------------------------------------------------------------------------

		labelphone = new JLabel("Phone n0"); // Creating phone no label
		
		labelphone.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		labelphone.setBounds(24, 186, 158, 22); // x , y and width and height
		jf.getContentPane().add(labelphone); // Adding the Jlabel to the Jframe

		fieldphone = new JTextField(); // Creating phone no field that we use to accept phone number from user
		
		fieldphone.setToolTipText("Enter you're phone number"); // Tip for user when using the software
		fieldphone.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		fieldphone.setBounds(170, 186, 210, 29); // x , y and width and height
		jf.getContentPane().add(fieldphone); // Adding to the Jframe
		//fieldphone.setColumns(10);
		
//		----------------DEPARTURE-----------------------------------------------------------------------------------------------------------------------

		JLabel labeldeparture = new JLabel("Departure"); // Creating departure label
		
		labeldeparture.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		labeldeparture.setBounds(24, 230, 92, 22); // x , y and width and height
		jf.getContentPane().add(labeldeparture); // Adding the Jlabel to the Jframe
		
		combofrom = new JComboBox(); // Creating combo box for departure to be chosen from
		
		combofrom.setToolTipText("Choose you're departure"); // Tip for user when using the software
		combofrom.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		combofrom.setModel(new DefaultComboBoxModel(new String[] { "Addis Ababa" }));
		// Passing the elements we want in the combo box using anonymous string creation
		combofrom.setSelectedIndex(0); // Making the index start from 0 but the default used to be -1
		combofrom.setBounds(170, 228, 210, 29); // x , y and width and height
		jf.getContentPane().add(combofrom); // Adding it to the frame
		
//		----------------DESTINATION---------------------------------------------------------------------------------------------------------------------

		JLabel labeldestination = new JLabel("Destination"); // Creating destination label
		
		labeldestination.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		labeldestination.setBounds(24, 270, 115, 22); // x , y and width and height
		jf.getContentPane().add(labeldestination); // Adding the Jlabel to the Jframe
		
		comboto = new JComboBox(); // Creating combo box for destination to be chosen from
		
		comboto.setToolTipText("Choose you're destination"); // Tip for user when using the software
		comboto.setModel(new DefaultComboBoxModel(desdatapool));
		// Passing the elements we want in the combo box which is the global variable that contains destination data pools
		comboto.setSelectedIndex(0); // Making the index start from 0 but the default used to be -1 
		comboto.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		comboto.setBounds(170, 268, 210, 29); // x , y and width and height
		jf.getContentPane().add(comboto); // Adding it to the frame
		
//		----------------CLASS---------------------------------------------------------------------------------------------------------------------------
		
		JLabel labelclass = new JLabel("Class"); // Creating class label
		
		labelclass.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		labelclass.setBounds(24, 320, 58, 22); // x , y and width and height
		jf.getContentPane().add(labelclass); // Adding the Jlabel to the Jframe
		
		comboclass = new JComboBox(); // Creating combo box for class to be chosen from
		
		comboclass.setToolTipText("Choose you're flight class\r\n"); // Tip for user when using the software
		comboclass.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		comboclass.setModel(new DefaultComboBoxModel(new String[] { "Economy Class", "Business Class", "First Class" }));
		// Passing the elements we want in the combo box using anonymous string creation
		comboclass.setSelectedIndex(0); // Making the index start from 0 but the default used to be -1
		comboclass.setBounds(170, 310, 210, 34); // x , y and width and height
		jf.getContentPane().add(comboclass); // Adding it to the frame
		
//		----------------DATEANDTIME---------------------------------------------------------------------------------------------------------------------
		
		JLabel labeldateandtime = new JLabel("Avaliable Date and Time"); // Creating Available date and time label
		
		labeldateandtime.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		labeldateandtime.setBounds(24, 362, 270, 22); // x , y and width and height 24
		jf.getContentPane().add(labeldateandtime); // Adding the Jlabel to the Jframe

		combodateandtime = new JComboBox(); // Creating combo box for date and time to be chosen from
		
		combodateandtime.setToolTipText("Choose the date and time you want to book"); // Tip for user when using the software
		combodateandtime.setFont(new Font("SansSerif", Font.PLAIN, 18)); // Setting font type and size
		combodateandtime.setModel(new DefaultComboBoxModel(new String[] {"YYYY-MM-DD"}));
		// passing the elements we want in the combo box using anonymous string creation
		combodateandtime.setSelectedIndex(0); // Making the index start from 0 but the default used to be -1
		combodateandtime.setBounds(24, 390, 210, 29); // x , y and width and height
		jf.getContentPane().add(combodateandtime); // Adding it to the frame
		
//		-----------------------------ACTION LISTNER FOR WHEN USER SELECT DESTINATION--------------------------------------------------------------------
		
		comboto.addActionListener(new ActionListener() { // Adding action listener to when user select a destination
			public void actionPerformed(ActionEvent e) {
				
//		-----------------------------FEATCHING DATE DATA BASED ON DESTINATION AND SEAT AVAILABLE--------------------------------------------------------
				// This is to populate date and time combo box based on the destination user chooses
				try { // Try block to catch if there is a problem while creating an object
					String destination = new String(); // Creating variable 
					destination = (String) comboto.getSelectedItem(); // Assigning variable to the destination user selected
					Class.forName("com.mysql.cj.jdbc.Driver"); // Establishing connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
							"Lewy1miky"); // Establishing connection
					Statement stm = con.createStatement(); // Establishing connection
					String sql = "SELECT COUNT(*) FROM flights where des='"+destination+"'and availseat>0"; 
					// Creating Query that returns how many flights records that contain this destination and there available seat>0
					ResultSet rs = stm.executeQuery(sql);  //Executing query and retrieving data
					rs.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
					int rowcount=rs.getInt(1); // Assigning value at row 1 column 1 of rs to row count
					if(rowcount==0) { // Selecting for when row count is zero
						datedatapool= new String[rowcount+2]; // Creating date data pool with a length of row count +2
						datedatapool[1]="0 AVAILABLE"; // Assigning second option of date data pool to be a 0-AVAILABLE
					}
					else { // Selecting for row count is not zero
						datedatapool= new String[rowcount+1]; // Creating date data pool with a length of row count +1
					}
					String sql1 = "Select datandtime from flights where des='"+destination+"'and availseat>0";
					// Creating Query that returns all flights records that contain this destination and there available seat>0
					ResultSet rs1 = stm.executeQuery(sql1);  //Executing query and retrieving data
					rs1.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
					datedatapool[0]="YYYY-MM-DD"; // Assigning first date data pool to be a default YYYY-MM-DD
					if(rowcount>0) { // Selecting for row count is greater that 0
						for(int i=1; i<=rowcount; i++) { // Iterating on date data pool until its fully assigned
							datedatapool[i]=rs1.getString(1); // Assigning date data pool to value on rs
							rs1.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
						}
					}
					combodateandtime.setModel(new DefaultComboBoxModel(datedatapool)); 
					// passing the elements we want in the combo box using the string created date data pool
					con.close(); // Closing Connection
				} catch (Exception ee) { // Error catching block of the try block
					System.out.println(ee); // Error printing
				}
			}});
				
//		----------------SEATSLEFT-----------------------------------------------------------------------------------------------------------------------
		
		JLabel labelseat = new JLabel("Seats Left"); // Creating Seats left label
		
		labelseat.setForeground(Color.BLACK); // Setting font color
		labelseat.setBackground(Color.WHITE); // setting back ground color
		labelseat.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		labelseat.setBounds(280, 362, 213, 30); // x , y and width and height 335
		jf.getContentPane().add(labelseat); // Adding the Jlabel to the Jframe
		
		areaseat = new JTextArea(); // Creating text area for seats left where seats left will be displayed
		
		areaseat.setEditable(false); // Making the text area non-editable
		areaseat.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		areaseat.setLineWrap(true); // Making the text area wrap text if it gets too long
		areaseat.setToolTipText("seats Left"); // Tip for user when using the software
		areaseat.setText(""); // Leaving it empty b/c we are setting it later based on condition of available date and time
		areaseat.setBounds(280, 390, 100, 35); // x , y and width and height
		jf.getContentPane().add(areaseat); // Adding it to the frame
		
//		----------------SEAT TYPE-----------------------------------------------------------------------------------------------------------------------
		
		JLabel labelseattp = new JLabel("Seat Type"); // Creating Seats type label
		
		labelseattp.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		labelseattp.setBounds(24, 435, 118, 25); // x , y and width and height
		jf.getContentPane().add(labelseattp); // Adding the Jlabel to the Jframe
		
		comboseattp = new JComboBox(); // Creating combo box for seat type to be chosen from
		
		comboseattp.setToolTipText("Choose you're seat type\r\n"); // Tip for user when using the software
		comboseattp.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		comboseattp.setModel(new DefaultComboBoxModel(new String[] { "Seat Type"}));
		// Passing the elements we want in the combo box using anonymous string creation
		comboseattp.setSelectedIndex(0); // Making the index start from 0 but the default used to be -1
		comboseattp.setBounds(170, 435, 210, 34); // x , y and width and height
		jf.getContentPane().add(comboseattp); // Adding it to the frame

// ----------------ACTION LISTNER FOR WHEN USER SELECT DATE AND TIME------------------------------------------------------------------------------------
		
		combodateandtime.addActionListener(new ActionListener() { // Adding action listener to when user select a date and time
			public void actionPerformed(ActionEvent e) {
				
// -----------------------------FETCHING FLIGHTNUM FROM DATABASE BASED ON DATE AND DESTINATION----------------------------------------------------------
				
				// This is to populate seat type combo box based on the date and time user chooses
				try { // Try block to catch if there is a problem while creating an object
					String destination = new String(); // Creating variable
					destination = (String) comboto.getSelectedItem(); // Assigning variable to the destination user selected
					dateandtime = (String) combodateandtime.getSelectedItem(); // Assigning variable to the date and time user selected
					Class.forName("com.mysql.cj.jdbc.Driver"); // Establishing connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
							"Lewy1miky"); // Establishing connection
					Statement stm = con.createStatement(); // Establishing connection
					if(!(dateandtime.equals("0 AVAILABLE")|| dateandtime.equals("YYYY-MM-DD"))) { // Selection For when user didn't select the default of the 0 AVAILABLE
						String sql = "Select id from flights where datandtime='"+dateandtime+"' and des='"+destination+"'";
						// Creating Query that fetches the flight number based on that date and destination
						ResultSet rs = stm.executeQuery(sql); //Executing query and retrieving data
						rs.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
						flightnum=rs.getString(1); // Assigning value at row 1 column 1 of rs to flightnum
					}
							
//	-----------------------------FEATCHING AVAILABLE SEAT DATA BASED ON FLIGHTNUM-----------------------------------------------------------------------
					
					if(dateandtime.equals("0 AVAILABLE")) {
						areaseat.setText(String.valueOf(0));
					}
					else {
						String sql1 = "Select availseat from flights where id='"+flightnum+"'"; 
						// Creating Query that fetches available seat on that flight
						ResultSet rs1 = stm.executeQuery(sql1); //Executing query and retrieving data
						rs1.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
						availseat=rs1.getInt(1); // Assigning value at row 1 column 1 of rs to availseat
						areaseat.setText(String.valueOf(availseat)); // Setting text area of available to the acquired value
						
//	-----------------------------------FEATCHING AVAILABLE SEAT TYPE DATA BASED ON DATE AND DESTINATION-------------------------------------------------
						
						String sql4 = "select seat from passengers where flightnum='"+flightnum+"'ORDER BY id DESC LIMIT 1";
						// Creating Query that returns the last passenger seat on that flightnum
						ResultSet rs4 = stm.executeQuery(sql4); //Executing query and retrieving data
						rs4.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
						String temp=rs4.getString(1); // Assigning value at row 1 column 1 of rs to temp. This holds the last taken seat on that flight
						char[] lastseat=temp.toCharArray(); // Assigning last seat with char array version of temp
						if(lastseat[4]=='Z'){ // Selecting for last column in last seat is Z which means that type of window on that column is unavailable
							seattypedatapool=new String [8]; 
							// Creating variable seat type data pool with length 8 since we know for sure 1 type of seat on one of the columns is booked
							char tempcol=lastseat[0]; // Assigning temporary variable with the column
							char temptp=lastseat[2]; // Assigning temporary variable with the seat type
							if(tempcol=='A' && temptp=='a') { // Selecting if the fully booked is column A window type and removing it while populating
								seattypedatapool[0]="Col A Middle Seat"; // Populating seat type data pool
								seattypedatapool[1]="Col A Side Seat"; // Populating seat type data pool
								seattypedatapool[2]="Col B Window Seat"; // Populating seat type data pool
								seattypedatapool[3]="Col B Middle Seat"; // Populating seat type data pool
								seattypedatapool[4]="Col B Side Seat"; // Populating seat type data pool
								seattypedatapool[5]="Col C Window Seat"; // Populating seat type data pool
								seattypedatapool[6]="Col C Middle Seat"; // Populating seat type data pool
								seattypedatapool[7]="Col C Side Seat"; // Populating seat type data pool
							}
							else if(tempcol=='A' && temptp=='b') { // Selecting if the fully booked is column A Middle type and removing it while populating
								seattypedatapool[0]="Col A Window Seat"; // Populating seat type data pool
								seattypedatapool[1]="Col A Side Seat"; // Populating seat type data pool
								seattypedatapool[2]="Col B Window Seat"; // Populating seat type data pool
								seattypedatapool[3]="Col B Middle Seat"; // Populating seat type data pool
								seattypedatapool[4]="Col B Side Seat"; // Populating seat type data pool
								seattypedatapool[5]="Col C Window Seat"; // Populating seat type data pool
								seattypedatapool[6]="Col C Middle Seat"; // Populating seat type data pool
								seattypedatapool[7]="Col C Side Seat"; // Populating seat type data pool
							}
							else if(tempcol=='A' && temptp=='c') { // Selecting if the fully booked is column A Side type and removing it while populating
								seattypedatapool[0]="Col A Window Seat"; // Populating seat type data pool
								seattypedatapool[1]="Col A Middle Seat"; // Populating seat type data pool
								seattypedatapool[2]="Col B Window Seat"; // Populating seat type data pool
								seattypedatapool[3]="Col B Middle Seat"; // Populating seat type data pool
								seattypedatapool[4]="Col B Side Seat"; // Populating seat type data pool
								seattypedatapool[5]="Col C Window Seat"; // Populating seat type data pool
								seattypedatapool[6]="Col C Middle Seat"; // Populating seat type data pool
								seattypedatapool[7]="Col C Side Seat"; // Populating seat type data pool
							}
							else if(tempcol=='B' && temptp=='a') { // Selecting if the fully booked is column B window type and removing it while populating
								seattypedatapool[0]="Col A Window Seat"; // Populating seat type data pool
								seattypedatapool[1]="Col A Middle Seat"; // Populating seat type data pool
								seattypedatapool[2]="Col A Side Seat"; // Populating seat type data pool
								seattypedatapool[3]="Col B Middle Seat"; // Populating seat type data pool
								seattypedatapool[4]="Col B Side Seat"; // Populating seat type data pool
								seattypedatapool[5]="Col C Window Seat"; // Populating seat type data pool
								seattypedatapool[6]="Col C Middle Seat"; // Populating seat type data pool
								seattypedatapool[7]="Col C Side Seat"; // Populating seat type data pool
							}
							else if(tempcol=='B' && temptp=='b') { // Selecting if the fully booked is column B Middle type and removing it while populating
								seattypedatapool[0]="Col A Window Seat"; // Populating seat type data pool
								seattypedatapool[1]="Col A Middle Seat"; // Populating seat type data pool
								seattypedatapool[2]="Col A Side Seat"; // Populating seat type data pool
								seattypedatapool[3]="Col B Window Seat"; // Populating seat type data pool
								seattypedatapool[4]="Col B Side Seat"; // Populating seat type data pool
								seattypedatapool[5]="Col C Window Seat"; // Populating seat type data pool
								seattypedatapool[6]="Col C Middle Seat"; // Populating seat type data pool
								seattypedatapool[7]="Col C Side Seat"; // Populating seat type data pool
							}
							else if(tempcol=='B' && temptp=='c') { // Selecting if the fully booked is column C Side type and removing it while populating
								seattypedatapool[0]="Col A Window Seat"; // Populating seat type data pool
								seattypedatapool[1]="Col A Middle Seat"; // Populating seat type data pool
								seattypedatapool[2]="Col A Side Seat"; // Populating seat type data pool
								seattypedatapool[3]="Col B Window Seat"; // Populating seat type data pool
								seattypedatapool[4]="Col B Middle Seat"; // Populating seat type data pool
								seattypedatapool[5]="Col C Window Seat"; // Populating seat type data pool
								seattypedatapool[6]="Col C Middle Seat"; // Populating seat type data pool
								seattypedatapool[7]="Col C Side Seat"; // Populating seat type data pool
							}
							else if(tempcol=='C' && temptp=='a') { // Selecting if the fully booked is column C window type and removing it while populating
								seattypedatapool[0]="Col A Window Seat"; // Populating seat type data pool
								seattypedatapool[1]="Col A Middle Seat"; // Populating seat type data pool
								seattypedatapool[2]="Col A Side Seat"; // Populating seat type data pool
								seattypedatapool[3]="Col B Window Seat"; // Populating seat type data pool
								seattypedatapool[4]="Col B Middle Seat"; // Populating seat type data pool
								seattypedatapool[5]="Col B Side Seat"; // Populating seat type data pool
								seattypedatapool[6]="Col C Middle Seat"; // Populating seat type data pool
								seattypedatapool[7]="Col C Side Seat"; // Populating seat type data pool
							}
							else if(tempcol=='C' && temptp=='b') { // Selecting if the fully booked is column C Middle type and removing it while populating
								seattypedatapool[0]="Col A Window Seat"; // Populating seat type data pool
								seattypedatapool[1]="Col A Middle Seat"; // Populating seat type data pool
								seattypedatapool[2]="Col A Side Seat"; // Populating seat type data pool
								seattypedatapool[3]="Col B Window Seat"; // Populating seat type data pool
								seattypedatapool[4]="Col B Middle Seat"; // Populating seat type data pool
								seattypedatapool[5]="Col B Side Seat"; // Populating seat type data pool
								seattypedatapool[6]="Col C Window Seat"; // Populating seat type data pool
								seattypedatapool[7]="Col C Side Seat"; // Populating seat type data pool
							}
							else if(tempcol=='C' && temptp=='c') { // Selecting if the fully booked is column C Side type and removing it while populating
								seattypedatapool[0]="Col A Window Seat"; // Populating seat type data pool
								seattypedatapool[1]="Col A Middle Seat"; // Populating seat type data pool
								seattypedatapool[2]="Col A Side Seat"; // Populating seat type data pool
								seattypedatapool[3]="Col B Middle Seat"; // Populating seat type data pool
								seattypedatapool[4]="Col B Side Seat"; // Populating seat type data pool
								seattypedatapool[5]="Col C Window Seat"; // Populating seat type data pool
								seattypedatapool[6]="Col C Window Seat"; // Populating seat type data pool
								seattypedatapool[7]="Col C Middle Seat"; // Populating seat type data pool
							}
						}
						else { // Selecting for last column in last seat is not Z which means that no type of seat on any column is unavailable
							seattypedatapool=new String [9]; // Populating seat type data pool
							seattypedatapool[0]="Col A Window Seat"; // Populating seat type data pool
							seattypedatapool[1]="Col A Middle Seat"; // Populating seat type data pool
							seattypedatapool[2]="Col A Side Seat"; // Populating seat type data pool
							seattypedatapool[3]="Col B Window Seat"; // Populating seat type data pool
							seattypedatapool[4]="Col B Middle Seat"; // Populating seat type data pool
							seattypedatapool[5]="Col B Side Seat"; // Populating seat type data pool
							seattypedatapool[6]="Col C Window Seat"; // Populating seat type data pool
							seattypedatapool[7]="Col C Middle Seat"; // Populating seat type data pool
							seattypedatapool[8]="Col C Side Seat"; // Populating seat type data pool
						}
						comboseattp.setModel(new DefaultComboBoxModel(seattypedatapool));
						// passing the elements we want in the combo box using the string created seat type data pool
					}
					con.close(); // Closing c0nnection
				} catch (Exception ee) { // Error catching block of the try block
					System.out.println(ee); // Error printing
				}
			}});
		
//		----------------PRICE---------------------------------------------------------------------------------------------------------------------------
		
		JLabel labelprice = new JLabel("Price"); // Creating price label
		
		labelprice.setForeground(Color.BLACK); // Setting four ground colour
		labelprice.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		labelprice.setBounds(24, 480, 55, 21); // x , y and width and height 24
		jf.getContentPane().add(labelprice); // Adding it to the frame
		
		areaprice = new JTextArea(); // Creating text area that will display the price
		
		areaprice.setToolTipText("The price you're paying b/c of the options you have selected");
		areaprice.setFont(new Font("SansSerif", Font.PLAIN, 20));// font type and size
		areaprice.setWrapStyleWord(true);
		areaprice.setEditable(false);// it can't be edited by a user
		areaprice.setBounds(170, 478, 100, 34);// x , y and width and height
		jf.getContentPane().add(areaprice);// adding it to the frame
				
// ----------------ACTION LISTNER FOR WHEN USER SELECT SEAT TYPE------------------------------------------------------------------------------------
		
		comboseattp.addActionListener(new ActionListener() { // Adding action listener to when user select a date and time
					public void actionPerformed(ActionEvent e) {
						
						boolean validf=false, validl=false, validp=false, pass=true; // Creating variable that store validity of inputs
						String fname = fieldfirst.getText(); // Using get text to retrieve data from the text field first name
						String lname = fieldlast.getText(); // Using get text to retrieve data from the text field last name
						String phone = fieldphone.getText(); // Using get text to retrieve data from the text field phone number
						String destination = (String) comboto.getSelectedItem(); // Creating and Assigning variable with user destination selected
						String selecteddateandtime = (String) combodateandtime.getSelectedItem(); // Creating and Assigning variable with user date and time selected
						validf = validatename(fname); // Validating the user input for first name returns true if valid
						validl = validatename(lname); // Validating the user input for last name returns true if valid
						validp = validatephone(phone); // Validating the user input for phone returns true if valid
						
// ----------------CALCULATING PRICE------------------------------------------------------------------------------------------------------------------
						
						// Selecting for all fields being filled accordingly before calculating price
						if (!fieldfirst.getText().isEmpty() && !fieldlast.getText().isEmpty() && !fieldphone.getText().isEmpty() && !destination.equals("--City--" )
								&& !selecteddateandtime.equals("YYYY-MM-DD") && !selecteddateandtime.equals("0 AVAILABLE") && validf == true && validl==true && validp==true && pass==true) {
							
							double classfactor=0, seatfactor=0, calcprice=0, baseprice=0; // Creating variables that hold price related values
							// Appending to the price text area based on the class selected by the user
							if (comboclass.getSelectedIndex() == 0) { // Selecting for when user select Economy class
								try { // Try block to catch if there is a problem while creating an object
									Class.forName("com.mysql.cj.jdbc.Driver"); // Establishing connection
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
											"Lewy1miky"); // Establishing connection
									Statement stm = con.createStatement(); // Establishing connection
									String sql = "Select cfactor from classfactor where class='Economy Class'";
									// Creating Query that fetches class factor(stored as cfactor in class factor table) for Economy Class
									ResultSet rs = stm.executeQuery(sql); //Executing query and retrieving data
									rs.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
									classfactor=rs.getDouble(1); // Assigning value at row 1 column 1 of rs to classfactor. 
									String sql1 = "Select baseprice from classfactor where class='Economy Class'";
									// Creating Query that fetches baseprice (stored as baseprice in class factor table) for Economy Class
									ResultSet rs1 = stm.executeQuery(sql1); //Executing query and retrieving data
									rs1.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
									baseprice=rs1.getDouble(1); // Assigning value at row 1 column 1 of rs to baseprice 
									con.close(); // Closing connection
								} catch (Exception ee) { // Error catching block of the try block
									System.out.println(ee); // Error printing
								}
							}
							else if (comboclass.getSelectedIndex() == 1) { // Selecting for when user select Business class
								try { // Try block to catch if there is a problem while creating an object
									Class.forName("com.mysql.cj.jdbc.Driver"); // Establishing connection
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
											"Lewy1miky"); // Establishing connection
									Statement stm = con.createStatement(); // Establishing connection
									String sql = "Select cfactor from classfactor where class='Buissness Class'";
									// Creating Query that fetches class factor(stored as cfactor in class factor table) for Business Class
									ResultSet rs = stm.executeQuery(sql); //Executing query and retrieving data
									rs.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
									classfactor=rs.getDouble(1); // Assigning value at row 1 column 1 of rs to classfactor. 
									String sql1 = "Select baseprice from classfactor where class='Buissness Class'";
									// Creating Query that fetches baseprice (stored as baseprice in class factor table) for Business Class
									ResultSet rs1 = stm.executeQuery(sql1); //Executing query and retrieving data
									rs1.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
									baseprice=rs1.getDouble(1); // Assigning value at row 1 column 1 of rs to basefactor. 
									con.close(); // Closing connection
								} catch (Exception ee) { // Error catching block of the try block
									System.out.println(ee); // Error printing
								}
							}
							else if (comboclass.getSelectedIndex() == 2) { // Selecting for when user select First class
								try { // Try block to catch if there is a problem while creating an object
									Class.forName("com.mysql.cj.jdbc.Driver"); // Establishing connection
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
											"Lewy1miky"); // Establishing connection
									Statement stm = con.createStatement(); // Establishing connection
									String sql = "Select cfactor from classfactor where class='First Class'";
									// Creating Query that fetches class factor(stored as cfactor in class factor table) for First Class
									ResultSet rs = stm.executeQuery(sql); //Executing query and retrieving data
									rs.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
									classfactor=rs.getDouble(1); // Assigning value at row 1 column 1 of rs to classfactor. 
									String sql1 = "Select baseprice from classfactor where class='First Class'";
									// Creating Query that fetches baseprice (stored as baseprice in class factor table) for First Class
									ResultSet rs1 = stm.executeQuery(sql1); //Executing query and retrieving data
									rs1.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
									baseprice=rs1.getDouble(1); // Assigning value at row 1 column 1 of rs to basefactor. 
									con.close(); // Closing connection
								} catch (Exception ee) { // Error catching block of the try block
									System.out.println(ee); // Error printing
								}
							}
							seattype=new String(); // Creating variable to store seat type
							
							if(comboseattp.getSelectedIndex() == 0) { 
								seattype="A-Window"; // Assigning seat type Accordingly
							}
							else if(comboseattp.getSelectedIndex() == 1) {
								seattype="A-Middle"; // Assigning seat type Accordingly
							}
							else if(comboseattp.getSelectedIndex() == 2) {
								seattype="A-Side"; // Assigning seat type Accordingly
							}
							else if(comboseattp.getSelectedIndex() == 3) {
								seattype="B-Window"; // Assigning seat type Accordingly
							}
							else if(comboseattp.getSelectedIndex() == 4) {
								seattype="B-Middle"; // Assigning seat type Accordingly
							}
							else if(comboseattp.getSelectedIndex() == 5) {
								seattype="B-Side"; // Assigning seat type Accordingly
							}
							else if(comboseattp.getSelectedIndex() == 6) {
								seattype="C-Window"; // Assigning seat type Accordingly
							}
							else if(comboseattp.getSelectedIndex() == 7) {
								seattype="C-Middle"; // Assigning seat type Accordingly
							}
							else if(comboseattp.getSelectedIndex() == 8) {
								seattype="C-Side"; // Assigning seat type Accordingly
							}
			
							if (comboseattp.getSelectedIndex() == 1 || comboseattp.getSelectedIndex() == 4 || comboseattp.getSelectedIndex() == 7 ) 
							{ // Selecting for when user select Middle seat type
								try { // Try block to catch if there is a problem while creating an object
									Class.forName("com.mysql.cj.jdbc.Driver"); // Establishing connection
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
											"Lewy1miky"); // Establishing connection
									Statement stm = con.createStatement(); // Establishing connection
									String sql = "Select sfactor from seatfactor where seat='Middle Seat'";
									// Creating Query that fetches seatfactor (stored as sfactor in seat factor table) for Middle seat
									ResultSet rs = stm.executeQuery(sql); //Executing query and retrieving data
									rs.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
									seatfactor=rs.getDouble(1); // Assigning value at row 1 column 1 of rs to seatfactor. 
									con.close(); // Closing connection
								} catch (Exception ee) { // Error catching block of the try block
									System.out.println(ee); // Error printing
								}
							}
							// Selecting for when user select Side seat type
							else if (comboseattp.getSelectedIndex() == 2 || comboseattp.getSelectedIndex() == 5 || comboseattp.getSelectedIndex() == 8) {
								try { // Try block to catch if there is a problem while creating an object
									Class.forName("com.mysql.cj.jdbc.Driver"); // Establishing connection
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
											"Lewy1miky"); // Establishing connection
									Statement stm = con.createStatement(); // Establishing connection
									String sql = "Select sfactor from seatfactor where seat='Side Seat'";
									// Creating Query that fetches seatfactor (stored as sfactor in seat factor table) for Side seat
									ResultSet rs = stm.executeQuery(sql); //Executing query and retrieving data
									rs.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
									seatfactor=rs.getDouble(1); // Assigning value at row 1 column 1 of rs to seatfactor. 
									con.close(); // Closing connection
								} catch (Exception ee) { // Error catching block of the try block
									System.out.println(ee); // Error printing
								}
							}
							// Selecting for when user select window seat type
							else if (comboseattp.getSelectedIndex() == 0 || comboseattp.getSelectedIndex() == 3 || comboseattp.getSelectedIndex() == 6) {
								try { // Try block to catch if there is a problem while creating an object
									Class.forName("com.mysql.cj.jdbc.Driver"); // Establishing connection
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
											"Lewy1miky"); // Establishing connection
									Statement stm = con.createStatement(); // Establishing connection
									String sql = "Select sfactor from seatfactor where seat='Window Seat'";
									// Creating Query that fetches seatfactor (stored as sfactor in seat factor table) for Window seat
									ResultSet rs = stm.executeQuery(sql); //Executing query and retrieving data
									rs.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
									seatfactor=rs.getDouble(1); // Assigning value at row 1 column 1 of rs to seatfactor. 
									con.close(); // Closing connection
								} catch (Exception ee) { // Error catching block of the try block
									System.out.println(ee); // Error printing
								}
							}
							calcprice=baseprice*classfactor*seatfactor; // Calculating price as product of base price, seat factor and class factor
							areaprice.setText(""); // We are using set to clear the price text area before using it
							areaprice.append(String.valueOf(calcprice+"$")); // Assigning price text area with calculated price
						}	
					}});

//		----------------BOOK TICKET BUTTON-------------------------------------------------------------------------------------------------------------

		JButton buttonbook = new JButton("Book ticket"); // Creating book ticket button
		
		buttonbook.setForeground(Color.DARK_GRAY); // Setting fore ground colour
		buttonbook.setBackground(new Color(0, 255, 255)); // Setting Back ground colour
		buttonbook.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		buttonbook.setBounds(24, 530, 170, 23); // x , y and width and height
		jf.getContentPane().add(buttonbook); // Adding to JFrame
		
//		----------------VIEW DATABASE BUTTON-------------------------------------------------------------------------------------------------------------------
		
		buttonview = new JButton("View Database"); // Creating View Database button
		
		buttonview.setForeground(Color.DARK_GRAY); // Setting fore ground colour
		buttonview.setBackground(new Color(0, 255, 255)); // Setting Back ground colour
		buttonview.setFont(new Font("SansSerif", Font.PLAIN, 20)); // font type and size
		buttonview.setBounds(214, 560, 200, 23);// x , y and width and height
		buttonview.setVisible(false); // Making button visibility false cause we want it to be visible after one book
		jf.getContentPane().add(buttonview); // Adding to JFrame
		
//		----------------HIDE DATABASE BUTTON-------------------------------------------------------------------------------------------------------------------
		
		buttonhide = new JButton("Hide Database"); // Creating View Database button
		
		buttonhide.setForeground(Color.DARK_GRAY); // Setting fore ground colour
		buttonhide.setBackground(new Color(0, 255, 255)); // Setting Back ground colour
		buttonhide.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		buttonhide.setBounds(214, 560, 200, 23); // x , y and width and height
		buttonhide.setVisible(false); // Making button visibility false cause we want it to be visible after view button
		jf.getContentPane().add(buttonhide); // Adding to JFrame
					
//		----------------ACTION LISTNER FOR BOOK TICKET PAGE--------------------------------------------------------------------------------------------

		buttonbook.addActionListener(new ActionListener() { // Adding action listener to our book button
			public void actionPerformed(ActionEvent e) {
				
//		---------------------------VALIDATION OF INPUT DATA---------------0000000000000000000----------------------------------------------------------
				
				boolean validf=false, validl=false, validp=false, pass=true; // Creating variable that store validity of inputs
				String fname = fieldfirst.getText(); // Using get text to retrieve data from the text field first name
				String lname = fieldlast.getText(); // Using get text to retrieve data from the text field last name
				String phone = fieldphone.getText(); // Using get text to retrieve data from the text field phone number
				String destination = (String) comboto.getSelectedItem(); // Creating and Assigning variable with user destination selected
				String selecteddateandtime = (String) combodateandtime.getSelectedItem(); // Creating and Assigning variable with user date and time selected
				// casting it to string to store it on a string variable b/c it returns the selected object
				String age = (String) comboage.getSelectedItem(); // Creating and Assigning variable with user age selected
				String departure = (String) combofrom.getSelectedItem(); // Creating and Assigning variable with user departure selected
				String selectedclass = (String) comboclass.getSelectedItem(); // Creating and Assigning variable with user class selected
				String gender=(String) malefemalegroup.getSelection().getActionCommand(); // Creating and Assigning variable with user gender selected
				seattype=(String) comboseattp.getSelectedItem();
				if (fieldfirst.getText().isEmpty() || fieldlast.getText().isEmpty() || fieldphone.getText().isEmpty() || destination.equals("--City--" )|| 
						selecteddateandtime.equals("YYYY-MM-DD") || selecteddateandtime.equals("0 AVAILABLE")) 
				{ // Checking if any of the fields are empty
					JOptionPane.showMessageDialog(new JFrame(),"WARNING \n "
															 + "Please make sure every field is filled accordingly!"); 
					//POP UP message for any empty filled
					pass=false; // Not making data eligible to be booked
				}
				else { // Checking if all of the fields are filled
					validf = validatename(fname); // Validating the user input for first name returns true if valid
					validl = validatename(lname); // Validating the user input for last name returns true if valid
					validp = validatephone(phone); // Validating the user input for phone returns true if valid
					if(!validf) { // Selecting if first name is invalid
							JOptionPane.showMessageDialog(new JFrame(),"Incorrect First Name. Please Re-enter!!"); //POP UP message
					}
					else if(!validl) { // Selecting if last name is invalid
							JOptionPane.showMessageDialog(new JFrame(),"Incorrect Last Name. Please Re-enter!!"); //POP UP message
					}
					else if(!validp) { // Selecting if phone is invalid
							JOptionPane.showMessageDialog(new JFrame(),"Incorrect Phone Number. Please Re-enter!!"); //POP UP message
					}
				}	
				try { // Try block to catch if there is a problem while creating an object
					Class.forName("com.mysql.cj.jdbc.Driver"); //Establishing connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
							"Lewy1miky"); //Establishing connection
					Statement stm = con.createStatement(); //Establishing connection
					String sql7 = "SELECT COUNT(*) FROM passengers where fname='"+fname+"' and lname='"+lname+"' and tel='"+phone+"' and flightnum='"+flightnum+"'";
					// Creating Query that returns how many record is there with the matching first name , last name, phone and flightnum
					ResultSet rs7 = stm.executeQuery(sql7); // Executing query and retrieving data
					rs7.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
					int rowcount2=rs7.getInt(1); // Assigning value at row 1 column 1 of rs to rowcount2
					if (rowcount2==1) { // Checking if passenger exist and already booked
						JOptionPane.showMessageDialog(new JFrame(),"Passenger already booked"); // POP UP message
						pass=false; // Not making data eligible to be booked
					}
				}
				catch (Exception ee) { // Error catching block of the try block
					System.out.println(ee); // Error printing
				}	
				if(buttonhide.isVisible()) { // Selecting for when user try to book ticket while viewing database
					JOptionPane.showMessageDialog(new JFrame(),"HIDE DATABASE BEFORE YOU BOOK"); //POP UP message
				}			
				else if (validf == true && validl==true && validp==true && pass==true){ 
					
// ----------------ASSIGNING SEAT------------------------------------------------------------------------
					
					// Correctly formatting seat type for storage in database and assigning seat
					try { // Try block to catch if there is a problem while creating an object
					Class.forName("com.mysql.cj.jdbc.Driver"); // Establishing connection
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
							"Lewy1miky"); // Establishing connection
					Statement stm = con.createStatement(); // Establishing connection
					char [] seattptemp = seattype.toCharArray(); // Assigning seattptemp with character array version of seattype to iterate on it
					char[] temp= new char[5]; // Creating a variable with size 3 since seat type is like "A-Window" and we only need "A-W" part
					temp[0]= seattptemp[4]; // Same as old
					temp[1]= '-'; // Same as old
					temp[3]= '-';
					if(seattptemp[6]=='W') // Selecting for second index start with W 
						temp[2]= 'a';
					else if(seattptemp[6]=='M') // Selecting for second index start with M 
						temp[2]= 'b';
					else if(seattptemp[6]=='S') // Selecting for second index start with S
						temp[2]= 'c';
					
					String sql4 = "select seat from passengers where flightnum='"+flightnum+"' and seat LIKE '"
						+String.valueOf(temp)+"%' ORDER BY id DESC LIMIT 1";
					// Creating Query that fetches the last seat on that flight which is the same type as user selected
					ResultSet rs4 = stm.executeQuery(sql4); //Executing query and retrieving data
					char [] temp2= new char[5]; // Creating a variable that is going to be the corrected formatted seat
					if(!rs4.next()) { // Selecting for if user is the first to book seat on that flight which is type as user selected
						temp2[0]=temp[0]; // Assigning 
						temp2[1]=temp[1]; // Assigning
						temp2[2]=temp[2]; // Assigning
						temp2[3]=temp[3]; // Assigning
						temp2[4]='A'; // Assigning
					}
					else { // Selecting for if user is not the first to book seat on that flight which is type as user selected
						String lastseat=rs4.getString(1); // Assigning value at row 1 column 1 of rs to lastseat. 
						temp2=lastseat.toCharArray(); // Assigning temp2 with character array version of lastseat to iterate on it
						temp2[4]=++temp2[4]; // Giving the next seat on that column and seat type
					}
					
					seat= String.valueOf(temp2); // Converting temp2 to String type and assigning it to seat
					
// ----------------SAVING ON DATABASE------------------------------------------------------------------------
					
					String sql = "INSERT INTO passengers (fname,lname,gender,age,tel,class,seat, seattp, flightnum) "
							+ " VALUES ('" + fname + "','" + lname + "','" + gender + "', '"
							+ age + "','" + phone + "', '" + selectedclass + "', '"+seat+"', '" 
							+ seattype + "', '" + flightnum + "');"; 
					// Creating a Query that Adds passenger with complete information to database
					stm.executeUpdate(sql); // Executing Query
					String sql1 = "update flights set availseat="+--availseat+" where des='"+destination+"' and datandtime='"+selecteddateandtime+"' ";
					// Creating a Query that decrease the available seat on the flight passenger booked
					areaseat.setText(String.valueOf(availseat)); // Setting text area of available to the acquired value
					stm.executeUpdate(sql1); // Executing Query
					con.close(); // Closing connection
					}
				catch (Exception ee) { // Error catching block of the try block
					System.out.println(ee); // Error printing
				}

// ----------------FETCHING AND DISPLAYING STORED DATA FROM DATABASE------------------------------------------------------------------------------------					
										
					Object[][]data; // Creating Variable that will store the retrieved table from database
					String[] columns = {"ID", "First Name", "Last Name", "Gender", "Age",
										"Phone Number", "Class", "Seat", "Seat Type","F-N0"}; 
					// Creating and Assigning variable to names of column
					try { // Try block to catch if there is a problem while creating an object
						Class.forName("com.mysql.cj.jdbc.Driver"); // Establishing connection
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
								"Lewy1miky"); // Establishing connection
						Statement stm = con.createStatement(); // Establishing connection
						String sql = "SELECT * FROM rowcounting";
						// Creating Query that fetches how many records are there on passengers table
						ResultSet rs = stm.executeQuery(sql); //Executing query and retrieving data
						rs.next(); 
						int rowcount=rs.getInt(1); // Assigning value at row 1 column 1 of rs to rowcount 
						String sql1 = "select * from displayall";
						// Creating a query that fetches result of view which fetches all records are in passengers table
						ResultSet rs1 = stm.executeQuery(sql1); //Executing query and retrieving data
						rs1.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
						data = new Object[rowcount][11]; // Creating a variable with rowcount as row size and 11 column
						
						for(int i=1; i<=rowcount; i++) { // Iterating to populate variable with data retrieved from database table
							int j=1; // Assigning
							data[i-1][j-1] = rs1.getInt(j++); // Populating
							data[i-1][j-1] = rs1.getString(j++); // Populating
							data[i-1][j-1] = rs1.getString(j++); // Populating
							data[i-1][j-1] = rs1.getString(j++); // Populating
							data[i-1][j-1] = rs1.getString(j++); // Populating
							data[i-1][j-1] = rs1.getString(j++); // Populating
							data[i-1][j-1] = rs1.getString(j++); // Populating
							data[i-1][j-1] = rs1.getString(j++); // Populating
							data[i-1][j-1] = rs1.getString(j++); // Populating
							data[i-1][j-1] = rs1.getString(j++); // Populating
							rs1.next(); // Making data reading move to next row
						}
						
						passtable = new JTable(data, columns); // Creating a JTable 
						for (int i=0; i<10; i++) { // Setting size of phone seat type and class
							if(i==0 || i==7 || i==9) { // Setting size of ID, seat and Flight number
								TableColumn column = passtable.getColumnModel().getColumn(i); //Getting column
					            column.setMinWidth(45); // Setting size
					            column.setMaxWidth(45); // Setting size
					            column.setPreferredWidth(100); // Setting size
							}
							else if(i==8) { // Setting size of seat type 
								TableColumn column = passtable.getColumnModel().getColumn(i); //Getting column
					            column.setMinWidth(120); // Setting size
					            column.setMaxWidth(120); // Setting size
					            column.setPreferredWidth(120); // Setting size
							}
							else if(i==5 || i==6) { // Setting size of phone and class
								TableColumn column = passtable.getColumnModel().getColumn(i); //Getting column
					            column.setMinWidth(100); // Setting size
					            column.setMaxWidth(100); // Setting size
					            column.setPreferredWidth(100); // Setting size
							}
						}
						
						passtable.setVisible(false); // Setting visibility to false
						passtable.setBounds(680, 64, 800, 300); // x , y and width and height
						//passtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Setting auto resize false
						
						header = passtable.getTableHeader(); // Creating a table header by getting header value of the table created
						header.setBackground(Color.yellow); // Setting Background colour
						header.setVisible(false);  // Setting visibility to false
						
						tablepanel=new JPanel(); // Creating a panel
						
						tablepanel.setBounds(680, 64, 800, 500); // x , y and width and height
						tablepanel.add(header); // Adding header to panel
						tablepanel.add(passtable); // Adding table to panel
						tablepanel.setVisible(false); // Setting visibility of panel to false
						buttonview.setText("View Database"); // Changing buttonview text
						buttonhide.setText("Hide Database"); // Changing buttonhide text
						buttonview.setVisible(!buttonhide.isVisible()); // Changing visibility of buttonview with respect to buttonhide
						buttonhide.setVisible(buttonhide.isVisible()); // Changing visibility of buttonhide with respect to buttonview
						jf.getContentPane().add(tablepanel); // Adding panel to JFrame
						con.close(); // Closing connection
					} catch (Exception ee) { // Error catching block of the try block
						System.out.println(ee); // Error printing
					}
					
// ---------------------DISPLAYING TICKET AS PANEL------------------------------------------------------------------------------------------------------	
					
					Object[] options1 = { "PRINT", "NO"}; // Creating and Assigning a variable to Options on the pop up ticket
					JPanel panel1 = new JPanel(); // Creating a panel
					JLabel ticketp= new JLabel(); // Creating a ticket panel
	
					ticketp.setText("<html> ################################# You're ticket  #######################################################"
									+ "<br/>"
									+ "<br/>Air Wakanda"
									+ "<br/>The new spirit of Africa"
									+ "<br/>"
									+ "<br/>"
									+ "<br/> First name: " + fname 
									+ "<br/> Last name: " + lname
									+ "<br/> Gender: " + gender
									+ "<br/> Seat: " + seat
									+ "<br/> Class: " + selectedclass
									+ "<br/>"
									+ "<br/> Flight number: " + flightnum
									+ "<br/> Departure: " + departure
									+ "<br/> Destination: " + destination
									+ "<br/>"
									+ "<br/> Boarding Date and Time: " + selecteddateandtime
									+ "<br/>"
									+ "<br/>#######################################################################################################</html>");
					// Setting ticket on ticket panel
					panel1.add(ticketp); // Adding ticket panel to panel
					JOptionPane.showOptionDialog(null, panel1, "TICKET",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);	// Making the ticket a pop up message			
				}
			}

		});
		
//	----------------ACTION LISTNER FOR VIEW DATABASE BUTTON---------------------------------------------------------------------------------------------
		
		buttonview.addActionListener(new ActionListener() { // Adding action listener to our view database button
			public void actionPerformed(ActionEvent e) {					
				buttonhide.setVisible(true); // Changing Visibility of hide button
				buttonview.setVisible(false); // Changing Visibility of view button
				lsql.setVisible(true); // Changing Visibility of data on database label
				header.setVisible(true); // Changing Visibility of table header
				passtable.setVisible(true); // Changing Visibility of table
				tablepanel.setVisible(true); // Changing Visibility of table panel
			}});
//	----------------ACTION LISTNER FOR HIDE DATABASE BUTTON---------------------------------------------------------------------------------------------
		
		buttonhide.addActionListener(new ActionListener() { // Adding action listener to our hide database button
				public void actionPerformed(ActionEvent e) { 
					buttonhide.setVisible(false); // Changing Visibility of hide button
					buttonview.setVisible(true); // Changing Visibility of view button
					lsql.setVisible(false); // Changing Visibility of data on database label
					header.setVisible(false); // Changing Visibility of table header
					passtable.setVisible(false); // Changing Visibility of table
					tablepanel.setVisible(false); // Changing Visibility of table panel
				}});
		
//		----------------DETAILS BUTTON-------------------------------------------------------------------------------------------------------------------
		
		JButton buttondetail = new JButton("Details"); // Creating Details button
		
		buttondetail.setForeground(Color.DARK_GRAY); // Setting the fore ground colour
		buttondetail.setBackground(new Color(0, 255, 255)); // Setting back ground colour
		buttondetail.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		buttondetail.setBounds(214, 530, 200, 23); // x , y and width and height
		buttondetail.setVisible(true); // Setting visibility
		jf.getContentPane().add(buttondetail); // Adding to JFRame
		
//		----------------ACTION LISTNER FOR DETAILS BUTTON---------------------------------------------------------------------------------------------
		
		buttondetail.addActionListener(new ActionListener() { // Adding action listener to our details button
			public void actionPerformed(ActionEvent e) {
				
				Object[][]data;  // Creating Variable that will store the retrieved table from database
				String[] columns = {"ID", "First Name", "Last Name", 
									"Flight No","Pilot","Co-pilot","Host-1","Host-2", "Air Craft"}; // Creating and Assigning variable to names of column
				boolean validf=false, validl=false, validp=false, pass=true; // Creating variable that store validity of inputs
				String fname = fieldfirst.getText(); // Using get text to retrieve data from the text field first name
				String lname = fieldlast.getText(); // Using get text to retrieve data from the text field last name
				String phone = fieldphone.getText(); // Using get text to retrieve data from the text field phone number
				String destination = (String) comboto.getSelectedItem(); // Creating and Assigning variable with user destination selected
				String selecteddateandtime = (String) combodateandtime.getSelectedItem(); // Creating and Assigning variable with user date and time selected
				// casting it to string to store it on a string variable b/c it returns the selected object
			
				if (fieldfirst.getText().isEmpty() || fieldlast.getText().isEmpty() || fieldphone.getText().isEmpty() || destination.equals("--City--" )|| 
						selecteddateandtime.equals("YYYY-MM-DD") || selecteddateandtime.equals("0 AVAILABLE")) 
				{ // Checking if any of the fields are empty
					JOptionPane.showMessageDialog(new JFrame(),"WARNING \n "
															 + "Please make sure every field is filled accordingly!"); 
					//POP UP message for any empty filled
					pass=false; // Not making all fields are filled false
				}
				else { // Checking if all of the fields are filled
					validf = validatename(fname); // Validating the user input for first name returns true if valid
					validl = validatename(lname); // Validating the user input for last name returns true if valid
					validp = validatephone(phone); // Validating the user input for phone returns true if valid
					if(!validf) { // Selecting if first name is invalid
							JOptionPane.showMessageDialog(new JFrame(),"Incorrect First Name. Please Re-enter!!"); //POP UP message
					}
					else if(!validl) { // Selecting if last name is invalid
							JOptionPane.showMessageDialog(new JFrame(),"Incorrect Last Name. Please Re-enter!!"); //POP UP message
					}
					else if(!validp) { // Selecting if phone is invalid
							JOptionPane.showMessageDialog(new JFrame(),"Incorrect Phone Number. Please Re-enter!!"); //POP UP message
					}
				}
				// Checking if every field if filled and valid
				if (validf == true && validl==true && validp==true && pass==true){
					try { // Try block to catch if there is a problem while creating an object
						Class.forName("com.mysql.cj.jdbc.Driver"); // Creating Connection
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
								"Lewy1miky"); // Creating Connection
						Statement stm = con.createStatement(); // Creating Connection
						String sql6 = "SELECT COUNT(*) FROM passengers where fname='"+fname+"' and lname='"+lname+"' and tel='"+phone+"'";
						// Creating a Query that returns how many records existing in passenger table that math the details
						ResultSet rs6 = stm.executeQuery(sql6); //Executing query and retrieving data 
						rs6.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
						int rowcount=rs6.getInt(1); // Assigning value at row 1 column 1 of rs to rowcount 
						if (rowcount<1) { // Checking if passenger don't exist
							JOptionPane.showMessageDialog(new JFrame(),"Please Book passenger before trying to see detail"); // POP UP message
						}
						else if(!buttonview.isVisible() && buttonhide.isVisible()) { // Checking if user is already viewing
							JOptionPane.showMessageDialog(new JFrame(),"Already Viewing"); // POP UP message
						}
						else { // Checking if user isn't already viewing and passenger exist
							passtable.setVisible(false); // Setting visibility
							buttonview.setText("View Result"); // Changing buttonview text
							buttonhide.setText("Hide Result"); // Changing buttonhide text
							String sql8 = "SELECT planeref FROM flights where id='"+flightnum+"'";
							// Creating a Query that returns plane reference of that flight
							ResultSet rs8 = stm.executeQuery(sql8); //Executing query and retrieving data 
							rs8.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
							String planeref=rs8.getString(1); // Retrieving data
							String sql9 = "SELECT aircraft FROM planes where id='"+planeref+"'";
							// Creating a Query that returns aircraft name of that planeref
							ResultSet rs9 = stm.executeQuery(sql9); //Executing query and retrieving data 
							rs9.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
							data = new Object[2][10]; // Object creation to store table data to be displayed on JTable
							data[0][8] = rs9.getString(1); // Populating
							String sql7 = "SELECT passengers.id, passengers.fname, passengers.lname, passengers.flightnum, flights.pilot, flights.copilot1, flights.host1, flights.host2 FROM passengers INNER JOIN flights ON passengers.flightnum=flights.id where fname='"+fname+"' and lname='"+lname+"' and tel='"+phone+"';";
							// Creating Query that matches the user input with existing data and brings up a detailed information about flight 
							ResultSet rs7 =stm.executeQuery(sql7);  //Executing query and retrieving data  
							rs7.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
							data[0][0] = rs7.getInt(1); // Populating
							data[0][1] = rs7.getString(2); // Populating
							data[0][2] = rs7.getString(3); // Populating
							data[0][3] = rs7.getString(4); // Populating
							data[0][4] = rs7.getString(5); // Populating
							data[0][5] = rs7.getString(6); // Populating
							data[0][6] = rs7.getString(7); // Populating
							data[0][7] = rs7.getString(8); // Populating
							
							lsql.setVisible(false); // Setting Visibility
							header.setVisible(false); // Setting Visibility
							passtable.setVisible(false); // Setting Visibility
							tablepanel.setVisible(false); // Setting Visibility
							
							passtable = new JTable(data, columns){public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
						           Component component = super.prepareRenderer(renderer, row, column);
						           int rendererWidth = component.getPreferredSize().width;
						           TableColumn tableColumn = getColumnModel().getColumn(column);
						           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
						           return component;
						        }}; // Creating a JTable that can auto resize its column to fit content. It will store retrieved data from database
							
						     passtable.setVisible(false); // Setting visibility to false
						     passtable.setBounds(680, 64, 700, 300); // x , y and width and height
						     passtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Setting auto resize false
								
							 header = passtable.getTableHeader(); // Creating a table header by getting header value of the table created
							 header.setBackground(Color.yellow); // Setting Background colour
							 header.setVisible(false);  // Setting visibility to false
								
							tablepanel=new JPanel(); // Creating a panel
								
							tablepanel.setBounds(680, 64, 800, 500); // x , y and width and height
							tablepanel.add(header); // Adding header to panel
							tablepanel.add(passtable); // Adding table to panel
							tablepanel.setVisible(false); // Setting visibility of panel to false
							buttonview.setText("View Result"); // Changing buttonview text
							buttonhide.setText("Hide Result"); // Changing buttonhide text
							buttonview.setVisible(true); // Setting visibility
							buttonhide.setVisible(false); // Setting visibility
							jf.getContentPane().add(tablepanel); // Adding table panel to JFrame
						}
						con.close(); //Closing Connection
					} catch (Exception ee) { // Error catching block of the try block
						System.out.println(ee); // Error printing
					}
				
			}}});
		
//		----------------DELETE BUTTON-------------------------------------------------------------------------------------------------------------------

		JButton buttondelete = new JButton("DELETE"); // Creating Delete button
		
		buttondelete.setForeground(Color.DARK_GRAY); // Setting the fore ground colour
		buttondelete.setBackground(new Color(0, 255, 255)); // Setting back ground colour
		buttondelete.setFont(new Font("SansSerif", Font.PLAIN, 20)); // Setting font type and size
		buttondelete.setBounds(24, 560, 170, 23); // x , y and width and height
		buttondelete.setVisible(true); // Setting visibility
		jf.getContentPane().add(buttondelete); // Adding to JFRame
		
//		----------------ACTION LISTNER FOR DELETE BUTTON---------------------------------------------------------------------------------------------
		
		buttondelete.addActionListener(new ActionListener() { // adding action listener to our delete button
			public void actionPerformed(ActionEvent e) {
				Object[][]data; // Creating Variable that will store the retrieved table from database
				String[] columns = {"ID", "First Name", "Last Name", "Gender", "Age",
									"Phone Number", "Class", "Seat", "Seat Type","F-N0"};
				// Creating and Assigning variable to names of column
				boolean validf=false, validl=false, validp=false, pass=true; // Creating variable that store validity of inputs
				String fname = fieldfirst.getText(); // Using get text to retrieve data from the text field first name
				String lname = fieldlast.getText(); // Using get text to retrieve data from the text field last name
				String phone = fieldphone.getText(); // Using get text to retrieve data from the text field phone number
				String destination = (String) comboto.getSelectedItem(); // Creating and Assigning variable with user destination selected
				String selecteddateandtime = (String) combodateandtime.getSelectedItem(); // Creating and Assigning variable with user date and time selected
				// casting it to string to store it on a string variable b/c it returns the selected object
				
				if (fieldfirst.getText().isEmpty() || fieldlast.getText().isEmpty() || fieldphone.getText().isEmpty() || destination.equals("--City--" )|| 
						selecteddateandtime.equals("YYYY-MM-DD") || selecteddateandtime.equals("0 AVAILABLE")) 
				{ // Checking if any of the fields are empty
					JOptionPane.showMessageDialog(new JFrame(),"WARNING \n "
															 + "Please make sure every field is filled accordingly!"); 
					//POP UP message for any empty filled
					pass=false; // Not making all fields are filled false
				}
				else { // Checking if all of the fields are filled
					validf = validatename(fname); // Validating the user input for first name returns true if valid
					validl = validatename(lname); // Validating the user input for last name returns true if valid
					validp = validatephone(phone); // Validating the user input for phone returns true if valid
					if(!validf) { // Selecting if first name is invalid
							JOptionPane.showMessageDialog(new JFrame(),"Incorrect First Name. Please Re-enter!!"); //POP UP message
					}
					else if(!validl) { // Selecting if last name is invalid
							JOptionPane.showMessageDialog(new JFrame(),"Incorrect Last Name. Please Re-enter!!"); //POP UP message
					}
					else if(!validp) { // Selecting if phone is invalid
							JOptionPane.showMessageDialog(new JFrame(),"Incorrect Phone Number. Please Re-enter!!"); //POP UP message
					}
				}
				// Selection for all fields are filled and valid
				if (validf == true && validl==true && validp==true && pass==true){
					try {  // Try block to catch if there is a problem while creating an object
						Class.forName("com.mysql.cj.jdbc.Driver"); //Establishing connection
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root",
								"Lewy1miky"); //Establishing connection
						Statement stm = con.createStatement(); //Establishing connection
						String sql7 = "SELECT COUNT(*) FROM passengers where fname='"+fname+"' and lname='"+lname+"' and tel='"+phone+"'";
						// Creating Query that returns how many record is there with the matching first name , last name and phone
						ResultSet rs7 = stm.executeQuery(sql7); // Executing query and retrieving data
						rs7.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
						int rowcount2=rs7.getInt(1); // Assigning value at row 1 column 1 of rs to rowcount2
						
						if (rowcount2<1) { // Checking if passenger exist
							JOptionPane.showMessageDialog(new JFrame(),"Please Book passenger before trying to delete"); // POP UP message
						}
						else if(!buttonview.isVisible() && buttonhide.isVisible()) { // Checking if user is already viewing database
							JOptionPane.showMessageDialog(new JFrame(),"HIDE DATABASE BEFORE YOU DELETE");  // POP UP Message
						}
						else { // Selection if passenger exist and user is not already viewing database
							passtable.setVisible(false); // Setting Visibility
							buttonview.setText("View Database"); // Changing buttonview text
							buttonhide.setText("Hide Database"); // Changing buttonhide text
							String sql5 = "update flights set availseat="+(++availseat)+" where des='"+destination+"' and datandtime='"+selecteddateandtime+"' ";
							// Creating a Query that increase the available seat on the flight passenger booked
							stm.executeUpdate(sql5); // Executing query
							String sql4 = "DELETE from passengers where fname='"+fname+"' and lname='"+lname+"' and tel='"+phone+"'";
							// Creating a Query that removes a record that matches the fname, lname and phone
							stm.executeUpdate(sql4); // Executing query
							String sql6 = "SELECT * from rowcounting";
							// Creating a Query that returns how many records are in passengers table
							ResultSet rs6 = stm.executeQuery(sql6); // Executing query and retrieving data
							rs6.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
							int rowcount=rs6.getInt(1); // Assigning value at row 1 column 1 of rs to rowcount 
							String sql1 = "SELECT * from displayall";
							// Creating a Query that fetches all records from passengers table
							ResultSet rs1 = stm.executeQuery(sql1); // Executing query and retrieving data
							rs1.next(); // Making data reading start from first row since at first the data reading starts from row 0 which contains column label
							data = new Object[rowcount][11]; // Object creation to store table data to be displayed on JTable
							for(int i=1; i<=rowcount; i++) { // Populating variable created
								int j=1; // Assigning
								data[i-1][j-1] = rs1.getInt(j++); // Populating
								data[i-1][j-1] = rs1.getString(j++); // Populating
								data[i-1][j-1] = rs1.getString(j++); // Populating
								data[i-1][j-1] = rs1.getString(j++); // Populating
								data[i-1][j-1] = rs1.getString(j++); // Populating
								data[i-1][j-1] = rs1.getString(j++); // Populating
								data[i-1][j-1] = rs1.getString(j++); // Populating
								data[i-1][j-1] = rs1.getString(j++); // Populating
								data[i-1][j-1] = rs1.getString(j++); // Populating
								data[i-1][j-1] = rs1.getString(j++); // Populating
								rs1.next(); // Making data reading go to next row
							}
							
							areaseat.setText(String.valueOf(availseat)); // Setting text area of available to the acquired value
							JOptionPane.showMessageDialog(new JFrame(),"DELETED SUCCESSFULLY");  // POP UP Message
							
							lsql.setVisible(false); // Setting Visibility
							header.setVisible(false); // Setting Visibility
							passtable.setVisible(false); // Setting Visibility
							tablepanel.setVisible(false); // Setting Visibility
							
							passtable = new JTable(data, columns); // Creating a JTable 
							for (int i=0; i<10; i++) { // Setting size of phone seat type and class
								if(i==0 || i==7 || i==9) { // Setting size of ID, seat and Flight number
									TableColumn column = passtable.getColumnModel().getColumn(i); //Getting column
						            column.setMinWidth(45); // Setting size
						            column.setMaxWidth(45); // Setting size
						            column.setPreferredWidth(100); // Setting size
								}
								else if(i==8) { // Setting size of seat type 
									TableColumn column = passtable.getColumnModel().getColumn(i); //Getting column
						            column.setMinWidth(120); // Setting size
						            column.setMaxWidth(120); // Setting size
						            column.setPreferredWidth(120); // Setting size
								}
								else if(i==5 || i==6) { // Setting size of phone and class
									TableColumn column = passtable.getColumnModel().getColumn(i); //Getting column
						            column.setMinWidth(100); // Setting size
						            column.setMaxWidth(100); // Setting size
						            column.setPreferredWidth(100); // Setting size
								}
							}
							
							passtable.setVisible(false); // Setting visibility to false
							passtable.setBounds(680, 64, 700, 300); // x , y and width and height
							passtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Setting auto resize false
							
							header = passtable.getTableHeader(); // Creating a table header by getting header value of the table created
							header.setBackground(Color.yellow); // Setting Background colour
							header.setVisible(false);  // Setting visibility to false
							
							tablepanel=new JPanel(); // Creating a panel
							
							tablepanel.setBounds(680, 64, 800, 500); // x , y and width and height
							tablepanel.add(header); // Adding header to panel
							tablepanel.add(passtable); // Adding table to panel
							tablepanel.setVisible(false); // Setting visibility of panel to false
							buttonview.setText("View Database"); // Changing buttonview text
							buttonhide.setText("Hide Database"); // Changing buttonhide text
							buttonview.setVisible(true); // Setting visibility
							buttonhide.setVisible(false); // Setting visibility
							jf.getContentPane().add(tablepanel); // Adding table panel to JFrame
						}
						con.close(); //Closing Connection
					} catch (Exception ee) { // Error catching block of the try block
						System.out.println(ee); // Error printing
					}
				}
				
			}});
			
//		----------------BACKGROUND PICTURE OF BOOKING PAGE----------------------------------------------------------------------------------------------

		JLabel labelworldpic = new JLabel(""); // This is this is the world picture on main page
		labelworldpic.setIcon(new ImageIcon("src\\worldmap.png")); // Adding background picture of world map
		labelworldpic.setBounds(118, 45, 588, 515); // x , y and width and height
		jf.getContentPane().add(labelworldpic); // Adding it to the frame

		JLabel labelplanepic = new JLabel(""); // This is this is the air plane picture on main page
		labelplanepic.setIcon(new ImageIcon("src\\plane.png")); // Adding background picture of the plane
		labelplanepic.setBounds(255, 56, 445, 159); // x , y and width and height
		jf.getContentPane().add(labelplanepic); // Adding it to the frame
		
//		----------------THE END------------------------------------------------------------------------------------------------------------------------
	}
}
