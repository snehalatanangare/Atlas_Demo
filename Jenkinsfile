 node {
  stage('GIT'){
  git "https://github.com/qualitykiosktta/Atlas_Demo"
  }
  stage('DEV'){
 // sh "mvn clean install"
 dir("/target") {
  sh "java -jar carina-demo-1.0.jar"
  }
  }
  stage('QA'){
 // sh "mvn clean install"
  dir("/target") {
  sh "java -jar carina-demo-1.0.jar"
  }
  }
  stage('UAT'){
 // sh "mvn clean install"
  dir("/target") {
  sh "java -jar carina-demo-1.0.jar"
  }
  }
  dir("/target") {
  sh "java -jar carina-demo-1.0.jar"
  }
  }