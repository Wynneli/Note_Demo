
//创建一个单例

//方法1
/*
第一种形式: 定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，
通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
*/
public class Singleton{
	//声明为private只供内部使用
    private static Singleton instance=new Singleton();
    //提供一个供外部访问搞class的静态方法，可以直接访问
    public static singleton getInstance(){
    	return instance;
    }
}

//方法2
public class Singleton{
    private static Singleton instance=null;
    public static synchronized Singleton getInstance(){
    	//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次 ,使用时生成实例，提高了效率！
    	if(instance!=null){
    		return instance=new Singleton();
    	}
    }
}



/**
 * 10、 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
 * 但是要保证汉字不被截半个，如“我ABC”4，应该截为“我AB”，输入“我ABC汉DEF”，6，应该输出为“我ABC”而不是“我ABC+汉的半个”。
 * 
 * @author wynne
 */


/*
一、需要分析

1、输入为一个字符串和字节数，输出为按字节截取的字符串--------------》按照字节[byte]截取操作字符串，先将String转换成byte类型

.2、汉字不可以截半--------------汉字截半的话对应字节的ASC码为小于0的数值

 
二、技术难点

1、知道汉字截半的话对应字节的ASC码为小于0的数值

2、对字符串操作应该都要面对的一个问题，字符串是否有效null, 字符串的长度0,1这种边界处理

*/
public class spiltString{

	public void spiltString(String src,int len){

	  int byte_num=0;	
      if(src=null){
      	System.out.println("This is null String");
      	return ;
      }
      byte_num=src.length();
      byte bt[]=src.getByte();  //讲String转化为byte字节数组

      if(len>byte_num){
      	len=byte_num
      }

      // 判断是否出现了截半，截半的话字节对于的ASC码是小于0的值
      if(bt[len]<0){
      	String subStrx=new String(bt,0,--len);
      	System.out.println("subStrx=="+subStrx);
      }else{
      	String subStrx=new String(bt,0,len)
      	System.out.println("subStrx=="+subStrx);
      }
	}
}


//编写Jdbc连接Oracle数据库

import java.sql.*

public class jdbc{
	//数据库配置信息
	public static final String jdbc_Url="jdbc:mysql://127.0.0.1/student";
	public static final String jdbc_User="wynne";
	public static final String jdbc_Password="1234";
	public static final String jdbc_Name="com.mysql.jdbc.Driver"

	public  Connection conn=null;
	public PreparedStatement pst;

	public jdbc(String sql){
		try{
			Class.forName(jdbc_Name);  //指定连接类型
			conn=DirverManager.getConnection(jdbc_Url,jdbc_User,jdbc_Password);  //获取连接
			pst=conn.PreparedStatement(sql);  //准备执行语句
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				this.conn.close();
				this.pst.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}



//静态代理


/** 
 * 测试类
 *  
 * @author wynneli
 *  
 */
public interface Couut{
	//查看账户的方法
	public void queryCount();

	//修改账户的方法
	public void updateCount()；
}


/** 
 * 委托类(包含业务逻辑) 
 *  
 * @author wynneli  
 *  
 */  
public class CountImpl implements Count{

	public void queryCout{
		System.out.println("查看账户的方法！");
	} 

	public void updateCount(){
		System.out.println("修改账户的方法！");
	}
}




/** 
 * 这是一个代理类（增强CountImpl实现类） 
 *  
 * @author wynneli
 *  
 */  

public class CountProxy impements Count{

	private CountImpl countimpl;

     //默认构造器
	public CountProxy(CountImpl countimpl){
		this.countimpl=countimpl;
	}

	public void queryCount(){
		System.out.println("事务处理之前!");
		 // 调用委托类的方法;
		coutnimpl.queryCount();
		System.out.println("事务处理之后!");
	}

	public void updateCount(){
		System.out.println("事务处理之前!");
		 // 调用委托类的方法;
		coutnimpl.updateCount();
		System.out.println("事务处理之后!");
	}
}






//jdk动态代理

/** 
 * 被代理目标对象
 *  
 * @author wynneli
 *  
 */ 

public interface BookingService{
	public void add();
}

/** 
 * 被代理目标对象的接口的实现类
 *  
 * @author wynneli
 *  
 */

public class BookingServiceImpl implements BookingService{
	public void add(){
		System.out.println("增加订票信息");
	}
}


/** 
 * jdk动态代理类
 *  
 * @author wynneli
 *  
 */

public class JdkProxy implements InvocationHandler{
	//被代理的目标对象
	private Object target;

    // 1、 构造器 ，传入目标对象
    public JdkProxy(Object target){
    	this.target=target;
    }

    // 2、提供创建代理对象的方法

   public Object createProxy(){
   	return Proxt.newProxyInstance(target.getClassLoaer(),target.getClass().getInterfaces,this);
   }
   // 3、编写回调函数，拦截目标对象所有方法，都会执行invoke方法
   public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
          System.out.println("增加订单信息的操作被记录到日志中");
          System.out.println("记录体日志"+method.getName()+"被执行！");
          return method.invoke(target,args);
   }
}


/** 
 * 测试类
 *  
 * @author wynneli
 *  
 */

import org.junit.Test;

public class jdkProxyTest {

