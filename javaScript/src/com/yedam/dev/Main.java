package com.yedam.dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student("Hong", "S111", 20);
		Student s2 = new Student("Hwang", "S222", 37);
		Student s3 = new Student("Lee", "S333", 27);
		
		System.out.println(" == 배열 == ");
	
		Student[] studAry = {s1, s2, s3};
		
		for(Student s : studAry) {
			System.out.println(s.toString());
		}
		System.out.println();
		System.out.println(" == ArrayList : 중복가능, 순서존재 == ");
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s3);
		
		for(Student s:list) {
			System.out.println(s);
		}
		
		System.out.println();
		System.out.println(" == Set : 중복불가능, 순서존재x == ");
		Set<Student> studSet = new HashSet<Student>();
		studSet.add(s1);
		studSet.add(s2);
		studSet.add(s3);
		studSet.add(s3);
		
		System.out.println(" - for 이용 ");
		for(Student s:studSet) {
			System.out.println(s);
		}
		
		System.out.println(" - Iterator 이용 ");
		Iterator<Student> iter = studSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println();
		System.out.println(" == Map : Key, Value 값을 가짐== ");
		Map<Integer, Student> studMap = new HashMap<Integer, Student>();
		studMap.put(1, s1); //(key, value)
		studMap.put(2, s2);
		studMap.put(3, s3);
		
		Set<Integer> iSet = studMap.keySet(); //key값만 불러옴
		
		System.out.println(" - for 이용 ");
		for(Integer i:iSet) {
			System.out.println("key : " + i  + ", value : " + studMap.get(i));
		}
		
		System.out.println(" - Iterator 이용 ");
		Iterator<Integer> iter2 = iSet.iterator();
		while(iter2.hasNext()) {
			Integer iKey = iter2.next();
			System.out.println("key : " + iKey + ", value : " + studMap.get(iKey));
		}
		
		System.out.println();
		System.out.println(" == Map2 : entrySet 사용 == ");
		Set<Map.Entry<Integer, Student>> mSet = studMap.entrySet();
		
		
		System.out.println(" - for 이용 ");
		for(Entry<Integer, Student> i : mSet) {
			System.out.println(i);
		}
		
		Set<Integer> mSet2 = studMap.keySet();
		for(Integer i : mSet2) {
			System.out.println("key : " + i + ", value : " + studMap.get(i));
		}
		
		System.out.println(" - Iterator 이용 ");
		Iterator<Map.Entry<Integer, Student>> iter3 = mSet.iterator();
		while(iter3.hasNext()) {
			Map.Entry<Integer, Student> rMap = iter3.next();
			System.out.println("key :" + rMap.getKey() + ", value :" + rMap.getValue());
		}
		
	}
}
