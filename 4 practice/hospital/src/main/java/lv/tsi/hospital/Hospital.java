package lv.tsi.hospital;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hospital {
    @Id
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("blood_type")
    private String blood_type;
    @JsonProperty("visits")
    private int visits;

    public Hospital() {
    }
}
