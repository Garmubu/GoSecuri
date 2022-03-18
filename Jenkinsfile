pipeline {
    agent any
        tools { 
        maven 'mymaven'
        jdk 'myjdk'
    }
    stages {
        /*stage('clone') {
            steps {
                echo 'Debut de clonage'
                bat "rmdir /s /q GoSecuri"
                bat "git clone -b c-la-guerre https://github.com/Garmubu/GoSecuri"
            }
        }*/
        stage('dependence') {
            steps {
                echo "Telechargement des dependances Maven"
                bat "mvn -B clean package"
            }
        }
        stage('build') {
            steps {
                echo "Debut de build"
                bat "javac -cp C:\Users\thebi\.m2\repository\com\j2html\j2html\1.5.0/j2html-1.5.0.jar src/main/java/Generateur.java"
            }
        }
        stage('run') {
            steps {
                echo "Lancement de l'application"
                bat "java src/main/java/Generateur"
            }
        }
    }
}
