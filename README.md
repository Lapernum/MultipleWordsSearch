# MultipleWordsSearch

Imaging one person with a lot of legs walking on the road. In order to not break his legs, his first leg and the last leg should be in the smallest distance. But the legs between these two don't matter.

Firstly, after putting the first leg on the ground, more and more legs follow after. After all the legs touch the ground, one distance is recorded. Then, there are multiple situations:
  1. When we meet another place forward to step any leg in front of the man, we step on it as the first leg and record the distance.
  2. When we meet another place between the first and last legs, we step on it.
    1. If it's the place for the last leg, we record the new distance.
    2. If it's for some legs in the middle, we only move the leg.

After walking down the street to the end, we will output the shortest distance between the first leg and the last leg in the process.
