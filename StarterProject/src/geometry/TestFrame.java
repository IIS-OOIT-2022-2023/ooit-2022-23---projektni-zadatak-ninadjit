package geometry;

import java.util.ArrayList;

import javax.swing.JFrame;

public class TestFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		DrawingPanel panel = new DrawingPanel();
		
		/*
		Punjenje liste iz klase DrawingPanel prilikom pokretanja programa:
		1. koriscenjem set metode 
		2. koriscenjem get metode dobija se lista u koju se ubaciju elementi
		3. u pozivu konstruktora
		//1. 
		ArrayList<Shape> lista = new ArrayList<Shape>();
		lista.add(new Point(30,30));
		panel.setShapesList(lista);
		
		//2.
		ArrayList<Shape> list = panel.getShapesList();
		list.add(new Point(20,20));*/
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

}