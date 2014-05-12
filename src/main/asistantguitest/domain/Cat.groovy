package asistantguitest.domain

import grails.persistence.Entity

/**
 * Created by mirek on 11.5.14.
 */

@Entity
class Cat {

    String breed

    String name

    String ems

    String sex

    String born

    static constraints = {
        name nullable: false, unique: true, blank: false

    }
}
