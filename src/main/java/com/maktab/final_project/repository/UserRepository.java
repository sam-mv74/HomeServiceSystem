package com.maktab.final_project.repository;


import com.maktab.final_project.base.repository.BaseRepository;
import com.maktab.final_project.model.User;

public interface UserRepository <T extends User> extends BaseRepository<T, Long> {
    T findByUsername(String username);
    T findByUserNameAndPassword(String username, String password);
}
