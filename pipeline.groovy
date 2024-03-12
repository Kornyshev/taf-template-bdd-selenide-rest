pipeline {
    agent any

    parameters {
        string(name: 'TAF_BRANCH', defaultValue: 'master', description: 'Branch of Test Automation Framework', trim: true)
    }

    options {
        timestamps()
    }

    stages {
        stage('Checkout from GitHub') {
            steps {
                cleanWs()
                echo "Checkout in workspace: ${WORKSPACE}"
                git branch: "${TAF_BRANCH}", url: 'https://github.com/Kornyshev/taf-template-bdd-selenide-rest'
            }
        }

        stage('Run Maven Tests') {
            steps {
                withCredentials([
                        string(credentialsId: 'user.email', variable: 'USER_EMAIL'),
                        string(credentialsId: 'user.password', variable: 'USER_PASSWORD'),
                        string(credentialsId: 'api.token', variable: 'API_TOKEN')]) {
                    sh "mvn clean test -Duser.email=${USER_EMAIL} -Duser.password=${USER_PASSWORD} -Dapi.token=${API_TOKEN} -Dselenide.headless=true"
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}
