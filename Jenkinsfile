 node {
  stage('GIT'){
  git "https://github.com/qualitykiosktta/Atlas_Demo"
  }
  stage('DEV'){
 	//dir("/Atlas_Demo"){
 	    sh "mvn clean test -DstageName=DEV"
 	//}
  }
  stage('QA'){
   	//dir("/Atlas_Demo"){
   	    sh "mvn clean test -DstageName=QA"
 	//}
  }
  stage('UAT'){
  	//dir("/Atlas_Demo"){
   	    sh "mvn clean test -DstageName=UAT"
 	//}
  }
  }