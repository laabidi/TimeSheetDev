pipeline {
agent any
stages{
       stage('Checkout GIT'){
       steps{
             echo 'Pulling...';
             git branch: 'master',
             url : 'https://github.com/laabidi/TimeSheetDev';
             }
         }

         stage("Test,Build"){
          steps{
          bat """mvn clean package"""
          }
          }

          stage("Sonar"){
          steps{
          bat """mvn sonar:sonar"""
          }
          }

          stage("Nexus"){
          steps{
          bat """mvn deploy -DaltDeploymentRepository=deploymentRepo::default::file:/"""
          }
          }

        }
    post{
		success{
			emailext body: 'Build success', subject: 'Jenkins', to:'mohamed.laabidi@esprit.tn'
		}
		failure{
			emailext body: 'Build failure', subject: 'Jenkins', to:'mohamed.laabidi@esprit.tn'
		}
environment
{
registry = "laabidi91/webapp"
registryCredential= 'dockerHub'
dockerImage = ''
}
agent any
stages {
stage('Cloning our Git') {
steps { git 'https://github.com/laabidi/TimeSheetDev.git' }
}
stage('Building our image') {
steps { script { dockerImage= docker.build registry + ":$BUILD_NUMBER" } }
}
stage('Deploy our image') {
steps { script { docker.withRegistry( '', registryCredential) { dockerImage.push() } } }
}
stage('Cleaning up') {
steps { bat "docker rmi $registry:$BUILD_NUMBER" }
}
}

  }}