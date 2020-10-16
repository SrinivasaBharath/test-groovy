pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'In the Build'
      }
    }

    stage('Testing') {
      parallel {
        stage('Testing') {
          steps {
            echo 'Testing1'
          }
        }

        stage('Testing2') {
          steps {
            echo 'Testing2'
          }
        }

      }
    }

  }
}