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

import asistantguitest.domain.Judge
import ca.odell.glazedlists.swing.DefaultEventComboBoxModel
import util.WritableAdvancedTableFormat

import javax.swing.DefaultCellEditor
import javax.swing.JComboBox
import javax.swing.JList
import javax.swing.plaf.basic.BasicComboBoxRenderer
import java.awt.Component


actions {
    action(addCatAction, name: 'Add')
    action(addJudgeAction, name: 'Add')
    action(generateEntriesAction, name: 'Generate all')
    action(startTabletAction, name: 'Start tablet')
    action(saveAllAction, name: 'Save entries')
    action(deleteAllEntriesAction, name: 'Delete all entries')
    action(deleteJudgesAction, name: 'Delete')
    action(deleteCatsAction, name: 'Delete')
}

application(title: 'asistantGuiTest',
        preferredSize: [1024, 256 * 3],
        pack: true,
        //location: [50,50],
        locationByPlatform: true,
        iconImage: imageIcon('/griffon-icon-48x48.png').image,
        iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                imageIcon('/griffon-icon-32x32.png').image,
                imageIcon('/griffon-icon-16x16.png').image]) {
    // add content here

    tabbedPane(id: 'MainTabbedPane') {
        panel(title: 'Main Content') {
            migLayout(layoutConstraints: 'fill', columnConstraints: '[70%, grow][30%, grow]',
                    rowConstraints: '[30%, grow 33][30%, grow 33][30%, grow 33][]')
            panel(border: titledBorder(title: 'cat'), constraints: 'grow') {
                migLayout(layoutConstraints: 'fill', columnConstraints: '[][grow, fill][][grow, fill][][grow,fill]')
                label text: 'Name'
                textField(id: 'catsName')
                label text: 'Breed'
                textField(id: 'catsBreed')
                label text: 'Ems'
                textField(id: 'catsEms', constraints: 'wrap')
                label text: 'Sex'
                textField(id: 'catsSex')
                label text: 'Born'
                textField(id: 'catsBorn')
                button(addCatAction, constraints: 'skip 1')


            }
            panel(border: titledBorder(title: 'Judge'), constraints: 'grow, wrap') {
                migLayout(layoutConstraints: 'fill')
                label text: 'name', constraints: 'wrap'
                textField(id: 'judgeName', constraints: 'growx, wrap')
                button(addJudgeAction)
            }
            panel(constraints: 'grow') {
                migLayout(layoutConstraints: 'fill', rowConstraints: '[grow][]')

                scrollPane(constraints: 'grow, wrap') {
                    table(id: 'noo') {
                    tableFormat = defaultTableFormat(columnNames: ['name',
                            'breed', 'ems', 'sex', 'born'])
                    eventTableModel(source: model.cats, format: tableFormat)
                }
            }
                button deleteCatsAction
            }
            panel(constraints: 'grow, wrap') {
                migLayout(layoutConstraints: 'fill', rowConstraints: '[grow][]')
                scrollPane(constraints: 'grow, wrap') {
                table(id: 'noo2') {
                    tableFormat = defaultTableFormat(columnNames: ['name'])
                    eventTableModel(source: model.judges, format: tableFormat)
                }
            }
                button deleteJudgesAction
            }

            scrollPane(constraints: 'span, grow, wrap') {
                table(id: 'Entries')
                        {
                            def cols = ['No', 'Name', 'Class', 'Judge']
                            def vars = ['no', 'described', 'catClass', 'judge']
                            def subVars = ['described': 'name', 'judge': 'name']
                            tableF = [
                                    getColumnCount: { -> cols.size() },
                                    getColumnName: { i -> cols[i] },
                                    getColumnValue: { o, i ->
                                        if (subVars.containsKey(vars[i])) {
                                            o."${vars[i]}"?."${subVars[vars[i]]}"
                                        } else o."${vars[i]}"

                                    },
                                    isEditable: { e, i -> i != 1 },
                                    setColumnValue: { o, c, i ->
                                        o."${vars[i]}" = c
                                        return o
                                    },
                                    getColumnClass: { i ->
                                        if (i == 3) Judge.class
                                        else String
                                    }
                            ] as WritableAdvancedTableFormat
                            eventTableModel(source: model.entries, format: tableF)

                        }
                def x = new JComboBox(new DefaultEventComboBoxModel<Judge>(model.judges))
                x.setRenderer(new BasicComboBoxRenderer() {
                    @Override
                    public Component getListCellRendererComponent(
                            JList list,
                            Object value, int index,
                            boolean isSel, boolean cellFoc) {
                        super.getListCellRendererComponent(list, value, index, isSel, cellFoc)
                        if (index != -1) setText(value.name)
                        else setText('Judge')
                        return this
                    }
                })
                Entries.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(x))

            }
            panel(constraints: 'growx, span') {
                migLayout(layoutConstraints: 'rtl, fill', columnConstraints: '[][][][][grow]')
                button generateEntriesAction
                button startTabletAction
                button saveAllAction
                button deleteAllEntriesAction
            }

        }
    }
}
