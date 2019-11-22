 node {
  stage('GIT'){
  git "https://github.com/qualitykiosktta/Atlas_Demo"
  }
  stage('DEV'){
  sh "mvn clean install"
  }
  stage('QA'){
  sh "mvn clean install"
  }
  stage('UAT'){
  sh "mvn clean install"
  }
  dir("/target") {
  sh "java -jar carina-demo-1.0.jar"
  }
  }