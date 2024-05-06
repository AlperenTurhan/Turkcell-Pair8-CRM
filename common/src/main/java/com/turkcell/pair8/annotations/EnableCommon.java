package com.turkcell.pair8.annotations;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // It specifies how the marked annotation is stored: in the runtime (class loaded into the JVM)
@Target(ElementType.TYPE)
@ComponentScan(basePackages = {"com.turkcell.pair8.core"})
public @interface EnableCommon {
}