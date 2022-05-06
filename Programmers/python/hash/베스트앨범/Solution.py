def solution(genres, plays):
    dic = {}
    for i in range(0,len(genres)):
        print(i)
        dic[genres[i]] = plays[i]
        print(dic)

    answer = []
    return answer

solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500])