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

// reusable function for installing dependencies 
def installDependencies() {
     sh 'sudo apt-get -y install python3-pip'
     sh 'sudo pip install -r requirements.txt'

     echo "install dependencies has been done successfully"
}



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
                    installDependencies()       //call the reusable function
                    echo "Installing required dependencies... Message: ${message}"
                }
            }

            stage('Fetch Secrets and Processing') {
                steps {
                    echo "Fetching secrets and performing processing... Message: ${message}"
                }
            }

            stage('Upload Logs to Azure Blog Storage') {
                steps {
                    echo "uploading logs to Azure blog storage... Message: ${message}"
                }
            }
            
        }
    }
}
















