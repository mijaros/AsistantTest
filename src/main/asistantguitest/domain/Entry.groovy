/*
 * Copyright 2014 Miroslav Jaros
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package asistantguitest.domain

/**
 * Created by mirek on 11.5.14.
 */
import grails.persistence.Entity

@Entity
class Entry {

    Judge judge

    Cat described

    String no

    String catClass

    String type

    String head

    String eyes

    String ears

    String coat

    String tail

    String condition

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
        judge nullable: true
        described nullable: true
        no nullable: true
        catClass nullable: true
        type nullable: true
        head nullable: true
        eyes nullable: true
        ears nullable: true
        coat nullable: true
        tail nullable: true
        condition nullable: true
        impress nullable: true
        comment nullable: true
        mark nullable: true
        rank nullable: true
        nomination nullable: true
        note nullable: true
        title nullable: true
        reason nullable: true
        biv nullable: true
    }

    static mapping = {
        described lazy: false
        judge lazy: false
    }

}
