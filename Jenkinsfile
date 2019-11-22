 node {
  stage('GIT'){
  git "https://github.com/qualitykiosktta/Atlas_Demo"
  }
  stage('DEV'){
 	dir("/Atlas_Demo"){
 	    sh "mvn clean install"
 	}
  }
  stage('QA'){
   	dir("/Atlas_Demo"){
 	    sh "mvn clean install"
 	}
  }
  stage('UAT'){
  	dir("/Atlas_Demo"){
 	    sh "mvn clean install"
 	}
  }
 // dir("/target") {
 // sh "java -jar carina-demo-1.0.jar"
 // }
  }