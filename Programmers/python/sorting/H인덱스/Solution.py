def solution(citations):
       for h in range(max(citations), 0, -1):
           over_h = 0
           for citation in citations:
               if citation >= h:
                   over_h += 1
               if over_h == h:
                   return h
