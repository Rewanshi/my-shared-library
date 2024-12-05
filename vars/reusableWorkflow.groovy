def call(String message) {
    pipeline {
        agent { label agentLabel }

        stages {
            stage('Checkout Code') {
                steps {
                    echo "Checking out the repository... Message: ${message}"
                }
            }

            stage('Setup Python Environment') {
                steps {
                    sh 'sudo apt-get -y install python3.10-full'
                    sh 'sudo python3 -m venv venv'
                    sh '. venv/bin/activate'
                
                    echo "Setting up Python environment... Message: ${message}"
                }
            }

            stage('Install Google Chrome') {
                steps {
                    sh '''
                        sudo apt-get install -y wget
                        wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
                        sudo apt install -y --allow-downgrades ./google-chrome-stable_current_amd64.deb
                    '''
                    echo "Installing Google Chrome... Message: ${message}"
                }
            }

            stage('Install Dependencies') {
                steps {
                    sh '''
                        sudo apt-get -y install python3-pip
                        sudo pip install -r requirements.txt
                    '''
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






// def setupPythonEnvironment() {
//     // sh '''
//     //     // sudo apt-get update
//     //     // sudo apt-get -y install python3.10 python3.10-venv python3.10-distutils
//     //     // python3.10 -m venv $WORKSPACE/venv
//     //     // . $WORKSPACE/venv/bin/activate
//     //     // pip install --upgrade pip
//     //     // if [ -f "requirements.txt" ]; then
//     //     //     pip install -r requirements.txt
//     //     // else
//     //     //     echo "requirements.txt not found."
//     //     // fi
//     //     sudo apt-get -y install python3.10-full
//     //     sudo python3 -m venv venv
//     //     . venv/bin/activate
//     // '''
//     echo "Python environment set up successfully."
// }

// def installGoogleChrome() {
//     sh '''
//         sudo apt-get install -y wget
//         wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
//         sudo apt install -y --allow-downgrades ./google-chrome-stable_current_amd64.deb
//     '''
//     echo "Google Chrome installed."
// }

// // Reusable function for installing dependencies
// def installDependencies() {
//     sh '''
//         sudo apt-get -y install python3-pip
//         sudo pip install -r requirements.txt
//     '''
//     echo "Dependencies installed successfully."
// }

// // Main reusable workflow
// def call(String message) {
//     pipeline {
//         agent any
//         stages {
//             stage('Setup Python Environment') {
//                 steps {
//                     setupPythonEnvironment()
//                 }
//             }

//             stage('Install Google Chrome') {
//                 steps {
//                     installGoogleChrome()
//                 }
//             }

//             stage('Install Dependencies') {
//                 steps {
//                     installDependencies()
//                 }
//             }

//             stage('Upload Logs to Azure') {
//                 steps {
//                     echo "Uploading logs..."
//                 }
//             }
//         }
//     }
// }
// // def setupPythonEnvironment() {
// //     sh '''
// //         sudo apt-get update
// //         sudo apt-get -y install python3.10 python3.10-venv python3.10-distutils
// //         python3.10 -m venv $WORKSPACE/venv
// //         . $WORKSPACE/venv/bin/activate
// //         pip install --upgrade pip
// //         if [ -f "requirements.txt" ]; then
// //             pip install -r requirements.txt
// //         else
// //             echo "requirements.txt not found."
// //         fi
// //     '''
// //     echo "Python environment set up successfully."
// // }

// // def installGoogleChrome() {
// //     sh '''
// //         sudo apt-get install -y wget
// //         wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
// //         sudo apt install -y --allow-downgrades ./google-chrome-stable_current_amd64.deb
// //     '''
// //     echo "Google Chrome installed."
// // }
// //  // reusable function for installing dependencies 
// //   def installDependencies() {
// //      sh 'sudo apt-get -y install python3-pip'
// //      sh 'sudo pip install -r requirements.txt'

// //      echo "install dependencies has been done successfully."
// // }



// // def call(String message, Map config = [:]) {
// //     pipeline {
// //         agent any
// //         stages {
// //             stage('Checkout Code') {
// //                 steps { 
// //                     script {
// //                         echo "Checking out the repository... Message: ${message}"
// //                         // checkoutCode(config.branch, config.credentialsId, config.repositoryUrl)
// //                     }
// //                     // echo "Checking out the repository... Message: ${message}"
                    
// //                 }
// //             }

// //             stage('Setup Python Environment') {
// //                 steps {
// //                     setupPythonEnvironment()
// //                 }
// //             }

// //             stage('Install Google Chrome') {
// //                 steps {
// //                     installGoogleChrome()
// //                 }
// //             }

// //             stage('Install Dependencies') {
// //                 steps {
// //                     echo "Installing dependencies..."
// //                 }
// //             }

// //             stage('Upload Logs to Azure') {
// //                 steps {
// //                     echo "Uploading logs..."
// //                 }
// //             }
// //         }
// //     }
// // }
// // // // Reusable function for setting up Python environment
// // // def setupPythonEnvironment() {
// // //     sh '''
// // //         sudo apt-get update
// // //         sudo apt-get -y install python3.10 python3.10-venv python3.10-distutils
        
// // //         # Create a virtual environment in the workspace directory
// // //         python3.10 -m venv $WORKSPACE/venv
// // //         . $WORKSPACE/venv/bin/activate      // Activate the virtual environment
        
// // //         pip install --upgrade pip
        
// // //         # Check if requirements.txt exists before installing dependencies
// // //         if [ -f "requirements.txt" ]; then
// // //             pip install -r requirements.txt  // Install dependencies in virtual environment
// // //         else
// // //             echo "requirements.txt not found in the repository."
// // //         fi
// // //     '''
// // //     echo "Python environment with Python 3.10 has been successfully set up."
// // // }

// // // // Reusable function for installing Google Chrome
// // // def installGoogleChrome() {
// // //     sh '''
// // //         sudo apt-get update
// // //         sudo apt install -y wget
// // //         wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
// // //         sudo apt install -y --allow-downgrades ./google-chrome-stable_current_amd64.deb
// // //     '''
// // //     echo "Google Chrome has been successfully installed."
// // // }

// // // // Reusable function for installing dependencies
// // // def installDependencies() {
// // //     sh '''
// // //         sudo apt-get -y install python3-pip
// // //         pip install --upgrade pip
// // //         # Check if requirements.txt exists before installing dependencies
// // //         if [ -f "requirements.txt" ]; then
// // //             pip install -r requirements.txt
// // //         else
// // //             echo "requirements.txt not found in the repository."
// // //         fi
// // //     '''
// // //     echo "Install dependencies has been done successfully."
// // // }

// // // // Main pipeline script
// // // def call(String message) {
// // //     pipeline {
// // //         agent any
// // //         stages {
// // //             stage('Checkout Code') {
// // //                 steps {
// // //                     echo "Checking out the repository... Message: ${message}"
// // //                 }
// // //             }

// // //             stage('Setup Python Environment') {
// // //                 steps {
// // //                     setupPythonEnvironment()     // Call the reusable Python setup function
// // //                     echo "Setting up Python environment... Message: ${message}"
// // //                 }
// // //             }

// // //             stage('Install Google Chrome') {
// // //                 steps {
// // //                     installGoogleChrome()        // Call the reusable function
// // //                     echo "Installing Google Chrome... Message: ${message}"
// // //                 }
// // //             }

// // //             stage('Install Dependencies') {
// // //                 steps {
// // //                     installDependencies()       // Call the reusable function
// // //                     echo "Installing required dependencies... Message: ${message}"
// // //                 }
// // //             }

// // //             stage('Fetch Secrets and Processing') {
// // //                 steps {
// // //                     echo "Fetching secrets and performing processing... Message: ${message}"
// // //                 }
// // //             }

// // //             stage('Upload Logs to Azure Blob Storage') {
// // //                 steps {
// // //                     echo "Uploading logs to Azure blob storage... Message: ${message}"
// // //                 }
// // //             }

// // //         }
// // //     }
// // // }
// // // // // Reusable function for setting up Python environment
// // // // def setupPythonEnvironment() {
// // // //     sh '''
// // // //         sudo apt-get update
// // // //         sudo apt-get -y install python3.10 python3.10-venv python3.10-distutils
        
// // // //         # Create a virtual environment in the workspace directory
// // // //         python3.10 -m venv $WORKSPACE/venv
// // // //         . $WORKSPACE/venv/bin/activate      // Activate the virtual environment
        
// // // //         pip install --upgrade pip
        
// // // //         if [ -f "requirements.txt" ]; then
// // // //             pip install -r requirements.txt  // Install dependencies in virtual environment
// // // //         else
// // // //             echo "requirements.txt not found. Please ensure it is available in the repository."
// // // //             exit 1
// // // //         fi
// // // //     '''
// // // //     echo "Python environment with Python 3.10 has been successfully set up and dependencies installed."
// // // // }

// // // // // Reusable function for installing Google Chrome
// // // // def installGoogleChrome() {
// // // //     sh '''
// // // //         sudo apt-get update
// // // //         sudo apt install -y wget
// // // //         wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
// // // //         sudo apt install -y --allow-downgrades ./google-chrome-stable_current_amd64.deb
// // // //     '''
// // // //     echo "Google Chrome has been successfully installed."
// // // // }

// // // // // Reusable function for installing dependencies
// // // // def installDependencies() {
// // // //     sh '''
// // // //         sudo apt-get -y install python3-pip
// // // //         pip install --upgrade pip
// // // //         if [ -f "requirements.txt" ]; then
// // // //             pip install -r requirements.txt
// // // //         else
// // // //             echo "requirements.txt not found. Please ensure it is available in the repository."
// // // //             exit 1
// // // //         fi
// // // //     '''
// // // //     echo "Install dependencies has been done successfully."
// // // // }

// // // // // Main pipeline script
// // // // def call(String message) {
// // // //     pipeline {
// // // //         agent any
// // // //         stages {
// // // //             stage('Checkout Code') {
// // // //                 steps {
// // // //                     echo "Checking out the repository... Message: ${message}"
// // // //                 }
// // // //             }

// // // //             stage('Setup Python Environment') {
// // // //                 steps {
// // // //                     setupPythonEnvironment()     // Call the reusable Python setup function
// // // //                     echo "Setting up Python environment... Message: ${message}"
// // // //                 }
// // // //             }

// // // //             stage('Install Google Chrome') {
// // // //                 steps {
// // // //                     installGoogleChrome()        // Call the reusable function
// // // //                     echo "Installing Google Chrome... Message: ${message}"
// // // //                 }
// // // //             }

// // // //             stage('Install Dependencies') {
// // // //                 steps {
// // // //                     installDependencies()       // Call the reusable function
// // // //                     echo "Installing required dependencies... Message: ${message}"
// // // //                 }
// // // //             }

// // // //             stage('Fetch Secrets and Processing') {
// // // //                 steps {
// // // //                     echo "Fetching secrets and performing processing... Message: ${message}"
// // // //                 }
// // // //             }

// // // //             stage('Upload Logs to Azure Blob Storage') {
// // // //                 steps {
// // // //                     echo "Uploading logs to Azure blob storage... Message: ${message}"
// // // //                 }
// // // //             }

// // // //         }
// // // //     }
// // // // }
// // // // // // Reusable function for setting up Python environment
// // // // // def setupPythonEnvironment() {
// // // // //     sh '''
// // // // //         sudo apt-get update
// // // // //         sudo apt-get -y install python3.10 python3.10-venv python3.10-distutils
// // // // //         python3.10 -m venv venv  // Create a virtual environment
// // // // //         . venv/bin/activate      // Activate the virtual environment
// // // // //         pip install --upgrade pip
// // // // //         if [ -f "requirements.txt" ]; then
// // // // //             pip install -r requirements.txt  // Install dependencies in virtual environment
// // // // //         else
// // // // //             echo "requirements.txt not found. Please ensure it is available in the repository."
// // // // //             exit 1
// // // // //         fi
// // // // //     '''
// // // // //     echo "Python environment with Python 3.10 has been successfully set up and dependencies installed."
// // // // // }

// // // // // // Reusable function for installing Google Chrome
// // // // // def installGoogleChrome() {
// // // // //     sh '''
// // // // //         sudo apt-get update
// // // // //         sudo apt install -y wget
// // // // //         wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
// // // // //         sudo apt install -y --allow-downgrades ./google-chrome-stable_current_amd64.deb
// // // // //     '''
// // // // //     echo "Google Chrome has been successfully installed."
// // // // // }

// // // // // // Reusable function for installing dependencies
// // // // // def installDependencies() {
// // // // //     sh '''
// // // // //         sudo apt-get -y install python3-pip
// // // // //         pip install --upgrade pip
// // // // //         if [ -f "requirements.txt" ]; then
// // // // //             pip install -r requirements.txt
// // // // //         else
// // // // //             echo "requirements.txt not found. Please ensure it is available in the repository."
// // // // //             exit 1
// // // // //         fi
// // // // //     '''
// // // // //     echo "Install dependencies has been done successfully."
// // // // // }

// // // // // // Main pipeline script
// // // // // def call(String message) {
// // // // //     pipeline {
// // // // //         agent any
// // // // //         stages {
// // // // //             stage('Checkout Code') {
// // // // //                 steps {
// // // // //                     echo "Checking out the repository... Message: ${message}"
// // // // //                 }
// // // // //             }

// // // // //             stage('Setup Python Environment') {
// // // // //                 steps {
// // // // //                     setupPythonEnvironment()     // Call the reusable Python setup function
// // // // //                     echo "Setting up Python environment... Message: ${message}"
// // // // //                 }
// // // // //             }

// // // // //             stage('Install Google Chrome') {
// // // // //                 steps {
// // // // //                     installGoogleChrome()        // Call the reusable function
// // // // //                     echo "Installing Google Chrome... Message: ${message}"
// // // // //                 }
// // // // //             }

// // // // //             stage('Install Dependencies') {
// // // // //                 steps {
// // // // //                     installDependencies()       // Call the reusable function
// // // // //                     echo "Installing required dependencies... Message: ${message}"
// // // // //                 }
// // // // //             }

// // // // //             stage('Fetch Secrets and Processing') {
// // // // //                 steps {
// // // // //                     echo "Fetching secrets and performing processing... Message: ${message}"
// // // // //                 }
// // // // //             }

// // // // //             stage('Upload Logs to Azure Blob Storage') {
// // // // //                 steps {
// // // // //                     echo "Uploading logs to Azure blob storage... Message: ${message}"
// // // // //                 }
// // // // //             }

// // // // //         }
// // // // //     }
// // // // // }
// // // // // // // Reusable function for setting up Python environment
// // // // // // def setupPythonEnvironment() {
// // // // // //     sh '''
// // // // // //         sudo apt-get update
// // // // // //         sudo apt-get -y install software-properties-common
// // // // // //         sudo add-apt-repository -y ppa:deadsnakes/ppa
// // // // // //         sudo apt-get update
// // // // // //         sudo apt-get -y install python3.10 python3.10-venv python3.10-distutils
// // // // // //         python3.10 -m venv venv
// // // // // //         . venv/bin/activate
// // // // // //     '''
// // // // // //     echo "Python environment with Python 3.10 has been successfully set up."
// // // // // // }

// // // // // // // Reusable function for installing Google Chrome
// // // // // // def installGoogleChrome() {
// // // // // //     sh '''
// // // // // //         sudo apt-get update
// // // // // //         sudo apt-get install -y wget
// // // // // //         wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
// // // // // //         sudo apt install -y --allow-downgrades ./google-chrome-stable_current_amd64.deb
// // // // // //     '''
// // // // // //     echo "Google Chrome has been successfully installed."
// // // // // // }

// // // // // // // reusable function for installing dependencies 
// // // // // // def installDependencies() {
// // // // // //      sh 'sudo apt-get -y install python3-pip'
// // // // // //      sh 'sudo pip install -r requirements.txt'

// // // // // //      echo "install dependencies has been done successfully"
// // // // // // }



// // // // // // // main pipeline script

// // // // // // def call(String message) {
// // // // // //     pipeline {
// // // // // //         agent any
// // // // // //            stages {
// // // // // //             stage('Checkout Code') {
// // // // // //                 steps {
// // // // // //                     echo "Checking out the repository... Message: ${message}"
// // // // // //                 }
// // // // // //             }

// // // // // //             stage('Setup Python Environment') {
// // // // // //                 steps {
// // // // // //                     setupPythonEnvironment()     // Call the reusable Python setup function
// // // // // //                     echo "Setting up Python environment... Message: ${message}"
// // // // // //                 }
// // // // // //             }            

// // // // // //             stage('Install Google Chrome') {
// // // // // //                 steps {
// // // // // //                     installGoogleChrome()        // Call the reusable function
// // // // // //                     echo "Installing Google Chrome... Message: ${message}"
// // // // // //                 }
// // // // // //             }

// // // // // //             stage('Install Dependencies') {
// // // // // //                 steps {
// // // // // //                     installDependencies()       //call the reusable function
// // // // // //                     echo "Installing required dependencies... Message: ${message}"
// // // // // //                 }
// // // // // //             }

// // // // // //             stage('Fetch Secrets and Processing') {
// // // // // //                 steps {
// // // // // //                     echo "Fetching secrets and performing processing... Message: ${message}"
// // // // // //                 }
// // // // // //             }

// // // // // //             stage('Upload Logs to Azure Blog Storage') {
// // // // // //                 steps {
// // // // // //                     echo "uploading logs to Azure blog storage... Message: ${message}"
// // // // // //                 }
// // // // // //             }
// // // // // //            }    
// // // // // //     }
// // // // // // }















