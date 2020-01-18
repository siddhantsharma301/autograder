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
    opt = parser.parse_args()

    if opt.dir is not None and opt.file is not None:
        raise ValueError("Both directory and file cannot be given, either one or the other")

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
        exec_file(opt.file, opt.answer)


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
    name = os.path.splitext(file)[0]
    subprocess.check_call(['python', file])
    out = name + ".out.txt"
    diff = get_diff(out, answer)
    print("\n" + str(diff) + "%")


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
