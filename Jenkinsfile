pipeline {
       environment
{
registry = "saoussenbenmohamed/saoussenbenmohamed"
registryCredential= 'dockerHub'
dockerImage = ''
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
                   bat """docker build -f C:\\Users\\Saoussen\\Documents\\workspace-sts-3.8.4.RELEASE\\TimesheetProject\\Dockerfile -t saoussenbenmohamed/devopsimage ."""
                 // bat """docker build -t saoussenbenmohamed/devopsimage ."""
                }
            }
        }
stage('Deploy our image') {
steps { script { 
    bat """docker login"""
    
    
    
} } }


stage('push our image') {
steps { script { 
    bat """docker push saoussenbenmohamed/devopsimage"""
    
    
    
} } }


stage('Cleaning up') {
steps { bat "docker rmi saoussenbenmohamed/devopsimage" }
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
