from collections import Counter
def solution(s):
    counter = Counter(s)
    if counter['p'] + counter['P'] == counter['y'] + counter['Y']: 
        return True
    else:
        return False
    
    