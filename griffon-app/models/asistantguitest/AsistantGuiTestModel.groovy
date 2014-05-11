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