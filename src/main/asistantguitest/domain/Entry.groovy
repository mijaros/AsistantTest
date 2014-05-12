package asistantguitest.domain

/**
 * Created by mirek on 11.5.14.
 */
import grails.persistence.Entity

@Entity
class Entry {


    Cat described

    String no

    String catClass

    String type

    String head

    String eyes

    String ears

    String coat

    String tail

    String condiditon

    String impress

    String comment

    String mark

    String rank

    String nomination

    String note

    String title

    String reason

    String biv

    static constraints = {
        no unique: true, nullable: false, blank: false
    }

}
