package com.cognizant;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class CollectionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Float> li = new ArrayList<Float>();
		
		li.add(7.98f);
		li.add(1.2f);
		System.out.println("List"+li);
		
		Set s = new HashSet();
		s.add("India");
		System.out.println("contents"+s);

	}

}
