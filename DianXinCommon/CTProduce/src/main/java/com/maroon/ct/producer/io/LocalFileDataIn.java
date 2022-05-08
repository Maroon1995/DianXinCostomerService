package com.maroon.ct.producer.io;

import com.maroon.ct.common.bean.Data;
import com.maroon.ct.common.bean.DataIn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 本地数据输入
 */
public class LocalFileDataIn implements DataIn {

    private BufferedReader reader = null;

    public LocalFileDataIn(String path) {
        setPath(path);
    }

    @Override
    public void setPath(String path) {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Object read() throws IOException {
        return null;
    }

    @Override
    public <T extends Data> List<T> read(Class<T> clazz) throws IOException {
        List<T> ts = new ArrayList<T>();
        // 从数据文件中读取所有数据
        String line = null;
        while ((line = reader.readLine()) != null) {
            // 将数据转换成指定类型的对象,并封装为集合返回
            try {
                T t = clazz.newInstance(); //反射
                t.setValue(line);
                ts.add(t);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return ts;
    }

    /*关闭资源
    * */
    @Override
    public void close() throws IOException {
        if(reader != null) {
            reader.close();
        }
    }
}
