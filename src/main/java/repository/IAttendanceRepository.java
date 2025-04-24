package repository;

import com.example.classRoomAPI.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance,Integer> {
}
