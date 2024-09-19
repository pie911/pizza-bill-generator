# pizza-bill-generator
Java Project: Pizza Bill Generator App Project Title: Create Pizza Bill Generator App using Core Java Description: The Pizzamania is a new pizza outlet and it wants to automate the pizza-billing process in Java way. Assuming that Pizzamania is going to have four variants of Pizza:
1.	Veg Pizza
2.	Non-Veg Pizza
3.	Delux Veg Pizza - already loaded with extra cheese & extra toppings
4.	Delux Non-Veg Pizza - already loaded with extra cheese & extra toppings
Requirements:
•	Create a menu-driven app which first asks to select the type of pizza.
•	After selecting the pizza type, it should ask for Extra Cheese, Extra Toppings.
•	For Delux Pizza, it should not ask for Extra Cheese & Extra Toppings, as it’s already loaded.
•	Finally, it should ask whether to opt for take away (Packaging Charges).
•	Generate the Bill.
Pricing:
•	Veg Pizza: ₹300
•	Non-Veg Pizza: ₹400
•	Delux Veg Pizza: ₹550
•	Delux Non-Veg Pizza: ₹650
•	Cheese Extra: ₹100
•	Toppings Extra: ₹20
DevOps Operations to Build Project with Maven
1.	Install Maven:
o	Ensure Maven is installed on your system. You can download it from the official website.
2.	Create Project Structure:
o	Use the following command to create a new Maven project:
o	mvn archetype:generate -DgroupId=com.pizzamania -DartifactId=pizza-bill-generator -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
3.	Project Directory Structure:
o	Navigate to the project directory:
o	cd pizza-bill-generator
4.	Update pom.xml:
o	Open the pom.xml file and add the necessary dependencies:
o	<dependencies>
o	    <!-- Add your dependencies here -->
o	</dependencies>
5.	Create Java Classes:
o	Create the necessary Java classes under src/main/java/com/pizzamania: 
	Pizza.java
	DeluxPizza.java
	BillGenerator.java
	Main.java
6.	Build the Project:
o	Use the following command to build the project:
o	mvn clean install
7.	Run the Application:
o	Use the following command to run the application:
o	mvn exec:java -Dexec.mainClass="com.pizzamania.Main"
This setup will help you automate the pizza-billing process using Core Java and Maven.
To set up Jenkins for the Pizza Bill Generator App using Core Java and Maven, follow these steps:
1.	Install Jenkins:
o	Download and install Jenkins from the official website.
o	Start Jenkins and complete the initial setup.
2.	Install Required Plugins:
o	Go to Manage Jenkins > Manage Plugins.
o	Install the following plugins: 
	Maven Integration Plugin
	Git Plugin
3.	Create a New Jenkins Job:
o	Go to New Item and create a Freestyle project named PizzaBillGenerator.
4.	Configure Source Code Management:
o	Under Source Code Management, select Git.
o	Enter the repository URL where your project is hosted (e.g., GitHub).
5.	Build Triggers:
o	Set up build triggers as needed (e.g., Poll SCM or GitHub hook trigger for GITScm polling).
6.	Build Environment:
o	Add any necessary environment variables or configurations.
7.	Build Steps:
o	Add a Build Step and select Invoke top-level Maven targets.
o	Enter clean install in the Goals field.
8.	Post-build Actions:
o	Add Post-build Actions to archive the artifacts or publish test results.
9.	Pipeline Configuration (Optional):
o	For a more advanced setup, you can use a Jenkins Pipeline. Create a Jenkinsfile in your project repository with the following content:
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo/pizza-bill-generator.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            junit 'target/surefire-reports/*.xml'
        }
    }
}
