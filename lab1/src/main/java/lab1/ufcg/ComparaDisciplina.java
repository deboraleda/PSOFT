package lab1.ufcg;

import java.util.Comparator;

public class ComparaDisciplina implements Comparator<Disciplina> {

	@Override
	public int compare(Disciplina o1, Disciplina o2) {
		return o1.compareTo(o2);
	}

	
	
}
