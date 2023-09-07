package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Rectangle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;


public class DlgStack extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtR;
	public boolean confirmation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStack dialog = new DlgStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStack() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblx = new JLabel("enter the  X coor:");
			GridBagConstraints gbc_lblx = new GridBagConstraints();
			gbc_lblx.insets = new Insets(0, 0, 5, 5);
			gbc_lblx.gridx = 0;
			gbc_lblx.gridy = 1;
			contentPanel.add(lblx, gbc_lblx);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 2;
			gbc_txtX.gridy = 1;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lbly = new JLabel("enter the Y coor:");
			GridBagConstraints gbc_lbly = new GridBagConstraints();
			gbc_lbly.insets = new Insets(0, 0, 5, 5);
			gbc_lbly.gridx = 0;
			gbc_lbly.gridy = 2;
			contentPanel.add(lbly, gbc_lbly);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 2;
			gbc_txtY.gridy = 2;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblR = new JLabel("enter the radius:");
			GridBagConstraints gbc_lblR = new GridBagConstraints();
			gbc_lblR.insets = new Insets(0, 0, 0, 5);
			gbc_lblR.gridx = 0;
			gbc_lblR.gridy = 3;
			contentPanel.add(lblR, gbc_lblR);
		}
		{
			txtR = new JTextField();
			GridBagConstraints gbc_txtR = new GridBagConstraints();
			gbc_txtR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtR.gridx = 2;
			gbc_txtR.gridy = 3;
			contentPanel.add(txtR, gbc_txtR);
			txtR.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("OK");
				btnOK.setBackground(new Color(153, 255, 102));
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(getTxtX().getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Please, enter a value.", "Message", JOptionPane.ERROR_MESSAGE);
						} else if(getTxtY().getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Please, enter a value.", "Message", JOptionPane.ERROR_MESSAGE);
						} else if(getTxtR().getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please, enter a value.", "Message", JOptionPane.ERROR_MESSAGE);
						}
					
					else {
						try {
							if(Integer.parseInt(getTxtR().getText()) > 0) {
								confirmation = true;
								setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "Radius must be integer and greater than 0.", "Message", JOptionPane.ERROR_MESSAGE);
							}
						} catch (Exception NumberFormatException){
							JOptionPane.showMessageDialog(null, "Radius must be integer and greater than 0.", "Message", JOptionPane.ERROR_MESSAGE);
						}
					}
					}
					
				});
				
				
				btnOK.setActionCommand("OK");
				buttonPane.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setBackground(new Color(255, 153, 153));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

public final JTextField  getTxtX() {
		
		return txtX;
	}

	public final void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}
	
	public final JTextField  getTxtY() {
		
		return txtY;
	}

	public final void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}
	
	public final JTextField  getTxtR() {
		
		return txtR;
	}

	public final void setTxtR(JTextField txtR) {
		this.txtR = txtR;
	}
	
	public void setCircle(Circle c) {
		txtX.setText("" + c.getCenter().getX());
		txtY.setText("" + c.getCenter().getY());
		txtR.setText("" + c.getRadius());
		
	}

	public boolean isConfirm() {
		// TODO Auto-generated method stub
		return false;
	}
}