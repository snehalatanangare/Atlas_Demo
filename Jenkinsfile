 node {
  stage('GIT'){
  git "https://github.com/qualitykiosktta/Atlas_Demo"
  }
  stage('DEV'){
 	dir("/Atlas_Demo"){
 	    sh "mvn test -DsuiteXmlFile=/src/test/resources/testng_suites/android.xml"
 	}
  }
  stage('QA'){
   	dir("/Atlas_Demo"){
   	    sh "mvn test -DsuiteXmlFile=/src/test/resources/testng_suites/android.xml"
 	}
  }
  stage('UAT'){
  	dir("/Atlas_Demo"){
   	    sh "mvn test -DsuiteXmlFile=/src/test/resources/testng_suites/android.xml"
 	}
  }
 // dir("/target") {
 // sh "java -jar carina-demo-1.0.jar"
 // }
  }