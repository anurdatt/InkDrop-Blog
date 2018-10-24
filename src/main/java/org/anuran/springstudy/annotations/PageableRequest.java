package org.anuran.springstudy.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PageableRequest {

	String path() default "/";
	
}
