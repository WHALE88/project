package itea.ua.oliinyk.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification {
	private char[] obj;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;

	private Matcher matcher;

	public Verification() {
	}

	public boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public boolean getShortPassword(String object) {
		if (object.length() <= 6) {
			return true;
		}
		return false;
	}

	public boolean getLongPassword(String object) {
		if (object.length() >= 20) {
			return true;
		}
		return false;
	}

	public boolean hasUpperCase(String object) {
		obj = object.toCharArray();
		for (char pass : obj) {
			if (Character.isUpperCase(pass)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasLowerCase(String object) {
		obj = object.toCharArray();
		for (char pass : obj) {
			if (Character.isLowerCase(pass)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasDigit(String object) {
		obj = object.toCharArray();
		for (char pass : obj) {
			if (Character.isDigit(pass)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasBackspace(String object) {
		obj = object.toCharArray();
		for (char pass : obj) {
			if (Character.isWhitespace(pass)) {
				return false;
			}
		}
		return true;
	}

	public boolean compare(String obj1, String obj2) {
		if (obj1.equals(obj2)) {
			return true;
		}
		return false;
	}

	public boolean empty(String object) {
		if (object == null || object.equals("")) {
			return true;
		}
		return false;
	}
}
