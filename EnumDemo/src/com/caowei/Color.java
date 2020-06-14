package com.caowei;

/**
 * 定义一个枚举类型
 */
public enum Color implements info {
    RED(10){
        @Override
        public String getColor2() {
            return "red";
        }
    },GREEN {
        @Override
        public String getColor2() {
            return "green";
        }
    },BLUE {
        @Override
        public String getColor2() {
            return "blue";
        }
    };  //在对象上调用构造方法  可以有参可以无参
    private int color;  //可以定义属性
    private Color(){
        System.out.println("调用无参构造方法");
    };   //可以定义构造方法
    private Color(int color){
        this.color = color;
        System.out.println("调用有参构造方法");
    };

    @Override
    public int getColor() {
        return color;
    }

    public abstract String getColor2();
}
