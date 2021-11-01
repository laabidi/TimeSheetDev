pipeline {
agent any
stages{
       stage('Checkout GIT'){
       steps{
             echo 'Pulling...';
             git branch: 'main',
             url : 'https://github.com/laabidi/TimeSheetDev.git';
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
      post {
    always {
       mail to: 'laabidi.mohamed120@gmail.com',
          subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
          body: "${env.BUILD_URL} has result ${currentBuild.result}"
    }
  }

       }