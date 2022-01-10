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

         stage('archive artifacts') {
                steps {
   				  stash(name: 'artifact', includes: 'target/*.war')
    				  stash(name: 'pom', includes: 'pom.xml')
   				  // to add artifacts in jenkins pipeline tab (UI)
   				  archiveArtifacts 'target/*.war'
   			 }              
		 }

         stage('Build image') {
                steps {
                           sh 'docker build -t sihamlogwire/testing:$BUILD_NUMBER .'
                         }
                 }


         stage('testing image') {
                steps {
                           sh 'docker run -d --name testing_conteneur -p 8081:8080 sihamlogwire/testing:$BUILD_NUMBER'
                         }
                 }


	
//	stage('ansible') {
 //              steps {
//
//                        sh 'ansible-playbook playbook.yml'
//                 }

//	}
   }
}
