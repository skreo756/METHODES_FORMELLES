package projet;


public class Or extends Prop {

	protected Prop p1;
	protected Prop p2;
	
	public Or (Prop prop1 , Prop prop2) {
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
		System.out.print( " v " );
		p2.affichage();
		System.out.print(")");
	}

	@Override
	Prop clausifier() {
		
		if (p2 instanceof Top) {
			Top t = new Top();
			return t;		
		}
		
		else if (p1 instanceof Top) {
			Top t = new Top();
			return t;		
		}
		
		else if (p1 instanceof Bottom) {
			return p2.clausifier();
		}
		
		else if (p2 instanceof Bottom) {
			return p1.clausifier();
		}
		
		else if (p1 instanceof And) {
			Or o1 = new Or (p1.getp1(),p2);
			Or o2 = new Or (p1.getp2(),p2);
			
			And a1 = new And (o1,o2);
			return a1.clausifier();
		}
		
		else if (p2 instanceof And) {
			Or o1 = new Or (p1,p2.getp1());
			Or o2 = new Or (p1,p2.getp2());
			
			And a1 = new And (o1,o2);
			return a1.clausifier();
		}
		
		else {
		System.out.print("(");		
		p1.clausifier();		
		System.out.print(" v " );	
		p2.clausifier();	
		System.out.print(")");
		return null;
		}
			
	}

	@Override
	Prop getProp() {
		// TODO Auto-generated method stub
		return null;
	}

}
