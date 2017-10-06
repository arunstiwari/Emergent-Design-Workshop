pipeline{
	agent {
        node {
            label 'master'
        }
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
		stage('Jacoco') {
			steps {
				sh 'mvn jacoco:report'
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
		
		stage('CodeCoverage-Reports') {
			steps{
				step( [ $class: 'JacocoPublisher' ] )
			}
		}
		stage('SonarQube analysis') {
    			def scannerHome = tool 'SonarQube Scanner 3.0.3.778';
			withSonarQubeEnv('sonarqube') {
      		sh "${scannerHome}/bin/sonar-scanner"
    }
  }
		
	}
}