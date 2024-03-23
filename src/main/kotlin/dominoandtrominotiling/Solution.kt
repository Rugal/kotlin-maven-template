package dominoandtrominotiling

const val MOD: Long = 1000000007

/**
 * https://leetcode.com/problems/domino-and-tromino-tiling
 */
class Solution {
  fun numTilings(n: Int): Int {
    // initialize the first 4 setup's configuration number
    val data = longArrayOf(0, 1, 2, 5)
    if (n <= 3) return data[n].toInt()

    for (i in 4..n) {
      // key: dp[i] = 2 * dp[i-1] + dp[i-3]
      val next: Long = (2 * data[3] + data[1]) % MOD // must use long to avoid overflow
      data[0] = data[1]
      data[1] = data[2]
      data[2] = data[3]
      data[3] = next
    }
    return data[3].toInt()
  }
}

// https://leetcode.com/problems/domino-and-tromino-tiling/solutions/116581/detail-and-explanation-of-o-n-solution-why-dp-n-2-d-n-1-dp-n-3/?envType=study-plan-v2&envId=leetcode-75

/*
 int numTilings(int N) {
    int md=1e9;
    md+=7;
    vector<long long> v(1001,0);
    v[1]=1;
    v[2]=2;
    v[3]=5;
    if(N<=3)
        return v[N];
    for(int i=4;i<=N;++i){
        v[i] = 2*v[i-1] + v[i-3]; 
        v[i] %= md;
    }
    return v[N];
    
}
 */
