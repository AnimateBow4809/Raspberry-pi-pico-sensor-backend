package animate.cn2test1.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.Instant;
import java.time.ZonedDateTime;

@Data
@Table(name = "data")
@Entity
public class MyData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "temp")
    private Float temp;

    @Column(name = "humidity")
    private Float humidity;

    @Column(name = "time")
    @CreationTimestamp(source = SourceType.DB)
    private ZonedDateTime time;
}
