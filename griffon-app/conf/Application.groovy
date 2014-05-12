application {
    title = 'AsistantGuiTest'
    startupGroups = ['mainFrame']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "mainFrame"
    'mainFrame' {
        model = 'asistantguitest.MainFrameModel'
        view = 'asistantguitest.MainFrameView'
        controller = 'asistantguitest.MainFrameController'
    }

    // MVC Group for "asistantGuiTest"
    'asistantGuiTest' {
        model      = 'asistantguitest.AsistantGuiTestModel'
        view       = 'asistantguitest.AsistantGuiTestView'
        controller = 'asistantguitest.AsistantGuiTestController'
    }

}
