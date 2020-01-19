# autograder
this makes life easier for automatically grading programs based on their outputs :))  
Siddhant Sharma, 2020
***

## Why?
Mass grading files is painful. You have to compile (depending on the language), execute, compare the text files, blah blah blah. So I decided to make a tool that does it real quick.

## Assumptions
The files need to be set up correctly. For example, the paths to read and write files should be set correctly by ther user. Also, this runs using the format used by Lockheed Martin's Code Quest Competition (pls dont copyright me or anything for mentioning lockheed). The files take input with `~.in.txt` files and output to `~.out.txt` files.

## Example Usage
By file:
```
python autograder\<language>\main.py --file <file to grade>.<extension> --answer <path to answer>.txt
```

By directory:
```
python autograder\<language>\main.py --dir <path to dir to find grading files> --answer <path to answer>.txt --name <name to store output grading>.txt
```
For help, try `python autograder\<language>\main.py -h`
