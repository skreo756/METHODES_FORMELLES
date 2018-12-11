package resolution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Forall extends Prop {

	protected Prop p1;
	String var;
	
	public Forall( String v , Prop p) {
		p1 = p;
		var = v;
	}
	
	@Override
	void affichage() {
		System.out.print("∀"+var+ "("); 
		p1.affichage(); 
		System.out.print(")") ;
		
	}
	
	public List<Terme> getVarLibres() {
		List<Terme> l = p1.getVarLibres();

		Iterator itr = l.iterator();
		Terme t;
		while(itr.hasNext()) {
			t = (Terme) itr.next();
			if(t.toString().equals(var)) {
				itr.remove();
			}
		}

		return  l;
	}

	@Override
	Prop clausifier() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Prop> GetListClause() {
		return ListeClause;
	}

	@Override
	Prop getProp() {
		return this.p1;
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

	@Override
	Prop skolemizer() {
		p1.affichage();
		System.out.println();
		return p1.skolemizer();
		
	}

	@Override
	Prop herbrandiser() {
		
		String nomFonct = NameGenerator.generateFonctionName();
		List<Terme> VL = this.getVarLibres(); // = fonction qui extrait les variables libres de pp
		
		ReplaceTerme.replaceTerme(this.var, new AppFonction(nomFonct,VL), this.getProp());
		return this.p1.skolemizer();
	}

	@Override
	ArrayList<Prop> MakeClause() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
