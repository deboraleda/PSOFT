package com.example.lab02.comparators;

import java.util.Comparator;

import com.example.lab02.entidades.Disciplina;

public class ComparaPorLike implements Comparator<Disciplina> {

	@Override
	public int compare(Disciplina o1, Disciplina o2) {
		if(o1.getLikes() > o2.getLikes())
			return 1;
		else if(o1.getLikes() < o2.getLikes())
			return -1;
		return 0;
	}

}
