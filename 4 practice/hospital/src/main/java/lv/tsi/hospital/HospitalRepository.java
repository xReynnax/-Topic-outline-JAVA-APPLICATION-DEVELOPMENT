package lv.tsi.hospital;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface HospitalRepository extends CrudRepository<Hospital, Long> {
}
