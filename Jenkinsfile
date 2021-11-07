pipeline{

			environment{
		registry = 'cyrine96/devops'
		registryCredential= 'dockerHub'
		dockerImage = ''
	

		agent any 
	stages{
		stage ('Checkout GIT'){
			steps{
				echo 'Pulling...';
					git branch: 'cyrine-branche',
					url : 'https://github.com/laabidi/TimeSheetDev';
			}
		}
//
		 stage ("Lancement des Tests Unitaires"){
		 	steps{
		 		bat """mvn test"""
		 	}
	 }

		 stage ("Création du livrable dans target"){
		 	steps{
		 		bat """mvn package"""
		 	}
		 }

		 stage ("Analyse avec Sonar"){
		 	steps{
		 		bat """mvn clean package -Dmaven.test.skip=true sonar:sonar -Dsonar.host.url=http://localhost:9007/"""
		 	}
		 }

			stage ("Deploiement dans http://localhost:8081/repository/maven-releases/ "){
			steps{
				bat """nexus: 

<groupId>tn.esprit.spring</groupId>
	<artifactId>Timesheet-spring-boot-core-data-jpa-mvc-REST-1</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>Timesheet-spring-boot-core-data-jpa-mvc-REST-1</name>

commande: 

mvn clean deploy:deploy-file -DgroupId= tn.esprit.spring-DartifactId= Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion= 0.0.1-SNAPSHOT -DgeneratePom=true-Dpackaging= war -DrepositoryId=deploymentRepo-Durl=http://localhost:8081/repository/maven-releases/-Dfile=target/ Timesheet-spring-boot-core-data-jpa-mvc-REST-1"""
			}
		}
		
		stage('Building our image'){
			steps{ 
				script{ 
					dockerImage= docker.build registry + ":$BUILD_NUMBER" 
				}
			}
		}

		stage('Deploy our image'){
			steps{ 
				script{
					docker.withRegistry( '', registryCredential){
						dockerImage.push()
					} 
				} 
			}
		}

		stage('Cleaning up'){
			steps{
				bat "docker rmi $registry:$BUILD_NUMBER" 
			}
		}
		

	}

	post{
		success{
			emailext body: 'Build success', subject: 'Jenkins', to:'mohamedamin.benhssan1@esprit.tn'
		}
		failure{
			emailext body: 'Build failure', subject: 'Jenkins', to:'mohamedamin.benhssan1@esprit.tn'
		}

	}
}
