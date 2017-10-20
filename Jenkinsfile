pipeline{
	 agent {
        docker {
            label 'QA'
            image 'maven:3.5.0-jdk-8'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
	stages{
		stage('Checkout'){
			steps {
				git url: "https://github.com/arunstiwari/Emergent-Design-Workshop.git"
			}
		}
		stage('UnitTest') {
			steps {
				sh 'mvn clean test'
			}
		}
		stage('Package') {
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
		stage('Checkstyle-Reports') {
			steps{
				checkstyle canComputeNew: false, defaultEncoding: '', healthy: '', pattern: 'target/checkstyle-result.xml', unHealthy: ''
			}
		}
		
	}
}