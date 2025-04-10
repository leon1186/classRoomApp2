package services;

import com.example.classRoomAPI.models.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IRegistrationRepository;

@Service
public class RegistrationService {
    @Autowired
    IRegistrationRepository  repository;

    //metodo para guardar

    public Registration saveRegistration(Registration registrationData) throws Exception{
        try {
            return this.repository.save(registrationData);

        }catch (Exception error){
            throw  new Exception();
        }

    }
}
