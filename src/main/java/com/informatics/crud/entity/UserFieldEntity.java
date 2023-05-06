package com.informatics.crud.entity;



import com.informatics.crud.common.SportField;
import jakarta.persistence.*;
import java.io.Serializable;

/**
 * @author Ali Alavi
 */

@Entity
@Table(name = "user_field_entity")
public class UserFieldEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Enumerated
    @Column(name = "sport_field",nullable = false)
    private SportField sportField;




    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public SportField getSportField() {
        return sportField;
    }

    public void setSportField(SportField sportField) {
        this.sportField = sportField;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "UserFieldEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", sportField=" + sportField +
                '}';
    }
}
