pipeline{
	agent any
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
	}
}