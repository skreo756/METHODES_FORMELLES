package resolution;

import java.util.ArrayList;
import java.util.List;

public class Predicat extends Prop {
	
	String nom;
	
	List<Terme> args;
	
	public Predicat(String n , List<Terme> a) {
		nom = n;
		args = a;
	}

	@Override
	void affichage() {
		String predicat = nom+"(";
		for (Terme t : args){
			predicat +=t.toString()+",";		
		}
		predicat = predicat.substring(0, predicat.length()-1);
		predicat +=")";
		System.out.print(predicat);		
	}

	@Override
	Prop clausifier() {
		return this;
	}
	
	public List<Terme> getVarLibres() {
		List<Terme> l = new ArrayList<>();
		for (Terme t : args) {
			l.add(new Var(t.toString()));
		}
		return l;
	}
	
	public List<Terme> getArgs() {
		return args;
	}

	public void setArgs(List<Terme> args) {
		this.args = args;
	}
	
	
	
	public ArrayList<Prop> GetListClause() {
		return ListeClause;
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
