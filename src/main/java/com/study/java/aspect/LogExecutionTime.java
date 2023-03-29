package com.study.java.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어떤 곳에 붙힐 수 있는 메소드인가? 타겟 지정 현재는 메소드
@Target(ElementType.METHOD)
// 이 애노테이션을 사용한 코드를 언제까지 유지를 한것인가?
// 런타임까지 유지해야된다. spring이 runtime을찾아서 적용해준다.
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
}
