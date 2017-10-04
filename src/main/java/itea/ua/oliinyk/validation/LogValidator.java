package itea.ua.oliinyk.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Size.List;

import itea.ua.oliinyk.validation.myannotation.CheckCase;
import itea.ua.oliinyk.validation.myannotation.MyCaseMode;

public class LogValidator {
	@CheckCase(MyCaseMode.BACKSPACE)
	@NotNull(message = "{login.empty.error}")
	@CheckCase(MyCaseMode.EMPTY)
	private String login;

	@NotNull(message = "{password.empty.error}")
	@CheckCase(MyCaseMode.EMPTY)
	@List({ @Size(min = 6, message = "{password.min_length.error}"),
			@Size(max = 20, message = "{password.max_length.error}") })
	@CheckCase(MyCaseMode.UPPER)
	@CheckCase(MyCaseMode.LOWER)
	@CheckCase(MyCaseMode.BACKSPACE)
	@CheckCase(MyCaseMode.DIGIT)
	private String password;

	public LogValidator() {
	}

	public LogValidator(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
