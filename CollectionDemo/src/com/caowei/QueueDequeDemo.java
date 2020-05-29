package com.caowei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Queue接口：队列，一种先进先出的线性数据结构
 * LinkedList类实现了queue接口
 * 请求队列，消息队列
 * 
 * Deque接口，双端队列，队列两端都可以进行操作
 * LinkedList实现了该接口
 * 
 * Stack类:堆栈，先进后出
 *
 */
public class QueueDequeDemo {
	
	private static void stack() {
		Stack<String> s = new Stack<>();
		s.push("bin");
		s.push("lili");
		s.push("tom");
		System.out.println(s.peek());  //取  不移除
		System.out.println(s.pop());  //取 并移除
		System.out.println(s.pop());  //取 并移除
	}
	private static void deque() {
		Deque<String> deque = new LinkedList<>();
		deque.add("小花");
		deque.add("小黑");
		deque.add("小红");
		deque.add("小绿");
		deque.add("小白");
		deque.add("小伟");
		System.out.println(deque.getFirst());
		System.out.println(deque.getLast());
	}
	private static void queue() {
		Queue<String> queue = new LinkedList<>();
		queue.add("小花");
		queue.add("小黑");
		queue.add("小红");
		queue.add("小绿");
		queue.add("小白");
		queue.add("小伟");
		System.out.println(queue);
		System.out.println(queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue);
	}
	public static void main(String[] args) {
//		queue();
//		deque();
		stack();
	}

}
