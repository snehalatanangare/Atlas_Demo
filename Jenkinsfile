 node {
  stage('GIT'){
  git "https://github.com/qualitykiosktta/Atlas_Demo"
  }
  stage('DEV'){
 	dir(""){
 	    sh "mvn clean install"
 	}
  }
  stage('QA'){
   	dir(""){
 	    sh "mvn clean install"
 	}
  }
  stage('UAT'){
  	dir(""){
 	    sh "mvn clean install"
 	}
  }
 // dir("/target") {
 // sh "java -jar carina-demo-1.0.jar"
 // }
  }