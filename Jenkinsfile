#!groovy

pipeline {
  agent any

  stages {
    stage("Maven") {
      steps {
        sh "mvn clean package"
      }
    }
  }
}