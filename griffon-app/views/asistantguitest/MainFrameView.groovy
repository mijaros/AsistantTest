package asistantguitest

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
                    rowConstraints: '[33%, grow][33%, grow][33%, grow]')
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
                table(id: 'yess')
            }
            panel(constraints: 'growx, span') {
                migLayout(layoutConstraints: 'rtl, fill', columnConstraints: '[][][grow]')
                button text: 'e'
                button text: 'ehlo'
            }

        }
    }
}
