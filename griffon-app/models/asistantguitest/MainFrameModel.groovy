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

    EventList<Entry> entries = new SortedList<>(new BasicEventList<Entry>(data: [new Entry(no: '12',
            described: new Cat(name: 'Kocicka'))]),
            { Entry a, Entry b -> a.no <=> b.no } as Comparator)
}