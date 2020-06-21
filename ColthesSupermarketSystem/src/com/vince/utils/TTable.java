package com.vince.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class TTable<T> {


    ArrayList<TColumn> colList = new ArrayList<>();

    public ArrayList<TColumn> getColList() {
        return colList;
    }

    public void setColList(ArrayList<TColumn> colList) {
        this.colList = colList;
    }
    public TTable<T> addColumn(TColumn col)
    {
        this.colList.add(col);
        return this;
    }
    public TTable<T> addColumn(String header, String property, int width)
    {
        this.colList.add(new TColumn(header, property, width));
        return this;
    }

    public void printHeader()
    {

        int total = drawHorizLine();

        out.print("\n|");
        for(int i=0;i<colList.size();i++)
        {
            TColumn col = colList.get(i);
            String data = col.getHeader();

            for(int j=0;j<col.getWidth();j++)
                if(j<data.length())
                    out.print(data.charAt(j));
                else
                    out.print(" ");
            out.print("|");
        }
        //out.print("|");
        drawHorizLine();
    }

    private void printRow(ArrayList<String> list)
    {

        out.print("\n|");
        for(int i=0;i<colList.size();i++)
        {
            TColumn col = colList.get(i);
            String data = list.get(i);

            for(int j=0;j<col.getWidth();j++)
                if(j<data.length())
                    out.print(data.charAt(j));
                else
                    out.print(" ");
            out.print("|");
        }
        //out.print("+");
    }

    public int drawHorizLine()
    {
        int total = 0;

		/*for(int i=0;i<colList.size();i++)
			total+=colList.get(i).getWidth()+1;

		out.print("\n+");
		for(int i=0;i<total;i++)
			out.print("-");
		*/

        out.print("\n+");
        for(int i=0;i<colList.size();i++)
        {
            for(int j=0;j<colList.get(i).getWidth();j++)
                out.print("-");
            out.print("+");
        }

        //out.print("+");

        return total;
    }

    public void printBean(T bean)
    {
        Class clazz = bean.getClass();
        Method[] methods = clazz.getMethods();
        ArrayList<String> list = new ArrayList<String>();


        for(int i=0;i<colList.size();i++)
        {
            String getter="get"+colList.get(i).getProperty();

            for(int j=0;j<methods.length;j++)
            {
                Method method = methods[j];
                if(method.getName().equalsIgnoreCase(getter))
                    try {
                        list.add(""+method.invoke(bean));
                    } catch (IllegalAccessException | IllegalArgumentException
                            | InvocationTargetException e){
                        e.printStackTrace();
                    }
            }
        }

        this.printRow(list);
        this.drawHorizLine();
    }
    public void printBeans(List<T> beanList)
    {
        for(T item:beanList)
        {
            this.printBean(item);
        }
    }

}

class TColumn {
    String header;
    String property;
    int width;

    public TColumn(String header, String property, int width) {
        super();
        this.header = header;
        this.property = property;
        this.width = width;
    }
    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }
    public String getProperty() {
        return property;
    }
    public void setProperty(String property) {
        this.property = property;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

}
