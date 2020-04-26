package com.caowei.ex;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 1、Throwable是异常的基类，分为Error和Exception,在编程中我们关注Exception
 * 2、Exception分为编译期异常（受检）和运行期异常（非受检） 3、异常会导致程序中断，无法继续执行
 * 4、在开发中，我们需要把可能出现异常的语句用try{}catch(){}包裹
 */

public class ExecptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		div(10,2);
//		div(10,0);
//		try {
//			div2(20,0);
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		input();
	}

	private static void div(int num1, int num2) {
		int[] arr = { 1, 2, 3, 4, 5 };
		try {
			System.out.println(arr[4]);
			arr = null;
			System.out.println(arr.length);
			int result = num1 / num2;
			System.out.println("result=" + result);
		} catch (ArithmeticException e) { // 数学运算异常
			// TODO: handle exception
			System.out.println("除数不能为零" + e);
		} catch (ArrayIndexOutOfBoundsException e) { // 数组越界异常
			System.out.println("数组下标越界了" + e);
		} catch (NullPointerException e) { // 空指针异常
			System.out.println("空指针异常" + e);
		} catch (Exception e) {
			System.out.println("出错了");
		} finally {
			System.out.println("程序执行完毕");
		}
		System.out.println("结束");
	}

	private static int method() {
		int a = 10;
		int b = 5;
		try {
			System.out.println("a=" + a);
			System.out.println("b=" + b);
			int c = a / b;
			System.out.println("a/b=" + c);
			return c; // return前会先打印finally信息
		} catch (Exception e) {
			e.printStackTrace(); // 打印栈信息 代码测试时使用
		} finally {
			System.out.println("finally");
		}
		return -1;
	}

	// throws和throw一起使用 throws后面可以跟多个异常用逗号分隔
	private static int div2(int a, int b) throws ArithmeticException {
		try {
			int c = a / b;
			return c;
		} catch (ArithmeticException e) {
			throw new ArithmeticException("除数不能为零"); // 不需要写return
		} finally {
			System.out.println("运行结束");
		}
	}

	private static void input() {
		// ctrl+shift+o快速导包
		Scanner input = new Scanner(System.in);
		try {
			int num = input.nextInt();
			System.out.println(num);
		} catch (InputMismatchException e) {
			System.out.println("输入不匹配");
		}

	}
}
