package sh.nothing.android.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class AutoDebugSuffixPlugin implements Plugin<Project> {
    @Override
    void apply(Project target) {
        def extension = target.extensions.create("autoDebugSuffix", AutoDebugSuffixExtension)

        target.afterEvaluate {
            target.android {
                buildTypes {
                    debug {
                        applicationIdSuffix '.debug'
                        if (extension.updateVersionName) {
                            versionNameSuffix '-DEBUG'
                        }
                    }
                }
            }
        }
    }
}

