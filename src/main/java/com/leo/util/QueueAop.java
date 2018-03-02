//package com.leo.util;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Proxy;
//import java.util.List;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//
//import com.omniprimeinc.component.queue.core.QueueContainer;
//import com.omniprimeinc.component.queue.core.QueueResourceManager;
//import com.omniprimeinc.component.queue.core.serializers.Serializer;
//import com.omniprimeinc.component.queue.core.server.MessageRunner;
//import com.omniprimeinc.component.queue.core.server.QueueServer;
//
//@Component
//public class QueueAop implements ApplicationContextAware {
//
//	@Autowired
//	private QueueResourceManager manager;
//
//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		try {
//			QueueContainer container = applicationContext.getBean(QueueContainer.class);;
//			Class<?> cls = container.getClass();
//			Field field = cls.getDeclaredField("queueServers");
//			field.setAccessible(true);
//			List<QueueServer> queueServers = (List<QueueServer>) field.get(container);
//			for (QueueServer server : queueServers) {
//				cls = server.getClass();
//				field = cls.getDeclaredField("messageRunners");
//				field.setAccessible(true);
//				List<MessageRunner> messageRunners = (List<MessageRunner>) field.get(server);
//				for (MessageRunner runner : messageRunners) {
//					cls = runner.getClass();
//					field = cls.getDeclaredField("serializer");
//					field.setAccessible(true);
//					Serializer serializer = (Serializer) field.get(runner);
//					InvocationHandler handler = new SerializerProxy(serializer);
//					Serializer proxy = (Serializer) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
//							serializer.getClass().getInterfaces(), handler);
//					field.set(runner, proxy);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
