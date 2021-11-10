pipeline {
environment
{
registry = "aladindr/alaimage"
registryCredential= 'dockerHub'
dockerImage = ''
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
	stage('Building our image') {
	steps { script { dockerImage= docker.build registry + ":$BUILD_NUMBER" } }
	}
	stage('Deploy our image') {
	steps { script { docker.withRegistry( '', registryCredential) { dockerImage.push() } } }
	}
	steps { bat "docker rmi $registry:$BUILD_NUMBER" }
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