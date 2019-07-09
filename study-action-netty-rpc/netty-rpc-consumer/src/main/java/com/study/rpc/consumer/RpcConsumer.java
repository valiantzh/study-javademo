package com.study.rpc.consumer;

import com.study.rpc.consumer.proxy.RpcProxy;
import com.study.rpc.service.RpcService;

public class RpcConsumer {
    public static void main(String[] args){
        RpcService service = RpcProxy.create(RpcService.class);
        String hello = service.hello("rpc");
        System.out.println(hello);
        System.out.println(service.add(5, 3));
        System.out.println(service.sub(5, 3));

    }
}
