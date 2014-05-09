package asistantguitest

import ca.odell.glazedlists.gui.TableFormat
import ca.odell.glazedlists.swing.DefaultEventTableModel
import org.json.simple.JSONObject

actions {
    action(id: 'startTablet',
            name: 'Spustit',
            closure: controller.startAction)
    action(id: 'testProperty',
            name: 'Pridej',
            closure: controller.testProperty)
}

private def genTableModel() {
    def columnNames = ['no', 'breed', 'mark', 'rank', 'note']
    return new DefaultEventTableModel<JSONObject>(model.jsons, [
            getColumnCount: { columnNames.size() },
            getColumnName: { int index -> columnNames[index] as String },
            getColumnValue: { object, index ->
                object.get(columnNames[index])
            }
    ] as TableFormat<JSONObject>)
}

application(title: 'AsistantGuiTest',
        preferredSize: [480, 320],
        pack: true,
        //location: [50,50],
        locationByPlatform: true,
        iconImage: imageIcon('/griffon-icon-48x48.png').image,
        iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                imageIcon('/griffon-icon-32x32.png').image,
                imageIcon('/griffon-icon-16x16.png').image]) {
    // add content here
    borderLayout()
    scrollPane(constraints: CENTER) {
        table(id: 'AsistantTable', model: genTableModel()) {
            installTableComparatorChooser(source: model.jsons)
        }
    }
    panel(constraints: SOUTH) {
        migLayout(layoutConstraints: 'fill')

        button(startTablet)
        button(testProperty)
    }
}
