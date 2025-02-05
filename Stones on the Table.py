n=int(input())
stone=input()
neighbour=0
for i in range(n):
   neighbour+=1 if i!=n-1 and stone[i]==stone[i+1] else 0
print(neighbour)
