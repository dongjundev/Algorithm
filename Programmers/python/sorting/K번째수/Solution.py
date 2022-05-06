def solution(array, commands):
    answer = []

    for command in commands:
        start = command[0] - 1
        finish = command[1]
        pick = command[2] - 1

        newarr = array[start:finish]
        newarr.sort()
        answer.append(newarr[pick])

    return answer