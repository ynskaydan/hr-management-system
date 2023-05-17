package com.tech1.personelmanagementsystem.Business.concretes;

import com.tech1.personelmanagementsystem.Business.abstracts.UserService;
import com.tech1.personelmanagementsystem.Core.DataAccess.UserDao;
import com.tech1.personelmanagementsystem.Core.Entities.User;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.DataResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result Add(User user) {
        userDao.save(user);
        return new SuccessResult("User Added");
    }
    public Result Delete(User user){
        String message = "User Deleted: " + user.getEmail();
        userDao.delete(user);
        return new SuccessResult(message);
    }

    @Override
    public Result Update(User user) {
        return null;
    }


    private boolean checkUserExist(User user) {
        User userToFind = userDao.findByUsername(user.getUsername());
        if (userToFind == null){
            return false;
        }
        return true;
    }

    @Override
    public DataResult<User> checkUserExistByUsernamePassword(String username, String password) {
        return null;
    }

    @Override
    public DataResult<User> checkUserExistByUsernameEmail(String email, String password) {
        return null;
    }



    @Override
    public DataResult<User> findByUsername(String username) {
        return null;
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email)
                ,"Kullanıcı bulundu");
    }
}
