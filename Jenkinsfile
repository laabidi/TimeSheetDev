pipeline {
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
          
        }
      
       environment {
        EMAIL_TO = 'benmohamedsaoussen@gmail.com'
    }
         post {
           success {
           emailext body: 'build success' , subject: 'Jenkins' 
           }
            failure {
           emailext body: 'build failure' , subject: 'Jenkins' 
           }
           }
       }
           
