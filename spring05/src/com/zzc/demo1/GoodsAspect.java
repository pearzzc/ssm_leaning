package com.zzc.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class GoodsAspect {
    //前置通知注解
    @Before(value = "execution(* com.zzc.demo1.GoodsDaoImpl.add(..))")
    public void before(){
        System.out.println("增强前置");
    }
    //后置通知注解
    @AfterReturning(value = "execution(* com.zzc.demo1.GoodsDaoImpl.delete(..))" ,returning = "returningRes")
    public void after(Object returningRes){
        System.out.println("后置通知"+returningRes);
    }
    //环绕通知注解
    @Around(value = "execution(* com.zzc.demo1.GoodsDaoImpl.update(..))")
    public Object round(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕后");
        return proceed;
    }

    //异常通知的注解配置
    @AfterThrowing(value = "execution(* com.zzc.demo1.GoodsDaoImpl.find(..))",throwing = "ex")
    public void afterThroble(Throwable ex){
        System.out.println("抛出异常"+ex.getMessage());
    }


    //最终通知的注解配置
    /*@After(value = "execution(* com.zzc.demo1.GoodsDaoImpl.find(..))")*/
    //上面注解的简化形式
    @After(value = "GoodsAspect.pointcut1() || GoodsAspect.pointcut3()")
    public void afterMost(){
        System.out.println("最终通知");
    }

    @Pointcut(value = "execution(* com.zzc.demo1.GoodsDaoImpl.find(..))")
     private  void pointcut1(){
        //
    }
    @Pointcut(value = "execution(* com.zzc.demo1.GoodsDaoImpl.delete(..))")
    private  void pointcut2(){
        //
    }
    @Pointcut(value = "execution(* com.zzc.demo1.User.save(..))")
    private  void pointcut3(){
        //
    }
}
