pipeline{
    agent any
    environment{
        DOCKERHUB_AUTH = credentials("docker-hub")
    }
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
        stage("Test"){
            steps{
                sh "./gradlew test"
            }
        }
        stage("Code Coverage"){
             steps{
                sh "./gradlew jacocoTestCoverageVerification"
                sh "./gradlew jacocoTestReport"
                    publishHTML(target: [
                        reportDir: 'build/reports/jacoco/test/html',
                        reportFiles: 'index.html',
                        reportName: 'Jacoco Report'
                ])
             }
        }
        stage("gradlew Build"){
            steps{
                sh "./gradlew clean build"
            }
        }

        stage("Docker image Build"){
            steps{
                sh "docker build -t gunwoda/board:latest ."
            }
        }

        stage("Docker login"){
            steps{
                sh "echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin"
            }
        }
        stage("Docker Push"){
            steps{
                sh "docker push gunwoda/board:latest"
            }
        }
        stage("Docker image run"){
            steps{
                sh "docker run -d -p 8081:8080 --name board gunwoda/board:latest"
            }
        }
    }
    post{
        always{
            sh 'docker stop jenkins1112'
        }
    }
}