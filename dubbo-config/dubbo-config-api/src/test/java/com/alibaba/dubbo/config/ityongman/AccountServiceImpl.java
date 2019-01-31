package com.alibaba.dubbo.config.ityongman;

public class AccountServiceImpl implements IAccountService{

    @Override
    public void printUserName() {
        System.out.println("This is printUserName function");
    }
}
