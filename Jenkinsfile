pipeline {
environment {

    PATH = "C:\Windows\System32"

}
agent any
stages{
       stage('Checkout GIT'){
       steps{
             echo 'Pulling...';
             git branch: 'Alabranche',
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
			emailext body: 'Build success', subject: 'Jenkins', to:'alaeddine.driss@esprit.tn'
		}
		failure{
			emailext body: 'Build failure', subject: 'Jenkins', to:'alaeddine.driss@esprit.tn'
		}

  }

       }