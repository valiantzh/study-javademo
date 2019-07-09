package com.study.rpc.provider;

import com.study.rpc.service.RpcService;

public class RpcServiceImpl implements RpcService {


    @Override
    public String hello(String name) {
        return "hello,my name is "+name;

    }

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }
}
