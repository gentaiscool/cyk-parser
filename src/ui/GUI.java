package ui;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;

import main.Main;
import model.Node;
import model.Tuple;

public class GUI extends JFrame {
	private JFrame frame;
	private JTree tree;
	private JTextField textField;
	private JLabel label;

	public GUI() {
		// TODO Auto-generated constructor stub
	}

	public void createGUI() throws IOException {
		GridLayout myLayout = new GridLayout(0,2);
		frame = new GUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setLayout(myLayout);
		
		label = new JLabel();
		label.setText("Masukkan kalimat yang akan diproses");
		frame.add(label);
		
		textField = new JTextField();
		frame.add(textField);
		frame.setVisible(true);

		Tuple<Boolean, ArrayList<Node>, Integer> tuples = new Main()
				.getResult();
		int index = tuples.getC();
		Node node = tuples.getB().get(index);
		tree = new JTree(node.makeTree());
		JScrollPane treeView = new JScrollPane(tree);
		frame.add(treeView);
		
		frame.setTitle("Parse Tree");
		frame.setVisible(true);
		
		//text field
		
		
	}

	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new GUI().createGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
