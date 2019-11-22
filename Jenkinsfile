 node {
  stage('GIT'){
  git "https://github.com/qualitykiosktta/Atlas_Demo"
  }
  stage('DEV'){
 	//dir("/Atlas_Demo"){
 	    sh "mvn clean test"
 	//}
  }
  stage('QA'){
   	//dir("/Atlas_Demo"){
   	    sh "mvn clean test"
 	//}
  }
  stage('UAT'){
  	//dir("/Atlas_Demo"){
   	    sh "mvn clean test"
 	//}
  }
 // dir("/target") {
 // sh "java -jar carina-demo-1.0.jar"
 // }
  }