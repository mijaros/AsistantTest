AsistantTest
============

Run of application:

`$./griffonw run-app`


Description
===========

The button `Spustit` will run the SocketThread.

When propertyChangeEvent is fired, the new row in table should appear, it's expected from `evt.newValue` to
be instance of `JSONObject` when some other kind of object will be obtained, this won't work.


Integrated with jenkins
