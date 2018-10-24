package org.anuran.springstudy.data.validators;

import org.anuran.springstudy.data.entities.Comment;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CommentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Comment.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "author.empty");
		ValidationUtils.rejectIfEmpty(errors, "body", "body.empty");
	}

	
}
