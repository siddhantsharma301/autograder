import os
import subprocess

JAVA_EXT = ".java"

def run(file):
    """
    Run a given Java file
    Compiles the file and executes the generated `.class` file

    Args:
    * file
        File to run

    Returns:
    """
    # Get file name, without extension
    name = os.path.splitext(file)[0]

    # Compile Java file
    subprocess.check_call(['javac', name + JAVA_EXT])

    # Change working directory bc java is wack and has some 
    # weird rules for running `.class` files 🤡
    os.chdir(os.path.dirname(os.path.realpath(file)))

    # Execute compiled file
    subprocess.check_call(['java', name.split('\\')[-1]])


if __name__ == "__main__":
    file = "C:\\Users\\siddh\\Documents\\GitHub\\autograder\\java\\Tester.java"
    run(file)
