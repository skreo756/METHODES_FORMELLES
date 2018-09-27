package projet;

public class Main {

	public static void main(String[] args) {
		
		
		Prop A = new Var("A");
		
		Prop B = new Var("B");
		
		Prop C = new Var("C");
		
		
		
		Prop a1 = new And(A,B);
		
		Prop o1 = new Or(a1,C);
		
		Prop i1 = new Implique(C,o1);
		
		i1.affichage();
		System.out.println();
		
		Prop d =  i1.clausifier();
		
		d.clausifier();
		
		
		
		
		
		
		
		
		/* not1.clausifier();
		
		not2.clausifier();
		
		not5.clausifier();
		
		not3.clausifier(); */
		
		
	
		
		
		
		
		
		
		
		
		
		
		

	}

}
