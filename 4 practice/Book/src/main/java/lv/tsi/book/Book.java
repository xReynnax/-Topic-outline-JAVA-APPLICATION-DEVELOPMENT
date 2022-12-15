package lv.tsi.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Book {
    @Id
    @JsonProperty("id")
    private long id;
    @JsonProperty("author")
    private String author;
    @JsonProperty("name")
    private String name;
    @JsonProperty("times_published")
    private int times_published;

}
