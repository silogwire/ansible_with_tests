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
                 stage('archive artifacts') {
                         steps {
                                 sh 'mvn test'
                }
                         post {
                                 always {

                                         stash(name: 'artifact', includes: 'target/*.war')
                                         stash(name: 'pom', includes: 'pom.xml')
                                         // to add artifacts in jenkins pipeline tab (UI)
                                         archiveArtifacts 'target/*.war'
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
