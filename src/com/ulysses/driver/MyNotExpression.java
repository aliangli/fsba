package com.ulysses.driver;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.NotExpression;

public class MyNotExpression extends NotExpression {

	protected MyNotExpression(Criterion criterion) {
		super(criterion);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
