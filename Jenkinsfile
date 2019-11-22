node {
stage ('GIT'){
git "https://github.com/qualitykiosktta/Atlas_Demo"
}
stage ('DEV'){
dir("comtest") {
sh "mvn clean install"
}
stage ('QA'){
dir("comtest") {
sh "mvn clean install"
}
stage ('UAT'){
dir("comtest") {
sh "mvn clean install"
}
dir("/target") {
sh "java -jar carina-demo-1.0.jar"
}
}
}
