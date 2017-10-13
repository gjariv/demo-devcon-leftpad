#!groovy

pipeline {
  agent any

  options {
    buildDiscarder(logRotator(numToKeepStr: '20'))
    disableConcurrentBuilds()
    timestamps()
  }

  triggers {
    pollSCM('')
  }

  stages {
    stage("Maven") {
      steps {
        sh "mvn clean deploy"
      }
    }
  }
}