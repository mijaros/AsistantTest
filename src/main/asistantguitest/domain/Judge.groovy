package asistantguitest.domain

import grails.persistence.Entity

/**
 * Created by mirek on 11.5.14.
 */
@Entity
class Judge {

    static hasMany = [entries: Entry]
    static mappedBy = [entries: 'judge']

    String name


}
