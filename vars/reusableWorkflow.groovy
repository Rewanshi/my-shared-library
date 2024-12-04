// // Reusable function for setting up Python environment
// def setupPythonEnvironment() {
//     sh '''
//         sudo apt-get -y install python3.10-full
//         sudo python3 -m venv venv
//         . venv/bin/activate
//     '''
//     echo "Python environment has been successfully set up."
// }

// Reusable function for setting up Python environment
def setupPythonEnvironment() {
    sh '''
        sudo apt-get update
        sudo apt-get -y install software-properties-common
        sudo add-apt-repository -y ppa:deadsnakes/ppa
        sudo apt-get update
        sudo apt-get -y install python3.10 python3.10-venv python3.10-distutils
        python3.10 -m venv venv
        . venv/bin/activate
    '''
    echo "Python environment with Python 3.10 has been successfully set up."
}


// Reusable function for installing Google Chrome
def installGoogleChrome() {
    sh '''
        sudo apt-get update
        sudo apt-get install -y wget
        wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
        sudo apt install -y --allow-downgrades ./google-chrome-stable_current_amd64.deb
    '''
    echo "Google Chrome has been successfully installed."
}

// node {
//     stage('Checkout') {
//         checkout scm  // Ensure the repo is checked out correctly
//         sh 'echo "List of files in the current directory:"'
//         sh 'ls -al'    // List the files after checkout to verify requirements.txt is present
//     }

//     stage('Install Dependencies') {
//         echo 'Installing required dependencies...'
        
//         // Check if requirements.txt exists before proceeding
//         sh '''#!/bin/bash
//         if [ -f "requirements.txt" ]; then
//             echo "Found requirements.txt, proceeding with installation."
//             python3 -m venv venv  # Create a virtual environment named 'venv'
//             source venv/bin/activate  # Activate the virtual environment
//             pip install --upgrade pip  # Upgrade pip inside the virtual environment
//             pip install --upgrade -r requirements.txt  # Install dependencies from requirements.txt
//         else
//             echo "ERROR: requirements.txt not found in the current directory."
//             exit 1  # Exit if requirements.txt is not found
//         fi
//         '''
//     }

//     stage('Fetch Secrets and Processing') {
//         echo "Fetching secrets and performing processing... Message: Hello from Jenkins Pipeline!"
//     }
// }


// // Reusable function for installing dependencies in a virtual environment
// def installDependencies() {
//     try {
//         // Debugging: Print the current working directory
//         sh '''#!/bin/bash
//         echo "Current directory:"
//         pwd  # Print the current working directory
//         echo "Listing all files:"
//         ls -al  # List all files in the current directory
//         echo "Searching for requirements.txt in the current directory and subdirectories:"
//         find . -name "requirements.txt"  # Search for requirements.txt
//         '''
        
//         // Check if requirements.txt exists before installing
//         sh '''#!/bin/bash
//         if [ -f "requirements.txt" ]; then
//             echo "Found requirements.txt, proceeding with installation."
//             python3 -m venv venv  # Create a virtual environment named 'venv'
//             source venv/bin/activate  # Activate the virtual environment
//             pip install --upgrade pip  # Upgrade pip inside the virtual environment
//             pip install --upgrade -r requirements.txt  # Install dependencies from requirements.txt
//         else
//             echo "ERROR: requirements.txt not found in the current directory."
//             exit 1  # Exit if requirements.txt is not found
//         fi
//         '''
        
//         echo "Dependencies have been successfully installed in the virtual environment."
//     } catch (Exception e) {
//         echo "Error while installing dependencies: ${e.message}"
//         currentBuild.result = 'FAILURE'
//     }
// }


// // Reusable function for installing dependencies in a virtual environment
// def installDependencies() {
//     try {
//         // Debugging: List files recursively to check where requirements.txt is located
//         sh '''#!/bin/bash
//         echo "Listing all files recursively to check for requirements.txt:"
//         find . -name "requirements.txt"  # Look for requirements.txt in the current directory and subdirectories
//         '''

//         // Check if requirements.txt exists before installing
//         sh '''#!/bin/bash
//         if [ -f "requirements.txt" ]; then
//             echo "Found requirements.txt, proceeding with installation."
//             python3 -m venv venv  # Create a virtual environment named 'venv'
//             source venv/bin/activate  # Activate the virtual environment
//             pip install --upgrade pip  # Upgrade pip inside the virtual environment
//             pip install --upgrade -r requirements.txt  # Install dependencies from requirements.txt
//         else
//             echo "ERROR: requirements.txt not found in the current directory."
//             exit 1  # Exit if requirements.txt is not found
//         fi
//         '''
        
