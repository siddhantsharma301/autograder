PATH = "C:\\Users\\siddh\\documents\\GitHub\\autograder\\py\\tests\\wink\\wink.in.txt"

out_file = open("C:\\Users\\siddh\\documents\\GitHub\\autograder\\py\\tests\\wink\\wink.out.txt", "w", encoding="utf-8")
f = open(PATH, "r", encoding="utf-8")
T = int(f.readline())

for i in range(T):
    ln = f.readline()
    split = ln.split()
    wink_count = 0
    
    for w in split:
        if "wink" in w:
            wink_count += 1

    ln = ln.replace(" wink", "")
    ln = ln.replace("\n", "")

    if wink_count % 2 == 0:
        out_file.write('\"' + ln + '\"' + ' was SERIOUS\n')
    else:
        out_file.write('\"' + ln + '\"' + ' was SARCASTIC\n')

out_file.close()