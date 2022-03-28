package org.acme.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/** * 
 * Check the coherence between two dates {@code dateOne} and
 * {@code dateTwo} depending to the case mode {@code caseMode} 
 **/
@Target({ ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.TYPE}) 
@Retention(RetentionPolicy.RUNTIME) 
@Constraint(validatedBy = CheckDateCoherenceValidator.class) 
@Repeatable(CheckDateCoherence.List.class)
@Documented
public @interface CheckDateCoherence {
	String dateOne();
	String dateTwo();
	CaseMode caseMode();
	
	String message() default "{graphql.validation.CheckDateCoherence.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME) 
    @Documented 
    @interface List { 
    	CheckDateCoherence[] value(); 
    }
}
