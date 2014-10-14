package ui;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import main.Main;
import model.Node;
import model.Tuple;

public class GUI extends JFrame {
	private JFrame frame;
	private JTree tree;

	public GUI() {
		// TODO Auto-generated constructor stub
	}

	public void createGUI() throws IOException {
		frame = new GUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
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
