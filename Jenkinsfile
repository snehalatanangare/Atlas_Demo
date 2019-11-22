 node {
  stage('GIT'){
  git "https://github.com/qualitykiosktta/Atlas_Demo"
  }
  stage('DEV'){
 	//dir("/Atlas_Demo"){
 	    sh "mvn clean test -DSTAGE_NAME=DEV"
 	//}
  }
  stage('QA'){
   	//dir("/Atlas_Demo"){
   	    sh "mvn clean test -DSTAGE_NAME=QA"
 	//}
  }
  stage('UAT'){
  	//dir("/Atlas_Demo"){
   	    sh "mvn clean test -DSTAGE_NAME=UAT"
 	//}
  }
  }