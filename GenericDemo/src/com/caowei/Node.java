package com.caowei;

/**
 *泛型只作用于编译期，运行期擦除
 * 泛型类
 */
public class Node<T> {
    private T data;
    public Node(){}
    public Node(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
