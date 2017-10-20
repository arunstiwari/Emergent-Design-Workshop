pipeline{
	agent {
        docker {
            label 'QA'
            image 'maven:3.5.0-jdk-8'
        }
    }
	stages{
		stage('UnitTest') {
			steps {
				sh 'mvn clean test'
			}
			post{
				success{
					junit allowEmptyResults: true, testResults: './target/surefire-reports/*.xml'
				}
			}
		}
		stage('Build') {
			steps {
				sh 'mvn package'
			}
			post {
				success {
					archiveArtifacts(artifacts: '**/target/*.jar', allowEmptyArchive: true)
				}
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
		stage('MutationTest'){
			steps {
				sh 'mvn org.pitest:pitest-maven:mutationCoverage'
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
		
		stage('MutationCoverage') {
			steps {
				publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/pit-reports/**/*', reportFiles: 'index.html', reportName: 'Mutation Reports', reportTitles: 'MutationReport'])
			}
		}
	  }
}