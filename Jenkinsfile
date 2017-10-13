#!groovy

pipeline {
  agent any

  stages {
    stage("Maven") {
      sh "mvn clean package"
    }
  }
}