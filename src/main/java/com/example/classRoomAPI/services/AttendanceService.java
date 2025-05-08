package com.example.classRoomAPI.services;

import com.example.classRoomAPI.helper.APImessages;
import com.example.classRoomAPI.models.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.classRoomAPI.repository.IAttendanceRepository;

import java.util.List;
import java.util.Optional;


@Service
public class AttendanceService {
    @Autowired
    IAttendanceRepository repository;

    //metodo para guardar

    public Attendance saveAttendance(Attendance attendanceData) throws Exception{
        try {
            return this.repository.save(attendanceData);

        }catch (Exception error){
            throw  new Exception();
        }

    }

    public List<Attendance>attendanceList() throws Exception{
        try{
            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception();

        }
    }

    public Attendance searchAttendanceById(Integer id) throws Exception {
        try {
            Optional<Attendance> attendanceToSearchFor = this.repository.findById(id);
            if (attendanceToSearchFor.isPresent()) {
                return attendanceToSearchFor.get();
            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());// AQUI LLAMAMOS AL ENUM
            }

            //PROGRAMACION FUNCIONAL CON JAVA. VER LA FORMA DE HACERLO COMO OPERADOR TERNARIO
            //PULIR EN SPRINGBOOT

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    public Attendance modifyAttendance(Integer id, Attendance newDataAttendance) throws Exception {
        try {
            Optional<Attendance> attendanceSearchToEdit = this.repository.findById(id);
            if (attendanceSearchToEdit.isPresent()) {
                // I MODIFY THE PROFFESOR
                //aqui estoy abriendo toda la bosla con el get
                // uso el set para camnbiar y no puede ser el id
                attendanceSearchToEdit.get().setDOA(newDataAttendance.getDOA());// EN ESTE CASO ESTAMOS TRABAJANDO CON EL DATE OF ATTENDANCE.ELEGIR EL DATO CORRESPONDIENTE  E

                //HOW I KEEP THE NEW MODIFY INFO
                return this.repository.save(attendanceSearchToEdit.get());


            } else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //METODO PARA ELIMINAR
    public Boolean deleteAttendance(Integer id) throws Exception {
        try {

            Optional<Attendance> attendanceToSearch = this.repository.findById(id);
            if (attendanceToSearch.isPresent()) {
                //LO ELIMINO
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(APImessages.ERROR_PROFESSOR_NOT_FOUND.getMessage());
            }


        } catch (Exception error) {
            throw new Exception();

        }

    }

}
