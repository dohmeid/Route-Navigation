import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class UI extends JFrame {
	private String algorithm = "DFS";
	private String algo = "DFS";
	private int goalID = 2;
	private int goalID2 = 1;
	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox1;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox2;
	private JComboBox comboBox3;
	private JButton btn1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UI() {
		setBackground(new Color(0, 0, 51));
		setTitle("Route Navigation Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 595);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl1 = new JLabel("Choose a search algorithm");
		lbl1.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));
		lbl1.setForeground(new Color(0, 51, 51));
		lbl1.setBounds(29, 286, 246, 31);
		contentPane.add(lbl1);

		comboBox1 = new JComboBox();
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jComboBox1ActionPerformed(e);
			}
		});
		comboBox1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		comboBox1.setEditable(true);
		comboBox1.setBackground(new Color(255, 239, 213));
		comboBox1.setModel(new DefaultComboBoxModel(new String[] { "DFS", "BFS", "A* using h1", "A* using h2" }));
		comboBox1.setForeground(new Color(0, 51, 51));
		comboBox1.setBounds(239, 283, 178, 39);
		contentPane.add(comboBox1);

		JLabel lblChooseGoalCity = new JLabel("Choose Goal City");
		lblChooseGoalCity.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));
		lblChooseGoalCity.setForeground(new Color(0, 51, 51));
		lblChooseGoalCity.setBounds(29, 333, 194, 31);
		contentPane.add(lblChooseGoalCity);

		comboBox2 = new JComboBox();
		comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jComboBox2ActionPerformed(e);
			}
		});
		comboBox2.setMaximumRowCount(6);
		comboBox2.setModel(new DefaultComboBoxModel(new String[] { "Jerusalem", "Bethlehem", "Hebron", "Nablus",
				"Jenin", "Jericho", "Salfit", "Ramleh", "Yafa", "Haifa", "Aka", "Sabastia", "Halhoul", "Dura", "Tubas",
				"Safad", "Tulkarm", "Qalqilya", "Nazareth" }));
		comboBox2.setForeground(new Color(0, 51, 51));
		comboBox2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		comboBox2.setEditable(true);
		comboBox2.setBackground(new Color(255, 239, 213));
		comboBox2.setBounds(239, 330, 178, 39);
		contentPane.add(comboBox2);

		btn1 = new JButton("FIND SHORTEST PATH FROM RAMALLAH TO YOUR GOAL");
		btn1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed(e);
			}
		});

		btn1.setFont(new Font("Open Sans", Font.BOLD, 12));
		btn1.setForeground(new Color(245, 245, 220));
		btn1.setBackground(new Color(102, 153, 102));
		btn1.setBounds(29, 465, 385, 39);
		contentPane.add(btn1);

		JLabel lblimg = new JLabel("");
		lblimg.setVerticalAlignment(SwingConstants.TOP);
		lblimg.setIcon(new ImageIcon(UI.class.getResource("/images/logo11.png")));
		lblimg.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo11.png")).getImage()
				.getScaledInstance(260, 160, Image.SCALE_SMOOTH)));
		lblimg.setToolTipText("");
		lblimg.setForeground(Color.RED);
		lblimg.setBounds(100, 87, 256, 158);
		contentPane.add(lblimg);

		JLabel lblheader = new JLabel("WELCOME TO PALESTINE ROUTING APP");
		lblheader.setToolTipText("");
		lblheader.setFont(new Font("Tabletron", Font.ITALIC, 20));
		lblheader.setForeground(new Color(204, 51, 51));
		lblheader.setBounds(42, 41, 378, 35);
		contentPane.add(lblheader);

		comboBox3 = new JComboBox();
		comboBox3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jComboBox3ActionPerformed(e);
			}
		});
		comboBox3.setModel(new DefaultComboBoxModel(new String[] { "none ", "Jerusalem", "Bethlehem", "Hebron",
				"Nablus", "Jenin", "Jericho", "Salfit", "Ramleh", "Yafa", "Haifa", "Aka", "Sabastia", "Halhoul", "Dura",
				"Tubas", "Safad", "Tulkarm", "Qalqilya", "Nazareth" }));
		comboBox3.setMaximumRowCount(6);
		comboBox3.setForeground(new Color(0, 51, 51));
		comboBox3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		comboBox3.setEditable(true);
		comboBox3.setBackground(new Color(255, 239, 213));
		comboBox3.setBounds(239, 380, 178, 39);
		contentPane.add(comboBox3);

		JLabel lblChooseGoalCity_1 = new JLabel("Choose Goal City #2");
		lblChooseGoalCity_1.setForeground(new Color(0, 51, 51));
		lblChooseGoalCity_1.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));
		lblChooseGoalCity_1.setBounds(29, 383, 194, 31);
		contentPane.add(lblChooseGoalCity_1);
	}

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent e) {
		// select search algorithm
		if (comboBox1.getSelectedIndex() == 0)
			algorithm = "DFS";
		else if (comboBox1.getSelectedIndex() == 1) {
			algorithm = "BFS";
			algo = "BFS";
		} else if (comboBox1.getSelectedIndex() == 2) {
			algorithm = "A* using h1";
			algo = "A*";
		} else {
			algorithm = "A* using h2";
			algo = "A*";
		}
	}

	private void jComboBox2ActionPerformed(java.awt.event.ActionEvent e) {
		// select goal city
		goalID = comboBox2.getSelectedIndex() + 2;
	}

	private void jComboBox3ActionPerformed(java.awt.event.ActionEvent e) {
		// select goal city
		goalID2 = comboBox3.getSelectedIndex() + 1;
	}

	@SuppressWarnings("deprecation")
	private void jButtonActionPerformed(java.awt.event.ActionEvent e) {

		System.out.println("Selected algorithm is " + algorithm);
		Result newFrame = new Result(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		dispose(); // to close the current frame(screen/window)

		/*
		 * other way to open a new screen Result newFrame = new Result();
		 * newFrame.pack(); newFrame.setVisible(true);
		 */
		Result.lblAlgo.setText(String.valueOf(algo));
		if (algorithm.compareTo("DFS") == 0) {
			Result.textField1.setText("O(b^m) - exponential");
			Result.textField2.setText("O(b*m) - linear space");
			Result.textField3.setText("not necessarily complete - may loop");
			Result.textField4.setText("not optimal");
		} else if (algorithm.compareTo("BFS") == 0) {
			Result.textField1.setText("O(b^d) - exponential");
			Result.textField2.setText("O(b^d) - exponential space");
			Result.textField3.setText("complete");
			Result.textField4.setText("optimal if all link costs are equal");
		} else {
			Result.textField1.setText("exponential");
			Result.textField2.setText("exponential space");
			Result.textField3.setText("complete");
			Result.textField4.setText("optimal - if heuristic h is admissible");
			Result.textField5.setVisible(false);
			Result.lblPath.setVisible(false);
			Result.lblOfVisited.setVisible(true);
			Result.textField8.setVisible(true);
		}

		int flag = 0;
		int cost1 = 0;
		Main m = new Main();
		m.readFile();

		// for (int i = 0; i < m.cities.size(); i++)
		// System.out.println(m.cities.get(i).toString());

		System.out.println("Finished reading the file");
		System.out.println("*******************************************************");
		System.out.println("Selected goal is: " + m.cities.get(goalID - 1).getCityName() + ", Goal ID is: " + goalID);

		cityNode res = null;
		if (algorithm.compareTo("DFS") == 0) {
			res = m.DFS(m.cities.get(0), m.cities.get(goalID - 1));
			m.printPath(res, 1, 1);
		} else if (algorithm.compareTo("BFS") == 0) {
			res = m.BFS(m.cities.get(0), m.cities.get(goalID - 1));
			m.printPath(res, 1, 1);
		} else { // A*
			flag = 1;
			if (algorithm.compareTo("A* using h1") == 0) {
				res = m.aStar1(m.cities.get(0), m.cities.get(goalID - 1));
				System.out.print("goal found\n");
				m.printPath(res, 0, 1);
			} else { // A* using h2
				res = m.aStar2(m.cities.get(0), m.cities.get(goalID - 1));
				System.out.print("goal found\n");
				m.printPath(res, 1, 1);
			}
			Result.textField8.setText(String.valueOf(m.expanded_nodes_counter));
		}
		// to print on the interface
		System.out.println("*******************************************************");

		// for path
		/*
		 * System.out.println("path by indices: "); for (int i = 0; i < m.path.size();
		 * i++) System.out.print(m.path.get(i) + "-->");
		 */

		// System.out.println("\npath by names: ");
		String citiesPath = "";
		for (int i = 0; i < m.path.size(); i++) {
			int id = m.path.get(i);
			// System.out.print(m.cities.get(id - 1).getCityName() + "-->");
			if (i == (m.path.size() - 1))
				citiesPath = citiesPath + m.cities.get(id - 1).getCityName();
			else
				citiesPath = citiesPath + m.cities.get(id - 1).getCityName() + "-->";
		}
		// System.out.println("\npath cost=" + m.path_cost + "\ndone");
		// System.out.println("\npath=" + citiesPath);
		Result.textField7.setText(String.valueOf(citiesPath));
		Result.textField6.setText(String.valueOf(m.path_cost));
		cost1 = m.path_cost;

		// for visited nodes
		if (flag != 1) {
			// for visited nodes
			/*
			 * System.out.println("visited nodes by indices: "); for (int i = 0; i <
			 * m.visited_nodes.size(); i++) System.out.print(m.visited_nodes.get(i) +
			 * "-->");
			 */

			// System.out.println("\nvisited nodes by names: ");
			String citiesVisited = "";
			for (int i = 0; i < m.visited_nodes.size(); i++) {
				int id = m.visited_nodes.get(i);
				// System.out.print(m.cities.get(id - 1).getCityName() + "-->");
				citiesVisited = citiesVisited + m.cities.get(id - 1).getCityName() + "-->";
			}
			citiesVisited = citiesVisited + m.cities.get(goalID - 1).getCityName();
			Result.textField5.setText(String.valueOf(citiesVisited));
		}

		for (int i = 0; i < m.cities.size() + 1; i++) {
			switch (i) {
			case 2:
				Result.btn2.setVisible(false);
				break;
			case 3:
				Result.btn3.setVisible(false);
				break;
			case 4:
				Result.btn4.setVisible(false);
				break;
			case 5:
				Result.btn5.setVisible(false);
				break;
			case 6:
				Result.btn6.setVisible(false);
				break;
			case 7:
				Result.btn7.setVisible(false);
				break;
			case 8:
				Result.btn8.setVisible(false);
				break;
			case 9:
				Result.btn9.setVisible(false);
				break;
			case 10:
				Result.btn10.setVisible(false);
				break;
			case 11:
				Result.btn11.setVisible(false);
				break;
			case 12:
				Result.btn12.setVisible(false);
				break;
			case 13:
				Result.btn13.setVisible(false);
				break;
			case 14:
				Result.btn14.setVisible(false);
				break;
			case 15:
				Result.btn15.setVisible(false);
				break;
			case 16:
				Result.btn16.setVisible(false);
				break;
			case 17:
				Result.btn17.setVisible(false);
				break;
			case 18:
				Result.btn18.setVisible(false);
				break;
			case 19:
				Result.btn19.setVisible(false);
				break;
			case 20:
				Result.btn20.setVisible(false);
				break;
			}
		}

		// to color the graph
		Result.btn1.setBackground(new Color(153, 51, 51));
		for (int i = 0; i < m.path.size(); i++) {
			int id = m.path.get(i);
			// System.out.println((id-1)+" "+m.cities.get(id - 1).getCityName() + " " +
			// m.cities.get(id - 1).isVisited() );
			switch (id) {
			case 2:
				Result.btn2.setVisible(true);
				Result.btn2.setBackground(new Color(153, 51, 51));
				break;
			case 3:
				Result.btn3.setVisible(true);
				Result.btn3.setBackground(new Color(153, 51, 51));
				break;
			case 4:
				Result.btn4.setVisible(true);
				Result.btn4.setBackground(new Color(153, 51, 51));
				break;
			case 5:
				Result.btn5.setVisible(true);
				Result.btn5.setBackground(new Color(153, 51, 51));
				break;
			case 6:
				Result.btn6.setVisible(true);
				Result.btn6.setBackground(new Color(153, 51, 51));
				break;
			case 7:
				Result.btn7.setVisible(true);
				Result.btn7.setBackground(new Color(153, 51, 51));
				break;
			case 8:
				Result.btn8.setVisible(true);
				Result.btn8.setBackground(new Color(153, 51, 51));
				break;
			case 9:
				Result.btn9.setVisible(true);
				Result.btn9.setBackground(new Color(153, 51, 51));
				break;
			case 10:
				Result.btn10.setVisible(true);
				Result.btn10.setBackground(new Color(153, 51, 51));
				break;
			case 11:
				Result.btn11.setVisible(true);
				Result.btn11.setBackground(new Color(153, 51, 51));
				break;
			case 12:
				Result.btn12.setVisible(true);
				Result.btn12.setBackground(new Color(153, 51, 51));
				break;
			case 13:
				Result.btn13.setVisible(true);
				Result.btn13.setBackground(new Color(153, 51, 51));
				break;
			case 14:
				Result.btn14.setVisible(true);
				Result.btn14.setBackground(new Color(153, 51, 51));
				break;
			case 15:
				Result.btn15.setVisible(true);
				Result.btn15.setBackground(new Color(153, 51, 51));
				break;
			case 16:
				Result.btn16.setVisible(true);
				Result.btn16.setBackground(new Color(153, 51, 51));
				break;
			case 17:
				Result.btn17.setVisible(true);
				Result.btn17.setBackground(new Color(153, 51, 51));
				break;
			case 18:
				Result.btn18.setVisible(true);
				Result.btn18.setBackground(new Color(153, 51, 51));
				break;
			case 19:
				Result.btn19.setVisible(true);
				Result.btn19.setBackground(new Color(153, 51, 51));
				break;
			case 20:
				Result.btn20.setVisible(true);
				Result.btn20.setBackground(new Color(153, 51, 51));
				break;
			}

		}

		if (goalID2 != 1 && goalID2 != goalID) {
			int flag2 = 0;
			Main m2 = new Main();
			m2.readFile();

			System.out.println(
					"Selected goal is: " + m2.cities.get(goalID2 - 1).getCityName() + ", Goal ID is: " + goalID2);

			cityNode res2 = null;
			if (algorithm.compareTo("DFS") == 0) {
				res2 = m2.DFS(m2.cities.get(0), m2.cities.get(goalID2 - 1));
				m2.printPath(res2, 1, 1);
			}

			else if (algorithm.compareTo("BFS") == 0) {
				res2 = m2.BFS(m2.cities.get(0), m2.cities.get(goalID2 - 1));
				m2.printPath(res2, 1, 1);
			} else { // A*
				flag2 = 1;
				if (algorithm.compareTo("A* using h1") == 0) {
					res2 = m2.aStar1(m2.cities.get(0), m2.cities.get(goalID2 - 1));
					System.out.print("goal found\n");
					m2.printPath(res2, 0, 1);
				} else { // A* using h2
					res2 = m2.aStar2(m2.cities.get(0), m2.cities.get(goalID2 - 1));
					System.out.print("goal found\n");
					m2.printPath(res2, 1, 1);
				}

				// Result.textField8.setText(String.valueOf(m2.expanded_nodes_counter));
			}

			String citiesPath2 = "";
			for (int i = 0; i < m2.path.size(); i++) {
				int id = m2.path.get(i);
				// System.out.print(m2.cities.get(id - 1).getCityName() + "-->");
				if (i == (m2.path.size() - 1))
					citiesPath2 = citiesPath2 + m2.cities.get(id - 1).getCityName();
				else
					citiesPath2 = citiesPath2 + m2.cities.get(id - 1).getCityName() + "-->";
			}

			String citiesVisited2 = "";
			if (flag2 != 1) {

				for (int i = 0; i < m2.visited_nodes.size(); i++) {
					int id = m2.visited_nodes.get(i);
					// System.out.print(m.cities.get(id - 1).getCityName() + "-->");
					citiesVisited2 = citiesVisited2 + m2.cities.get(id - 1).getCityName() + "-->";
				}
				citiesVisited2 = citiesVisited2 + m2.cities.get(goalID2 - 1).getCityName();

			}

			if (m2.path_cost < cost1) {
				if (flag2 == 1)
					Result.textField8.setText(String.valueOf(m2.expanded_nodes_counter));
				else
					Result.textField5.setText(String.valueOf(citiesVisited2));
				Result.textField7.setText(String.valueOf(citiesPath2));
				Result.textField6.setText(String.valueOf(m2.path_cost));

				for (int i = 0; i < m2.cities.size() + 1; i++) {
					switch (i) {
					case 2:
						Result.btn2.setVisible(false);
						break;
					case 3:
						Result.btn3.setVisible(false);
						break;
					case 4:
						Result.btn4.setVisible(false);
						break;
					case 5:
						Result.btn5.setVisible(false);
						break;
					case 6:
						Result.btn6.setVisible(false);
						break;
					case 7:
						Result.btn7.setVisible(false);
						break;
					case 8:
						Result.btn8.setVisible(false);
						break;
					case 9:
						Result.btn9.setVisible(false);
						break;
					case 10:
						Result.btn10.setVisible(false);
						break;
					case 11:
						Result.btn11.setVisible(false);
						break;
					case 12:
						Result.btn12.setVisible(false);
						break;
					case 13:
						Result.btn13.setVisible(false);
						break;
					case 14:
						Result.btn14.setVisible(false);
						break;
					case 15:
						Result.btn15.setVisible(false);
						break;
					case 16:
						Result.btn16.setVisible(false);
						break;
					case 17:
						Result.btn17.setVisible(false);
						break;
					case 18:
						Result.btn18.setVisible(false);
						break;
					case 19:
						Result.btn19.setVisible(false);
						break;
					case 20:
						Result.btn20.setVisible(false);
						break;
					}
				}
				for (int i = 0; i < m2.path.size(); i++) {
					int id = m2.path.get(i);
					// System.out.println((id-1)+" "+m.cities.get(id - 1).getCityName() + " " +
					// m.cities.get(id - 1).isVisited() );
					switch (id) {
					case 2:
						Result.btn2.setVisible(true);
						Result.btn2.setBackground(new Color(153, 51, 51));
						break;
					case 3:
						Result.btn3.setVisible(true);
						Result.btn3.setBackground(new Color(153, 51, 51));
						break;
					case 4:
						Result.btn4.setVisible(true);
						Result.btn4.setBackground(new Color(153, 51, 51));
						break;
					case 5:
						Result.btn5.setVisible(true);
						Result.btn5.setBackground(new Color(153, 51, 51));
						break;
					case 6:
						Result.btn6.setVisible(true);
						Result.btn6.setBackground(new Color(153, 51, 51));
						break;
					case 7:
						Result.btn7.setVisible(true);
						Result.btn7.setBackground(new Color(153, 51, 51));
						break;
					case 8:
						Result.btn8.setVisible(true);
						Result.btn8.setBackground(new Color(153, 51, 51));
						break;
					case 9:
						Result.btn9.setVisible(true);
						Result.btn9.setBackground(new Color(153, 51, 51));
						break;
					case 10:
						Result.btn10.setVisible(true);
						Result.btn10.setBackground(new Color(153, 51, 51));
						break;
					case 11:
						Result.btn11.setVisible(true);
						Result.btn11.setBackground(new Color(153, 51, 51));
						break;
					case 12:
						Result.btn12.setVisible(true);
						Result.btn12.setBackground(new Color(153, 51, 51));
						break;
					case 13:
						Result.btn13.setVisible(true);
						Result.btn13.setBackground(new Color(153, 51, 51));
						break;
					case 14:
						Result.btn14.setVisible(true);
						Result.btn14.setBackground(new Color(153, 51, 51));
						break;
					case 15:
						Result.btn15.setVisible(true);
						Result.btn15.setBackground(new Color(153, 51, 51));
						break;
					case 16:
						Result.btn16.setVisible(true);
						Result.btn16.setBackground(new Color(153, 51, 51));
						break;
					case 17:
						Result.btn17.setVisible(true);
						Result.btn17.setBackground(new Color(153, 51, 51));
						break;
					case 18:
						Result.btn18.setVisible(true);
						Result.btn18.setBackground(new Color(153, 51, 51));
						break;
					case 19:
						Result.btn19.setVisible(true);
						Result.btn19.setBackground(new Color(153, 51, 51));
						break;
					case 20:
						Result.btn20.setVisible(true);
						Result.btn20.setBackground(new Color(153, 51, 51));
						break;
					}

				}

			}

		}

	}
}
