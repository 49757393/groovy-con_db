/*
 * This Spock specification was generated by the Gradle 'init' task.
 */
package con_db

import spock.lang.Specification

class AppTest extends Specification {
    def "application has a greeting"() {
        setup:
        def app = new App()

        when:
        def result = app.greeting

        then:
        result != null
    }
}
