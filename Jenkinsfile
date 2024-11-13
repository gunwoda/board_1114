pipeline{
    agent any
    stages{
        stage("Print"){
            steps{
                sh 'echo connected'
            }
        }
        stage("Permission"){
            steps{
                sh "chmod +x ./gradlew"
            }
        }
        stage("Compile"){
            steps{
                sh "./gradlew compileJava"
            }
        }
    }
}