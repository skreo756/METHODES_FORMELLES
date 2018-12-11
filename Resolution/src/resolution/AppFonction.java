package resolution;

import java.util.ArrayList;
import java.util.List;

public class AppFonction extends Terme {
	
	String nom;
	
	List<Terme> args;
	
	
	public AppFonction(String nomFonct, List<Terme> vL) {
		this.nom = nomFonct;
		this.args = vL;
	}

	@Override
	void affichage() {
		String predicat = nom+"(";
		for (Terme t : args){
			predicat +="," +t.toString();		
		}
		predicat +=")";
		System.out.println(predicat);
		
	}

	@Override
	public String toString() {
		String predicat = nom+"(";
		for (Terme t : args){
			predicat +="," +t.toString();		
		}
		predicat +=")";
		return predicat;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public List<Terme> getArgs(){
		return args;
	}
	

}
