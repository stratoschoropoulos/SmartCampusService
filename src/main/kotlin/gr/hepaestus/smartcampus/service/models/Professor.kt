package gr.hepaestus.smartcampus.service.models

import com.fasterxml.jackson.annotation.JsonIdentityReference
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID


@Entity
class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : UUID? = null

    var name: String? = null

    var lastName: String? = null

    var am: String? = null

    var email: String? = null

    var site: String? = null



    @OneToOne(mappedBy = "professor", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIdentityReference(alwaysAsId = true)
    var auditorium: Auditorium? = null


    var created : LocalDateTime? = null

    var updated : LocalDateTime? = null

    @PrePersist
    fun prePersist() {
        created = LocalDateTime.now()
        updated = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpdate() {
        updated = LocalDateTime.now()
    }

    override fun toString(): String {
        return "Professor(id=$id, name=$name, lastName=$lastName, am=$am, email=$email, site=$site, created=$created, updated=$updated)"
    }


}