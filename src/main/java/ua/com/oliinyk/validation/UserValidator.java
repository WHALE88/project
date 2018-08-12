package ua.com.oliinyk.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Size.List;

import ua.com.oliinyk.validation.myannotation.CheckCase;
import ua.com.oliinyk.validation.myannotation.MyCaseMode;

public class UserValidator {

	@NotNull(message = "Empty login")
	@CheckCase(MyCaseMode.BACKSPACE)
	private String login;

	@NotNull(message = "Empty email")
	@CheckCase(MyCaseMode.BACKSPACE)
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Bad email address")
	private String email;

	@NotNull(message = "Empty password")
	@List({ @Size(min = 6, message = "Password must be at least 6 characters long"),
			@Size(max = 20, message = "Password must contain no more than 20 characters") })
	@CheckCase(MyCaseMode.UPPER)
	@CheckCase(MyCaseMode.LOWER)
	@CheckCase(MyCaseMode.BACKSPACE)
	@CheckCase(MyCaseMode.DIGIT)
	private String password;
	
	private String retypePassword;
	
	@NotNull(message = "Empty name")
	@CheckCase(MyCaseMode.BACKSPACE)
	private String name;

	@NotNull(message = "Empty region")
	private String region;

	@NotNull(message = "Empty feedback")
	private String feedback;

	@NotNull(message = "Empty gender")
	private String gender;
	
	@NotNull(message = "Empty gender")
	private String agreement;

	private String loginErrorMessage;
	private String emailErrorMessage;
	private String passwordErrorMessage;
	private String rePasswordErrorMessage;
	private String nameErrorMessage;
	private String regionErrorMessage;
	private String feedbackErrorMessage;
	private String genderErrorMessage;
	private String agreementErrorMessage;

	private boolean validForm;

	private Verification verif;

	public UserValidator() {
	}

	public UserValidator(String login, String email, String password, Verification verif) {
		this.login = login;
		this.email = email;
		this.password = password;
		this.verif = verif;
	}

	public UserValidator(String password, String retypePassword, Verification verif) {
		this.password = password;
		this.retypePassword = retypePassword;
		this.verif = verif;
	}

