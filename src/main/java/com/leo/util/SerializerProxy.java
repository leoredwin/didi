//package com.leo.util;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//
//import com.omniprimeinc.component.queue.core.serializers.Serializer;
//
//
//public class SerializerProxy implements InvocationHandler{
//
//	private Serializer object;
//
//	public SerializerProxy(Serializer serializer) {
//		this.object = serializer;
//	}
//	@Override
//	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		if(method.getName().equals("deserialize")){
//			System.out.println("hello world");
//			Object result = method.invoke(object, args);
//			return result;
//		}
//		Object result = method.invoke(object, args);
//		return result;
//	}
//
//
//}
