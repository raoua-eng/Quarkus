package org.acme.utils;

import java.util.Locale;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
@Interceptor
@LocaleChangeInterceptor
@Priority(0)
public class LocaleChange {
    @AroundInvoke
	Object localChangeInvocation(InvocationContext context) {
		Object ret;
		try {
			Locale.setDefault(Locale.FRANCE);
			System.out.println("-------------------------------"+Locale.getDefault());
			System.out.println("-----------------------before mutation invocation-----------------------------------");
			ret = context.proceed();
			System.out.println("-----------------------after mutation invocation-----------------------------------");
			System.out.println("-------------------------------"+Locale.getDefault());
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		
	}
}
