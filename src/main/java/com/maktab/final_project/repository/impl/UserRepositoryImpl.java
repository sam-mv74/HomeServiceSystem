package com.maktab.final_project.repository.impl;

import com.maktab.final_project.base.repository.impl.BaseRepositoryImpl;
import com.maktab.final_project.exception.EntityNotFoundException;
import com.maktab.final_project.model.User;
import com.maktab.final_project.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public abstract class UserRepositoryImpl<T extends User> extends BaseRepositoryImpl<T, Long> implements UserRepository<T> {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public T findByUsername(String username) {
        try {
            TypedQuery<T> query = entityManager.createQuery(
                    "SELECT u FROM "+getEntityClass().getSimpleName()+" u WHERE u.userName = :username", getEntityClass());
            query.setParameter("username", username);
            return query.getSingleResult();
        }catch (Exception e){
            throw new EntityNotFoundException("User Not Found With This Username",e);
        }
    }

    @Override
    public T findByUserNameAndPassword(String username, String password) {
        try {
            TypedQuery<T> query = entityManager.createQuery(
                    "SELECT u FROM "+getEntityClass().getSimpleName()+" u WHERE u.userName = :username AND u.password = :password", getEntityClass());
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();
        }catch (Exception e){
            throw new EntityNotFoundException("User Not Found With This Id",e);
        }
    }
}
