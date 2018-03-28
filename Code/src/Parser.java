import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 * @author aaron
 *
 */
@SuppressWarnings("serial")
public class Parser extends JFrame {
	public static JPanel mainPanel ;
	public JPanel mainNorthPanel;
	public JPanel mainSouthPanel;

	public static JTextField input;
	public static JTextArea output;
	public static JLabel acceptable;


	public static void main(String [] args){
		new Parser();
	}
	
	/**
	 * Constructer to initialiswe GUI components
	 */
	public Parser(){
		// TODO Auto-generated method stub
		super.setTitle("Parser");
		add(getMainPanel());
		setSizes();
	}
	
	
	private void setSizes() {
		setSize(800, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public JPanel getMainPanel(){
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(getNorthPanel(), BorderLayout.NORTH);
		mainPanel.add(getSouthPanel(), BorderLayout.SOUTH);
		return mainPanel;
	}
	
	public JPanel getNorthPanel(){
	
		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(300, 100));
		
		input = new JTextField(50);
		output = new JTextArea();
		output.setLineWrap(true);
	
		input.setFont(new Font("Century Gothic", Font.PLAIN , 14));		
		output.setPreferredSize(new Dimension(700, 200));
		output.setFont(new Font("Century Gothic", Font.PLAIN ,22));
		output.setBackground(Color.WHITE);
		output.setEditable(false);
	
		JButton parse = new JButton("Parse text");
		parse.addActionListener(new ParseButtonListener());
		
		
		northPanel.add(input);
		northPanel.add(parse);
		northPanel.add(output);
		
		return northPanel;
	}
	
	/**
	 * For displaying results
	 * @return
	 */
	public JPanel getSouthPanel(){
		JPanel southPanel = new JPanel();
		acceptable = new JLabel("<html><b>Result - </b> Acceptable Regular Expression:</html>" + true);
		acceptable.setFont(new Font("Century Gothic", Font.ITALIC , 16 ));
		acceptable.setPreferredSize(new Dimension(300, 40));
		
		
		JButton test = new JButton("Test Tagged");
		test.addActionListener(new TestButtonListener());
		
		southPanel.add(acceptable);
		southPanel.add(test);
		
		
		return southPanel;
	}
}
