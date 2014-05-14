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

import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.SortedList
import groovy.beans.Bindable
import org.json.simple.JSONObject

/**
 * Model of main view
 */
class AsistantGuiTestModel {

    EventList<JSONObject> jsons = new SortedList<JSONObject>(new BasicEventList<JSONObject>(),
            { JSONObject a, JSONObject b -> a.get('no') <=> b.get('no') } as Comparator)

}