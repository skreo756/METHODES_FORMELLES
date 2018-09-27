package projet;

public class Not extends Prop {
	
	protected Prop p1;
	
	public Not(Prop p) {
		p1 = p;
	}
	
	public Prop getProp() {
		return p1;
	}

	
	@Override
	void affichage() {
		System.out.print("¬(");
		p1.affichage();
		System.out.print(")");
		
	}
	
	public Prop clausifier() {
		if (p1 instanceof Not ) {
			Prop n = p1.getProp().clausifier();
			return n;		
		}
		else if (p1 instanceof Bottom) {
			Prop t = new Top();
			return t.clausifier();
			
		}
		
		else if (p1 instanceof Top) {
			Prop b = new Bottom();
			return b.clausifier();
		}
		
		else if (p1 instanceof And) {
			Not n1 = new Not(p1.getp1());
			Not n2 = new Not(p1.getp2());
			Or or = new Or(n1,n2);
			return or.clausifier();
			
		}
		
		else if (p1 instanceof Var) {
			  affichage();
			  Not n = new Not(p1.getProp());
			  return n;
			  
		}
		
		else {
			return null;
		}
		
	}
	

	
	public Prop clausifier(And and) {
		Not n1 =  new Not(and.getp1());
		Not n2 =  new Not(and.getp2());
		Or or = new Or(n1,n2);
		return or;
	}

	@Override
	Prop getp1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Prop getp2() {
		// TODO Auto-generated method stub
		return null;
	}

	

	


}
