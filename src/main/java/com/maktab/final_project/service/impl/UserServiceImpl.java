package com.maktab.final_project.service.impl;


import com.maktab.final_project.base.service.impl.BaseServiceImpl;
import com.maktab.final_project.exception.InvalidRegistrationDetailsException;
import com.maktab.final_project.exception.ServiceException;
import com.maktab.final_project.exception.EntityNotFoundException;
import com.maktab.final_project.model.User;
import com.maktab.final_project.repository.UserRepository;
import com.maktab.final_project.service.UserService;
import com.maktab.final_project.validation.ClientRegistrationDetailsValidation;

public class UserServiceImpl<T extends User,R extends UserRepository<T>> extends BaseServiceImpl<T, Long, R> implements UserService<T> {

    public UserServiceImpl(R repository) {
        super(repository);
    }



    @Override
    public T findByUsername(String username) {
        try {
            return repository.findByUsername(username);
        } catch (EntityNotFoundException e) {
            throw new ServiceException("Error While Finding User By Username",e);
        }
    }

    @Override
    public void changePassword(String userName, String password, String newPassword) {
        try {
            User user = findByUserNameAndPassword(userName, password);
            if (user !=null){
                String result = ClientRegistrationDetailsValidation.passwordValidation(newPassword);
                if(result.isBlank()) {
                    user.setPassword(newPassword);
                    saveOrUpdate((T) user);
                }else {
                    throw new InvalidRegistrationDetailsException(result);
                }
            }
        } catch (EntityNotFoundException | InvalidRegistrationDetailsException e) {
            throw new ServiceException("Error While Changing Password",e);
        }
    }

    @Override
    public T findByUserNameAndPassword(String userName, String password) {
        try {
            return repository.findByUserNameAndPassword(userName, password);
        }catch (EntityNotFoundException e){
            throw new ServiceException("Error While Finding User By Username And Password ",e);
        }
    }
}
