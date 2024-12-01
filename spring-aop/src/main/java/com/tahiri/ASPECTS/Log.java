package com.tahiri.ASPECTS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) //It is processed at runtime.
@Target(ElementType.METHOD) //apply it on methods where logging behavior is desired.
public @interface Log {
}