	@Test
	public void test_staticProxy() {
		//目标对象
		Count target=new CountImpl();
		//创建代理
		jdkProxy jdkproxy=new jdkProxy(target);
		//代理面向接口
		Count proxy=(Count)jdkproxy.createProxy();
		
		//通过代对象执行方法
		proxy.queryCount();
		System.out.println("====================");
		proxy.updateCount();
	}
	@Test
	public void test_jdkProxy() {
		//目标对象
		BookingService target=new BookingServiceImpl();
		//创建代理
		jdkProxy jdkproxy=new jdkProxy(target);
		//代理面向接口
		BookingService proxy=(BookingService)jdkproxy.createProxy();
		
		//通过代对象执行方法
		proxy.add();
	}
}




//cglib动态代理

/** 
 * 被代理的对象
 *  
 * @author wynneli
 *  
 */

public class CustomerService{
	public void save(){
		System.out.println("保存用户信息！");
	}
	public void update(){
		System.out.println("更新用户信息！");
	}
}



/** 
 * 编写 CglibProxyFactory 工具类 ，对目标对象进行cglib代理
 *  工具类，对目标进行cglib代理
 * @author wynneli
 *  
 */

public class CglibProxyFactory implements MethodInterceptor{

	//被代理的目标对象
	private Object target;

	//1,通过构造器传入被代理目标对象
    public CglibProxyFactory(Object target){
    	this.target=target;
    }

    //2,提供生成代理对象的方法
    public Object createProxy(){
    	//用于生成代理API
    	Enhancer enhancer=new Enhancer();

    	//设置目标类，根据类生成子类代理
    	enhancer.setSuperclass(target.getClass());

    	//设置回调函数
    	enhancer.setCallback(this);
    	//生成代理返回
    	return enhancer.create();
    }

    //编写回调拦截函数，拦截目标对象的所有方法
    public Object intercept(Object proxy,Method method,Object[] args
    	MethodProxy methodproxy) throws Throwable{
    	System.out.println("记录日志"+method.getName()+"方法被调用");

    	return methodproxy.invokeSuper(proxy,args);//调用父类（真是对象）的方法
    }
}


/** 
 * 测试类
 * @author wynneli
 *  
 */
import org.junit.Test;
import com.wynne.proxy.CustomerService;

public class CglibProxyFactoryTest {

	@Test
	public void testCglibProxy() {
		//目标
		CustomerService target=new CustomerService();
		//生成代理
		CglibProxyFactory factory=new CglibProxyFactory(target);
		CustomerService proxy=(CustomerService)factory.createProxy();
		//调用代理对象的方法
		proxy.save();
		proxy.update();
	}

}
