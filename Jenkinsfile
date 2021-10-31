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
          bat """mvn deploy"""
          }
          }
          
        }
         post {
           success {
           emailext body: 'build success' , subject: 'Jenkins' , to: 'benmohamedsaoussen@gmail.com'
           }
            failure {
           emailext body: 'build failure' , subject: 'Jenkins' , to: 'benmohamedsaoussen@gmail.com'
           }
           }
           }
         
