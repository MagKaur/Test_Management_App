package Test_Management_App.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "test_task")
public class TestTask {

    //TODO dokończyc test task po dodaniu Binary
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTestTask;
    @Column(name = "test_task_name")
    private String testTaskName;
    @Temporal(TemporalType.DATE)
    @Column(name = "deadline")
    private Date deadline;
    @Enumerated(EnumType.STRING)
    @Column(name = "test_task_status")
    private TestTaskStatus testTaskStatus;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private UserEmployee idUserEmployee;

    @ManyToOne
    @JoinColumn(name = "id_binary")
    @JsonIgnore
    private Binary idBinary;
}
