
// vars/reusableFunctions.groovy

def reusableSetupPythonEnv(String pythonVersion) {
    
    echo "Python ${pythonVersion} environment set up successfully!"
}

def reusableInstallGoogleChrome() {
    
    echo "Google Chrome installed successfully!"
}

def reusableInstallDependencies(String requirementsFile) {
    
    echo "Dependencies from ${requirementsFile} installed successfully!"
}

def reusableSendNotification(String status) {
    
    echo "Notification sent for ${status}."
}






// def call(script) {
//     script.stage('Reusable Workflow') {
//         script.echo 'Reusable Workflow: Executing shared library stage.'
//     }
// }




// def call(Map params = [:]) {
//     pipeline {
//         agent any
//         stages {
//             stage('Checkout Code') {
//                 steps {
//                     echo 'Checking out code...'
//                     // Add your code to check out the repository, if required
//                 }
//             }

//             stage('Run Workflow') {
//                 steps {
//                     echo "Running stage: ${params.stage ?: 'Default Stage'}"
//                     // You can add additional logic for this stage as needed
//                 }
//             }

//             stage('Install Google Chrome') {
//                 steps {
//                     echo 'Installing Google Chrome...'
//                     // Here, you would add your logic for installing Chrome
//                 }
//             }

//             stage('Install Dependencies') {
//                 steps {
//                     echo 'Installing dependencies...'
//                     // Add commands for dependency installation here
//                 }
//             }
//         }

//         post {
//             failure {
//                 emailext(
//                     to: params.email ?: 'admin@example.com',
//                     subject: "Job '${env.JOB_NAME}' (${env.BUILD_NUMBER}) Failed",
//                     body: """<p>Job '${env.JOB_NAME}' (${env.BUILD_NUMBER}) failed.</p>
//                              <p>Check console output at <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
//                     mimeType: 'text/html'
//                 )
//             }
//         }
//     }
// }
