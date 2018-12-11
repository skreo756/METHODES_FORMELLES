package resolution;

import java.util.List;
public class ReplaceTerme {
	

	public static void replaceTerme(String nom, AppFonction f, Prop p) {
		
		if(p instanceof Predicat) {
			List<Terme> l = ((Predicat) p).getArgs();
			for(int i=0; i < l.size(); i++) {
				if(l.get(i).toString().equals(nom)) {
					l.set(i, f);
				}
			}
			((Predicat) p).setArgs(l);
		}
		
		else {
			if(p.getProp() != null) {
				replaceTerme(nom,f,p.getProp());
			}
			if(p.getp1() != null) {
				replaceTerme(nom, f, p.getp1());
			}
			if(p.getp2() != null) {
				replaceTerme(nom, f, p.getp2());
			}
		}
	}
}