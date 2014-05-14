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

import grails.persistence.Entity

/**
 * Created by mirek on 11.5.14.
 */
@Entity
class Judge {

    static hasMany = [entries: Entry]
    static mappedBy = [entries: 'judge']

    String name

    static mapping = {
        entries lazy: false
    }

}
