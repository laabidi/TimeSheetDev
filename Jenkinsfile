pipeline {
       environment {
    registry = "saoussenbenmohamed/devopsimage"
    registryCredential = 'dockerHub'
    dockerImage = 'devopsimage'
  }
agent any
stages{
       stage('Checkout GIT'){
       steps{
             echo 'Pulling...';
             git branch: 'master',
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
      
       stage {("Pull Image")
  // Now let's pull it, just to test that a pull from Nexus works correctly
  docker.withRegistry('https://nexus.doyouevenco.de', 'nexus-admin') {
     docker.image("jenkins-docker-maven-example:latest").pull()
  }}
       
       
       
          
        }
      post {
    always {
       mail to: 'benmohamedsaoussen@gmail.com',
          subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
          body: "${env.BUILD_URL} has result ${currentBuild.result}"
    }
  }
      
       }
           
