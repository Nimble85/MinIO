def ga = "git add .".execute()
def b = new StringBuffer()
ga.consumeProcessErrorStream(b)

println ga.text
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




/*
    git add cocolab_pre
    git config user.name 'jenkins'
    git config user.email 'jenkins@comparus.eu'
    git commit --allow-empty -am 'jenkins ${JOB_NAME}-${BUILD_NUMBER}'
    git tag -m "${BUILD_URL}" b"${BUILD_NUMBER}"
    git pull --rebase origin master
    git push --tags origin master   || \
                            git pull --rebase origin master || \
                            git push --tags origin master   || \
                            git pull --rebase origin master || \
                            git push --tags origin master
*/
