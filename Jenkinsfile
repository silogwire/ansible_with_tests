pipeline {
	agent any 

   	stages {
        	stage('Clone') {
			steps {
              			git 'https://github.com/silogwire/ansible_with_tests.git'
       			 }
		}	
		stage('Build') {
                	steps {
	               		 sh 'mvn  -B -DskipTests clean package'
       			 }
		}
	 stage('Unit Tests') {
                steps {
   			 sh 'mvn test'
		}
		post {
		    always {
    			 junit 'target/surefire-reports/**/*.xml'
   		    }
		}
  	 }

         stage('Integration Tests') {
                steps {
	        	 sh label: '', script: 'mvn verify -Dsurefire.skip=true'

        	 }
		 post {
			 always {
    				 junit 'target/failsafe-reports/**/*.xml'
   			 }
   			 success {
   				  stash(name: 'artifact', includes: 'target/*.jar')
    				  stash(name: 'pom', includes: 'pom.xml')
   				  // to add artifacts in jenkins pipeline tab (UI)
   				  archiveArtifacts 'target/*.jar'
   			 }              
		 }
	}
	
	stage('ansible') {
               steps {

                        sh 'ansible-playbook playbook.yml'
                 }

	}
   }
}
