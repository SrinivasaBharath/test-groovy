def call(Map params){
    pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/red-hat-storage/cephci.git']]])
      }
    }

    stage('Testing in parallel') {
      parallel {
        stage('Testing') {
          steps {
            echo params.param1
            echo " FOOBAR value: ${params.'RhVersion'}"
          }
        }
        stage('Testing2') {
          steps {
            echo params.param2
          }
        }

      }
    }

  }
}
}
