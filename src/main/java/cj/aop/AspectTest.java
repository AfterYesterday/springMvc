package cj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
@Aspect //该注解标示该类为切面类
public class AspectTest {

    @Pointcut("@annotation(cj.aop.MethodLog)")
    public void methodCachePointcut() {
       // System.out.print("methodCachePointcut");
    }
    public AspectTest() {
        System.out.println("123------------------aop--------------------------");
    }

    @Around("methodCachePointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
//                .getRequestAttributes()).getRequest();
        String monthRemark = getMthodRemark(point);
        System.out.print("11111112");
        System.out.print(monthRemark);
        Object object;
        try {
            object = point.proceed();
        } catch (Exception e) {
            throw e;
        }
        return object;
    }

    // 获取方法的中文备注____用于记录用户的操作日志描述
    public static String getMthodRemark(ProceedingJoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        Class targetClass = Class.forName(targetName);
        Method[] method = targetClass.getMethods();
        String methode = "";
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    MethodLog methodCache = m.getAnnotation(MethodLog.class);
                    if (methodCache != null) {
                        methode = methodCache.remark();
                    }
                    break;
                }
            }
        }
        return methode;
    }
}
