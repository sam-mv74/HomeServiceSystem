package com.maktab.final_project.util;

import com.maktab.final_project.model.User;
import lombok.Getter;

import java.time.LocalDate;

public class SecurityContext {

    private SecurityContext() {
    }

    @Getter
    private static User currentUser;
    @Getter
    public static LocalDate currentDate;

    public static void fillUserContext(User user) {
        currentUser =user;
    }

    public static void fillDateContext(LocalDate date) {
        currentDate = date;
    }
}
