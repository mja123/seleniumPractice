pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'First Pipeline'
            }
        }
        stage('Result') {
            steps {
                sh 'pwd'
            }
        }
        stage('Call another job') {
            steps {
                build 'firstJob'
            }
        }
    }
}