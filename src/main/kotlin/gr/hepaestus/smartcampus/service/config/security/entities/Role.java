package gr.hepaestus.smartcampus.service.config.security.entities;

/*
 *
 *  @Code from GitHub repository :  https://github.com/xartokoptiko/spring-jwt-conf
 *
 */

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
