package com.wei.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FreemarkerApplicationTests {

    @Autowired
    private Configuration configuration;

    @Test
    public void contextLoads() {
    }

//    @Test
//    public void FreemarkerTest() throws IOException, TemplateException {
//        Template template = configuration.getTemplate("index.ftl");
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("index", "freemaker使用");
//        Writer fileWriter = new FileWriter("C:\\Users\\user\\Desktop\\hello.html");
//        template.process(map,fileWriter );
//        fileWriter.close();
//    }

    @Test
    public void addFreemarkerAndIndex() {

    }

}
