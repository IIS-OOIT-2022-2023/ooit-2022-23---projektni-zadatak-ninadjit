package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;
import stack.DlgStack;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	DefaultListModel <Circle> dlm = new DefaultListModel<Circle>();
	ArrayList <Circle> list = new ArrayList<Circle>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		setTitle("Anastasija Beric IT38/2022");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(250, 240, 230));
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblnorth = new JLabel("Stack with sort");
		lblnorth.setForeground(new Color(153, 0, 153));
		lblnorth.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		pnlNorth.add(lblnorth);
		
		JPanel pnlCentre = new JPanel();
		contentPane.add(pnlCentre, BorderLayout.CENTER);
		
		JList lstCircle = new JList();
		pnlCentre.add(lstCircle);
		lstCircle.setModel(dlm);
		
		JScrollBar scrpnl = new JScrollBar();
		pnlCentre.add(scrpnl);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(new Color(221, 160, 221));
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(51, 255, 204));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStack dlgStack = new DlgStack();
				dlgStack.setVisible(true); 
				if(dlgStack.confirmation)
				{
					try {
						int x = Integer.parseInt(dlgStack.getTxtX().getText()); 
						int y = Integer.parseInt(dlgStack.getTxtY().getText());
						int radius = Integer.parseInt(dlgStack.getTxtR().getText());
						
						Circle c = new Circle(new Point(x,y), radius); 
						
						dlm.add(0, c);
						list.add(c);
						
					}
					 catch(Exception NumberFormatException) {
						 
						 JOptionPane.showMessageDialog(null,"Please, insert values!");
						 
					 }
					
				}
			}
		});
		pnlSouth.add(btnAdd);
		
		JButton btnSort = new JButton("Sort");
		btnSort.setBackground(new Color(255, 102, 153));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is empty! ", "ERROR", JOptionPane.WARNING_MESSAGE);
				} else {
					
					list.sort(null);
					dlm.clear();
					for(int i=0; i<list.size();i++) {
						dlm.addElement(list.get(i));
						
					}
				}
			}
		});
		pnlSouth.add(btnSort);
	}

}