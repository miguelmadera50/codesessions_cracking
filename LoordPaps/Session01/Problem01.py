'''
Created on 17 feb. 2018

@author: Emiliano Aguayo (LoordPaps)

'''

def checkForUnique(str):
    for s in str:
        if str.count(s) > 1:
            return False
            
            
    

print checkForUnique("Emiliano")
