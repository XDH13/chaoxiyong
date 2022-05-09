package com.huawei.classroom.student.h20;

/**定义合适的类、接口，使得下面的代码编译并能正确运行*/
public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
/**
 * A
 * B
 * C
 *
 */
		A a = new D();// A->D
		C c = new D();//C->D,D with C
		D d = new D();
		//A
		//B inter
		//B->C inter
		//E with C
		//A->D with C
		System.out.println("pass 1");
		
		B b = c; //B->C, C with B
		System.out.println("pass 2");
		
		a = d;
		System.out.println("pass 3");
		
		c=new E();//C->E,E with C
		System.out.println("pass 4");
		
		a=new A();
		if (!(a instanceof B)) {// B->A
			System.out.println("pass 5");
		}
		
		if (!(c instanceof A)) {//A->C
			System.out.println("pass 6");
		}
		if (!(c instanceof D)) {//D->C
			System.out.println("pass 7");
		}

	}
}
