package cs544.exercise6_1.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;
import cs544.exercise6_1.EmailSender;

@Aspect
public class AspectLogger {
	
	final static Logger logger = Logger.getLogger(AspectLogger.class);
	
	@After("execution(public void sendEmail(String,String)) && args(email,address)")
	public void logger(JoinPoint joinpoint, String email, String address){
//		logger.info("method= "+joinpoint.getSignature().getName());	
		
		EmailSender sendEmail  = (EmailSender)joinpoint.getTarget();
		
		System.out.println("method = " + joinpoint.getSignature().getName());
		System.out.println("address = " + email);
		System.out.println("message = " + address);
		System.out.println("outgoing mail server = " + sendEmail.getOutgoingMailServer());
	}
	
	@Around("execution(public void save(*))")
	public Object invoke(ProceedingJoinPoint call ) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		// print the time to the console
		System.out.println("Time to execute save = " + totaltime + " ms");
		return retVal;
	}

}
