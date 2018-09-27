package projet;

public class And extends Prop {
	
	protected Prop p1;
	protected Prop p2;
	
	public And (Prop prop1 , Prop prop2) {
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
		System.out.print( " ∧ " );
		p2.affichage();
		
	}

	@Override
	public Prop clausifier() {
		
		 p1.clausifier();
		System.out.print(" ∧ " );
		 p2.clausifier();
		return null;
	}

	@Override
	Prop getProp() {
		// TODO Auto-generated method stub
		return null;
	}

}
