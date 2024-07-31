def solution(name, yearning, photo):
    yearningMap = {}
    for i in range(len(name)):
        yearningMap[name[i]] = yearning[i]
        
    answer = []
    for p in photo:
        total = 0
        for name in p:
            if yearningMap.get(name) != None:
                total += int(yearningMap[name])
        answer.append(total)
    return answer