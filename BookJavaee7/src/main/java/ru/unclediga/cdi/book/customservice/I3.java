package ru.unclediga.cdi.book.customservice;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class I3 extends Ixx{
    @AroundInvoke
    public Object logMethod(InvocationContext context) throws Exception {
        return super.logMethod(context, getClass().getName());
    }
}
