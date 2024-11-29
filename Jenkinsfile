@Library('my-shared-library') _

pipeline {
    agent any
    stages {
        stage('Run Reusable Workflow') {
            steps {
                script {
                    // Call the reusable workflow defined in the shared library
                    reusableWorkflow(stage: 'Install Google Chrome', email: 'user@example.com')
                }
            }
        }
    }
}
