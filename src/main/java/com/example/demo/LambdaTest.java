package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {

	//需要挑选出菜谱里面卡路里小于1000，且卡路里排名前三的菜品的名称。
	public List<String > find(List<Dish > menu){

		return menu.stream().filter(dish -> dish.getCalories() < 1000)
				                  .sorted(Comparator.comparing(Dish::getCalories)).limit(3).map(Dish::getName).collect(Collectors.toList());

	}

}
