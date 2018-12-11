package resolution;

import java.util.ArrayList;

public class And extends Prop {
	
	protected Prop p1;
	protected Prop p2;
	
//	ArrayList<Prop> ListeClause;
	
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
	
	public ArrayList<Prop> GetListClause() {	
		return ListeClause;
	}
	

	@Override
	void affichage() {
		System.out.print("(");
		p1.affichage();
		System.out.print( " ∧ " );
		p2.affichage();
		System.out.print(")");
		
	}
	
	public String toString() {
		String o = "("+p1.toString()+" ∧ "+p2.toString()+")";
		return o;
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
		return this;		
		}
	}
	
	public ArrayList<Prop> MakeClause() {
		
		if (p1 instanceof Predicat) {				
			ListeClause.add(p1);			
		}
		
		if (p2 instanceof Predicat) {
			ListeClause.add(p1);
		}
		
		if (p1 instanceof Not) {
			ListeClause.add(p1);
		}
		
		if (p2 instanceof Not) {
			ListeClause.add(p2);
		}
		
		if (p1 instanceof And) {
			 ListeClause.addAll(p1.MakeClause());
		}
		
		if (p2 instanceof And) {
			 ListeClause.addAll(p2.MakeClause());
		}
		
		if (p1 instanceof Or) {
			ListeClause.add(p1);
		}
		
		if (p2 instanceof Or) {
			ListeClause.add(p2);
		}
		
		return ListeClause;		
	}
		
	
	

	@Override
	Prop getProp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Prop skolemizer() {
		
		And a = new And(p1.skolemizer(),p2.skolemizer());
		return a;
	}

	@Override
	Prop herbrandiser() {
		And a = new And(p1.herbrandiser(),p2.herbrandiser());
		return a;
	}

}
