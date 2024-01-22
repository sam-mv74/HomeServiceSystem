package com.maktab.final_project.validation;

import com.maktab.final_project.dto.TechnicianRegistrationDTO;
import com.maktab.final_project.exception.InvalidRegistrationDetailsException;
import com.maktab.final_project.model.Technician;
import com.maktab.final_project.util.ApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TechnicianRegistrationDetailsValidation extends GlobalValidation {
    public static Boolean validateAllTechnicianDetails(TechnicianRegistrationDTO technicianRegistrationDTO) {

        String results = stringValidation(technicianRegistrationDTO.getFirstname()) + " " +
                stringValidation(technicianRegistrationDTO.getLastname()) + " " +
                emailValidation(technicianRegistrationDTO.getEmail()) + " " +
                passwordValidation(technicianRegistrationDTO.getPassword()) + " " +
                imageValidation(technicianRegistrationDTO.getPhotoFilePath());
        if (results.isBlank())
            throw new InvalidRegistrationDetailsException(results);
        return true;
    }
    public static String emailValidation(String input) {
        String result = "";
        if (!input.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            result = "Invalid Email Format";
        } else {
            List<Technician> users = ApplicationContext.getTechnicianService().findAll();
            boolean existEmail = users.stream()
                    .anyMatch(user -> user.getEmail() != null && user.getEmail().equals(input));
            if(existEmail)
                result = "Technician With This Email Already Exists";
        }
        return result;
    }

    public static String imageValidation(String input) {
        String result = "";
        Path path = Paths.get(input);
        long fileSize = 0;
        try {
            fileSize = Files.size(path);
            if (fileSize > 300 * 1024) {
                result = "Maximum Image Size Is 300 KB";
            } else {
                String type = Files.probeContentType(path);
                if (type == null || !type.equals("image/jpeg")) {
                    result = "Invalid Image Format";
                }
            }
        } catch (IOException e) {
            result = e.getMessage();
        }
        return result;
    }
}
