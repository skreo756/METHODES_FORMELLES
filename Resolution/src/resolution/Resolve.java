package resolution;

import java.util.ArrayList;
import java.util.List;

public class Resolve {
	
	public static List<Prop> S = new ArrayList<Prop>();
	
	public static List<Prop> Sat = new ArrayList<Prop>();
	
		
	public  static boolean  Resolve_(ArrayList<Prop> ListClause) {
		for (int i = 0 ; i < ListClause.size() ; i++ ) {
			ListClause.get(i).affichage();
			System.out.print("   ");
		}
		
		
		Sat = new ArrayList<Prop>();
		S = ListClause;
		
		while (!S.isEmpty()) {
			
			Prop p = null;
			
			for (int i = 0; i < S.size(); i ++) {
				
				p = S.get(i);
				
				if (p instanceof Empty) {
					return false;
				}
				if (p instanceof Top) {
					S.remove(p);
				}
				
				else if (p instanceof Bottom) {
					return false;
				}
				
				else if (Sat.contains(p)) {
					S.remove(p);
				}
				
			}
			
			S.remove(p);
		}
		
		return true;		
		
	}

}
