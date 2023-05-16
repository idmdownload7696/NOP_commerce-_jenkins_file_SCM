
pipeline{
    agent any
    
    stages{
        stage('orange_git'){
            steps{
               build job:'sahil'
            }
        }
        
        stage('AshreyBuild'){
            steps{
               build job:'AshreyBuild'
            }
        }
        
        stage('NoorBuild'){
            steps{
                build job:'NOP_Commerce_Git'
            }
        }
    }
}

        
    
    
