package com.informatics.crud.entity;



import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Ali Alavi
 */

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private Long id;

    @Column(name = "name",length = 30,nullable = false)
    private String name;

    @Column(name = "family",length = 30,nullable = false)
    private String family;

    @Column(name = "age",nullable = true)
    private Integer age;

    @Column(name = "national_code",unique = true,length = 10,nullable = false)
    private String nationalCode;

    @Column(name = "create_date",nullable = false)
    private String createDate;

    @Column(name = "start_date",nullable = false)
    private String startDate;

    @Column(name = "exp_date",nullable = false)
    private String expDate;

    @Column(name = "gender",nullable = false)
    private Boolean gender;

    @Column(name = "status",nullable = false)
    private Boolean status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<UserFieldEntity> list;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<UserFieldEntity> getList() {
        return list;
    }

    public void setList(List<UserFieldEntity> list) {
        this.list = list;
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", nationalCode='" + nationalCode + '\'' +
                ", createDate='" + createDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", gender=" + gender +
                ", status=" + status +
                ", list=" + list +
                '}';
    }
}
