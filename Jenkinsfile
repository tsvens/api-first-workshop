// name of the template that will be created
def templateName = 'wm-msr-runtime'

pipeline {

	agent none 
	
    stages {
        stage('Initialize Products'){
            steps {
                script {
					openshift.withCluster() {
						def dcProduccts = openshift.newApp( 'https://github.com/elpinjo/api-first-workshop.git', '--context-dir=Products', '--name=products' ).narrow('dc')

						def dc = dcProduccts.object()

						// dc is not a Selector -- It is a Groovy Map which models the content of the DC
						// new-app created at the time object() was called. Changes to the model are not
						// reflected back to the API server, but the DC's content is at our fingertips.
						echo "new-app created a ${dc.kind} with name ${dc.metadata.name}"
						echo "The object has labels: ${dc.metadata.labels}"
					}
                }
			}
		}
		stage('Initialize Machines'){
            steps {
                script {
					openshift.withCluster() {
						def dcMachines = openshift.newApp( 'https://github.com/elpinjo/api-first-workshop.git', '--context-dir=Machines', '--name=machines' ).narrow('dc')

						def dc = dcMachines.object()
						echo "new-app created a ${dc.kind} with name ${dc.metadata.name}"
						echo "The object has labels: ${dc.metadata.labels}"
					}
                }
			}
		}
		stage('Initialize Service Monitor'){
            steps {
                script {
					openshift.withCluster() {
						def dcServiceMonitor = openshift.newApp( 'https://github.com/elpinjo/api-first-workshop.git', '--context-dir=ServiceMonitor', '--name=serviceMonitor' ).narrow('dc')

						def dc = dcServiceMonitor.object()

						// dc is not a Selector -- It is a Groovy Map which models the content of the DC
						// new-app created at the time object() was called. Changes to the model are not
						// reflected back to the API server, but the DC's content is at our fingertips.
						echo "new-app created a ${dc.kind} with name ${dc.metadata.name}"
						echo "The object has labels: ${dc.metadata.labels}"
					}
                }
			}
		}
	}
}
