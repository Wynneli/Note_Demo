package com.wynne.util;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
public class SetIterator{
	public static void main(String[] args){
		Set<String> set=new HashSet<String>();
		set.add("AA");
		set.add("BB");
		set.add("CC");
		//Set集合的遍历
		System.out.println("====================");
		System.out.println("方法1:.迭代遍历");
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String str=it.next();
			System.out.print("value:"+str+"\t");
		}

		System.out.println();
		System.out.println("====================");
		System.out.println("第2中方法:for循环遍历");
		for(String str:set){
			System.out.print("value"+str+"\t");
		}

		System.out.println();
		System.out.println("====================");
		System.out.println("第3中方法:for循环遍历");
		//优点还体现在泛型 假如 set中存放的是Object 
		for(Object obj:set){
			if(obj instanceof Integer){
				int str=(Integer)obj;
				System.out.print("value:"+str+"\t");
			}else if(obj instanceof String){
				String str=(String)obj;
				System.out.print("value:"+str+"\t");
			}
		}
	}
}