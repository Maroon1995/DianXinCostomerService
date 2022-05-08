package com.maroon.ct.common.bean;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public interface DataIn extends Closeable{
    public void setPath(String path);

    public Object read() throws IOException;
    // 添加一个泛型

    /**
     * 读取数据，返回数据集合
     * "<T extends Data>"表示传进来的类型只能是Data及其子类
     * @param <T>
     * @param clazz 传进来的是一个类型
     * @return 返回一个该类型的列表
     * @throws IOException
     */
    public <T extends Data> List<T> read(Class<T> clazz) throws IOException;


}
