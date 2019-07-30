package com.commons.examples.generic.interfaces;

import java.util.List;

public interface GenericInterface<F, S, T> {
	F returnFirstValue();
	void consumeSecondValue(S s);
	T transformFirstIntoThird(F f, T t);
	<A> A addSecondIntoList(S s, List<? super Number> list);	
}
