#!groovy

pipeline {
  agent any

  options {
    buildDiscarder(logRotator(numToKeepStr: '20'))
    disableConcurrentBuilds()
    timestamps()
    skipStagesAfterUnstable()
  }

  triggers {
    pollSCM('')
  }

  stages {
    stage("Clean") {
      steps {
        withMaven(jdk: 'Java 8', maven: 'Maven 3') {
          sh "mvn clean"
        }
      }
    }
    stage("Test") {
      steps {
        withMaven(jdk: 'Java 8', maven: 'Maven 3') {
          sh "mvn test"
          sh "mvn org.owasp:dependency-check-maven:2.1.1:check"
        }
      }
    }
    stage("Publish") {
      steps {
        withMaven(jdk: 'Java 8', maven: 'Maven 3') {
          sh "mvn deploy -DskipTests"
        }
      }
    }
  }

  post {
    unstable {
      emailext(
              subject: "UNSTABLE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
              body: """See <${env.BUILD_URL}>""",
              recipientProviders: [[$class: 'CulpritsRecipientProvider'], [$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']]
      )
    }
    failure {
      emailext(
              subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
              body: """See <${env.BUILD_URL}>""",
              recipientProviders: [[$class: 'CulpritsRecipientProvider'], [$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']]
      )
    }
  }
}