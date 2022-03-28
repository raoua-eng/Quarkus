package org.acme.utils;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.ws.rs.ext.Provider;

import org.apache.commons.beanutils.BeanUtils;

@Provider
public class CheckDateCoherenceValidator implements ConstraintValidator<CheckDateCoherence, Object> {
	private String dateOne;
	private String dateTwo;
	private CaseMode caseMode;

	@Override
	public void initialize(CheckDateCoherence annotation) {
		dateOne = annotation.dateOne();
		dateTwo = annotation.dateTwo();
		caseMode = annotation.caseMode();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		try {
			LocalDate dateOneValue = LocalDate.parse(BeanUtils.getProperty(value, dateOne));
			System.out.println("####################################"+dateOneValue);
			LocalDate dateTwoValue = LocalDate.parse(BeanUtils.getProperty(value, dateTwo));
			System.out.println("*********************************"+dateTwoValue);
			switch (caseMode) {
			case AFTER:
				return dateOneValue.isAfter(dateTwoValue);
			case BEFORE:
				return dateOneValue.isBefore(dateTwoValue);
			case EQUAL:
				System.out.println("-----------------------------------------"+dateOneValue.isEqual(dateTwoValue));
				return dateOneValue.isEqual(dateTwoValue);
			case BEFORE_OR_EQUAL:
				return dateOneValue.isBefore(dateTwoValue) || dateOneValue.isEqual(dateTwoValue);
			case AFTER_OR_EQUAL:
				return dateOneValue.isAfter(dateTwoValue) || dateOneValue.isEqual(dateTwoValue);
			default:
				break;
			}
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
		return true;
	}

}
