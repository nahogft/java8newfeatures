package org.gft.learning.java8newfeatures.Aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class TimerAspect {
	@Around("execution(@org.gft.learning.java8newfeatures.Annotations.ServiceDuration * *(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		Object result = joinPoint.proceed();

		long endTime = System.currentTimeMillis();

		long duration = endTime - startTime;

		Logger.getLogger(this.getClass()).info(joinPoint.getTarget().getClass().getName() + "." + MethodSignature.class.cast(joinPoint.getSignature()).getMethod().getName() + " done in: " + duration + "ms");

		return result;
	}

}
