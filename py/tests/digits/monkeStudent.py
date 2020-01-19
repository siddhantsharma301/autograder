PATH = "C:\\Users\\siddh\\documents\\GitHub\\autograder\\py\\tests\\digits\\digits.in.txt"

out_file = open("C:\\Users\\siddh\\documents\\GitHub\\autograder\\py\\tests\\digits\\monkeStudent.out.txt", "w")
f = open(PATH, "r")
T = int(f.readline())

for i in range(T):
    ln = f.readline()
    ln = ln.replace("\n", "")
    line = ln.split(':')

    n1 = int(line[0])
    n2 = line[1]
    pos = 0

    for c in n2:
        c = int(c)
        if n1 >= c:
            break
        pos +=1 

    # print(pos)
    n2 = list(n2)
    n2.insert(pos, str(n1))
    n2 = str(n2)
    n2 = n2.replace("[","").replace("\'", "").replace(",", "").replace("]", "").replace(" ", "")
    out_file.write(n2 + "\n")

out_file.close()