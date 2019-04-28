package com.zzc.demo03;

import org.aspectj.lang.ProceedingJoinPoint;

public class Check {
   public void check(){
       System.out.println("检查");
   }

   public void log(){
       System.out.println("增加日志");
   }
   public Object round(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
       System.out.println("环绕前");
       Object proceed = proceedingJoinPoint.proceed();
       System.out.println("环绕后");
       return proceed;
   }
   public void exceptionx(Throwable ex){
       System.out.println("发生异常"+ex.getMessage());
   }
   public void after(){
       System.out.println("无论代码是否有异常都执行");
   }
}
