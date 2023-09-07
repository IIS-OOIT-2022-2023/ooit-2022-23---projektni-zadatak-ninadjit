package stack;

import java.awt.BorderLayout;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;
import geometry.Rectangle;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import javax.swing.JScrollBar;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.AbstractListModel;




public class FrmStack extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<Circle> dlm= new DefaultListModel<Circle>();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
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
	public FrmStack() {
		setTitle("Anastasija Beric IT38/2022");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(240, 255, 240));
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));
		
		
		JScrollPane scrlPnlStack = new JScrollPane();
		pnlCenter.add(scrlPnlStack,BorderLayout.CENTER);
		
		JList lstStack = new JList();
		scrlPnlStack.setViewportView(lstStack);//koristi se za kreiranje
		lstStack.setModel(dlm);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(new Color(255, 255, 224));
		contentPane.add(pnlSouth,BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(new Color(153, 255, 102));
		btnAdd.setForeground(Color.BLACK);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStack dlgStack = new DlgStack();
				dlgStack.setVisible(true);
				if(dlgStack.confirmation) {
					try {
						int x = Integer.parseInt(dlgStack.getTxtX().getText());
						int y = Integer.parseInt(dlgStack.getTxtY().getText());
						int radius = Integer.parseInt(dlgStack.getTxtR().getText());
						
						Circle c = new Circle (new Point(x, y), radius);
						
						dlm.add(0,c);
						
					} catch(Exception NumberFormatException) {
						
						JOptionPane.showMessageDialog(null, "Coordinates must be integers.");
					}	
				}
			}
		});
		pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnlSouth.add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setBackground(new Color(255, 204, 204));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty() == false)
				{
					DlgStack dlgStack = new DlgStack();
					Point p = dlm.getElementAt(0).getCenter();
					int radius = dlm.getElementAt(0).getRadius();
					
					dlgStack.getTxtX().setText(Integer.toString(p.getX()));
					dlgStack.getTxtY().setText(Integer.toString(p.getY()));
					dlgStack.getTxtR().setText(Integer.toString(radius));
					
					dlgStack.setVisible(true);
					
					dlm.removeElementAt(0);
				}
				else {
					JOptionPane.showMessageDialog(null,"Stack is empty!","ERROR", JOptionPane.ERROR_MESSAGE);
				return;
				}	
				}
			
		});
		pnlSouth.add(btnDelete);
	}

}