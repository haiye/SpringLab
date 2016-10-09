/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier  // Specify this is a Qualifier
@Retention(RetentionPolicy.RUNTIME)  // Specify RUNTIME retention
@Target({ElementType.TYPE , ElementType.FIELD}) // Specify TYPE and FIELD targets
public @interface Version {
  double value() default 1.0;
}
