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

/*
 * This script is executed inside the UI thread, so be sure to  call 
 * long running code in another thread.
 *
 * You have the following options
 * - execOutsideUI { // your code }
 * - execFuture { // your code }
 * - Thread.start { // your code }
 *
 * You have the following options to run code again inside the UI thread
 * - execInsideUIAsync { // your code }
 * - execInsideUISync { // your code }
 */

import grails.orm.bootstrap.HibernateDatastoreSpringInitializer
import groovy.swing.SwingBuilder
import org.h2.Driver
import org.springframework.jdbc.datasource.DriverManagerDataSource

import static griffon.util.GriffonApplicationUtils.isMacOSX

SwingBuilder.lookAndFeel((isMacOSX ? 'system' : 'nimbus'), 'gtk', ['metal', [boldFonts: false]])

SplashGriffonAddon.display(app)


new Thread() {
    @Override
    public void start() {
        new HibernateDatastoreSpringInitializer('asistantguitest.domain').
                configureForDataSource(new DriverManagerDataSource(Driver.name,
                        "jdbc:h2:~/.asistant/asistantGui;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE", 'sa', ''))
    }
}
        .start()