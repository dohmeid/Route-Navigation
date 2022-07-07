import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Result extends JFrame {

	private JPanel contentPane;
	static JTextField textField1;
	static JTextField textField4;
	static JTextField textField2;
	static JTextField textField3;
	static JTextField textField5;
	static JTextField textField6;
	static JTextField textField7;
	static JToggleButton btn1;
	static JToggleButton btn2;
	static JToggleButton btn3;
	static JToggleButton btn4;
	static JToggleButton btn5;
	static JToggleButton btn6;
	static JToggleButton btn7;
	static JToggleButton btn8;
	static JToggleButton btn9;
	static JToggleButton btn10;
	static JToggleButton btn11;
	static JToggleButton btn12;
	static JToggleButton btn13;
	static JToggleButton btn14;
	static JToggleButton btn15;
	static JToggleButton btn16;
	static JToggleButton btn17;
	static JToggleButton btn18;
	static JToggleButton btn19;
	static JToggleButton btn20;
	static JLabel lblPath;
	static JLabel lblAlgo;
	private JLabel lblAlgorithm;
	private JLabel lblNewLabel;
	static JTextField textField8;
	static JLabel lblOfVisited;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
					frame.setVisible(true);

					textField6.setText("0");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Result() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1174, 645);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPath = new JLabel("VISITED CITIES");
		lblPath.setForeground(new Color(255, 239, 213));
		lblPath.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));
		lblPath.setBounds(57, 432, 112, 31);
		contentPane.add(lblPath);

		JLabel lblCost = new JLabel("COST\r\n");
		lblCost.setForeground(new Color(255, 239, 213));
		lblCost.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));
		lblCost.setBounds(114, 539, 55, 31);
		contentPane.add(lblCost);

		textField5 = new JTextField();
		textField5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField5.setForeground(new Color(102, 51, 51));
		textField5.setColumns(15);
		textField5.setBackground(new Color(255, 239, 213));
		textField5.setBounds(175, 429, 923, 42);
		contentPane.add(textField5);

		textField6 = new JTextField();
		textField6.setForeground(new Color(102, 51, 51));
		textField6.setColumns(10);
		textField6.setBackground(new Color(255, 239, 213));
		textField6.setBounds(175, 535, 119, 42);
		contentPane.add(textField6);

		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(173, 216, 230));
		panel.setBounds(814, 0, 338, 401);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblAlgorithmsInfo = new JLabel("Algorithm's Properties");
		lblAlgorithmsInfo.setBounds(37, 25, 240, 46);
		panel.add(lblAlgorithmsInfo);
		lblAlgorithmsInfo.setForeground(new Color(204, 51, 51));
		lblAlgorithmsInfo.setFont(new Font("Tabletron", Font.BOLD | Font.ITALIC, 19));

		textField1 = new JTextField();
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 10));
		textField1.setBounds(153, 120, 159, 31);
		panel.add(textField1);
		textField1.setBackground(new Color(102, 153, 102));
		textField1.setForeground(new Color(255, 255, 255));
		textField1.setColumns(10);

		JLabel lblTimeComplexity = new JLabel("Time Complexity");
		lblTimeComplexity.setBounds(10, 117, 133, 31);
		panel.add(lblTimeComplexity);
		lblTimeComplexity.setForeground(new Color(102, 153, 102));
		lblTimeComplexity.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));

		JLabel lblSpaceComplexity = new JLabel("Space Complexity");
		lblSpaceComplexity.setBounds(10, 159, 133, 31);
		panel.add(lblSpaceComplexity);
		lblSpaceComplexity.setForeground(new Color(102, 153, 102));
		lblSpaceComplexity.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));

		JLabel lblCompleteness = new JLabel("Completeness ");
		lblCompleteness.setBounds(10, 225, 109, 31);
		panel.add(lblCompleteness);
		lblCompleteness.setForeground(new Color(102, 153, 102));
		lblCompleteness.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));

		JLabel lblOptimality = new JLabel("Optimality\r\n");
		lblOptimality.setBounds(10, 267, 93, 31);
		panel.add(lblOptimality);
		lblOptimality.setForeground(new Color(102, 153, 102));
		lblOptimality.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));

		textField4 = new JTextField();
		textField4.setHorizontalAlignment(SwingConstants.CENTER);
		textField4.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 10));
		textField4.setBounds(153, 267, 159, 31);
		panel.add(textField4);
		textField4.setForeground(new Color(255, 255, 255));
		textField4.setColumns(10);
		textField4.setBackground(new Color(102, 153, 102));

		textField3 = new JTextField();
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 10));
		textField3.setBounds(153, 225, 159, 31);
		panel.add(textField3);
		textField3.setForeground(new Color(255, 255, 255));
		textField3.setColumns(10);
		textField3.setBackground(new Color(102, 153, 102));

		textField2 = new JTextField();
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 10));
		textField2.setBounds(153, 159, 159, 31);
		panel.add(textField2);
		textField2.setForeground(new Color(255, 255, 255));
		textField2.setColumns(10);
		textField2.setBackground(new Color(102, 153, 102));

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(204, 51, 51));
		separator.setBounds(0, 82, 348, 22);
		panel.add(separator);
		separator.setBackground(new Color(204, 51, 51));

		lblAlgo = new JLabel("DFS");
		lblAlgo.setForeground(new Color(204, 51, 51));
		lblAlgo.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 20));
		lblAlgo.setBounds(193, 331, 64, 46);
		panel.add(lblAlgo);

		lblAlgorithm = new JLabel("Algorithm :");
		lblAlgorithm.setForeground(new Color(204, 51, 51));
		lblAlgorithm.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 20));
		lblAlgorithm.setBounds(57, 331, 126, 46);
		panel.add(lblAlgorithm);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(801, 0, 22, 401);
		contentPane.add(separator_1);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(204, 51, 51));
		separator_1.setBackground(new Color(255, 248, 220));

		btn1 = new JToggleButton("");
		btn1.setEnabled(false);
		btn1.setBackground(new Color(153, 51, 51));
		btn1.setBounds(348, 27, 12, 12);
		contentPane.add(btn1);

		btn7 = new JToggleButton("");
		btn7.setEnabled(false);
		btn7.setBackground(new Color(255, 248, 220));
		btn7.setBounds(77, 70, 12, 12);
		contentPane.add(btn7);

		btn2 = new JToggleButton("");
		btn2.setEnabled(false);
		btn2.setBackground(new Color(255, 248, 220));
		btn2.setBounds(245, 77, 12, 12);
		contentPane.add(btn2);

		btn5 = new JToggleButton("");
		btn5.setEnabled(false);
		btn5.setBackground(new Color(255, 248, 220));
		btn5.setBounds(584, 73, 12, 12);
		contentPane.add(btn5);

		btn15 = new JToggleButton("");
		btn15.setEnabled(false);
		btn15.setBackground(new Color(255, 248, 220));
		btn15.setBounds(450, 113, 12, 12);
		contentPane.add(btn15);

		btn18 = new JToggleButton("");
		btn18.setEnabled(false);
		btn18.setBackground(new Color(255, 248, 220));
		btn18.setBounds(571, 190, 12, 12);
		contentPane.add(btn18);

		btn6 = new JToggleButton("");
		btn6.setEnabled(false);
		btn6.setBackground(new Color(255, 248, 220));
		btn6.setBounds(640, 191, 12, 12);
		contentPane.add(btn6);

		btn16 = new JToggleButton("");
		btn16.setEnabled(false);
		btn16.setBackground(new Color(255, 248, 220));
		btn16.setBounds(726, 193, 12, 12);
		contentPane.add(btn16);

		btn20 = new JToggleButton("");
		btn20.setEnabled(false);
		btn20.setBackground(new Color(255, 248, 220));
		btn20.setBounds(701, 292, 12, 12);
		contentPane.add(btn20);

		btn12 = new JToggleButton("");
		btn12.setEnabled(false);
		btn12.setBackground(new Color(255, 248, 220));
		btn12.setBounds(646, 380, 12, 12);
		contentPane.add(btn12);

		btn11 = new JToggleButton("");
		btn11.setEnabled(false);
		btn11.setBackground(new Color(255, 248, 220));
		btn11.setBounds(601, 288, 12, 12);
		contentPane.add(btn11);

		btn19 = new JToggleButton("");
		btn19.setEnabled(false);
		btn19.setBackground(new Color(255, 248, 220));
		btn19.setBounds(364, 246, 12, 12);
		contentPane.add(btn19);

		btn8 = new JToggleButton("");
		btn8.setEnabled(false);
		btn8.setBackground(new Color(255, 248, 220));
		btn8.setBounds(340, 80, 12, 12);
		contentPane.add(btn8);

		btn14 = new JToggleButton("");
		btn14.setEnabled(false);
		btn14.setBackground(new Color(255, 248, 220));
		btn14.setBounds(213, 354, 12, 12);
		contentPane.add(btn14);

		btn13 = new JToggleButton("");
		btn13.setEnabled(false);
		btn13.setBackground(new Color(255, 248, 220));
		btn13.setBounds(132, 306, 12, 12);
		contentPane.add(btn13);

		btn4 = new JToggleButton("");
		btn4.setEnabled(false);
		btn4.setBackground(new Color(255, 248, 220));
		btn4.setBounds(71, 215, 12, 12);
		contentPane.add(btn4);

		btn3 = new JToggleButton("");
		btn3.setEnabled(false);
		btn3.setBackground(new Color(255, 248, 220));
		btn3.setBounds(114, 144, 12, 12);
		contentPane.add(btn3);

		btn9 = new JToggleButton("");
		btn9.setEnabled(false);
		btn9.setBackground(new Color(255, 248, 220));
		btn9.setBounds(172, 146, 12, 12);
		contentPane.add(btn9);

		btn17 = new JToggleButton("");
		btn17.setEnabled(false);
		btn17.setBackground(new Color(255, 248, 220));
		btn17.setBounds(219, 249, 15, 15);
		contentPane.add(btn17);

		btn10 = new JToggleButton("");
		btn10.setEnabled(false);
		btn10.setBackground(new Color(255, 248, 220));
		btn10.setBounds(239, 145, 12, 12);
		contentPane.add(btn10);

		JLabel lblimg = new JLabel("");
		lblimg.setIcon(new ImageIcon(Result.class.getResource("/images/graph4.png")));
		lblimg.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/graph4.png")).getImage()
				.getScaledInstance(750, 400, Image.SCALE_SMOOTH)));
		lblimg.setBounds(29, 11, 775, 396);
		contentPane.add(lblimg);

		textField7 = new JTextField();
		textField7.setForeground(new Color(102, 51, 51));
		textField7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField7.setColumns(15);
		textField7.setBackground(new Color(255, 239, 213));
		textField7.setBounds(175, 482, 923, 42);
		contentPane.add(textField7);

		JLabel label = new JLabel("PATH\r\n");
		label.setForeground(new Color(255, 239, 213));
		label.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));
		label.setBounds(111, 485, 54, 31);
		contentPane.add(label);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(255, 248, 220));
		separator_2.setBackground(new Color(204, 51, 51));
		separator_2.setBounds(-10, 407, 1198, 15);
		contentPane.add(separator_2);

		lblNewLabel = new JLabel("Note: path cities are colores in red in the graph");
		lblNewLabel.setForeground(new Color(153, 51, 51));
		lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblNewLabel.setBounds(274, 391, 297, 14);
		contentPane.add(lblNewLabel);

		textField8 = new JTextField();
		textField8.setForeground(new Color(102, 51, 51));
		textField8.setColumns(10);
		textField8.setBackground(new Color(255, 239, 213));
		textField8.setBounds(274, 428, 119, 42);
		textField8.setVisible(false);
		contentPane.add(textField8);

		lblOfVisited = new JLabel("# OF VISITED CITIES/NODES\r\n");
		lblOfVisited.setForeground(new Color(255, 239, 213));
		lblOfVisited.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));
		lblOfVisited.setBounds(57, 432, 207, 31);
		lblOfVisited.setVisible(false);
		contentPane.add(lblOfVisited);

	}
}
