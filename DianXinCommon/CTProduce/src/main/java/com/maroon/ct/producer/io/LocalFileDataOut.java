package com.maroon.ct.producer.io;

import com.maroon.ct.common.bean.DataOut;

import java.io.IOException;

/**
 * 数据输出到本地
 */
public class LocalFileDataOut implements DataOut {

    public LocalFileDataOut( String path ) {
        setPath(path);
    }

    @Override
    public void setPath(String path) {

    }

    @Override
    public void close() throws IOException {

    }
}
