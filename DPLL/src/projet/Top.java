package projet;

public class Top extends Prop {
	
	
	public Top () {
		
	}

	@Override
	void affichage() {
		System.out.print( " ⊤ " );
		
	}

	@Override
	Prop clausifier() {
		System.out.print( " ⊤ " );
		return null;
		
	}

}
