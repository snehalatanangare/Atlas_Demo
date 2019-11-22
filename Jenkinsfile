node {
stage (‘SCM checkout’){
git “https://github.com/qualitykiosktta/Atlas_Demo”
}
stage (‘DEV’){
dir(“comtest”) {
sh “mvn clean install”
}
dir(“/target”) {
sh “java -jar carina-demo-1.0.jar”
}
}
}
