package ivanovvasil.u5d5w2Project.repositories;
import ivanovvasil.u5d5w2Project.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicesRepository extends JpaRepository<Device, Integer> {

}
