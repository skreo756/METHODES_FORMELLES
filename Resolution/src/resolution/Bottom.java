package resolution;

import java.util.ArrayList;
import java.util.List;

public class Bottom extends Prop {
	
	
public Bottom () {
		
	}

	@Override
	void affichage() {
		System.out.print( " ⊥ " );
		
	}

	@Override
	Prop clausifier() {
		System.out.print( " ⊥ " );
		return null;
	}
	
public List<Terme> getVarLibres() {
		
		return new ArrayList<Terme>();
	}

	@Override
	Prop getProp() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Prop> GetListClause() {
		return ListeClause;
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
		return this;
	}

	@Override
	Prop herbrandiser() {
		return this;
	}

	@Override
	ArrayList<Prop> MakeClause() {
		// TODO Auto-generated method stub
		return null;
	}

}
