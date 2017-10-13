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
        }
      }
    }
    stage("Maven") {
      steps {
        withMaven(jdk: 'Java 8', maven: 'Maven 3') {
          sh "mvn deploy -DskipTests"
        }
      }
    }
  }
}