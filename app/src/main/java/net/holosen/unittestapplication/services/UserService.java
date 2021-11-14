package net.holosen.unittestapplication.services;

import net.holosen.unittestapplication.models.User;

public class UserService {

    public static boolean checkUserPass(User data) {
        if (data == null) return false;
        if (data.getUsername() == null ||
                data.getPassword() == null ||
                data.getRepeatedPassword() == null)
            return false;
        if (data.getUsername().equals("") ||
                data.getPassword().equals("") ||
                data.getRepeatedPassword().equals(""))
            return false;
        if (!data.getPassword().equals(data.getRepeatedPassword()))
            return false;
        return true;
    }
}
