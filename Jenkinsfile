pipeline{
	agent any
	tools {
		maven 'maven-3.2.9'
	}
	stages{
		stage('Test') {
			steps {
				sh 'mvn clean test'
			}
		}
		stage('Build') {
			steps {
				sh 'mvn package'
			}
		}
		stage('Checkstyle') {
			steps {
				sh 'mvn checkstyle:checkstyle'
			}
		}
		stage('Reports-Junit') {
			steps {
				junit allowEmptyResults: true, testResults: './target/surefire-reports/*.xml'
			}
		}
	}
}