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

    action(saveAction, name: 'Save')
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
            button(saveAction)
        }
    }
}
