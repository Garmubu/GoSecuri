pipeline {
    agent any
        tools { 
        maven 'mymaven'
        jdk 'myjdk'
    }
    stages {
        stage('clone') {
            steps {
                echo 'Debut de clonage'
                bat "rmdir /s /q GoSecuri"
                bat "git clone -b c-la-guerre https://github.com/Garmubu/GoSecuri"
            }
        }
        stage('dependence') {
            steps {
                echo "Telechargement des dependances Maven"
                bat "cd GoSecuri && mvn -B clean package"
            }
        }
        stage('build') {
            steps {
                echo "Debut de build"
                bat "javac GoSecuri/src/main/java/Generateur.java"
            }
        }
        stage('run') {
            steps {
                echo "Lancement de l'application"
                bat "java GoSecuri/src/main/java/Generateur"
            }
        }
    }
}
