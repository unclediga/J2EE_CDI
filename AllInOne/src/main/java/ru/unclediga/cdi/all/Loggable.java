package ru.unclediga.cdi.all;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

import javax.interceptor.InterceptorBinding;

@InterceptorBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface Loggable {	
}