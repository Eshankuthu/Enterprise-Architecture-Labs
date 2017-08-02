package cs544.exercise6_1.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectLogger {
	
	final static Logger logger = Logger.getLogger(AspectLogger.class);
	
	@After("execution(public void sendEmail(..))")
	public void logger(JoinPoint joinpoint){
		logger.info("method: "+joinpoint.getSignature().getName());	
	}

}
