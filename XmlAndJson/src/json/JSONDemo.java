package json;

import com.google.gson.stream.JsonReader;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JSONDemo {
    /**
     * 解析一个json数组
     */
    @Test
    public void parseJSONName(){
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/caowei/json/names.json");
        InputStreamReader in = new InputStreamReader(is);
        //json的解析工具（解析器）
        JsonReader reader = new JsonReader(in);
        ArrayList<Name> list = new ArrayList<>();
        try {
            //开始解析json数组
            reader.beginArray();
            while (reader.hasNext()){
                list.add(parsrName(reader));
            }
            //结束解析数组
            reader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
    //用来解析对象
    private Name parsrName(JsonReader jsonRader){
        Name name = null;
        try {
            //开始解析对象
            jsonRader.beginObject();
            name = new Name();
            while (jsonRader.hasNext()){
                String attr = jsonRader.nextName();
                if("firstName".equals(attr)){
                    name.setFirstName(jsonRader.nextString());
                }else if("lastName".equals(attr)){
                    name.setLastName(jsonRader.nextString());
                }else if("email".equals(attr)){
                    name.setEmail(jsonRader.nextString());
                }
            }
            //结束解析对象
            jsonRader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
