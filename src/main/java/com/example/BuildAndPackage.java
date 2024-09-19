package com.example;

import java.io.File;
import java.io.IOException;

public class BuildAndPackage {
    public static void main(String[] args) {
        String projectDir = System.getProperty("user.dir");
        String jarFilePath = projectDir + "/target/your-app.jar"; // Path to your JAR file
        String exeDir = projectDir + "/exe";
        String exeFileName = "your-app.exe"; // Desired name for the EXE file

        try {
            // Step 1: Build the project using Maven
            ProcessBuilder mavenBuilder = new ProcessBuilder("cmd.exe", "/c", "mvn clean package");
            mavenBuilder.directory(new File(projectDir));
            mavenBuilder.inheritIO();
            Process mavenProcess = mavenBuilder.start();
            int mavenExitCode = mavenProcess.waitFor();

            if (mavenExitCode != 0) {
                System.err.println("Maven build failed. Exit code: " + mavenExitCode);
                return;
            }

            // Step 2: Create the exe directory if it doesn't exist
            File exeDirectory = new File(exeDir);
            if (!exeDirectory.exists()) {
                exeDirectory.mkdir();
            }

            // Step 3: Package the JAR file into an EXE file using jpackage
            ProcessBuilder jpackageBuilder = new ProcessBuilder(
                "jpackage",
                "--input", "target",
                "--name", exeFileName,
                "--main-jar", jarFilePath,
                "--type", "exe",
                "--dest", exeDir
            );

            jpackageBuilder.inheritIO();
            Process jpackageProcess = jpackageBuilder.start();
            int jpackageExitCode = jpackageProcess.waitFor();

            if (jpackageExitCode == 0) {
                System.out.println("EXE file created successfully in the 'exe' directory.");
            } else {
                System.err.println("Failed to create EXE file. Exit code: " + jpackageExitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
