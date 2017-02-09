package com.wynne.util;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class listIterator{
	public static void main(String[] args){
		List<String> list=new ArrayList<String>();
		list.add("AA");
		list.add("BB");
		list.add("CC");
		System.out.println("====================");
        System.out.println("方法1:.for循环遍历");
		for(String v:list){
			System.out.print("value:"+v+"\t");
		}
		System.out.println();
        System.out.println("====================");
        System.out.println("方法2:for循环遍历");
        //对于ArrayList来说速度比较快, 用for循环, 以size为条件遍历:
        for(int i=0;i<list.size();i++){
        	System.out.print("value:"+list.get(i)+"\t");
        }
        System.out.println();
        System.out.println("====================");
        System.out.println("方法3:迭代器迭代遍历");
        Iterator<String> it=list.iterator();
        while(it.hasNext()){
        	System.out.print("value:"+it.next()+"\t");
        }
	}
}