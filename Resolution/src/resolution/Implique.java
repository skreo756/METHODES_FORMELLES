package resolution;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Terme> getVarLibres() {
		List<Terme> l = Union.union(p1,p2);
		return l;
	}

	@Override
	void affichage() {
		System.out.print("(");
		p1.affichage();
		System.out.print( " ⇒ " );
		p2.affichage();
		System.out.print(")");
		
	}
	
	public ArrayList<Prop> GetListClause() {
		return ListeClause;
	}
	
	public String toString() {
		String o = "("+p1.toString()+" ⇒ "+p2.toString()+")";
		return o;
	}

	@Override
	Prop clausifier() {
		
		//A -> B ≡ ¬(A) v B 
		Not n = new Not(p1);
		Or o = new Or(n,p2);
		return o.clausifier();
		
	}

	@Override
	Prop getProp() {
		return this;
	}

	@Override
	Prop skolemizer() {
		Implique i = new Implique(p1.herbrandiser(),p2.skolemizer());
		return i;
	}

	@Override
	Prop herbrandiser() {
		Implique i = new Implique(p1.skolemizer(),p2.herbrandiser());
		return i;
	}

	@Override
	ArrayList<Prop> MakeClause() {
		// TODO Auto-generated method stub
		return null;
	}

}
