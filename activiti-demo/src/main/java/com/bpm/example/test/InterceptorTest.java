package com.bpm.example.test;

import org.activiti.engine.impl.interceptor.AbstractCommandInterceptor;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandConfig;

/**
 * Created by jiankunking on 2017/6/21 11:54.
 */
public class InterceptorTest extends AbstractCommandInterceptor {
    @Override
    public <T> T execute(CommandConfig config, Command<T> command) {
        //输入字符串和命令
        System.out.println("this is InterceptorTest----->" + command.getClass().getName());
        //然后让职责链中的下一个请求处理者处理命令
        return next.execute(config, command);
    }
}
