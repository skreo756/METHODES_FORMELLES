 package resolution;

import java.util.ArrayList;

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
		
		Resolve(testOr.GetListClause());
		

		
		
		
		
		
		
		
	 
		
		

	}

}