	public UserValidator(String login, String email, String password, String retypePassword, String name, String region,
			String feedback, String gender, String agreement, Verification verif) {
		this.login = login;
		this.email = email;
		this.password = password;
		this.retypePassword = retypePassword;
		this.name = name;
		this.region = region;
		this.feedback = feedback;
		this.gender = gender;
		this.agreement = agreement;
		this.verif = verif;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getLoginErrorMessage() {
		loginErrorMessage = "";
		if (verif.empty(login)) {
			loginErrorMessage = "Empty Login";
		}
		if (!verif.hasBackspace(login)) {
			loginErrorMessage = "Backspace mistake";
		}
		return loginErrorMessage;
	}

	public void setLoginErrorMessage(String loginErrorMessage) {
		this.loginErrorMessage = loginErrorMessage;
	}

	public String getEmailErrorMessage() {
		emailErrorMessage = "";
		if (verif.empty(email)) {
			emailErrorMessage = "Empty Login";
		}
		if (!verif.hasBackspace(email)) {
			emailErrorMessage = "Backspace mistake";
		}
		if (!verif.validateEmail(email)) {
			emailErrorMessage = "Bad email address";
		}
		return emailErrorMessage;
	}

	public void setEmailErrorMessage(String emailErrorMessage) {
		this.emailErrorMessage = emailErrorMessage;
	}

	public String getPasswordErrorMessage() {
		passwordErrorMessage = "";
		if (!verif.hasBackspace(password)) {
			passwordErrorMessage = "Backspace mistake";
		}
		if (!verif.hasDigit(password)) {
			passwordErrorMessage = "No digits in the password";
		}
		if (!verif.hasLowerCase(password)) {
			passwordErrorMessage = "No lower case letters in the password";
		}
		if (!verif.hasUpperCase(password)) {
			passwordErrorMessage = "No upper case letters in the password";
		}
		if (verif.empty(password)) {
			passwordErrorMessage = "Empty password";
		}
		if (verif.getShortPassword(password)) {
			passwordErrorMessage = "Password must be at least 6 characters long";
		}
		if (verif.getLongPassword(password)) {
			passwordErrorMessage = "Password must contain no more than 20 characters";
		}
		return passwordErrorMessage;
	}

	public void setPasswordErrorMessage(String passwordErrorMessage) {
		this.passwordErrorMessage = passwordErrorMessage;
	}

	public String getRePasswordErrorMessage() {
		rePasswordErrorMessage = "";
		if (verif.empty(retypePassword)) {
			rePasswordErrorMessage = "Empty retype password";
		}
		if (!verif.compare(password, retypePassword)) {
			rePasswordErrorMessage = "Passwords don't match";
		}
		if (!verif.hasBackspace(retypePassword)) {
			rePasswordErrorMessage = "Backspace mistake";
		}
		return rePasswordErrorMessage;
	}

	public void setRePasswordErrorMessage(String rePasswordErrorMessage) {
		this.rePasswordErrorMessage = rePasswordErrorMessage;
	}

	public String getNameErrorMessage() {
		nameErrorMessage = "";
		if (verif.empty(name)) {
			nameErrorMessage = "Empty Name";
		}
		if (!verif.hasBackspace(name)) {
			nameErrorMessage = "Backspace mistake";
		}
		return nameErrorMessage;
	}

	public void setNameErrorMessage(String nameErrorMessage) {
		this.nameErrorMessage = nameErrorMessage;
	}

	public String getRegionErrorMessage() {
		regionErrorMessage = "";
		if (verif.empty(region)) {
			regionErrorMessage = "Empty Region";
		}
		return regionErrorMessage;
	}

	public void setRegionErrorMessage(String regionErrorMessage) {
		this.regionErrorMessage = regionErrorMessage;
	}

	public String getFeedbackErrorMessage() {
		feedbackErrorMessage = "";
		if (verif.empty(feedback)) {
			feedbackErrorMessage = "Empty Feedback";
		}
		return feedbackErrorMessage;
	}

	public void setFeedbackErrorMessage(String feedbackErrorMessage) {
		this.feedbackErrorMessage = feedbackErrorMessage;
	}

	public String getGenderErrorMessage() {
		genderErrorMessage = "";
		if (verif.empty(gender)) {
			genderErrorMessage = "Empty Gender";
		}
		return genderErrorMessage;
	}

	public void setGenderErrorMessage(String genderErrorMessage) {
		this.genderErrorMessage = genderErrorMessage;
	}

	public String getAgreementErrorMessage() {
		agreementErrorMessage = "";
		if (verif.empty(agreement)) {
			agreementErrorMessage = "Empty Agreement";
		}
		return agreementErrorMessage;
	}

	public void setAgreementErrorMessage(String agreementErrorMessage) {
		this.agreementErrorMessage = agreementErrorMessage;
	}

	public boolean getValidForm() {
		if (verif.empty(login) || !verif.hasBackspace(login) || !verif.validateEmail(email) || verif.empty(email)
				|| !verif.hasBackspace(email) || !verif.hasBackspace(password) || !verif.hasDigit(password)
				|| !verif.hasLowerCase(password) || !verif.hasUpperCase(password) || verif.empty(password)
				|| verif.getShortPassword(password) || verif.getLongPassword(password) || verif.empty(retypePassword)
				|| !verif.hasBackspace(retypePassword) || !verif.compare(password, retypePassword) || verif.empty(name)
				|| !verif.hasBackspace(name) || verif.empty(region) || verif.empty(feedback) || verif.empty(gender)
				|| verif.empty(agreement)) {
			validForm = false;
		} else {
			validForm = true;
		}
		return validForm;
	}
	
	public boolean getValidLog() {
		if (verif.empty(login) || !verif.hasBackspace(login) || !verif.validateEmail(email) || verif.empty(email)
				|| !verif.hasBackspace(email) || !verif.hasBackspace(password) || !verif.hasDigit(password)
				|| !verif.hasLowerCase(password) || !verif.hasUpperCase(password) || verif.empty(password)
				|| verif.getShortPassword(password) || verif.getLongPassword(password)) {
			validForm = false;
		} else {
			validForm = true;
		}
		return validForm;
	}

	public boolean getValidPassword() {
		if (!verif.hasBackspace(password) || !verif.hasDigit(password) || !verif.hasLowerCase(password)
				|| !verif.hasUpperCase(password) || verif.empty(password) || verif.getShortPassword(password)
				|| verif.getLongPassword(password) || verif.empty(retypePassword)
				|| !verif.compare(password, retypePassword)) {
			validForm = false;
		} else {
			validForm = true;
		}
		return validForm;
	}

}
