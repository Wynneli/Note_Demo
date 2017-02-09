package com.wynne.util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapInterator{
	public static void main(String[] args){
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(1,"AA");
		map.put(2,"BB");
		map.put(3,"CC");

		/*
		map的遍历
		*/

		//方法一

		//得到所有的Key集合
        System.out.println("===============================================");
        System.out.println("方法1:通过Map.keySet遍历key和value：");
        for(Integer in:map.keySet()){
        	//map.keySet()返回所有的key值
        	String str=map.get(in);  //返回对应key值的value
            System.out.print("key："+in+" "+"value:"+str+"\t");
        }
        System.out.println();
        System.out.println("===============================================");
        System.out.println("第2中方法:通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<Integer,String>> it =map.entrySet().iterator();
        while(it.hasNext()){
        	Map.Entry<Integer,String> entry=it.next();
        	System.out.print("key："+entry.getKey()+" "+"value:"+entry.getValue()+"\t");
        }
        System.out.println();
        System.out.println("===============================================");
        System.out.println("第3中方法:通过Map.entrySet遍历key和value：");
        //推荐，尤其是容量大时
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.print("key："+entry.getKey()+" "+"value:"+entry.getValue()+"\t");
        }
        System.out.println();
        System.out.println("===============================================");
        System.out.println("第4中方法:通过Map.values()遍历所有的value，但不能遍历key");
        for(String v:map.values()){
        	System.out.print("value:"+v+"\t");
        }
	} 
}