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
            echo "Test"
            echo env.getProperty("rhel_version")
            echo env.getProperty("Ceph_version")
            echo env.getProperty("Container_image")
            echo env.getProperty("Repolink") 
            echo env.getProperty("Branch")  
              
          }
        }
        stage('Testing2') {
          steps {
            echo "Test2"
          }
        }

      }
    }

  }
}
}
