PATH = "C:\\Users\\siddh\\documents\\GitHub\\autograder\\py\\tests\\spaces\\spaces.in.txt"

out_file = open("C:\\Users\\siddh\\documents\\GitHub\\autograder\\py\\tests\\spaces\\spaces.out.txt", "w")
f = open(PATH, "r")
T = int(f.readline())

for i in range(T):
    ln = f.readline()
    ln = ln.split(")")

    offset = int(ln[0].replace("(", ""))

    msg = ln[1]
    msg = msg.replace("{", "").replace("}", "").replace("\n", "")
    msg = list(msg)
    pos = 0
    
    # print("Original: " + "".join(msg))
    for w in msg:
        if w == " ":
            space = msg.pop(pos)
            off = pos - offset
            if off > len(msg):
                off = off - len(msg)           

        pos += 1

    msg = "".join(msg)
    # print("Out: " + msg)

    out_file.write(msg + '\n')

out_file.close()