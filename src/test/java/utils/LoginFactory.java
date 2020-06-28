package utils;

import constants.AppConstants;
import utils.CRUD.User;

public class LoginFactory {
    public static User createValidLogin(){
        return new User(AppConstants.VALID_EMAIL, AppConstants.VALID_PASSWORD);
    }
    public static User createInvalidEmailLogin(){
        return new User("paulinha", AppConstants.VALID_PASSWORD);
    }
    public static User createEmptyEmailLogin(){
        return new User("", AppConstants.VALID_PASSWORD);
    }
}
