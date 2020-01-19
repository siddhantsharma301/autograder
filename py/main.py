import os
import glob
import argparse
import difflib
import subprocess


def parse_args():
    """
    Parse flags for Autograder JAVA

    Args:

    Returns:
    """
    parser = argparse.ArgumentParser(description = "CLI for Autograder Python")
    parser.add_argument("--dir", help = "Directory to look for files to run")
    parser.add_argument("--file", help = "File to run")
    parser.add_argument("--answer", required = True, help = "Answer file")
    parser.add_argument("--name", help = "Name of problem")
    opt = parser.parse_args()

    if opt.dir is not None and opt.file is not None:
        raise ValueError("Both directory and file cannot be given, either one or the other")

    if opt.dir is not None and opt.name is None:
        raise ValueError("Problem name must be given with directory flag using --name")

    return opt


def main(opt):
    """
    Main method for Autograder Python

    Args:
    * opt
        Parsed arguments

    Returns:
    """
    if opt.file is not None:
        print(exec_file(opt.file, opt.answer))

    if opt.dir is not None:
        exec_dir(opt.dir, opt.answer, opt.name)


def exec_dir(dir, answer, out_filename):
    """
    Execute all files and grade outputs
    Stores graded results in a `.graded.txt` file

    Args:
    * dir
        Directory to look for and execute files
    * answer
        Answer key text file
    * out_filename
        Name of output file (problem name)

    Returns:
    """
    # Sort all Python files in given directory
    files = sorted(glob.glob(dir + '\\*.py'))

    # Create output file
    out_file = open(dir + '\\' + out_filename + '.graded.txt', "w")

    for file in files:
        # Get file name without extension or any path before it
        # ex: C:\users\usr\test.py --> test
        name = os.path.splitext(file)[0].split("\\")[-1]

        # Write output to file
        out_file.write(name + ": " + exec_file(file, answer))

    # Close output file
    out_file.close()


def exec_file(file, answer):
    """
    Execute a file and get similarity between ground truth

    Args:
    * file
        File to execute
    * answer
        Ground truth file to compare output to
    
    Returns:
    """
    # Run the given file
    subprocess.check_call(['python', file])

    # Get file name without extension to find 
    # output file and to compare to answer
    # ex: test.py --> find test.out.txt
    name = os.path.splitext(file)[0]
    out = name + ".out.txt"

    # Compare differences
    diff = get_diff(out, answer)

    return (str(diff) + "%\n")


def get_diff(curr, answer):
    """
    Get difference between two text files

    Args:
    * curr
        Original text file
    * answer
        Answer text file to compare to

    Returns:
    Similarity score as a percent
    """
    text1 = open(curr).read()
    text2 = open(answer).read()
    m = difflib.SequenceMatcher(None, text1, text2)
    return round(m.ratio() * 100, 2)


if __name__ == "__main__":
    import time
    start = time.time()
    opts = parse_args()
    main(opts)
    print("Time taken: " + str(time.time() - start) + " seconds")
