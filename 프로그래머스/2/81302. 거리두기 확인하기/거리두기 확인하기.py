dx = [1, -1, 0 ,0]
dy = [0 , 0 ,1 ,-1]

def sol(place):
    for i in range(5):
        for j in range(5):
            if place[i][j] == 'P':
                for k in range(4):
                    new_i = i + dx[k]
                    new_j = j + dy[k]

                    if new_i == -1 or new_i == 5:
                        continue
                    if new_j == -1 or new_j == 5:
                        continue

                    if place[new_i][new_j] == 'O':
                        for l in range(4):
                            new_new_i = new_i + dx[l]
                            new_new_j = new_j + dy[l]
                            if new_new_i == i and new_new_j == j:
                                continue
                            if new_new_i == -1 or new_new_i == 5:
                                continue
                            if new_new_j == -1 or new_new_j == 5:
                                continue
                            if place[new_new_i][new_new_j] == 'P':
                                return 0
                    elif place[new_i][new_j] == 'P':
                        return 0
    return 1

def solution(places):
    answer = []
    
    for place in places:
        answer.append(sol(place))
            
                            

                                
                        
                        
    return answer