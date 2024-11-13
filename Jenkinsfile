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
                sh "docker build -t gunwoda/board ."
            }
        }
        stage("Docker image run"){
            steps{
                sh "docker run -d -p 8081:8080 --name board gunwoda/board"
            }
        }
    }
}