package resolution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exists extends Prop {

	protected Prop p1;
	protected String var;
	
	public Exists( String v , Prop p) {
		p1 = p;
		var = v;
	}
	
	@Override
	void affichage() {
		// System.out.println("∃"+var+"("+p1+")");
		
		System.out.print("∃"+var+ "("); 
		p1.affichage(); 
		System.out.print(")") ;
		
	}
	
	public List<Terme> getVarLibres() {

		List<Terme> l = p1.getVarLibres();

		Iterator itr2 = l.iterator();

		Terme t2;
		while(itr2.hasNext()) {
			t2 = (Terme) itr2.next();
			if(t2.toString().equals(var)) {
				itr2.remove();
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
		System.out.println();
		p1.affichage();
		System.out.println();
	//	IlExiste p1 = (IlExiste) p;
		String nomFonct = NameGenerator.generateFonctionName();
		List<Terme> VL = this.getVarLibres(); 
		System.out.println(VL);  // = fonction qui extrait les variables libres de pp
		this.getProp().affichage();
		System.out.println();
		ReplaceTerme.replaceTerme(this.var, new AppFonction(nomFonct,VL), this.getProp());
		return p1.skolemizer();
	}

	@Override
	Prop herbrandiser() {
		return p1.herbrandiser();
	}

	@Override
	ArrayList<Prop> MakeClause() {
		// TODO Auto-generated method stub
		return null;
	}

}
