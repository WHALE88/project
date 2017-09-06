package itea.ua.oliinyk.validation.myannotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

	private MyCaseMode caseMode;
	private char[] charChain;

	@Override
	public void initialize(CheckCase constraintAnnotation) {
		this.caseMode = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
		if (object == null) {
			return true;
		}

		boolean isValid = false;

		if (caseMode == MyCaseMode.EMPTY) {
			if (object.equals("")) {
				isValid = false;
				return isValid;
			} else {
				isValid = true;
			}
			constraintContext.disableDefaultConstraintViolation();
			constraintContext.buildConstraintViolationWithTemplate("Is Empty").addConstraintViolation();
			return isValid;
		}

		if (caseMode == MyCaseMode.UPPER) {
			charChain = object.toCharArray();
			for (char pass : charChain) {
				if (Character.isUpperCase(pass)) {
					isValid = true;
					return isValid;
				}
			}
			constraintContext.disableDefaultConstraintViolation();
			constraintContext.buildConstraintViolationWithTemplate("No Upper case letter").addConstraintViolation();
			return isValid;
		}
		if (caseMode == MyCaseMode.LOWER) {
			charChain = object.toCharArray();
			for (char pass : charChain) {
				if (Character.isLowerCase(pass)) {
					isValid = true;
					return isValid;
				}
			}
			constraintContext.buildConstraintViolationWithTemplate("No Lower case letter").addConstraintViolation();
			return isValid;
		}
		if (caseMode == MyCaseMode.DIGIT) {
			charChain = object.toCharArray();
			for (char pass : charChain) {
				if (Character.isDigit(pass)) {
					isValid = true;
					return isValid;
				}
			}
			constraintContext.buildConstraintViolationWithTemplate("No digit").addConstraintViolation();
			return isValid;
		}
		if (caseMode == MyCaseMode.BACKSPACE) {
			charChain = object.toCharArray();
			for (char pass : charChain) {
				if (Character.isWhitespace(pass)) {
					constraintContext.buildConstraintViolationWithTemplate("Backspace mistake")
							.addConstraintViolation();
					isValid = false;
					return isValid;
				}
			}
			return isValid = true;
		}
		return isValid;
	}

}