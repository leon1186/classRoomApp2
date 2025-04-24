package services;



import com.example.classRoomAPI.helper.APImessages;
import com.example.classRoomAPI.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.IUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository repository;

    //metodo para guardar

        public User saveUser(User userData) throws Exception {
            try {
                return this.repository.save(userData);

            } catch (Exception error) {
                throw new Exception();
            }
        }


        public List<User>userList() throws Exception{
            try{
                return this.repository.findAll();

            }catch (Exception error){
                throw new Exception();

            }
        }


    public User searchUserById(Integer id) throws Exception {
        try {
            Optional<User> userToSearchFor = this.repository.findById(id);
            if (userToSearchFor.isPresent()) {
                return userToSearchFor.get();
            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage()); // AQUI LLAMAMOS AL ENUM
            }

            // PROGRAMACION FUNCIONAL CON JAVA. VER LA FORMA DE HACERLO COMO OPERADOR TERNARIO
            // PULIR EN SPRINGBOOT

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public User modifyUser(Integer id, User newDataUser) throws Exception {
        try {
            Optional<User> userSearchToEdit = this.repository.findById(id);
            if (userSearchToEdit.isPresent()) {
                // I MODIFY THE USER
                userSearchToEdit.get().setName(newDataUser.getName()); // ELEGIR EL DATO CORRESPONDIENTE

                // SAVE THE UPDATED USER
                return this.repository.save(userSearchToEdit.get());

            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // METODO PARA ELIMINAR
    public Boolean deleteUser(Integer id) throws Exception {
        try {
            Optional<User> userToSearch = this.repository.findById(id);
            if (userToSearch.isPresent()) {
                // DELETE USER
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }


}




