package ie.cit.cloudapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect 
public class TracingAspect {
	private static Log log = LogFactory.getLog(TracingAspect.class);
	
	// Format...
	//[Modifiers] ReturnType [ClassType] MethodName ([Arguments]) [throws Exception]
	//@Before(stages = {LifecycleStage.BindingAndValidation, LifecycleStage.CustomValidation})
	 
	//Was trying to implement Tracing for multiple...might have it...

	@Before("execution(* ie.cit.cloudapp.*.*(*))")	 

	public void traceMethod(JoinPoint point) {
		try
		{
			String className = point.getTarget().getClass().getName();
			String methodName = point.getSignature().getName();
			if (className.equalsIgnoreCase("ie.cit.cloudapp.JdbcPlayerRepository"))
			{
				log.trace("Player Repository Method Invoked:"+className+" -> "+methodName);
			}
			
			else if (className.equalsIgnoreCase("ie.cit.cloudapp.JdbcGameRepository"))
			{
				log.trace("Game Repository Method Invoked: "+className+" -> "+methodName);
			}
			
			else if (className.equalsIgnoreCase("ie.cit.cloudapp.Player"))
			{
				log.trace("Player Method Invoked: "+className+" -> "+methodName);
			}
			
			else if (className.equalsIgnoreCase("ie.cit.cloudapp.Game"))
			{
				log.trace("Game Method Invoked: "+className+" -> "+methodName);
			}
			
			else 
			{
				log.trace("Other Method Invoked: "+className+" -> "+methodName);
			}
		}
		catch (NullPointerException e)
		{
		   System.out.println("Found a null but didnt want to crash!!!");
		}
		
		
	}
}
