package backend.project.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "opiniones")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User users;
}
