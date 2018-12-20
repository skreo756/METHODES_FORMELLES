 package resolution;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	


	public static void main(String[] args) {
		
		
	
		
		// On crée les variables x, y et z
		Terme x = new Var("x");
		
		Terme y = new Var("y");
		
		Terme z = new Var("z");
		
		
		// On crée l'arrayList de Terme pxyz qui contient x y z
		ArrayList<Terme> pxyz = new ArrayList<Terme>();
		
		pxyz.add(x);
		pxyz.add(y);
		pxyz.add(z);
		
		ArrayList<Terme> px = new ArrayList<Terme>();
		
		
		px.add(x);
		
		//On crée la Proposition P(x)
		Prop propx = new Predicat("P",px);
		
		
		// On crée la Proposition P(x,y,z)
		Prop propxyz = new Predicat("P",pxyz);
				
		ArrayList<Terme> pxy = new ArrayList<Terme>();
		
		pxy.add(x);
		pxy.add(y);
		
		//On crée la proposition P(x,y)
		Prop propxy  = new Predicat("P",pxy);
		
		System.out.println();

		
		// P(x,y) v P(x)
		Prop or2 = new Or(propxy,propx);
		
		// P(x,y,z) v (P(x,y) v P(x))
		Prop or3 = new Or(or2,propxyz);
 		
		// On affiche la Proposition puis la proposition clausifiée
		System.out.println();
		or3.affichage();
		System.out.println();		
		or3.clausifier().affichage();
		System.out.println();
		System.out.println();
		System.out.println();
		

		
		// P(x,y) ∧  P(x)
		Prop and1= new And(propxy,propx);
		
		// (P(x,y) ∧  P(x)) v P(x,y,z)
		Prop or1 = new Or(and1,propxyz);
		
		
		// (((P(x,y) ∧ P(x)) v P(x,y,z)) ⇒ ((P(x,y) v P(x)) v P(x,y,z)))
		Prop impl = new Implique(or1,or3);
		System.out.println();
		// On affiche la Proposition
		impl.affichage();
		System.out.println();
		// On la clausifie et on affiche le résultat
		impl.clausifier().affichage();
		
		
		System.out.println();
		System.out.println();
		Prop impl1 = new Implique(propx,propxy);
		
		// (P(x) -> P(x,y)) -> P(x,y,z)
		Prop impl2 = new Implique(impl1,propxyz);
		
		
		System.out.println();
		// On affiche
		impl2.affichage();
		System.out.println();
		// On clausifie et on affiche le rsultat
		impl2.clausifier().affichage();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		Prop test = impl2.clausifier();
		test.MakeClause();
		System.out.println();
		// On affiche la liste des clauses
		test.GetListClause();
		
		System.out.println();
		System.out.println();
		System.out.println();


		
		
		
		List<Terme> l = new ArrayList<>();
		Var t1 = new Var("x");
		Var t2 = new Var("y");
		Var t3 = new Var("z");
		Var t4 = new Var("a");
		l.add(t1);
		l.add(t2);
		l.add(t3);
		// On crée la Proposition ∀x(∃y(∀z(P(x,y,z))))
		Prop p1 = new Forall("x",new Exists("y",new Forall("z",new Predicat("P",l))));
		// On l'affiche
		p1.affichage();
		System.out.println();
		// On skolemize la fonction et on affiche le résultat : P(x,f1(x),z)
		p1.skolemizer();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		List<Terme> l2 = new ArrayList<>();
		l2.add(t1);
		
		List<Terme> l3 = new ArrayList<>();
		l3.add(t4);
		
		
		
		Forall for1 = new Forall("x", new Predicat ("P", l2));	
		Or o1 = new Or(for1, new Predicat ("Q", l2));
		Or o2 = new Or(new Predicat ("P" , l3), new Predicat ("Q" , l3));		
		Implique i1 = new Implique(o1, o2);
		Not n1 = new Not(i1);
		
		// On crée la proposition ¬(((∀x(P(x)) v Q(x)) ⇒ (P(a) v Q(a))))P(x)
		// On affiche la proposition
		n1.affichage();
		// On skolemize la fonction
		Prop I = n1.skolemizer();
		
		System.out.println();
		// On la clausifie puis on affiche la proposition clausifée et la liste des clauses.
		Prop II = I.clausifier();
		II.affichage();		
		II.MakeClause();
		System.out.println();
		II.GetListClause();
		

		

	}

}
