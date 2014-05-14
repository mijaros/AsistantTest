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

package asistantguitest

import asistantguitest.domain.Cat
import asistantguitest.domain.Entry
import asistantguitest.domain.Judge
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.SortedList
import groovy.beans.Bindable

class MainFrameModel {
    // @Bindable String propName

    EventList<Cat> cats = new SortedList<>(new BasicEventList<Cat>(),
            { Cat a, Cat b -> a.id <=> b.id } as Comparator)

    EventList<Judge> judges = new SortedList<>(new BasicEventList<Judge>(),
            { Judge a, Judge b -> a.id <=> b.id } as Comparator)

    EventList<Entry> entries = new SortedList<>(new BasicEventList<Entry>(),
            { Entry a, Entry b -> a.no <=> b.no } as Comparator)
}