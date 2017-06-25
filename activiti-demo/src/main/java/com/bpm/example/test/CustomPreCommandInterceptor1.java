package com.bpm.example.test;

import org.activiti.engine.impl.interceptor.AbstractCommandInterceptor;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandConfig;

/**
 * Created by jiankunking on 2017/6/22 7:31.
 */
public class CustomPreCommandInterceptor1 extends AbstractCommandInterceptor {
    @Override
    public <T> T execute(CommandConfig config, Command<T> command) {
        //输出字符串和命令
        System.out.println("this is CustomPreCommandInterceptor1----->" + command.getClass().getName());
        //然后让职责链中的下一个请求处理者处理命令
        return next.execute(config, command);
    }
}
