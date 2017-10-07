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
			steps{
			sh 'mvn -Dsonar.host.url=http://52.31.36.145:9000/ -Dsonar.login=36388ea54758e7cc7703cc8134f779afe1a0118c org.sonarsource.scanner.maven:sonar-maven-plugin:3.3.0.603:sonar'
  		}
		stage ('Parallel Demo') {
	parallel 'static': {
	 sh "echo shell scripts to run static"
	 },
	 'unit' : {
	 	sh "echo shell scripts to run unit"
 	},
 	'integration' : {
	 	sh "echo shell scripts to run integration"
 	}
	 
}
    }
  }
}
