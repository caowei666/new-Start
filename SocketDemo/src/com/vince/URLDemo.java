package com.vince;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        /**
         * URL:统一资源定位符
         */
        try {
            URL url = new URL("https://t8.baidu.com/it/u=3571592872,3353494284&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1592071816&t=14c70c9393b1a5ff2e968299bd349e42");
            HttpURLConnection coon = (HttpURLConnection) url.openConnection();
            BufferedInputStream in = new BufferedInputStream(coon.getInputStream());
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("d:\\java\\meinv.jpg"));
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = in.read(bytes)) != -1){
                out.write(bytes,0,len);
                out.flush();
            }
            in.close();
            out.close();
            System.out.println("下载成功");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
