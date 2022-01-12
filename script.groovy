def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t mantu0328/java-maven-app:1.2 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push mantu0328/java-maven-app:1.2'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 
return this
