package uz.zohidjon.book.handle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum BusinessErrorCodes {
    NO_CODE(0, NOT_IMPLEMENTED, "No Code"),
    INCORRECT_PASSWORD(300, BAD_REQUEST, "Incorrect Password"),
    NEW_PASSWORD_DOES_NOT_MATCH(301, BAD_REQUEST, "New Password Does Not Match"),
    ACCOUNT_LOCKED(302, FORBIDDEN, "Account Locked"),
    ACCOUNT_DISABLED(303, FORBIDDEN, "Account Disabled"),
    BAD_CREDENTIALS(304, BAD_REQUEST, "Login and/or password is incorrect"),
    ;

    private final int code;
    private final HttpStatus httpStatus;
    private final String description;
}

