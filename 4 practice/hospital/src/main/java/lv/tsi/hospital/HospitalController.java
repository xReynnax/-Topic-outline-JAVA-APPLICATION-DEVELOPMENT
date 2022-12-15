package lv.tsi.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/hospital"})
public class HospitalController {
    private final HospitalRepository repository;

    @Autowired
    public HospitalController(HospitalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Iterable<Hospital>> findPatients() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Hospital> findPatient(@PathVariable("id") Long id) {
        return ResponseEntity.of(this.repository.findById(id));
    }
}
