package com.MakerSharks.Apis.helpers;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordBcrypt {
    //method to hash password
    public static String hashPassword(String plainTextPassword){
        //generate salt and hash the password
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainTextPassword, String hashPassword){
        return BCrypt.checkpw(plainTextPassword, hashPassword);
    }
}