//         echo "Dependencies have been successfully installed in the virtual environment."
//     } catch (Exception e) {
//         echo "Error while installing dependencies: ${e.message}"
//         currentBuild.result = 'FAILURE'
//     }
// }


// // Reusable function for installing dependencies in a virtual environment
// def installDependencies() {
//     try {
//         // Debugging: Check current directory and list files
//         sh '''#!/bin/bash
//         echo "Listing files in the current directory:"
//         ls -l
//         '''
        
//         // Create a virtual environment (if it doesn't already exist)
//         sh '''#!/bin/bash
//         python3 -m venv venv  # Creates a virtual environment named 'venv'
//         '''
        
//         // Check if requirements.txt exists before installing
//         sh '''#!/bin/bash
//         if [ -f "requirements.txt" ]; then
//             echo "Found requirements.txt, proceeding with installation."
//             source venv/bin/activate
//             pip install --upgrade pip  # Upgrade pip inside the virtual environment
//             pip install --upgrade -r requirements.txt  # Install dependencies from requirements.txt
//         else
//             echo "ERROR: requirements.txt not found in the current directory."
//             exit 1  # Exit if requirements.txt is not found
//         fi
//         '''
        
//         echo "Dependencies have been successfully installed in the virtual environment."
//     } catch (Exception e) {
//         echo "Error while installing dependencies: ${e.message}"
//         currentBuild.result = 'FAILURE'
//     }
// }


// // Reusable function for installing dependencies in a virtual environment
// def installDependencies() {
//     try {
//         // Create a virtual environment (if it doesn't already exist)
//         sh '''#!/bin/bash
//         python3 -m venv venv  # Creates a virtual environment named 'venv'
//         '''

//         // Install dependencies into the virtual environment
//         sh '''#!/bin/bash
//         # Activate the virtual environment and install dependencies
//         source venv/bin/activate
//         pip install --upgrade pip  # Upgrade pip inside the virtual environment
//         pip install --upgrade -r requirements.txt  # Install dependencies from requirements.txt
//         '''

//         echo "Dependencies have been successfully installed in the virtual environment."
//     } catch (Exception e) {
//         echo "Error while installing dependencies: ${e.message}"
//         currentBuild.result = 'FAILURE'
//     }
// }


// // Reusable function for installing dependencies in a virtual environment
// def installDependencies() {
//     try {
//         // Create a Python virtual environment (if it doesn't already exist)
//         sh '''#!/bin/bash
//         python3 -m venv venv  # Creates a virtual environment named 'venv'
//         '''

//         // Activate the virtual environment and install dependencies
//         sh '''#!/bin/bash
//         source venv/bin/activate  # Activates the virtual environment
//         pip install --upgrade -r requirements.txt  # Install dependencies from requirements.txt
//         '''

//         echo "Dependencies have been successfully installed in the virtual environment."
//     } catch (Exception e) {
//         echo "Error while installing dependencies: ${e.message}"
//         currentBuild.result = 'FAILURE'
//     }
// }


// // Reusable function for installing dependencies
// def installDependencies() {
//     try {
//         // Ensure the package list is up to date
//         sh '''#!/bin/bash
//         sudo apt-get update -y
//         sudo apt-get install -y python3-pip
//         '''
        
//         // Install dependencies from requirements.txt using pip3
//         sh '''#!/bin/bash
//         sudo pip3 install --upgrade -r requirements.txt
//         '''

//         echo "Dependencies have been successfully installed."
//     } catch (Exception e) {
//         echo "Error while installing dependencies: ${e.message}"
//         currentBuild.result = 'FAILURE'
//     }
// }


// // Reusable function for installing dependencies
// def installDependencies() {
//     sh '''
//         sudo apt-get update
//         sudo apt-get -y install python3-pip
//         sudo pip install -r requirements.txt
//     '''
//     echo "Dependencies have been successfully installed."
// }


// main pipeline script

def call(String message) {
    pipeline {
        agent any

        stages {
            stage('Checkout Code') {
                steps {
                    echo "Checking out the repository... Message: ${message}"
                }
            }

            stage('Setup Python Environment') {
                steps {
                    setupPythonEnvironment()     // Call the reusable Python setup function
                    echo "Setting up Python environment... Message: ${message}"
                }
            }            

            stage('Install Google Chrome') {
                steps {
                    installGoogleChrome()        // Call the reusable function
                    echo "Installing Google Chrome... Message: ${message}"
                }
            }

            stage('Install Dependencies') {
                steps {
                    echo "Installing required dependencies... Message: ${message}"
                }
            }

            stage('Fetch Secrets and Processing') {
                steps {
                    echo "Fetching secrets and performing processing... Message: ${message}"
                }
            }
        }
    }
}









