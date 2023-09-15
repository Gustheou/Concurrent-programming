
#!/bin/bash

# Function to compile Java files
compile_java_files() {
    find . -name "*.java" > sources.txt
    javac @sources.txt
    rm -f sources.txt
}

execute_java_principal() {
  java Principal
}

# Function to remove .class files
remove_class_files() {
    find . -name "*.class" -type f -delete
}

# Compile Java files
compile_java_files

# Execute Principal file
execute_java_principal

# Remove .class files
remove_class_files

echo "Java files compiled and all .class files removed."
