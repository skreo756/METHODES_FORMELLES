package projet;

public class Var extends Prop {
	
	 String var;
	
	public Var(String v) {
		var = v;
	}

	@Override
	void affichage() {
		System.out.print(var);
		
		
	}

	@Override
	public Prop clausifier() {
		System.out.print(var);
		return null;
		
	}

	@Override
	Prop getProp() {
		// TODO Auto-generated method stub
		return null;
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

}
