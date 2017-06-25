package com.bpm.example.test;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import java.util.Date;

/**
 * Created by jiankunking on 2017/6/5 15:46.
 */
public class AutomatedDataDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        Date now = new Date();
        execution.setVariable("autoWelcomeTime", now);
        System.out.println("Faux call to backend for ["
                + execution.getVariable("fullName") + "]");
    }

}
