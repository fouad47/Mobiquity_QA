package utils;

import models.Comments;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.function.Predicate;

public class EmailValidation {

    private static final EmailValidator emailValidator = EmailValidator.getInstance();
    private static Predicate<Comments> validateEmailFormat =
            comment -> emailValidator.isValid(comment.getEmail());


}
