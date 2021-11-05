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
      
     stage('Build Docker Image') {
            steps {
                script {
                   bat """docker build -f 'SaoussenBranch/Dockerfile' -t saoussenbenmohamed/devopsimage ."""
                 // bat """docker build -t saoussenbenmohamed/devopsimage ."""
                }
            }
        }
    
       
       
          
        }
      post {
    always {
       mail to: 'benmohamedsaoussen@gmail.com',
          subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
          body: "${env.BUILD_URL} has result ${currentBuild.result}"
    }
  }
      
       }
           
