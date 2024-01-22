package com.maktab.final_project.service;


import com.maktab.final_project.base.service.BaseService;
import com.maktab.final_project.model.User;

public interface UserService<T extends User> extends BaseService<T, Long> {
    User findByUsername(String username);
    void changePassword(String userName, String password,String newPassword);

    User findByUserNameAndPassword(String userName, String password);
}
