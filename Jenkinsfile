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
        sh "mvn clean"
      }
    }
    stage("Test") {
      steps {
        sh "mvn test"
      }
    }
    stage("Maven") {
      steps {
        sh "mvn deploy -DskipTests"
      }
    }
  }
}