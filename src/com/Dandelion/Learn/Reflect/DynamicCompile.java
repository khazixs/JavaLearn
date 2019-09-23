package com.Dandelion.Learn.Reflect;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class DynamicCompile {
    public static void main(String[] args) throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "D:\\Java\\JavaLearn\\src\\com\\Dandelion\\Learn\\Reflect\\HelloWorld.java");
        System.out.println(result == 0 ? "编译成功" : "编译失败");

        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp D:\\Java\\JavaLearn\\src\\com\\Dandelion\\Learn\\Reflect HelloWorld");
        InputStream in = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String info = "";
        while ((info = reader.readLine()) != null) {
            System.out.println(info);
        }
    }
}
