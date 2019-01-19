package cj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectTab {
    @Pointcut("@annotation(cj.aop.TabLog)")
    public void pointcut()
    { System.out.println("pointcut");}

    @Around(value = "pointcut()")
    public void aroundRecordLog(ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("around before");
        //获取参数
        Object [] objs=pjp.getArgs();
        for(Object obj :objs)
        {
            System.out.println(obj);
        }
        //返回值
        Object oo=pjp.proceed();

        System.out.println("around after"  +oo);
    }
}
