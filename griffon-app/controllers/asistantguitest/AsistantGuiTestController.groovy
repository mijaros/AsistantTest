package asistantguitest

import ServerMultipleThreads.SocketThread
import org.json.simple.JSONObject
import util.ImplementationOfInterface

import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener


/**
 * The controller for manage of views actions and events
 *
 */
class AsistantGuiTestController {
    // these will be injected by Griffon
    def model
    def view

    private def socketThread = null

    @Override
    void mvcGroupInit(Map args) {

    }

    def startAction = { evt = null ->
        if (socketThread != null) return
        log.info 'Starting server'
        socketThread = new SocketThread([propertyChange: { PropertyChangeEvent e ->
            log.info "New json obtained ${e.newValue.get('no')}"
            execInsideUIAsync {
                model.jsons.add e.newValue
            }
        }
        ] as PropertyChangeListener, new ImplementationOfInterface())
        socketThread.start()
    }

    def testProperty = { evt = null ->
        JSONObject o = new JSONObject(['no': '123', 'breed': 'PER',
                'mark': 'Excellent', 'rank': '1', 'note': 'nic'])
        execInsideUIAsync {
            model.jsons.add(o)
        }
    }
}
