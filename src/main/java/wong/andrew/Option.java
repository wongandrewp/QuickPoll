package wong.andrew;

import javax.persistence.*;

/**
 * Created by andrewwong on 6/20/17.
 */
@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OPTION_ID")
    private long id;

    @Column(name = "OPTION_VALUE")
    private String value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
