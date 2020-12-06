package com.example.demo.handlers;

import com.example.demo.database.RegisterDatabase;
import com.example.demo.models.BillingInfo;
import com.example.demo.models.PersonalInfo;
import com.example.demo.models.RegisterModel;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {

	private final RegisterDatabase registerDatabase;


	public RegisterHandler(final RegisterDatabase registerDatabase) {
		super();
		this.registerDatabase = registerDatabase;
	}

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addPersonalInfo(final RegisterModel registerModel, final PersonalInfo personalInfo) {
		registerModel.setPersonalInfo(personalInfo);
	}

	public void addBillingInfo(final RegisterModel registerModel, final BillingInfo billingInfo) {
		registerModel.setBillingInfo(billingInfo);
	}

	public String saveAll(final RegisterModel registerModel, final MessageContext error) {

		if (this.registerDatabase.contains(registerModel.getPersonalInfo().getUsername())) {
			error.addMessage(
					new MessageBuilder()
						.error()
						.source("registration")
						.defaultText(
								String.format(
										"Couldn't register user with username: %s!",
										registerModel.getPersonalInfo().getUsername()))
						.build());
			return "failure"; //transitionValue
		}

		this.registerDatabase.add(registerModel);

		return "success"; //transitionValue

	}

	public String validatePersonalInfo(final PersonalInfo personalInfo, final MessageContext error) {

		// Checking if password matched the confirm password
		if (!personalInfo.getPassword().equals(personalInfo.getConfirmPassword())) {
			error.addMessage(
					new MessageBuilder()
						.error()
						.source("confirmPassword")
						.defaultText("Password doesn't match up the confirm password!")
						.build());

			return "failure"; //transitionValue
		}

		return "success"; //transitionValue

	}

}
