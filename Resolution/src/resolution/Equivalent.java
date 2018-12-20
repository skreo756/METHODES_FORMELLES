package resolution;

import java.util.ArrayList;
import java.util.List;

public class Equivalent extends Prop {
	
	protected Prop p1;
	protected Prop p2;
	
	public Equivalent (Prop prop1 , Prop prop2) {
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
		System.out.print( " ⇔ " );
		p2.affichage();
		
		
	}
	
	public List<Terme> getVarLibres() {
		List<Terme> l = Union.union(p1,p2);
		return l;
	}
	
	public ArrayList<Prop> GetListClause() {
		return ListeClause;
	}

	@Override
	Prop clausifier() {
		
		// A <-> B ≡ A -> B ET B-> A
		Implique i1 = new Implique (p1,p2);
		Implique i2 = new Implique (p2,p1);	
		
		And a = new And (i1,i2);
		return a.clausifier();
	}

	@Override
	Prop getProp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Prop skolemizer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Prop herbrandiser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	ArrayList<Prop> MakeClause() {
		// TODO Auto-generated method stub
		return null;
	}

}
