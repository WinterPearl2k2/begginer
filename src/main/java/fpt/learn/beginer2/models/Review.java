package fpt.learn.beginer2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "REIVEWS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    private String body;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonBackReference // Đặt tên cột khoá ngoại trong bảng review
    private Movie movie;
}
