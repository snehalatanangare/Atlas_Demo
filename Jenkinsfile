  node {
  stage('GIT'){
  git "https://github.com/qualitykiosktta/Atlas_Demo"
  }
  stage('DEV'){
  sh "clean install"
  }
  stage('QA'){
  sh "clean install"
  }
  stage('UAT'){
  sh "clean install"
  }
  dir("/target") {
  sh "java -jar carina-demo-1.0.jar"
  }
  }
