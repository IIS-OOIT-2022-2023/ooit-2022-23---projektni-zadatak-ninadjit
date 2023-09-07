package geometry;


import java.awt.Color;
import java.awt.Graphics;

//u Javi nije moguce prosirivati vise klasa, ali je moguce implementirati vise interfejsa
public abstract class Shape implements Moveable, Comparable {

	protected boolean selected;
	protected Color color;
	protected Color innerColor;
	
	/*NAPOMENA:
	Kada klasa (npr. Point) prosiruje (nasledjuje) neku klasu (npr. Shape),
	postupak kreiranja objekta izvedene klase podrazumeva lanac izvrsavanja konstruktora,
	pocevsi od klase koja je poslednja u nizu izvodjenja (1. Object -> 2. Shape -> 3. Point)
	Ukoliko se u konstruktorima izvedene klase ne navodi eksplicitno poziv super konstruktora,
	implicitno se poziva podrazumevani super()
	Do greske dolazi ukoliko nadklasa nema definisan podrazumevani konstruktor bez parametara,
	a ima definisane druge konstruktore (u ovom slucaju Java ne generise ugradjeni konstruktor bez parametara)
	*/
	public Shape() { 
		
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public void setColor(Color color) {							//polimorfizam
		this.color = color;;
	}
	public Color getColor() {
		return this.color;
	}
	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	public Color getInnerColor() {
		return innerColor;
	}
	//APSTRAKTNE METODE nemaju implementaciju, odnosno telo metode
	//deklarisu se modifikatorom abstract i implementiraju u klasama koje nasledjuju apstraktnu klasu 
	public abstract void draw(Graphics g);
	public abstract boolean contains(int x, int y);
	public abstract boolean contains(Point point);

	public void fill(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}