package resolution;

import java.util.ArrayList;
import java.util.List;

public class Top extends Prop {
	
	
	public Top () {
		
	}

	@Override
	void affichage() {
		System.out.print( " ⊤ " );
		
	}
	
	public ArrayList<Prop> GetListClause() {
		return ListeClause;
	}

	@Override
	Prop clausifier() {
		return this;
		
	}
	
	public List<Terme> getVarLibres() {
		return new ArrayList<Terme>();
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
