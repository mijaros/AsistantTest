package asistantguitest

import ca.odell.glazedlists.gui.TableFormat
import ca.odell.glazedlists.swing.DefaultEventTableModel
import org.json.simple.JSONObject

/**
 * Main View script
 */
actions {
    action(id: 'startTablet',
            name: 'Spustit',
            closure: controller.startAction)
    action(id: 'testProperty',
            name: 'Pridej',
            closure: controller.testProperty)
}

private def genTableModel() {
    def columnNames = ['no', 'breed', 'ems', 'class',
            'sex', 'born', 'type', 'head',
            'eyes', 'ears', 'coat']
    return new DefaultEventTableModel<JSONObject>(model.jsons, [
            getColumnCount: { columnNames.size() },
            getColumnName: { int index -> columnNames[index] as String },
            getColumnValue: { object, index ->
                object.get(columnNames[index])
            }
    ] as TableFormat<JSONObject>)
}

private def genScndHalfTableModel() {
    def columnNames = ['tail',
            'condition', 'impress', 'comment',
            'mark', 'rank', 'biv', 'nomination',
            'note', 'title', 'reason']
    return new DefaultEventTableModel<JSONObject>(model.jsons, [
            getColumnCount: { columnNames.size() },
            getColumnName: { int index -> columnNames[index] as String },
            getColumnValue: { object, index ->
                object.get(columnNames[index])
            }
    ] as TableFormat<JSONObject>)
}

tabbedPane(tabGroup, selectedIndex: tabGroup.tabCount) {
    panel(title: 'The entries') {// add content here
        migLayout layoutConstraints: 'fill',
                rowConstraints: '[40%, grow 50][40%, grow 50][]',
                columnConstraints: '[grow]'
        scrollPane(constraints: 'grow, wrap') {
            table(id: 'AsistantTable', model: genTableModel()) {
            installTableComparatorChooser(source: model.jsons)
        }
    }
        scrollPane(constraints: 'grow, wrap') {
            table(id: 'AsistantTable2', model: genScndHalfTableModel()) {
                installTableComparatorChooser(source: model.jsons)
            }
        }
        panel(constraints: 'span') {
            migLayout(layoutConstraints: 'fill')

        button(startTablet)
        button(testProperty)
        }
    }
}
