#!groovy
pipeline {
    stages {
        stage('Check for CHANGELOG update') {
            when { expression { env.BRANCH_NAME != 'master' } }
            steps {
                script {
                    sshagent(['CREDENTIAL_NAME']) {
                        sh "git config --add remote.origin.fetch +refs/heads/master:refs/remotes/origin/master"
                        sh "git fetch --no-tags"
                        List<String> sourceChanged = sh(returnStdout: true, script: "git diff --name-only origin/master..origin/${env.BRANCH_NAME}").split()
                        def isSourceChanged = false
                        def isChangelogUpdated = false
                        for (int i = 0; i < sourceChanged.size(); i++) {
                            if (sourceChanged[i].contains("src")) {
                                isSourceChanged = true
                            }
                            if (sourceChanged[i].contains("CHANGELOG")) {
                                isChangelogUpdated = true
                            }
                        }
                        // Changelog not updated after changing source, fail build and notify
                        if (isSourceChanged && !isChangelogUpdated) {
                            error("Source files changed but CHANGELOG was not updated!")
                        }
                    }
                }
            }
            post {
                failure {
                    // post to Slack
                }
            }
        }
    }
}