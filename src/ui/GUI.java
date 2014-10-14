package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
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
	private JScrollPane treeView;
	private JLabel lblResult;

	public GUI() {
		// TODO Auto-generated constructor stub
	}

	public void createGUI() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 483, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Masukkan kalimat yang akan diproses");
		lblNewLabel.setBounds(10, 11, 447, 29);
		frame.getContentPane().add(lblNewLabel);
		
	
		//System.out.println("haha>>" + node.getName());
		tree = new JTree();
		treeView = new JScrollPane(tree);
		treeView.setBounds(10, 103, 447, 320);
		frame.getContentPane().add(treeView);
		
		textField = new JTextField();
		textField.setBounds(10, 38, 447, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblResult = new JLabel("...");
		lblResult.setBounds(109, 73, 346, 14);
		frame.getContentPane().add(lblResult);
		
		JButton btnCek = new JButton("Cek");
		btnCek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tuple<Boolean, ArrayList<Node>, Integer> tuples;
				frame.remove(treeView);
				try {
					frame.remove(treeView);
					Main compute = new Main(textField.getText());
					tuples = compute.getResult();
					int index = tuples.getC();
					Node node = tuples.getB().get(index);
					tree = new JTree(node.makeTree());
					treeView = new JScrollPane(tree);
					treeView.setBounds(10, 103, 447, 320);
					frame.getContentPane().add(treeView);
					frame.setVisible(true);
					
					if (tuples.getA()) {
						lblResult.setText("Kalimat Valid");
					} else {
						lblResult.setText("Kalimat Tidak Valid");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					lblResult.setText("Kalimat Tidak Valid");
					e1.printStackTrace();
				}
			}
		});
		btnCek.setBounds(10, 69, 89, 23);
		frame.getContentPane().add(btnCek);
		
		
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
