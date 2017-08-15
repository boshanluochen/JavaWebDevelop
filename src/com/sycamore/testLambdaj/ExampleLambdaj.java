/*
 * Copyright (c) 2015-2017, Zhejiang QiZhi Technologies Co., Ltd.
 * <http://www.shterm.com/>
 */
package com.sycamore.testLambdaj;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;

import static ch.lambdaj.Lambda.*;

/**
 * test lambdaj
 * http://www.cnblogs.com/jcli/archive/2013/01/09/2851906.html
 * @author wanghw
 *
 */
public class ExampleLambdaj {
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		Person per = new Person();
		per.setId(1);
		per.setName("xiaoMing");
		per.setAge(10);
		persons.add(per);
		per = new Person();
		per.setId(2);
		per.setName("xiaoHua");
		per.setAge(20);
		persons.add(per);
		//joinFrom
		String names = joinFrom(persons).getName();
		System.out.println(names);
		//select
		List<Person> ageGreaterThan33 = select(persons,having(on(Person.class).getAge(),Matchers.greaterThan(15)));
		System.out.println(ageGreaterThan33);
	}
}
