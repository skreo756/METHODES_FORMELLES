package projet;

public class Main {

	public static void main(String[] args) {
		
		
		Prop A = new Var("A");
		
		Prop B = new Var("B");
		
		Prop C = new Var("C");
		
		Prop Bot = new Bottom();
		
		Prop Top = new Top();
		
		Prop And1 = new And(A,B);
		
		Prop not1 = new Not(And1);
		
		Prop not2 = new Not(Bot);
		
		Prop not5 = new Not(Top);
		
		not1.clausifier();
		
		not2.clausifier();
		
		not5.clausifier();
		
		
	
		
		
		
		
		
		
		
		
		
		
		

	}

}
