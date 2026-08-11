package model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends PanacheEntity {

    @Column(name = "first_name", nullable = false)
    public String firstName;

    @Column(name = "last_name", nullable = false)
    public String lastName;

    @Column(name = "email", nullable = false, unique = true)
    public String email;

    @Column(name = "address")
    public String address;

    @Column(name = "salary")
    public Double salary;
}
