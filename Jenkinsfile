pipeline{
	agent any
	stages{
		stage('Test') {
			steps {
				mvn clean test
			}
		}
		stage('Build') {
			steps {
				mvn package
			}
		}
		stage('Checkstyle') {
			steps {
				mvn checkstyle:checkstyle
			}
		}
	}
}