 package resolution;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	
	public static void Resolve(ArrayList<Prop> ListClause) {
		for (int i = 0 ; i < ListClause.size() ; i++ ) {
			ListClause.get(i).affichage();
			System.out.print("   ");
		}
		
	}

	public static void main(String[] args) {
		
		
	
		
		
		Terme x = new Var("x");
		
		Terme y = new Var("y");
		
		Terme z = new Var("z");
		
		ArrayList<Terme> pxyz = new ArrayList<Terme>();
		
		pxyz.add(x);
		pxyz.add(y);
		pxyz.add(z);
		
		ArrayList<Terme> px = new ArrayList<Terme>();
		
		px.add(x);
		
		Prop propx = new Predicat("P",px);
		
		
		
		Prop propxyz = new Predicat("P",pxyz);
		

		
		ArrayList<Terme> pxy = new ArrayList<Terme>();
		
		pxy.add(x);
		pxy.add(y);
		
		Prop propxy  = new Predicat("P",pxy);
		
		System.out.println();

		Prop or2 = new Or(propxy,propx);
		
		Prop or3 = new Or(or2,propxyz);
 		
		System.out.println();
		or3.affichage();
		System.out.println();		
		or3.clausifier().affichage();
		System.out.println();
		System.out.println();
		

		
		
		Prop and1= new And(propxy,propx);
		
		Prop or1 = new Or(and1,propxyz);
		
		System.out.println();
		or1.affichage();
		System.out.println();
		
		or1.clausifier().affichage();
		
		System.out.println();
		System.out.println();
		Prop impl = new Implique(or2,or3);
		System.out.println();
		impl.affichage();
		System.out.println();
		impl.clausifier().affichage();
		
		
		System.out.println();
		System.out.println();
		Prop impl1 = new Implique(propx,propxy);
		Prop impl2 = new Implique(impl1,propxyz);
		
		System.out.println();
		impl2.affichage();
		System.out.println();
		impl2.clausifier().affichage();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//ArrayList<Prop> ListeClause = new ArrayList<Prop>();
		
		//impl2.clausifier().MakeClause();
		
		
		Prop test = impl2.clausifier();
		test.affichage();
		test.MakeClause();
		System.out.println();
		test.GetListClause();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		Prop testOr = or3.clausifier(); 
		testOr.affichage();
		testOr.MakeClause();
		System.out.println();
		testOr.GetListClause();
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		
	//	Resolve(testOr.GetListClause());
		
		
		List<Terme> l = new ArrayList<>();
		Var t1 = new Var("x");
		Var t2 = new Var("y");
		Var t3 = new Var("z");
		Var t4 = new Var("a");
		l.add(t1);
		l.add(t2);
		l.add(t3);
		Prop p1 = new Forall("x",new Exists("y",new Forall("z",new Predicat("P",l))));
		p1.affichage();
		System.out.println();
		Prop p = p1.skolemizer();
		p.affichage();
		
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
		
		n1.affichage();
		Prop I = n1.skolemizer();
		I.affichage();
		System.out.println();
		Prop II = I.clausifier();
		II.affichage();
		
		System.out.println();
		System.out.println("//////");
		System.out.println();
		
		II.MakeClause();
		II.GetListClause();
		
		System.out.println();
		System.out.println("//////");
		System.out.println();
		
		
		
		
		System.out.println();
		System.out.println("//////");
		System.out.println();
		
		ArrayList<Prop> III = II.MakeClause();
		for(Prop p8 : III){
			p8.affichage();
			System.out.println();
		}
		
		
		
		
		

		
		
		
		
		
		
		
	 
		
		

	}

}
