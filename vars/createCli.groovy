def call(Map params){
    node(){
        
    stage('checkout'){  
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/red-hat-storage/cephci.git']]])
    }
    stage('build'){
        echo params.param1
        echo params.param2
    }
 }
}
