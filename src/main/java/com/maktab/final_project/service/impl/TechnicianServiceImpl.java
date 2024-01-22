package com.maktab.final_project.service.impl;

import com.maktab.final_project.dto.TechnicianRegistrationDTO;
import com.maktab.final_project.exception.InvalidRegistrationDetailsException;
import com.maktab.final_project.exception.ServiceException;
import com.maktab.final_project.model.Technician;
import com.maktab.final_project.model.enumeration.TechnicianStatus;
import com.maktab.final_project.repository.TechnicianRepository;
import com.maktab.final_project.service.TechnicianService;
import com.maktab.final_project.validation.TechnicianRegistrationDetailsValidation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TechnicianServiceImpl extends UserServiceImpl<Technician, TechnicianRepository> implements TechnicianService {
    public TechnicianServiceImpl(TechnicianRepository repository) {
        super(repository);
    }
    @Override
    public void registerTechnician(TechnicianRegistrationDTO technicianRegistrationDTO) {
        try {
            boolean isValid = TechnicianRegistrationDetailsValidation.validateAllTechnicianDetails(technicianRegistrationDTO);
            if (isValid) {
                Technician technician = new Technician();
                technician.setFirstName(technicianRegistrationDTO.getFirstname());
                technician.setLastName(technicianRegistrationDTO.getLastname());
                technician.setUserName(technicianRegistrationDTO.getLastname());
                technician.setPassword(technicianRegistrationDTO.getPassword());
                technician.setEmail(technicianRegistrationDTO.getEmail());
                technician.setPersonalPhoto(convertToByte(technicianRegistrationDTO.getPhotoFilePath()));
                technician.setSelectedSubServiceList(technicianRegistrationDTO.getSubServices());
                repository.saveOrUpdate(technician);}
        }catch (InvalidRegistrationDetailsException e){
            throw new ServiceException("Error While Registering Technician ",e);
        }

    }

    @Override
    public List<Technician> findByStatus(TechnicianStatus technicianStatus) {
        return repository.findByStatus(technicianStatus);
    }

    @Override
    public void downloadImage(Long id) {
        Technician technician = repository.findById(id);
        byte[] personalPhoto = technician.getPersonalPhoto();
        try {
            FileOutputStream outputStream = new FileOutputStream("F:\\Maktab\\FinalProject\\downloadTest\\downloadedImage.jpg");
            outputStream.write(personalPhoto);
            outputStream.close();
        } catch (IOException e) {
            throw new ServiceException("Error While Downloading Image",e);
        }
    }

    public byte[] convertToByte(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.readAllBytes(path);
        } catch (IOException e) {
            throw new ServiceException("Error While Uploading Image");
        }
    }
}
