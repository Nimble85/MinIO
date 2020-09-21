def ga = "git add test".execute()
//def gcn = "git config user.name 'Nimble85'"
//def gce = "git config user.email 'klimoshenko85@gmail.com'"
def gc = "git commit -ma"
def b = new StringBuffer()
def c = new StringBuffer()
ga.consumeProcessErrorStream(b)
gc.consumeProcessErrorStream(c)
//gcn.consumeProcessErrorStream(b)
//gce.consumeProcessErrorStream(b)
println ga.text
//println gcn.text
//println gce.text
println b.toString()


/*
def getGitCommit() {
    git_commit = sh (
            script: 'git rev-parse HEAD',
            returnStdout: true
    ).trim()
    return git_commit
}
*/





sshagent(['2456b422-7e08-4c76-aebb-3281647cdd14']) {
    sh """
    git add cocolab_pre
    git config user.name 'jenkins'
    git config user.email 'jenkins@comparus.eu'
    git commit --allow-empty -am 'jenkins ${JOB_NAME}-${BUILD_NUMBER}'
    git tag -m "${BUILD_URL}" b"${BUILD_NUMBER}"
    git pull --rebase origin master
   """
    sh git push --tags origin master   || \
                            git pull --rebase origin master || \
                            git push --tags origin master   || \
                            git pull --rebase origin master || \
                            git push --tags origin master

    try {
        sh "git push --tags origin master"
    } catch (err) {
        sh "git pull --rebase origin master"
    }

    List<String> sourceChanged = sh(returnStdout: true, script: "git push --tags origin master").split()
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
