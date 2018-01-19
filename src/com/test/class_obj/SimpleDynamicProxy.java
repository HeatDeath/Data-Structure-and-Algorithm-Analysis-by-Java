package com.test.class_obj;

import java.lang.reflect.*;

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() +
                ", method: " + method + ", args: " + args);

        if (args != null)
            for (Object arg : args)
                System.out.println("  " + arg);
        return method.invoke(proxied, args);
    }
}

class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // 创建动态代理
        Interface proxy = (Interface) Proxy.newProxyInstance(
                // 类加载器（可以从已经被加载的对象中获取其类加载器）
                Interface.class.getClassLoader(),
                // 希望代理实现的接口列表
                new Class[]{Interface.class},
                // InvocationHandler 接口的一个实现
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
