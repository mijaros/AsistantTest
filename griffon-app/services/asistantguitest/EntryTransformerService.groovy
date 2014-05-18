package asistantguitest

import asistantguitest.domain.Entry
import org.json.simple.JSONObject

class EntryTransformerService {
    // void serviceInit() {
    //    // this method is called after the model is instantiated
    // }

    // void serviceDestroy() {
    //    // this method is called when the service is destroyed
    // }

    def transform(JSONObject obj, Closure closure) {
        def names = ['coat', 'type', 'head', 'eyes', 'ears',
                'tail', 'condition', 'impress', 'comment',
                'mark', 'rank', 'reason', 'biv', 'nomination',
                'note', 'title']
        Entry toUp = Entry.findByNo(obj.get('no') as String)
        names.each { String s ->
            toUp."${s}" = obj.get(s);
        }
        closure(toUp)
    }


}
