package common;

import models.Users;

public class UserHelper {
    public static Integer getUserId(Users[] userResponse){
        return userResponse[0].getId();
    }

}