// def call() {
//     pipeline {
//         agent any

//         stages {
//             stage('Checkout Code') {
//                 steps {
//                     echo "Checking out the repository..."
//                 }
//             }

//             stage('Setup Python Environment') {
//                 steps {
//                     echo "Setting up Python environment..."
//                 }
//             }

//             stage('Install Google Chrome') {
//                 steps {
//                     echo "Installing Google Chrome..."
//                 }
//             }

//             stage('Install Dependencies') {
//                 steps {
//                     echo "Installing required dependencies..."
//                 }
//             }

//             stage('Fetch Secrets and Processing') {
//                 steps {
//                     echo "Fetching secrets and performing processing..."
//                 }
//             }
//         }
//     }
// }









// // vars/reusableWorkflow.groovy

// // Main pipeline execution
// def runPipeline() {
//     checkoutCdc()
//     setupPythonEnvironment()
//     installGoogleChrome()
//     installDependencies()
//     fetchSecretsAndProcessing()
// }

// // Stage: Checkout CDC
// def checkoutCdc() {
//     stage('Checkout CDC') {
//         echo "Checking out CDC code..."
//     }
// }

//  //Stage: Setup Python Environment
//  def setupPythonEnvironment() {
//     stage('Setup Python Environment') {


//         sh "echo 'Rew@nshi_jenkins' ' | sudo su -S "
//         sh 'apt-get -y install python3.10-full'
//         sh 'python3 -m venv venv'
//          sh '. venv/bin/activate'
//     }
// }

// // Stage: Install Google Chrome
// def installGoogleChrome() {
//     stage('Install Google Chrome') {
//         sh '''
//         sudo apt-get update
//         sudo apt-get install -y wget
//         wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
//         sudo apt install -y --allow-downgrades ./google-chrome-stable_current_amd64.deb
//         '''
//     }
// }

// // Stage: Install Dependencies
// def installDependencies() {
//     stage('Install Dependencies') {
//         sh 'sudo apt-get -y install python3-pip'
//         sh 'sudo pip install -r requirements.txt'
//     }
// }

// // Stage: Fetch Secrets and Processing
// def fetchSecretsAndProcessing() {
//     stage('Fetch Secrets and Processing') {
//         // Azure Key Vault logic
//         echo "Fetching secrets using Azure Key Vault..."

//         script {
//             def result = 0
//             catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
//                 dir('bots') {
//                     result = sh(script: '''#!/bin/bash
//                     export PYTHONPATH="$WORKSPACE"
//                     echo "python script running"
//                     ''', returnStatus: true)

//                     // Handle exit codes
//                     if (result == 1) {
//                         echo "Error: Failed to login into Brightree with exit code 1"
//                         emailext attachLog: false, attachmentsPattern: '', body: '''<p>Hi,</p>
//                         <p>Bot is not executing as expected. Kindly, check.</p>
//                         <p>Regards,<br>
//                         Intelera Bot</p>''', subject: 'MSC Stop Billing Bot Issue', to: 'rewanshichourasiya.v@gmail.com'
//                     } else if (result == 2) {
//                         echo "No record found with exit code 2"
//                     }
//                 }

//                 if (result == 0) {
//                     emailext attachLog: false, attachmentsPattern: 'reports/MSC_Claim_Denial_Bot_Report.xlsx', body: '''<p>Hi,</p>
//                     <p>Please find attached MSC claim denial Bot report.</p>
//                     <p>Regards,<br>
//                     Sohaib</p>''', subject: 'Claim Denial Bot Report', to: 'rewanshichourasiya.v@gmail.com'
//                 }
//             }
//         }
//     }
// }





















// vars/reusableFunctions.groovy

// def reusableSetupPythonEnv(String pythonVersion) {
    
//     echo "Python ${pythonVersion} environment set up successfully!"
// }

// def reusableInstallGoogleChrome() {
    
//     echo "Google Chrome installed successfully!"
// }

// def reusableInstallDependencies(String requirementsFile) {
    
//     echo "Dependencies from ${requirementsFile} installed successfully!"
// }

// def reusableSendNotification(String status) {
    
//    echo "Notification sent for ${status}."
// }






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
