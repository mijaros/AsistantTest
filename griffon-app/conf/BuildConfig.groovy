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

// key signing information
environments {
    development {
        signingkey {
            params {
                // sigfile = 'GRIFFON'
                // keystore = "${basedir}/griffon-app/conf/keys/devKeystore"
                // alias = 'development'
                storepass = 'BadStorePassword'
                keypass = 'BadKeyPassword'
                lazy = true // only sign when unsigned
            }
        }
    }
    test {
        griffon {
            jars {
                sign = false
                pack = false
            }
        }
    }
    production {
        signingkey {
            params {
                // NOTE: for production keys it is more secure to rely on key prompting
                // no value means we will prompt //storepass = 'BadStorePassword'
                // no value means we will prompt //keypass   = 'BadKeyPassword'
                lazy = true // sign, regardless of existing signatures
            }
        }

        griffon {
            jars {
                sign = false
                pack = true
                destDir = "${basedir}/staging"
            }
            webstart {
                codebase = 'CHANGE ME'
            }
        }
    }
}

griffon {
    memory {
        //max = '64m'
        //min = '2m'
        //minPermSize = '2m'
        //maxPermSize = '64m'
    }
    jars {
        sign = false
        pack = false
        destDir = "${basedir}/staging"
        jarName = "${appName}-${appVersion}.jar"
    }
    extensions {
        jarUrls = []
        jnlpUrls = []
        /*
        props {
            someProperty = 'someValue'
        }
        resources {
            linux { // windows, macosx, solaris
                jars = []
                nativelibs = []
                props {
                    someProperty = 'someValue'
                }
            }
        }
        */
    }
    webstart {
        codebase = "${new File(griffon.jars.destDir).toURI().toASCIIString()}"
        jnlp = 'application.jnlp'
    }
    applet {
        jnlp = 'applet.jnlp'
        html = 'applet.html'
    }
}

// required for custom environments
signingkey {
    params {
        def env = griffon.util.Environment.current.name
        sigfile = 'GRIFFON-' + env
        keystore = "${basedir}/griffon-app/conf/keys/${env}Keystore"
        alias = env
        // storepass = 'BadStorePassword'
        // keypass   = 'BadKeyPassword'
        lazy = true // only sign when unsigned
    }
}

griffon {
    doc {
        logo = '<a href="http://griffon-framework.org" target="_blank"><img alt="The Griffon Framework" src="../img/griffon.png" border="0"/></a>'
        sponsorLogo = "<br/>"
        footer = "<br/><br/>Made with Griffon (1.5.0)"
    }
}

deploy {
    application {
        title = "${appName} ${appVersion}"
        vendor = System.properties['user.name']
        homepage = "http://localhost/${appName}"
        description {
            complete = "${appName} ${appVersion}"
            oneline = "${appName} ${appVersion}"
            minimal = "${appName} ${appVersion}"
            tooltip = "${appName} ${appVersion}"
        }
        icon {
            'default' {
                name = 'griffon-icon-64x64.png'
                width = '64'
                height = '64'
            }
            splash {
                name = 'griffon.png'
                width = '391'
                height = '123'
            }
            selected {
                name = 'griffon-icon-64x64.png'
                width = '64'
                height = '64'
            }
            disabled {
                name = 'griffon-icon-64x64.png'
                width = '64'
                height = '64'
            }
            rollover {
                name = 'griffon-icon-64x64.png'
                width = '64'
                height = '64'
            }
            shortcut {
                name = 'griffon-icon-64x64.png'
                width = '64'
                height = '64'
            }
        }
    }
}

griffon.project.dependency.resolution = {
    // inherit Griffon' default dependencies
    inherits("global") {
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        griffonHome()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        mavenCentral()
        mavenRepo "http://snapshots.repository.codehaus.org"
        mavenRepo "http://repository.codehaus.org"
        mavenRepo "http://download.java.net/maven/2/"
        mavenRepo "http://repository.jboss.com/maven2/"
        mavenRepo "http://repo.spring.io/milestone"
        mavenRepo "http://repo.spring.io/release"
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
        //jcenter()
        //bintray(username: 'foo', repository: 'bar')
        //bintray('foo/bar')

    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime' or 'test' scopes eg.
        compile 'com.googlecode.json-simple:json-simple:1.1.1'
        runtime "org.grails:grails-datastore-gorm-hibernate4:3.0.0.RELEASE"
        runtime "org.grails:grails-spring:2.3.6"
        runtime "com.h2database:h2:1.3.164"
        compile "org.springframework:spring-expression:3.2.4.RELEASE"
        compile 'org.springframework:spring-core:3.2.7.RELEASE'
        // runtime 'mysql:mysql-connector-java:5.1.5'
    }
}

log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    error 'org.codehaus.griffon',
            'org.springframework',
            'org.apache.karaf',
            'groovyx.net'
    warn 'griffon'
}


app.fileType = '.groovy'
app.defaultPackageName = 'asistantguitest'
