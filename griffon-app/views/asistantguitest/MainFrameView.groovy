package asistantguitest

import asistantguitest.domain.Entry
import asistantguitest.domain.Judge
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.gui.TableFormat
import ca.odell.glazedlists.gui.WritableTableFormat
import ca.odell.glazedlists.swing.DefaultEventTableModel


import javax.swing.JComboBox

actions {

}

application(title: 'asistantGuiTest',
        preferredSize: [320, 240],
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
                migLayout(layoutConstraints: 'fill')

            }
            panel(border: titledBorder(title: 'Judge'), constraints: 'grow, wrap')
            scrollPane(constraints: 'grow') {
                table(id: 'noo') {
                    tableFormat = defaultTableFormat(columnNames: ['name',
                            'breed', 'ems', 'sex', 'born'])
                    eventTableModel(source: model.cats, format: tableFormat)
                }
            }
            scrollPane(constraints: 'grow, wrap') {
                table(id: 'noo2') {
                    tableFormat = defaultTableFormat(columnNames: ['name'])
                    eventTableModel(source: model.judges, format: tableFormat)
                }
            }

            scrollPane(constraints: 'span, grow, wrap') {
                table(id: 'yess') {
                    def cols = ['No', 'Name', 'Class', 'Judge']
                    def vars = ['no', 'described', 'catClass', 'judge']
                    def subVars = ['described': 'name']
                    tableF =
                            [
                                    getColumnCount: { -> cols.size() },
                                    getColumnName: { i -> cols[i] },
                                    getColumnValue: { o, i ->
                                        if (subVars.containsKey(vars[i])) {
                                            o."${vars[i]}"."${subVars[vars[i]]}"
                                        } else o."${vars[i]}"

                                    },
                                    isEditable: { i -> return !(i < 0 || i == 1) },
                                    setColumnValue: { o, c, i ->
                                        def y = model.entries.find { it.id = o.id }
                                        y.putAt(vars[i], c)
                                    },
                                    getColumnClass: { i ->
                                        if (i == 3) JComboBox.class
                                        else String
                                    }
                            ] as WritableTableFormat
                    eventTableModel(source: model.entries, format: tableF)

                }

            }
            panel(constraints: 'growx, span') {
                migLayout(layoutConstraints: 'rtl, fill', columnConstraints: '[][][grow]')
                button text: 'e'
                button text: 'ehlo'
            }

        }
    }
}
