package google.gunwo3442.board_1113;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Board")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int board_id;

    @Column(length = 50,nullable = false)
    private String title;

    @Column(length = 50,nullable = false)
    private String user_id;

    @Column(length = 200,nullable = false)
    private String content;

    @Column(length = 20,nullable = false)
    private Date date;

}
