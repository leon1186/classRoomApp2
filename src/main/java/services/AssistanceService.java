package services;

import com.example.classRoomAPI.models.Assistance;
import com.example.classRoomAPI.models.User;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IAssistanceRepository;
import repository.IUserRepository;

@Service
public class AssistanceService {
    @Autowired
    IAssistanceRepository repository;

    //metodo para guardar

    public Assistance saveAssistance(Assistance assistanceData) throws Exception{
        try {
            return this.repository.save(assistanceData);

        }catch (Exception error){
            throw  new Exception();
        }

    }
}
