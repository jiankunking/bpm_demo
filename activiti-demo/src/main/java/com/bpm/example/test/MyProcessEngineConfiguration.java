package com.bpm.example.test;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.CommandContextInterceptor;
import org.activiti.engine.impl.interceptor.CommandInterceptor;
import org.activiti.engine.impl.interceptor.LogInterceptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by jiankunking on 2017/6/21 13:38.
 */
public class MyProcessEngineConfiguration extends ProcessEngineConfigurationImpl {

    @Override
    protected CommandInterceptor createTransactionInterceptor() {
        // 事务拦截器 在activiti默认初始化的时候是空的
        // 此处返回自定义拦截器InterceptorTest2
        return new InterceptorTest2();
    }

    @Override
    protected Collection<? extends CommandInterceptor> getDefaultCommandInterceptors() {
        List<CommandInterceptor> interceptors = new ArrayList<>();
        //通过重写父类ProcessEngineConfigurationImpl中的getDefaultCommandInterceptors方法
        //可以自定义拦截器的位置
        //以及添加哪一些拦截器
        //添加自定义预处理拦截器
        interceptors.add(new LogInterceptor());
        CommandInterceptor transactionInterceptor = createTransactionInterceptor();
        if (transactionInterceptor != null) {
            interceptors.add(transactionInterceptor);
        }
        interceptors.add(new InterceptorTest());
        interceptors.add(new CommandContextInterceptor(commandContextFactory, this));
        return interceptors;
    }
}
