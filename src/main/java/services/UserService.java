package services;


import com.example.classRoomAPI.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.IUserRepository;

@Service
public class UserService {
    @Autowired
    IUserRepository repository;

    //metodo para guardar

    public User saveUser(User userData) throws Exception{
        try {
            return this.repository.save(userData);

        }catch (Exception error){
            throw  new Exception();
        }

    }

}


