def call(Map params){
    node(){
    stage('build'){
        echo params.param1
        echo params.param2
    }
 }
}
