package projet;

public class Implique extends Prop {
	
	protected Prop p1;
	protected Prop p2;
	
	public Implique (Prop prop1 , Prop prop2) {
		p1 = prop1;
		p2 = prop2;
	}
	
	public Prop getp1() {
		return p1;
	}
	
	public Prop getp2() {
		return p2;
	}

	@Override
	void affichage() {
		p1.affichage();
		System.out.print( " ⇒ " );
		p2.affichage();
		
	}

	@Override
	Prop clausifier() {
		Not n = new Not(p1);
		Or o = new Or(n,p2);
		o.clausifier();
		return null;
		
	}

	@Override
	Prop getProp() {
		// TODO Auto-generated method stub
		return null;
	}

}
