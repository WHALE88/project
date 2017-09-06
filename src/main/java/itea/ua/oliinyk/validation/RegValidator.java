package itea.ua.oliinyk.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Size.List;

import itea.ua.oliinyk.validation.myannotation.CheckCase;
import itea.ua.oliinyk.validation.myannotation.MyCaseMode;

public class RegValidator extends LogValidator {
	
	@NotNull(message = "Empty email")
	@CheckCase(MyCaseMode.BACKSPACE)
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Bad email address")
	private String email;
	
	@NotNull(message = "Empty retype password")
	private String retypePassword;

	@NotNull(message = "Empty name")
	@CheckCase(MyCaseMode.BACKSPACE)
	private String name;

	@List({ @Size(min = 10),
		@Size(max = 11, message = "Invalid phonenumber") })
	@NotNull(message = "Empty phonenumber")
	@CheckCase(MyCaseMode.EMPTY)
	private String phonenumber;

	@NotNull(message = "Empty region")
	@CheckCase(MyCaseMode.EMPTY)
	private String region;

	@NotNull(message = "Empty feedback")
	@CheckCase(MyCaseMode.EMPTY)
	private String feedback;

	@NotNull(message = "Empty gender")
	private String gender;

	@NotNull(message = "Empty agreement")
	private boolean agreement;

	public RegValidator() {
	}

	public RegValidator(String login, String email, String password, String retypePassword, String name,
			String phonenumber, String region, String feedback, String gender, boolean agreement) {
		super(login, password);
		this.retypePassword = retypePassword;
		this.name = name;
		this.phonenumber = phonenumber;
		this.region = region;
		this.feedback = feedback;
		this.gender = gender;
		this.agreement = agreement;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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

	public boolean isAgreement() {
		return agreement;
	}

	public void setAgreement(boolean agreement) {
		this.agreement = agreement;
	}

}
