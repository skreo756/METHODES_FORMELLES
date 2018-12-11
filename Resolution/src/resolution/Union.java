package resolution;

import java.util.ArrayList;
import java.util.List;

public class Union {

	public static List<Terme> union(Prop p1, Prop p2){
		List<Terme> l = new ArrayList<Terme>();
		l.addAll(p2.getVarLibres());
		for(Terme t : p1.getVarLibres()) {
			if(!l.contains(t)) {
				l.add(t);
			}
		}
		return l;
	}
}
