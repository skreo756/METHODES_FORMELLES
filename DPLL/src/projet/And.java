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
		System.out.print("(");
		p1.affichage();
		System.out.print( " ∧ " );
		p2.affichage();
		System.out.print(")");
		
	}

	@Override
	public Prop clausifier() {
		
		if (p1 instanceof Top) {
			return p2.clausifier();
			
		}
		
		else if (p2 instanceof Top) {
			return p1.clausifier();
		}
		
		else if(p1 instanceof Bottom) {
			Bottom b = new Bottom();
			return b;
		}
		
		else if(p2 instanceof Bottom) {
			Bottom b = new Bottom();
			return b;
		} 
		
		else {
		
	
		p1.clausifier();
		System.out.print(" ∧ " );
		p2.clausifier();
		return null;
		}
	}

	@Override
	Prop getProp() {
		// TODO Auto-generated method stub
		return null;
	}

}
