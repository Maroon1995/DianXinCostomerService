package com.maroon.ct.producer;


import com.maroon.ct.common.bean.Producer;
import com.maroon.ct.producer.bean.LocalFileProducer;
import com.maroon.ct.producer.io.LocalFileDataIn;
import com.maroon.ct.producer.io.LocalFileDataOut;

import java.io.IOException;

/**
 * 启动对象
 */
public class Bootstrap {
    public static void main(String[] args) throws IOException {

        // 构建生产数据对象
        Producer producer = new LocalFileProducer();
        producer.setIn(new LocalFileDataIn("F:\\resouceDownloadPath\\baiDuCloud\\contact.log"));
        producer.setOut(new LocalFileDataOut("F:\\resouceDownloadPath\\baiDuCloud\\call.log"));
        // 生产数据
        producer.produce();

        // 关闭生产者对象
        producer.close();
    }
}
