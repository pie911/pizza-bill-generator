package com.example;

import java.io.IOException;

public class JarToExeConverter {
    public static void main(String[] args) {
        String jarFilePath = "target/your-app.jar"; // Path to your JAR file
        String exeFileName = "your-app.exe"; // Desired name for the EXE file

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                "jpackage",
                "--input", "target",
                "--name", exeFileName,
                "--main-jar", jarFilePath,
                "--type", "exe"
            );

            processBuilder.inheritIO();
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("EXE file created successfully.");
            } else {
                System.err.println("Failed to create EXE file. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
